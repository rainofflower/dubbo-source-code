package com.yanghui.learn.dubbo.controller;

import com.yanghui.learn.dubbo.provider.dto.UserDTO;
import com.yanghui.learn.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangHui
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser")
    public UserDTO getUser(@RequestParam Long id){
        UserDTO user = userService.getUserById(id);
        return user;
    }
}
