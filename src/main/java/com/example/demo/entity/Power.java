package com.example.demo.entity;

/**
 * Created by Administrator on 2021/4/7.
 */
public class Power {
    int powerId;
    int powerDo;

    public int getPowerId() {
        return powerId;
    }

    public void setPowerId(int powerId) {
        this.powerId = powerId;
    }

    public int getPowerDo() {
        return powerDo;
    }

    public void setPowerDo(int powerDo) {
        this.powerDo = powerDo;
    }

    public String getPowerDoDes() {
        return powerDoDes;
    }

    public void setPowerDoDes(String powerDoDes) {
        this.powerDoDes = powerDoDes;
    }

    String powerDoDes;
}
