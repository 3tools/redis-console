package cn.tools3.redis.console.controller;

import cn.tools3.redis.console.domain.Server;
import cn.tools3.redis.console.repository.ServerRepository;
import cn.tools3.redis.console.repository.ServerUserRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/server")
public class ServerController {

    @Autowired
    private ServerRepository serverRepository;

    @Autowired
    private ServerUserRepository serverUserRepository;

    @RequestMapping(value = "/list")
    public String list() {
        return "server/vList";
    }

    @RequestMapping(value = "/add")
    public String add() {
        return "server/vAdd";
    }

    @JsonView(DataTablesOutput.View.class)
    @RequestMapping(value = "/datatable")
    @ResponseBody
    public DataTablesOutput<Server> getPage(@Valid DataTablesInput input) {
        DataTablesOutput<Server> dataTables = serverRepository.findAll(input);
        return dataTables;
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    @Transactional
    public String save(Server server) {
        server.setCreateTime(new Date());
        server.setLastModified(new Date());
        server.getUsers().forEach(user ->{
            user.setServer(server);
            user.setCreateTime(new Date());
            user.setLastModified(new Date());
        });
        serverRepository.save(server);
        serverUserRepository.save(server.getUsers());
        return "redirect:/server/list";
    }


}
