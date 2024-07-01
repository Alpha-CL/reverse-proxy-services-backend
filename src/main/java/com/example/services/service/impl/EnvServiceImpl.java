package com.example.services.service.impl;


import com.example.services.dto.EnvDto;
import com.example.services.entity.Env;
import com.example.services.mapper.EnvMapper;
import com.example.services.service.EnvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EnvServiceImpl implements EnvService {

    @Autowired
    private EnvMapper envMapper;

    @Override
    @Transactional
    public Void addEnv(Env env) {
        return envMapper.addEnv(env);
    }

    @Override
    @Transactional
    public Void deleteEnvById(Long id) {
        return envMapper.deleteEnvById(id);
    }

    @Override
    @Transactional
    public Void updateEnvById(Env env) {
        return envMapper.updateEnvById(env);
    }

    @Override
    @Transactional
    public EnvDto getEnvById(Long id) {
        Env env = envMapper.getEnvById(id);
        return new EnvDto(env.getId(), env.getName());
    }

    @Override
    public Void batchAddEnvs(List<Env> envList) {
        return envMapper.batchAddEnvs(envList);
    }

    @Override
    public Void batchDeleteEnvs(List<Long> ids) {
        return envMapper.batchDeleteEnvs(ids);
    }

    @Override
    public Void batchUpdateEnvs(List<Env> envList) {
        return envMapper.batchUpdateEnvs(envList);
    }

    @Override
    public List<EnvDto> getEnvsByPage(
            int currentPage,
            int pageSize,
            String queryCondition
    ) {
        int offset = (currentPage - 1) * pageSize;
        return null;
//        return (List<EnvDto>) envMapper.getEnvByPage(pageSize, offset, queryCondition);
    }

}