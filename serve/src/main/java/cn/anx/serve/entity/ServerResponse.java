package cn.anx.serve.entity;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * 实时通讯返回值.
 * @author  anx
 * @since 2021/12/27 15:39
 */
@Data
public class ServerResponse<T> {

    private Integer code;

    private String msg;

    private T data;

    private ServerResponse() {}

    public ServerResponse(final Integer code, final String msg, final T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ServerResponse(final Integer code, final String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ServerResponse(final Integer code, final T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ServerResponse<T> success(final T data) {
        return new ServerResponse<T>(HttpStatus.OK.value(), data);
    }

    public static <T> ServerResponse<T> success(final String msg, final T data) {
        return new ServerResponse<T>(HttpStatus.OK.value(), msg, data);
    }


    public static <T> ServerResponse<T> fail(final String msg) {
        return new ServerResponse<T>(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, null);
    }

    public static <T> ServerResponse<T> fail(final String msg, final T data) {
        return new ServerResponse<T>(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, data);
    }




}

