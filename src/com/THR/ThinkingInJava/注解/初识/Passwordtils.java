package com.THR.ThinkingInJava.ע��.��ʶ;

public class Passwordtils {

    @UserCase(id = 10, description = "����������Ҫ����һ������")
    public boolean validtePassword(String password) {
        return true;
    }
    @UserCase(id = 20)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }
}
