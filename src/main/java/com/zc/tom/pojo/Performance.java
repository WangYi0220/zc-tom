package com.zc.tom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/24 15:37
 * @description：
 * @modified By：
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Performance implements Serializable {
    private String perUUID;//绩效表编号
    private String stuUUID;//学生编号
    private String score;//绩效分值 满分100
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;//调整时间
}
