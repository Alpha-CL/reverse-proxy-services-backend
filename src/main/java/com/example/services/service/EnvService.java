package com.example.services.service;


import com.example.services.controller.PageResp;
import com.example.services.dto.EnvDto;
import com.example.services.entity.Env;

import java.util.List;


public interface EnvService {

    void addEnv(Env env);

    void deleteEnvById(Long id);

    void updateEnvById(Env env);

    EnvDto getEnvById(Long id);

    void batchAddEnvs(List<Env> envList);

    void batchDeleteEnvs(List<Long> ids);

    void batchUpdateEnvs(List<Env> envList);

    PageResp<EnvDto> getEnvsByPage(int currentPage, int pageSize, String queryCondition);
}
