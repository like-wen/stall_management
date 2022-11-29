package com.lkw.stall_management.entity.Vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class CommentVo {
    /**
     *
     */
    private String id;

    /**
     * 评论用户id
     */
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户头像
     */
    private String profileUrl;

    /**
     * 点赞数
     */
    private Integer likes;

    /**
     * 评论内容
     */
    private String comment;

    /**
     * 评分等级
     */
    private Integer stars;


    /**
     * 创建时间
     */
    private Date gmtCreate;


}
