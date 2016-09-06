package com.ican.langsky.xiaozi.model;

/**
 * Created by swd1 on 16-9-1.
 */
public interface Insurance {
    float getPerExpend();
    float getComExpend();
    float getAllExpend();
    Insurance setPerExpend(float exp);
    Insurance setComExpend(float exp);
    Insurance setTimeData(String time);
}
