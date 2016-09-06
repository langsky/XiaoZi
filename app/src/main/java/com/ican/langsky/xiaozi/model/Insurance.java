package com.ican.langsky.xiaozi.model;

import io.realm.RealmModel;

/**
 * Created by swd1 on 16-9-1.
 */
public interface Insurance extends RealmModel {
    float getPerExpend();
    float getComExpend();
    float getAllExpend();
    Insurance setPerExpend(float exp);
    Insurance setComExpend(float exp);
    Insurance setTimeData(String time);
}
