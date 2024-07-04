package com.example.services.controller;


import com.example.services.common.Resp.PageResp;
import com.example.services.common.Resp.Resp;
import com.example.services.dto.ServerDto;
import com.example.services.entity.Server;
import com.example.services.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("server")
public class ServerController {

    private final ServerService serverService;

    @Autowired
    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @PostMapping("")
    public Resp<Void> addServer(@RequestBody ServerDto server) {
        serverService.addServer(server);
        return Resp.success();
    }

    @DeleteMapping("/{id}")
    public Resp<Void> deleteServerById(@PathVariable Long id) {
        serverService.deleteServerById(id);
        return Resp.success();
    }

    @PutMapping("")
    public Resp<Void> updateServerById(@RequestBody Server server) {
        serverService.updateServerById(server);
        return Resp.success();
    }

    @GetMapping("/{id}")
    public Resp<ServerDto> getServerById(@PathVariable Long id) {
        return Resp.success(serverService.getServerById(id));
    }

    @PostMapping("/list")
    public Resp<Void> batchAddServers(@RequestBody List<Server> serverList) {
        serverService.batchAddServers(serverList);
        return Resp.success();
    }

    @DeleteMapping("/list/{ids}")
    public Resp<Void> batchDeleteServers(@PathVariable List<Long> ids) {
        serverService.batchDeleteServers(ids);
        return Resp.success();
    }

    @PutMapping("/list")
    public Resp<Void> batchUpdateServers(@RequestBody List<Server> serverList) {
        serverService.batchUpdateServers(serverList);
        return Resp.success();
    }

    @GetMapping("/list")
    public Resp<PageResp<ServerDto>> getServersByPage(
            @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(required = false) String queryCondition
    ) {
        return Resp.success(serverService.getServersByPage(currentPage, pageSize, queryCondition));
    }
}

