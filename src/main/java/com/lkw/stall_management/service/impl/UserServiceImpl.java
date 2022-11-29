package com.lkw.stall_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkw.stall_management.entity.User;
import com.lkw.stall_management.service.UserService;
import com.lkw.stall_management.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 李可文
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-11-28 22:09:41
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




