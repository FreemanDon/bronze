package com.bronze.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Don
 * @version 1.0
 * @create 2018-03-20 21:43
 * http请求返回的最外层对象
 **/
@Data
public class ResultVO<T> implements Serializable {
    /*错误码*/
    private Integer code;
    /*提示消息*/
    private String meg;
    /*具体内容详细*/
    private T data;
}
