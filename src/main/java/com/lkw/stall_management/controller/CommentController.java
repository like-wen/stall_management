package com.lkw.stall_management.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lkw.stall_management.entity.Comment;
import com.lkw.stall_management.entity.User;
import com.lkw.stall_management.entity.Vo.CommentVo;
import com.lkw.stall_management.service.CommentService;
import com.lkw.stall_management.service.UserService;
import com.lkw.stall_management.utils.R;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/common")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    //按照stall_id列出所有评论
    @GetMapping("listComment/{stallId}")
    public R listCommonOnStall(@PathVariable String stallId){
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("stall_id",stallId);
        List<Comment> list=commentService.list(queryWrapper);
        //创建CommentVo的list,添加用户信息,滤去更新时间,逻辑删除等
        List<CommentVo> commentVoList = list.stream().map(comment -> {
            //两个对象之间的复制
            CommentVo commentVo = new CommentVo();
            BeanUtils.copyProperties(comment, commentVo);
            //查询用户信息,并添加
            User user = userService.getById(comment.getUserId());
            commentVo.setUserName(user.getUsername());
            commentVo.setProfileUrl(user.getProfileUrl());
            //返回并被收集成List<CommentVo>
            return commentVo;
        }).collect(Collectors.toList());
        return R.ok().data("list",commentVoList);
    }

    //
    @PostMapping("addComment")
    public R addComment(@RequestBody Comment comment){
        comment.setId(null);
        commentService.save(comment);
        return R.ok();
    }

    @DeleteMapping("{id}")
    public R deleteComment(@PathVariable String id){
        commentService.removeById(id);
        return R.ok();
    }


}
