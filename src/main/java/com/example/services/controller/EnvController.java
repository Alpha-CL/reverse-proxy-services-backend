package com.example.services.controller;

import com.example.services.entity.Env;
import com.example.services.service.EnvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("env")
public class EnvController {

    @Autowired
    private EnvService service;

    @PostMapping("")
    public Resp<String> addEnv(@RequestBody Env env) {
        return Resp.success("addEnv");
    }

    @DeleteMapping("/{id}")
    public Resp<String> deleteEnvById(@PathVariable Long id) {
        return Resp.success("deleteEnvById");
    }

    @PutMapping("")
    public Resp<String> updateEnvById(@RequestBody Env env) {
        return Resp.success("updateEnvById");
    }

    @GetMapping("/{id}")
    public Resp<String> getEnvById(@PathVariable Long id) {
        return Resp.success("getEnvById");
    }

    @PostMapping("/list")
    public Resp<String> batchAddEnvs(@RequestBody List<Env> envList) {
        return Resp.success("batchAddEnvs");
    }

    @DeleteMapping("/list/{ids}")
    public Resp<String> batchDeleteEnvs(@PathVariable List<Long> ids) {
        return Resp.success("batchDeleteEnvs");
    }

    @PutMapping("/list")
    public Resp<String> batchUpdateEnvs(@RequestBody List<Env> envList) {
        return Resp.success("batchUpdateEnvs");
    }

    @GetMapping("/list")
    public Resp<String> getEnvList(
            @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(required = false) String queryCondition
    ) {
        return Resp.success("getEnvList");
    }
}