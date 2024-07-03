package com.example.services.service;

import com.example.services.common.Resp.PageResp;
import com.example.services.dto.ServerDto;
import com.example.services.entity.Server;

import java.util.List;

public interface ServerService {

    void addServer(Server server);

    void deleteServerById(Long id);

    void updateServerById(Server server);

    ServerDto getServerById(Long id);

    void batchAddServers(List<Server> serverList);

    void batchDeleteServers(List<Long> ids);

    void batchUpdateServers(List<Server> serverList);

    PageResp<ServerDto> getServersByPage(int currentPage, int pageSize, String queryCondition);
}
