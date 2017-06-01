package com.system.ccew.token;

import com.google.gson.Gson;

/**
 * @author finderlo
 * @date 15/05/2017
 */
public class TokenModel {

    private int uid;

    private String token;

    public TokenModel(int uid, String token) {
        this.uid = uid;
        this.token = token;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
