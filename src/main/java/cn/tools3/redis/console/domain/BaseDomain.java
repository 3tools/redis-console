package cn.tools3.redis.console.domain;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import cn.tools3.redis.console.IdGen;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@MappedSuperclass
public class BaseDomain {

	/**
	 * 唯一标识
	 */
	@Id
	private String id = IdGen.DEFAULT.gen();

	/**
	 * 创建时间
	 */
	@CreatedDate
	private Date createTime;

	/**
	 * 最后修改时间
	 */
	@LastModifiedDate
	private Date lastModified;

	/**
	 * 是否删除
	 */
	private boolean remove;

}
