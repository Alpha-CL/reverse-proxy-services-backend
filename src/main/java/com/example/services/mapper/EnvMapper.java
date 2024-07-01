package com.example.services.mapper;

import com.example.services.entity.Env;
import org.apache.ibatis.annotations.*;

import java.util.List;





@Mapper
public interface EnvMapper {

    @Insert("insert into envs(name) values(#{name})")
    public Void addEnv(@Param("env") Env env);

    @Delete("delete from envs where id = #{id}")
    public Void deleteEnvById(@Param("id") Long id);

    @Update("update env set id = #{id}")
    public Void updateEnvById(@Param("env") Env env);

    @Select("select * from envs where id = #{id}")
    public Env getEnvById(@Param("id") Long id);

    public Void batchAddEnvs(@Param("env") List<Env> envList);

    public Void batchDeleteEnvs(@Param("ids") List<Long> ids);

    public Void batchUpdateEnvs(@Param("env") List<Env> envList);

    public List<Env> getEnvByPage(
            @Param("currentPage") int currentPage,
            @Param("offset") int pageSize,
            @Param("queryCondition") String queryCondition
    );

}