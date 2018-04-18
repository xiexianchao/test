package com.example.oasystem_1_0.exception;

/**
 * @author:xiehcao
 * @Date:2018/4/18
 * @Time:14:58
 * @description：
 */
public class RegisterException extends Throwable {
    private String message;


    public RegisterException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return "RegisterException{" +
                "message='" + message + '\'' +
                '}';
    }
}
