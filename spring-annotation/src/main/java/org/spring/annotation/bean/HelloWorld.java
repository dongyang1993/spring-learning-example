package org.spring.annotation.bean;

public class HelloWorld {

    private String msg;

    public void speak() {
        System.out.println("Hello" + this.msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
