package com.lkw.stall_management.handler.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义异常类
 */
@Data
@AllArgsConstructor  //全参数构造器
@NoArgsConstructor   //生成无参数构造
public class StallException extends RuntimeException {
    private Integer code;//状态码
    private String msg;//输出消息
}
