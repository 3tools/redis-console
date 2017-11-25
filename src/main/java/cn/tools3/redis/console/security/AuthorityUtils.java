package cn.tools3.redis.console.security;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import cn.tools3.redis.console.domain.Resource;
import cn.tools3.redis.console.domain.Role;
import cn.tools3.redis.console.domain.User;


public abstract class AuthorityUtils {

    public static List<GrantedAuthority> getAuthorityList(User user) {
        if (null == user) {
            return Collections.emptyList();
        }
        List<GrantedAuthority> ret = new LinkedList<>();
        if (null != user.getRole()) {
            Role role = user.getRole();
            if (null != role.getResources()) {
                for (Resource resource : role.getResources()) {
                    ret.add(new SimpleGrantedAuthority(resource.getId()));
                }
            }
        }
        return ret;
    }

}
