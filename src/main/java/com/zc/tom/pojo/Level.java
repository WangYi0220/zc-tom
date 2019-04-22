package com.zc.tom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 21:24
 * @description：等级表
 * @modified By：
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Level implements Serializable {
    private Integer levelID;//等级编号
    private String levelName;//等级编号
    private Integer salary;//基本月薪/分
    private Integer integral;//级别最低积分
}
