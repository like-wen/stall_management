package com.lkw.stall_management.entity.Vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ManagerQuery {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "名字,模糊查询")
    private String name;

    @ApiModelProperty(value = "区域")
    private String district;

}
