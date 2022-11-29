package com.lkw.stall_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkw.stall_management.entity.Comment;
import com.lkw.stall_management.service.CommentService;
import com.lkw.stall_management.mapper.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author 李可文
* @description 针对表【comment】的数据库操作Service实现
* @createDate 2022-11-28 23:05:56
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

}




