package io.blog.util;

import lombok.Data;

@Data
public class Response<T> {
    private int status;
    private String msg;
    private T data;
}
