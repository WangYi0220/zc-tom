package com.zc.tom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author lxl
 * @Date Created in 2019/4/23 9:32
 * @description 响应结果
 * @modified By:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
public class ResponseResult {
    private Boolean status;//响应状态：true=成功，false=失败
    private String message;//响应信息
}
