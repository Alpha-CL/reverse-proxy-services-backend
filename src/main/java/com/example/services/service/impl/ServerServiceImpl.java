package com.example.services.service.impl;


import com.example.services.common.Resp.PageResp;
import com.example.services.dto.ServerDto;
import com.example.services.entity.Server;
import com.example.services.mapper.ServerMapper;
import com.example.services.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ServerServiceImpl implements ServerService {

    private final ServerMapper serverMapper;

    @Autowired
    public ServerServiceImpl(ServerMapper serverMapper) {
        this.serverMapper = serverMapper;
    }

    @Override
    @Transactional
    public void addServer(ServerDto server) {
        serverMapper.addServer(server);
    }

    @Override
    @Transactional
    public void deleteServerById(Long id) {
        serverMapper.deleteServerById(id);
    }

    @Override
    @Transactional
    public void updateServerById(Server server) {
        serverMapper.updateServerById(server);
    }

    @Override
    @Transactional
    public ServerDto getServerById(Long id) {
        Server server = serverMapper.getServerById(id);
        ServerDto serverDto = new ServerDto();
        serverDto.setId(server.getId());
        serverDto.setLabel(server.getName());
        return serverDto;
    }

    @Override
    public void batchAddServers(List<Server> serverList) {
        serverMapper.batchAddServers(serverList);
    }

    @Override
    public void batchDeleteServers(List<Long> ids) {
        serverMapper.batchDeleteServers(ids);
    }

    @Override
    public void batchUpdateServers(List<Server> serverList) {
        serverMapper.batchUpdateServers(serverList);
    }

    @Override
    public PageResp<ServerDto> getServersByPage(
            int currentPage,
            int pageSize,
            String queryCondition
    ) {
        int offset = (currentPage - 1) * pageSize;

        List<Server> serverList = serverMapper.getServersByPage(pageSize, offset, queryCondition);

        List<ServerDto> serverDtoList = serverList.stream()
                .map(server -> {
                    ServerDto serverDto = new ServerDto();
                    serverDto.setId(server.getId());
                    serverDto.setLabel(server.getName());
                    return serverDto;
                })
                .collect(Collectors.toList());

        Long serversTotal = serverMapper.getServersTotal();

        PageResp<ServerDto> pageResp = new PageResp<ServerDto>();
        pageResp.setData(serverDtoList);
        pageResp.setTotal(serversTotal);

        return pageResp;
    }
}



