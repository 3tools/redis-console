package cn.tools3.redis.console.security;

import java.util.Collections;
import java.util.Set;

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
	 * 授权的渠道不包含通用渠道
	 */
	private Set<String> resources = Collections.unmodifiableSet(Collections.emptySet());

	public CurrentUser(User user) {
		super(user.getUsername(), user.getPassword(), AuthorityUtils.getAuthorityList(user));
		this.resources = Collections.unmodifiableSet(resources);
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