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
        envService.addEnv(env);
        return Resp.success();
    }

    @DeleteMapping("/{id}")
    public Resp<Void> deleteEnvById(@PathVariable Long id) {
        envService.deleteEnvById(id);
        return Resp.success();
    }

    @PutMapping("")
    public Resp<Void> updateEnvById(@RequestBody Env env) {
        envService.updateEnvById(env);
        return Resp.success();
    }

    @GetMapping("/{id}")
    public Resp<EnvDto> getEnvById(@PathVariable Long id) {
        return Resp.success(envService.getEnvById(id));
    }

    @PostMapping("/list")
    public Resp<Void> batchAddEnvs(@RequestBody List<Env> envList) {
        envService.batchAddEnvs(envList);
        return Resp.success();
    }

    @DeleteMapping("/list/{ids}")
    public Resp<Void> batchDeleteEnvs(@PathVariable List<Long> ids) {
        envService.batchDeleteEnvs(ids);
        return Resp.success();
    }

    @PutMapping("/list")
    public Resp<Void> batchUpdateEnvs(@RequestBody List<Env> envList) {
        envService.batchUpdateEnvs(envList);
        return Resp.success();
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