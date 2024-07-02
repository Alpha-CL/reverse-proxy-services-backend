package com.example.services.service.impl;


import com.example.services.dto.EnvDto;
import com.example.services.entity.Env;
import com.example.services.mapper.EnvMapper;
import com.example.services.service.EnvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EnvServiceImpl implements EnvService {

    private final EnvMapper envMapper;

    @Autowired
    public EnvServiceImpl(EnvMapper envMapper) {
        this.envMapper = envMapper;
    }

    @Override
    @Transactional
    public void addEnv(Env env) {
        envMapper.addEnv(env);
    }

    @Override
    @Transactional
    public void deleteEnvById(Long id) {
        envMapper.deleteEnvById(id);
    }

    @Override
    @Transactional
    public void updateEnvById(Env env) {
        envMapper.updateEnvById(env);
    }

    @Override
    @Transactional
    public EnvDto getEnvById(Long id) {
        Env env = envMapper.getEnvById(id);
        EnvDto envDto = new EnvDto();
        envDto.setId(env.getId());
        envDto.setLabel(env.getName());
        return envDto;
    }

    @Override
    public void batchAddEnvs(List<Env> envList) {
        envMapper.batchAddEnvs(envList);
    }

    @Override
    public void batchDeleteEnvs(List<Long> ids) {
        envMapper.batchDeleteEnvs(ids);
    }

    @Override
    public void batchUpdateEnvs(List<Env> envList) {
        System.out.println("envList = " + envList);
        envMapper.batchUpdateEnvs(envList);
    }

    @Override
    public List<EnvDto> getEnvsByPage(
            int currentPage,
            int pageSize,
            String queryCondition
    ) {
        int offset = (currentPage - 1) * pageSize;
        List<Env> envList = envMapper.getEnvsByPage(pageSize, offset, queryCondition);
        List<EnvDto> envDtoList = envList.stream()
                .map(env -> {
                    EnvDto envDto = new EnvDto();
                    envDto.setId(env.getId());
                    envDto.setLabel(env.getName());
                    return envDto;
                })
                .collect(Collectors.toList());
        return envDtoList;
    }
}
