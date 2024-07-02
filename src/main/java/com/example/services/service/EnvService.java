package com.example.services.service;


import com.example.services.dto.EnvDto;
import com.example.services.entity.Env;

import java.util.List;



public interface EnvService {

    public void addEnv(Env env);

    public void deleteEnvById(Long id);

    public void updateEnvById(Env env);

    public EnvDto getEnvById(Long id);

    public void batchAddEnvs(List<Env> envList);

    public void batchDeleteEnvs(List<Long> ids);

    public void batchUpdateEnvs(List<Env> envList);

    public List<EnvDto> getEnvsByPage(int currentPage, int pageSize, String queryCondition);
}

