package cn.tools3.redis.console.controller;

import cn.tools3.redis.console.domain.Server;
import cn.tools3.redis.console.repository.ServerRepository;
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

    @RequestMapping(value = "/list")
    public String list() {
        Server server =  new Server();
        server.setDescribe("不花大萨达所");
        server.setHost("192.168.2.2");
        server.setName("哈哈哈");
        server.setCreateTime(new Date());
        server.setLastModified(new Date());
        serverRepository.save(server);
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
    @Transactional
    public String save(Server server) {
        serverRepository.save(server);
        return "redirect:/server/list";
    }


}
