package com.example.mybatis.controller;

import com.example.mybatis.bean.ResBody;
import com.example.mybatis.entity.User;
import com.example.mybatis.enums.ResEnum;
import com.example.mybatis.service.UserService;
import com.example.mybatis.utils.ResBodyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;


@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("getById")
    public ResBody getUserById(@RequestParam("id") Integer id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResBodyUtil.fail();
        }
        else {
            return ResBodyUtil.success(user);
        }
    }

    @RequestMapping("addUser")
    public ResBody addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResBodyUtil.success();
    }

    @RequestMapping("userRegistry")
    public ResBody userRegistry(@RequestBody User user) {
        userService.userRegistry(user);
        return ResBodyUtil.success();
    }

    @RequestMapping("updateUser")
    public ResBody updateUser(@RequestBody User user) {
        User dbUser = userService.getUserById(user.getId());
        if (dbUser == null) {
            return ResBodyUtil.fail();
        }
        userService.updateUser(user);
        return ResBodyUtil.success();
    }

    @RequestMapping("updateUserMap")
    public ResBody updateUserMap(@RequestBody Map<String, Object> map) {
        User dbUser = userService.getUserById((Integer)map.get("id"));
        if (dbUser == null) {
            return ResBodyUtil.fail();
        }
        userService.updateUserMap(map);
        return ResBodyUtil.success();
    }

    @PostMapping("userDestroy")
    public ResBody userDestroy(@RequestParam Integer id) {
        Integer res = userService.deleteUser(id);
        log.info("execution result: {}", res);
        if (res == 1) {
            return ResBodyUtil.success();
        }
        else {
            return ResBodyUtil.fail(ResEnum.NOT_EXIST);
        }
    }
}
