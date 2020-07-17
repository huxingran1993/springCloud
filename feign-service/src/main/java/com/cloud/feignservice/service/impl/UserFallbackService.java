package com.cloud.feignservice.service.impl;

import com.cloud.feignservice.model.CommonResult;
import com.cloud.feignservice.model.User;
import com.cloud.feignservice.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackService implements UserService {
    @Override
    public CommonResult create(User user) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<User> getUser(Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<User> getByUsername(String username) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult update(User user) {
        return new CommonResult("Process failure, service fallback", 500);
    }

    @Override
    public CommonResult delete(Long id) {
        return new CommonResult("Process failure, service fallback", 500);
    }
}
