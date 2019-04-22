package com.zc.tom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 21:39
 * @description：学生职位变动记录表
 * @modified By：
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PositionRecord implements Serializable {
    private String prUUID;//记录编号
    private String stuUUID;//学生编号
    private String prName;//变动名称
    private String remark;//备注说明
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;//变动时间

}
