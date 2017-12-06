package cn.tools3.redis.console.domain;

import cn.tools3.redis.console.IdGen;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@MappedSuperclass
public class BaseDomain {

    /**
     * 唯一标识
     */
    @JsonView({ DataTablesOutput.View.class })
    @Id
    private String id = IdGen.DEFAULT.gen();

    /**
     * 创建时间
     */
    @JsonView({ DataTablesOutput.View.class })
    @CreatedDate
    private Date createTime;

    /**
     * 最后修改时间
     */
    @JsonView({ DataTablesOutput.View.class})
    @LastModifiedDate
    private Date lastModified;

    /**
     * 是否删除
     */
    @JsonView({ DataTablesOutput.View.class })
    private boolean remove;

}
