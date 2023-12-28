package com.miclan.webfluxdemo.repo;

import com.miclan.webfluxdemo.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepo extends ReactiveCrudRepository<UserEntity, String> {
}
