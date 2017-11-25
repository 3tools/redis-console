package cn.tools3.redis.console.security;

import java.util.List;

import org.apache.commons.collections.IteratorUtils;
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

import cn.tools3.redis.console.domain.Resource;
import cn.tools3.redis.console.domain.Role;
import cn.tools3.redis.console.domain.User;
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
						"/plugins/**", "/index.html", "/index2.html", "/starter.html")
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
			UserRepository userRepository) throws Exception {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				if (!roleRepository.findAll().iterator().hasNext()) {
					// 初始化Role
					@SuppressWarnings("unchecked")
					List<Resource> resources = IteratorUtils.toList(resourceRepository.findAll().iterator());
					Role role = new Role();
					role.setName("管理员(全部)");
					role.setDescription("后台管理员账户");
					role.setResources(resources);
					roleRepository.save(role);
				}

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
		return null;
	}

}
