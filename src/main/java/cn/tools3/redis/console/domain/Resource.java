package cn.tools3.redis.console.domain;

import javax.persistence.Entity;

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
@SQLDelete(sql = " update resource set remove = true, last_modified = now() where id = ?")
public class Resource extends BaseDomain {

}
