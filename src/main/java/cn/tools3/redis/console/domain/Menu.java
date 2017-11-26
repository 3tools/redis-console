package cn.tools3.redis.console.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 系统菜单
 * 
 * @author fengshaoyun
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Table(indexes = { @Index(columnList = "lastModified") })
@Where(clause = "remove = false")
@SQLDelete(sql = " update menu set remove = true, last_modified = now() where id = ?")
public class Menu extends BaseDomain {

	public Menu(String id,Menu parent, String name, String path,int sequence) {
		this.setId(id);
		this.parent = parent;
		this.name = name;
		this.path = path;
		this.sequence = sequence;
		super.setCreateTime(new Date());
		super.setLastModified(new Date());
	}

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 路径
	 */
	private String path;

	/**
	 * 序号
	 */
	private int sequence;

	/**
	 * 上级菜单
	 */
	@ManyToOne
	private Menu parent;
}
