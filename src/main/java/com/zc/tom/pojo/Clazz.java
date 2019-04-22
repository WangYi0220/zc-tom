package com.zc.tom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 21:19
 * @description：班级表
 * @modified By：
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Clazz implements Serializable {
    private String classUUID;//班级编号
    private String grade;//届
    private String className;//班级名称
    private String teaUUID;//辅导员编号
}
