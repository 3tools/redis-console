package cn.tools3.redis.console.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Where(clause = "remove = false")
@SQLDelete(sql = " update role set remove = true, last_modified = now() where id = ?")
public class Role extends BaseDomain {

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 授权的资源
	 */
	@OneToMany
	private List<Resource> resources;
	
	/**
	 * 授权的菜单
	 */
	@OneToMany
	private List<Menu> menus;

}
