package cn.tools3.redis.console.security;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.google.common.collect.Sets;

import cn.tools3.redis.console.domain.Menu;
import cn.tools3.redis.console.domain.Resource;
import cn.tools3.redis.console.domain.Role;
import cn.tools3.redis.console.domain.User;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CurrentUser extends org.springframework.security.core.userdetails.User {

	/**
	 * 序列版本
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户实体
	 */
	private User user;

	/**
	 * 当前选择的菜单
	 */
	private Map<Menu, Set<Menu>> menuMap;

	/**
	 * 授权的渠道不包含通用渠道
	 */
	private Set<String> resources = Collections.unmodifiableSet(Collections.emptySet());

	public CurrentUser(User user) {
		super(user.getUsername(), user.getPassword(), AuthorityUtils.getAuthorityList(user));
		Set<Menu> menuSet = new HashSet<>();
		Set<String> resources = new LinkedHashSet<>();
		if (null != user.getRole()) {
			Role role = user.getRole();
			if (null != role.getResources()) {
				for (Resource resource : role.getResources()) {
					resources.add(resource.getId());
				}
			}
			if (null != role.getMenus()) {
				menuSet = new HashSet<>(role.getMenus());
			}
		}
		this.resources = Collections.unmodifiableSet(resources);
		// 菜单
		Map<Menu, Set<Menu>> menuMap = new TreeMap<>(Comparator.comparingInt(Menu::getSequence));
		for (Menu menu : menuSet) {
			if (null == menu.getParent()) {
				if (!menuMap.containsKey(menu)) {
					menuMap.put(menu, Sets.newTreeSet(Comparator.comparingInt(Menu::getSequence)));
				}
			}
		}
		for (Menu menu : menuSet) {
			if (null != menu.getParent()) {
				Menu parent = menu.getParent();
				Set<Menu> mapValue = menuMap.get(parent);
				if (mapValue != null) {
					mapValue.add(menu);
				}
			}
		}
		this.menuMap = Collections.unmodifiableMap(menuMap);

	}

	/**
	 * 判断是否包含某资源id
	 * 
	 * @param resource
	 * @return
	 */
	public boolean hasResource(String resource) {
		return resources.contains(resource);
	}

}