package com.zc.tom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 22:06
 * @description：学生赏罚记录表
 * @modified By：
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StipulationRecord implements Serializable {
    private String srUUID;//记录编号
    private String stuUUID;//学生编号
    private Integer sID;//规定编号
    private String srName;//赏罚名称
    private String remark;//备注说明
    private Date createTime;//变动时间
}
