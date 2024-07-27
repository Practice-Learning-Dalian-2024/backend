package io.blog.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private int status;//0-成功，1-失败
    private String msg;//提示信息
    private T data;//相应数据
    public static <E> Response<E> success(E data){
        return new Response<>(0,"操作成功",data);
    }

    //返回操作成功相应结果
    public static Response success(){return new Response(0,"操作成功", null);}

    //返回操作失败，并填写操作失败原因(msg)
    public static Response error(String msg){return new Response(1,msg,null);}
}
