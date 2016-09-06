package com.ican.langsky.xiaozi.model;

import io.realm.annotations.PrimaryKey;

/**
 * Created by swd1 on 16-8-28.
 * big hospitalization insurance
 */
public class InsBigHospital implements Insurance {

    @PrimaryKey
    public String time_id;
    private float per_expend = 3F;
    private float com_expend;

    public Formula standard;

    @Override
    public float getPerExpend() {
        return per_expend;
    }

    @Override
    public float getComExpend() {
        return com_expend;
    }

    @Override
    public InsBigHospital setPerExpend(float exp) {
        per_expend = exp;
        return this;
    }

    @Override
    public InsBigHospital setComExpend(float exp) {
        com_expend = exp;
        return this;
    }

    @Override
    public InsBigHospital setTimeData(String time) {
        time_id = time;
        return this;
    }

    @Override
    public float getAllExpend() {
        return getPerExpend()+ getComExpend();
    }
}
