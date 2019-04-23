package com.zc.tom.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 21:27
 * @description：职位表
 * @modified By：
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Position implements Serializable {
    private Integer postID;//职位编号
    private String postName;//职位名称
    private Integer postSubsidy;//岗位补贴/分
}
