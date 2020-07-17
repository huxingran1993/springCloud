package com.cloud.feignservice.controller;

import com.cloud.feignservice.model.CommonResult;
import com.cloud.feignservice.model.User;
import com.cloud.feignservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserFeignController {
    @Qualifier("user-service")
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public CommonResult getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @GetMapping("/getByUsername")
    public CommonResult getByUsername(@RequestParam String username){
        return userService.getByUsername(username);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user){
        return userService.create(user);
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody User user){
        return userService.update(user);
    }

    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id){
        return userService.delete(id);
    }

}
