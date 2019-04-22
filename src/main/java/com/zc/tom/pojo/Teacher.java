package com.zc.tom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 22:14
 * @description：辅导员
 * @modified By：
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Teacher implements Serializable {
    private String teaUUID;//辅导员编号
    private String teaName;//辅导员名称
    private String password;//密码
    private String telephone;//辅导员电话
    private Boolean status;//状态 0删除
    private Boolean root;//是否为管理员
}
