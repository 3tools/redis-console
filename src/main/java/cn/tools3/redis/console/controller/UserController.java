package cn.tools3.redis.console.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;

import cn.tools3.redis.console.domain.User;
import cn.tools3.redis.console.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/list")
	public String list(ModelMap model) {
		return "user/vList";
	}

	@JsonView(DataTablesOutput.View.class)
	@RequestMapping(value = "/datatable")
	@ResponseBody
	public DataTablesOutput<User> getPage(HttpServletRequest request, @Valid DataTablesInput input) {
		return userRepository.findAll(input);
	}
}
