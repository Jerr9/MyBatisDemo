package com.example.mybatis.controller;

import com.example.mybatis.bean.Result;
import com.example.mybatis.entity.User;
import com.example.mybatis.enums.ResEnum;
import com.example.mybatis.exception.GlobalException;
import com.example.mybatis.service.UserService;
import com.example.mybatis.utils.GenKeyUtil;
import com.example.mybatis.utils.ResultUtil;
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
    public Result getUserById(@RequestParam("uid") String uid) {
        User user = userService.getUserByUid(uid);
        log.warn("=============== {}", uid);
        if (user == null) {
            throw new GlobalException(ResEnum.USER_NOT_EXIST);
        }
        else {
            return ResultUtil.success(user);
        }
    }

    @RequestMapping("addUser")
    public Result addUser(@RequestBody User user) {
        user.setUid(GenKeyUtil.genUniqueStringKey());
        log.info("++++++++++++ {}", user);
        userService.addUser(user);
        return ResultUtil.success();
    }

    @RequestMapping("userRegistry")
    public Result userRegistry(@RequestBody User user) {
        user.setUid(GenKeyUtil.genUniqueStringKey());
        userService.userRegistry(user);
        return ResultUtil.success();
    }

    @RequestMapping("updateUser")
    public Result updateUser(@RequestBody User user) {
        User dbUser = userService.getUserByUid(user.getUid());
        if (dbUser == null) {
            return ResultUtil.fail();
        }
        userService.updateUser(user);
        return ResultUtil.success();
    }

    @RequestMapping("updateUserMap")
    public Result updateUserMap(@RequestBody Map<String, Object> map) {
        User dbUser = userService.getUserByUid((String) map.get("uid"));
        if (dbUser == null) {
            return ResultUtil.fail();
        }
        userService.updateUserMap(map);
        return ResultUtil.success();
    }

    @PostMapping("userDestroy")
    public Result userDestroy(@RequestParam("uid") String uid) {
        Integer res = userService.deleteUser(uid);
        log.info("execution result: {}", res);
        if (res == 1) {
            return ResultUtil.success();
        }
        else {
            return ResultUtil.fail(ResEnum.NOT_EXIST);
        }
    }
}
