package io.blog.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private int status;
    private String msg;
    private T data;
    public static <T> Response<T> success(T data){
        return new Response<>(0,"操作成功",data);
    }
}
