package cn.tools3.redis.console.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import cn.tools3.redis.console.domain.Menu;
import cn.tools3.redis.console.domain.Resource;
import cn.tools3.redis.console.domain.Role;
import cn.tools3.redis.console.domain.User;
import cn.tools3.redis.console.repository.MenuRepository;
import cn.tools3.redis.console.repository.ResourceRepository;
import cn.tools3.redis.console.repository.RoleRepository;
import cn.tools3.redis.console.repository.UserRepository;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().cacheControl().disable().frameOptions().disable().xssProtection().disable();
		http.authorizeRequests()
				// 无需授权目录
				.antMatchers("/bower_components/**", "/build/**", "/dist/**", "/documentation/**", "/pages/**",
						"/plugins/**", "/index.html", "/index2.html", "/starter.html", "jquery.spring-friendly.js","/css/**","/img/common/**")
				.permitAll()
				// 其它需要授权
				.anyRequest().authenticated();
		// 登录表单
		http.formLogin().loginPage("/login").permitAll();
		// 登出表单
		http.logout().permitAll();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public CommandLineRunner run(RoleRepository roleRepository, ResourceRepository resourceRepository,
			MenuRepository menuRepository, UserRepository userRepository) throws Exception {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				// 添加资源列表
				resourceList().forEach(r -> {
					Resource pr = resourceRepository.findOne(r.getId());
					if (null != pr) {
						BeanUtils.copyProperties(r, pr, "id");
					} else {
						pr = r;
					}
					resourceRepository.save(pr);
				});
				// 添加菜单列表
				menuList().forEach(m -> {
					Menu pm = menuRepository.findOne(m.getId());
					if (null != pm) {
						BeanUtils.copyProperties(m, pm, "id");
					} else {
						pm = m;
					}
					if (null != pm.getParent()) {
						Menu parent = menuRepository.findOne(pm.getParent().getId());
						if (null != parent) {
							pm.setParent(parent);
						}
					}
					menuRepository.save(pm);
				});

				if (!roleRepository.findAll().iterator().hasNext()) {
					// 初始化Role
					Role role = new Role();
					role.setName("admin");
					role.setDescription("后台管理员账户");
					roleRepository.save(role);
				}
				roleRepository.findAll().forEach(r -> {
					if ("admin".equals(r.getName())) {
						// 初始化Role
						@SuppressWarnings("unchecked")
						List<Resource> resources = IteratorUtils.toList(resourceRepository.findAll().iterator());
						@SuppressWarnings("unchecked")
						List<Menu> menus = IteratorUtils.toList(menuRepository.findAll().iterator());
						r.setResources(resources);
						r.setMenus(menus);
						roleRepository.save(r);
					}
				});

				if (!userRepository.findAll().iterator().hasNext()) {
					// 添加用户
					@SuppressWarnings("unchecked")
					List<Role> role = IteratorUtils.toList(roleRepository.findAll().iterator());
					User user = new User();
					user.setUsername("admin@3tools.cn");
					user.setPassword("admin");
					user.setRole(role.get(0));
					userRepository.save(user);
				}

			}

		};
	}

	/**
	 * 资源列表，修改慎重，注意历史数据
	 *
	 * @returns
	 */
	@Bean
	public List<Resource> resourceList() {
		List<Resource> l = new ArrayList<>();
		return l;
	}

	/**
	 * 资源列表，修改慎重，注意历史数据
	 *
	 * @returns
	 */
	@Bean
	public List<Menu> menuList() {
		List<Menu> l = new ArrayList<>();
		// 首页
		Menu parentHomeMenu = new Menu("home", null, "首页", "", 0);
		l.add(parentHomeMenu);
		l.add(new Menu("home.home", parentHomeMenu, "首页v1", "/", 40));
		// 配置管理
		Menu parentConfigMenu = new Menu("config", null, "配置管理", "", 10);
		l.add(parentConfigMenu);
		l.add(new Menu("config.server", parentConfigMenu, "服务器管理", "/server/list", 40));
		// 系统管理
		Menu parentSystemMenu = new Menu("system", null, "系统管理", "", 50);
		l.add(parentSystemMenu);
		l.add(new Menu("system.user", parentSystemMenu, "用户管理", "/user/userInfo", 40));
		l.add(new Menu("system.role", parentSystemMenu, "角色管理", "/role/roleInfo", 50));
		l.add(new Menu("system.log", parentSystemMenu, "操作日志", "/userLog/userLogInfo", 80));
		// 状态监控
		Menu parentMetricsMenu = new Menu("metrics", null, "状态监控", "", 60);
		l.add(parentMetricsMenu);
		l.add(new Menu("metrics.server", parentMetricsMenu, "服务器监控", "/server/metrics/info", 40));
		l.add(new Menu("metrics.redis", parentMetricsMenu, "redis监控", "/redis/metrics/info", 50));
		return l;
	}

}
