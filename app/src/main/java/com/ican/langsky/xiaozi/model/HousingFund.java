package com.ican.langsky.xiaozi.model;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by swd1 on 16-8-28.
 * housing fund
 */
public class HousingFund extends RealmObject implements Insurance{

    @PrimaryKey
    public String time_id;
    private float per_expend;
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
    public HousingFund setPerExpend(float exp) {
        per_expend = exp;
        return this;
    }

    @Override
    public HousingFund setComExpend(float exp) {
        com_expend = exp;
        return this;
    }

    @Override
    public HousingFund setTimeData(String time) {
        time_id = time;
        return this;
    }

    @Override
    public float getAllExpend() {
        return getPerExpend() + getComExpend();
    }
}
