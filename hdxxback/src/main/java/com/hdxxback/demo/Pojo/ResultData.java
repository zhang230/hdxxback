package com.hdxxback.demo.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.runtime.StoredScript;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(value = { "handler" })
public class ResultData<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResultData(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
