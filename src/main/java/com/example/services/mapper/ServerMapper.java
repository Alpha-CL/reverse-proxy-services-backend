package com.example.services.mapper;


import com.example.services.entity.Server;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;



@Mapper
public interface ServerMapper {

    void addServer(@Param("server") Server server);

    void deleteServerById(@Param("id") Long id);

    void updateServerById(@Param("server") Server server);

    Server getServerById(@Param("id") Long id);

    void batchAddServers(@Param("serverList") List<Server> serverList);

    void batchDeleteServers(@Param("ids") List<Long> ids);

    void batchUpdateServers(@Param("serverList") List<Server> serverList);

    List<Server> getServersByPage(
            @Param("pageSize") int pageSize,
            @Param("offset") int offset,
            @Param("queryCondition") String queryCondition
    );

    Long getServersTotal();
}