package com.cloud.feignservice.model;

import lombok.Data;

@Data
public class CommonResult<T> {
    private T data;
    private String message;
    private Integer code;

    public CommonResult(){}

    public CommonResult(T data, String message, Integer code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public CommonResult(String message, Integer code) {
        this(null, message, code);
    }

    public CommonResult(T data) {
        this(data, "Successful", 200);
    }

}


