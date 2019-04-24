package com.zc.tom.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shiloh
 * @Date Created in 2019/4/24 20:57
 * @description 封装查询条件
 * @modified By:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class QueryVo {
    private Integer flag;//赏罚区分，1为赏，0为罚
    private String stuUUID;//学生编号
    private String beginTime;//赏罚开始时间
    private String endTime;//赏罚结束时间
}
