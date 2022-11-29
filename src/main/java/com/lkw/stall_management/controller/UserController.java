package com.lkw.stall_management.controller;

import com.lkw.stall_management.entity.User;
import com.lkw.stall_management.service.UserService;
import com.lkw.stall_management.utils.R;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Api("博文相关操作")
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("updateUser")
    public R updateUser(@RequestBody User user){
        user.setPassword(null);
        System.out.println(user.toString());

        if (userService.updateById(user)) {
            return R.ok().message("修改用户信息成功");
        }else{
            return R.error().message("修改用户信息失败");
        }
    }

    @PostMapping("updatePassword/{id}/{oldPWD}/{newPWD}")
    public R updatePassword(@PathVariable String id,
                            @PathVariable String oldPWD,
                            @PathVariable String newPWD){
        String myOld = userService.getById(id).getPassword();
        if(myOld.equals(oldPWD)) {
            User user = new User();
            user.setId(id);
            user.setPassword(newPWD);
            userService.updateById(user);
            return R.ok().message("修改密码成功");
        }
        return R.error().message("旧密码错误");
    }
}
