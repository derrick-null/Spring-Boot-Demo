package com.derrick.vo;

import java.util.Date;

/**
 * Created by Derrick on 2016/7/11.
 */
public class RequestVO {

    private String base64Token;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBase64Token() {
        return base64Token;
    }

    public void setBase64Token(String base64Token) {
        this.base64Token = base64Token;
    }

    @Override
    public String toString() {
        return "RequestVO{" +
                "base64Token='" + base64Token + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
