package com.cloud.userservice.controller;

import com.cloud.userservice.model.CommonResult;
import com.cloud.userservice.model.User;
import com.cloud.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = new ArrayList<>();
        userService.getAllUser().forEach(users::add);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user){
        userService.create(user);
        return new CommonResult("Create Successful!", 200);
    }

    @GetMapping("/{id}")
    public CommonResult<User> getUser(@PathVariable Long id){
        User user = userService.getUser(id);
        LOGGER.info("Query by the Id, user name: {}", user.getUsername());
        return new CommonResult<>(user);
    }

    @GetMapping("/getUserByIds")
    public CommonResult<List<User>> getUserByIds(@RequestParam List<Long> ids){
        List<User> userList = userService.getUserByIds(ids);
        LOGGER.info("Query the user by IDs, User list: ", userList);
        return new CommonResult<>(userList);
    }

    @GetMapping("/getByUsername")
    public CommonResult<User> getByUsername(@RequestParam String username){
        User user = userService.getByUsername(username);
        return new CommonResult<>(user);
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody User user){
        userService.update(user);
        return new CommonResult("Update successful!", 200);
    }

    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id){
        userService.delete(id);
        return new CommonResult("Delete successful!", 200);
    }
}
