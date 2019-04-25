package com.zc.tom.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/23 14:55
 * @description：
 * @modified By：
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Accessors(chain = true)
public class Result implements Serializable {
    private String uuid;
    private boolean status = true;
}
