package com.example.services.mapper;

import com.example.services.entity.Env;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface EnvMapper {

    void addEnv(@Param("env") Env env);

    void deleteEnvById(@Param("id") Long id);

    void updateEnvById(@Param("env") Env env);

    Env getEnvById(@Param("id") Long id);

    void batchAddEnvs(@Param("envList") List<Env> envList);

    void batchDeleteEnvs(@Param("ids") List<Long> ids);

    void batchUpdateEnvs(@Param("envList") List<Env> envList);

    List<Env> getEnvsByPage(
            @Param("pageSize") int pageSize,
            @Param("offset") int offset,
            @Param("queryCondition") String queryCondition
    );
}