package com.zc.tom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 22:11
 * @description：
 * @modified By：
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student implements Serializable {
    private String stuUUID;//
    private String stuName;//
    private String stuNo;//
    private String classUUID;//
    private Integer levelID;//
    private String email;//
    private String status;//

    public Student(String stuUUID, String stuName, String stuNo, String classUUID, String email) {
        this.stuUUID = stuUUID;
        this.stuName = stuName;
        this.stuNo = stuNo;
        this.classUUID = classUUID;
        this.email = email;
    }
}
