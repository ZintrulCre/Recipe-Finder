package com.zintrulcre.RecipeFinder.domain;

import org.json.simple.JSONObject;

public class ReceiveObject {
    private String a;
    private JSONObject b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public JSONObject getB() {
        return b;
    }

    public void setB(JSONObject b) {
        this.b = b;
    }

    public ReceiveObject(String a, JSONObject b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "ReceiveObject{" +
                "a='" + a + '\'' +
                ", b=" + b +
                '}';
    }
}
