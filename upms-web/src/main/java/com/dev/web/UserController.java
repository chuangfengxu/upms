package com.dev.web;

import com.dev.bean.User;
import com.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author XuChuangFeng
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/view")
    public User selectByPrimaryKey(@RequestParam String id) {
        return userService.selectByPrimaryKey(id);
    }

    @PostMapping(value = "/add")
    public int insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @GetMapping(value = "/delete")
    public String deleteByPrimaryKey(@RequestParam("id") String id) {
        User user = userService.selectByPrimaryKey(id);
        return "";
    }

    @PostMapping(value = "/update")
    public int update(@RequestBody User user) {
        return userService.updateByPrimaryKey(user);
    }
}
