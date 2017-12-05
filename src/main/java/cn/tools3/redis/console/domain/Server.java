package cn.tools3.redis.console.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Where(clause = "remove = false")
@SQLDelete(sql = " update server set remove = true, last_modified = now() where id = ?")
public class Server extends BaseDomain {

    /**
     * 服务器名称
     */
    @JsonView({ DataTablesOutput.View.class })
    private String name;

    /**
     * 服务器地址
     */
    @JsonView({ DataTablesOutput.View.class})
    private String host;

    /**
     * 描述信息
     */
    @JsonView({ DataTablesOutput.View.class })
    private String describe;

    /**
     * 用户
     */
    @JsonView({ DataTablesOutput.View.class })
    @OneToMany(mappedBy = "server")
    @NotFound(action= NotFoundAction.IGNORE)
    private List<ServerUser> users;


}
