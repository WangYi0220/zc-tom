package com.zc.tom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 21:43
 * @description：赏罚表
 * @modified By：
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Stipulation implements Serializable {
    private Integer sID;//规定编号
    private Integer scID;//赏罚分类
    private String sName;//规定名称
    private String sRemark;//规定说明
    private String sValue;//加减分项，加为正数，减为负数
}
