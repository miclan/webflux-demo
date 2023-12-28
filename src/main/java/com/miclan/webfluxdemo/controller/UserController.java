package com.miclan.webfluxdemo.controller;

import com.miclan.webfluxdemo.entity.UserEntity;
import com.miclan.webfluxdemo.repo.UserRepo;
import com.miclan.webfluxdemo.service.IdService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserRepo userRepo;

    @Resource
    private IdService idService;

    @PostMapping("")
    public Mono<UserEntity> create(@RequestBody UserEntity user) {
        if (StringUtils.isBlank(user.getId())) {
            // 新创建
            user.setNewEntry(true);
            // 设置 id 为随机大写字符串
            user.setId(idService.getIdForDb());
        } else {
            // 修改
            user.setNewEntry(false);
        }
        return userRepo.save(user);
    }

    @GetMapping("")
    public Mono<UserEntity> getById(@RequestParam String id) {
        return userRepo.findById(id);
    }
}
