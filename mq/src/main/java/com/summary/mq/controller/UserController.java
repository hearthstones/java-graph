package com.summary.mq.controller;

import com.summary.mq.pojo.dto.AddUserDTO;
import com.summary.mq.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * UserController
 *
 * @author luchao
 * @since 2022/5/18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/add")
    public void add(@RequestBody AddUserDTO dto) {
        userService.add(dto);
    }

}
