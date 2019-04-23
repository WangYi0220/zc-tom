package com.zc.tom.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 21:47
 * @description：赏罚分类
 * @modified By：
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class StipulationClassify implements Serializable {
    private Integer scID;//赏罚分类编号
    private String scName;//分类名称
    private Boolean flag;//罚为0，赏为1
}
