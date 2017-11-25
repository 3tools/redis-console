package cn.tools3.redis.console.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.tools3.redis.console.domain.User;
import cn.tools3.redis.console.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CurrentUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
		log.debug("加载用户[{}]", username);
		User user = userRepository.findByUsername(username);
		if(null == user) {
			throw new UsernameNotFoundException("用户名不存在！");
		}
		return new CurrentUser(user);
	}

}