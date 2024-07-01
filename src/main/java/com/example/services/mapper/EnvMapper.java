package com.example.services.mapper;

import com.example.services.entity.Env;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface EnvMapper {

    public Void addEnv(@Param("env") Env env);

    public Void deleteEnvById(@Param("id") Long id);

    public Void updateEnvById(@Param("env") Env env);

    public Env getEnvById(@Param("id") Long id);

    public Void batchAddEnvs(@Param("envList") List<Env> envList);

    public Void batchDeleteEnvs(@Param("ids") List<Long> ids);

    public Void batchUpdateEnvs(@Param("envList") List<Env> envList);

    public List<Env> getEnvsByPage(
            @Param("pageSize") int pageSize,
            @Param("offset") int offset,
            @Param("queryCondition") String queryCondition
    );
}