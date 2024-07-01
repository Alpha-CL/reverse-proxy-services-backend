package com.example.services.controller;

import com.example.services.dto.EnvDto;
import com.example.services.entity.Env;
import com.example.services.service.EnvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("env")
public class EnvController {

    private final EnvService envService;

    @Autowired
    public EnvController(EnvService envService) {
        this.envService = envService;
    }

    @PostMapping("")
    public Resp<Void> addEnv(@RequestBody Env env) {
        return Resp.success(envService.addEnv(env));
    }

    @DeleteMapping("/{id}")
    public Resp<Void> deleteEnvById(@PathVariable Long id) {
        return Resp.success(envService.deleteEnvById(id));
    }

    @PutMapping("")
    public Resp<Void> updateEnvById(@RequestBody Env env) {
        return Resp.success(envService.updateEnvById(env));
    }

    @GetMapping("/{id}")
    public Resp<EnvDto> getEnvById(@PathVariable Long id) {
        return Resp.success(envService.getEnvById(id));
    }

    @PostMapping("/list")
    public Resp<Void> batchAddEnvs(@RequestBody List<Env> envList) {
        return Resp.success(envService.batchAddEnvs(envList));
    }

    @DeleteMapping("/list/{ids}")
    public Resp<Void> batchDeleteEnvs(@PathVariable List<Long> ids) {
        return Resp.success(envService.batchDeleteEnvs(ids));
    }

    @PutMapping("/list")
    public Resp<Void> batchUpdateEnvs(@RequestBody List<Env> envList) {
        return Resp.success(envService.batchUpdateEnvs(envList));
    }

    @GetMapping("/list")
    public Resp<List<EnvDto>> getEnvsByPage(
            @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(required = false) String queryCondition
    ) {
        return Resp.success(envService.getEnvsByPage(currentPage, pageSize, queryCondition));
    }
}