package com.example.services.controller;

import com.example.services.entity.Env;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("env")
public class EnvController {

    @PostMapping("")
    public Resp<Void> createEnv(@RequestBody Env env) {
        return Resp.success(null);
    }

    @DeleteMapping("/{id}")
    public Resp<Void> deleteEnv(@PathVariable Long id) {
        return Resp.success(null);
    }

    @PutMapping("")
    public Resp<Void> updateEnvById(@RequestBody Env env) {
        return Resp.success(null);
    }

    @GetMapping("/{id}")
    public Resp<Void> getEnvById(@PathVariable String id) {
        return Resp.success(null);
    }

    @PostMapping("/list")
    public Resp<Void> batchAddEnv(@RequestBody List<Env> envList) {
        return Resp.success(null);
    }

    @DeleteMapping("/list")
    public Resp<Void> batchDeleteEnv(@PathVariable List<String> ids) {
        return Resp.success(null);
    }

    @PutMapping("/list")
    public Resp<Void> batchUpdateEnv(@RequestBody List<Env> envList) {
        return Resp.success(null);
    }

    @GetMapping("/list")
    public Resp<Void> getEnvList(
            @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(required = false) String queryCondition
    ) {
        return Resp.success(null);
    }
}