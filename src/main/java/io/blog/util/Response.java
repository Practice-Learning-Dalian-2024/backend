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

    // 成功响应（不带数据）
    public static <T> Response<T> success() {
        return new Response<>(200, "Success", null);
    }

    // 成功响应（带数据）
    public static <T> Response<T> success(T data) {
        return new Response<>(200, "Success", data);
    }

    // 成功响应（带消息）
    public static <T> Response<T> success(String msg) {
        return new Response<>(200, msg, null);
    }

    // 成功响应（带消息和数据）
    public static <T> Response<T> success(String msg, T data) {
        return new Response<>(200, msg, data);
    }

    // 错误响应（带消息）
    public static <T> Response<T> error(String msg) {
        return new Response<>(500, msg, null);
    }

    // 错误响应（带状态码和消息）
    public static <T> Response<T> error(int status, String msg) {
        return new Response<>(status, msg, null);
    }

    // 错误响应（带状态码、消息和数据）
    public static <T> Response<T> error(int status, String msg, T data) {
        return new Response<>(status, msg, data);
    }

    // 自定义响应（带状态码和数据）
    public static <T> Response<T> of(int status, T data) {
        return new Response<>(status, null, data);
    }

    // 自定义响应（带状态码、消息和数据）
    public static <T> Response<T> of(int status, String msg, T data) {
        return new Response<>(status, msg, data);
    }

}
