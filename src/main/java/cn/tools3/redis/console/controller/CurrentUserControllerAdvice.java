package cn.tools3.redis.console.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import cn.tools3.redis.console.security.CurrentUser;

@ControllerAdvice
public class CurrentUserControllerAdvice {

	@ModelAttribute("currentUser")
	public CurrentUser getCurrentUser(Authentication authentication) {
		return (authentication == null) ? null : (CurrentUser) authentication.getPrincipal();
	}

}
