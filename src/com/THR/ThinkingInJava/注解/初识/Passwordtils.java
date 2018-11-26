package com.THR.ThinkingInJava.注解.初识;

public class Passwordtils {

    @UserCase(id = 10, description = "密码至少需要包含一个数字")
    public boolean validtePassword(String password) {
        return true;
    }
    @UserCase(id = 20)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }
}
