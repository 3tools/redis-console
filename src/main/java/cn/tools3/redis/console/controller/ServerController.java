package cn.tools3.redis.console.controller;

import cn.tools3.redis.console.domain.Server;
import cn.tools3.redis.console.repository.ServerRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/server")
public class ServerController {
	
	@Autowired
	private ServerRepository serverRepository;

	@RequestMapping(value = "/list")
	public String list(ModelMap model) {
		return "server/vList";
	}

    @RequestMapping(value = "/add")
    public String add(ModelMap model) {
        return "server/vAdd";
    }

	@JsonView(DataTablesOutput.View.class)
	@RequestMapping(value = "/datatable")
	@ResponseBody
	public DataTablesOutput<Server> getPage(HttpServletRequest request, @Valid DataTablesInput input) {
		return serverRepository.findAll(input);
	}
}
