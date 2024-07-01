package com.example.services.service;


import com.example.services.dto.EnvDto;
import com.example.services.entity.Env;

import java.util.List;



public interface EnvService {

    public Void addEnv(Env env);

    public Void deleteEnvById(Long id);

    public Void updateEnvById(Env env);

    public EnvDto getEnvById(Long id);

    public Void batchAddEnvs(List<Env> envList);

    public Void batchDeleteEnvs(List<Long> ids);

    public Void batchUpdateEnvs(List<Env> envList);

    public List<EnvDto> getEnvsByPage(int currentPage, int pageSize, String queryCondition);
}

