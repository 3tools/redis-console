package cn.tools3.redis.console.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * 服务器用户实体
 * Created by yangting on 2017/12/5.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Where(clause = "remove = false")
@SQLDelete(sql = " update server_user set remove = true, last_modified = now() where id = ?")
public class ServerUser extends BaseDomain {

    /**
     * 服务器
     */
    @JsonView({ DataTablesOutput.View.class })
    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    private Server server;

    /**
     * 用户名
     */
    @JsonView({ DataTablesOutput.View.class})
    private String username;

    /**
     * 密码
     */
    @JsonView({ DataTablesOutput.View.class })
    private String password;

}
