package cn.tools3.redis.console.domain;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@SQLDelete(sql = " update user set remove = true, last_modified = now() where id = ?")
@Table(indexes = { @Index(columnList = "username") })
public class User extends BaseDomain {

	/**
	 * 角色
	 */
	@ManyToOne
	private Role role;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

}
