package com.example.oasystem_1_0.exception;

/**
 * @author:xiehcao
 * @Date:2018/4/18
 * @Time:15:17
 * @description：
 */
public class ItemException  extends Throwable{

    private String message;

    public ItemException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return "ItemException{" +
                "message='" + message + '\'' +
                '}';
    }
}
