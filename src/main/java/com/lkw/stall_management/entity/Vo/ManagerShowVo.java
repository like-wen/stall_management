package com.lkw.stall_management.entity.Vo;

import lombok.Data;

@Data
public class ManagerShowVo {
    /**
     * 城管id
     */
    private String id;

    /**
     * 城管名字
     */
    private String name;

    /**
     * 头像
     */
    private String profileUrl;

    /**
     * 电话
     */
    private String phonenumber;

    /**
     * 区域
     */
    private String district;

}
