package com.ican.langsky.xiaozi.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by hgl on 16-9-6.
 */
public class TaxIncome extends RealmObject{
    @PrimaryKey
    private String time_id;
    private float incomeTax;

    public TaxIncome setTimeData(String timeData) {
        this.time_id = timeData;
        return this;
    }

    public TaxIncome setTax(float tax) {
        incomeTax = tax;
        return this;
    }

    public float getIncomeTax() {
        return incomeTax;
    }

    public String getTime_id() {
        return time_id;
    }
}
