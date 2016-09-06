package com.ican.langsky.xiaozi.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by swd1 on 16-9-1.
 */
public class Formula extends RealmObject {
    @PrimaryKey
    public String name = "default";

    public float per_rate_bhos;
    public float com_rate_bhos;
    public float min_base_bhos;
    public float max_base_bhos;

    public float per_rate_emi;
    public float com_rate_emi = 0.005F;
    public float min_base_emi = 3878F;
    public float max_base_emi = 19389F;

    public float per_rate_end = 0.08F;
    public float com_rate_end = 0.2F;
    public float min_base_end = 2585F;
    public float max_base_end = 19389F;

    public float per_rate_hos = 0.02F;
    public float com_rate_hos = 0.1F;
    public float min_base_hos = 3878F;
    public float max_base_hos = 19389F;

    public float per_rate_hou = 0.12F;
    public float com_rate_hou = 0.12F;
    public float min_base_hou = 1995F;
    public float max_base_hou = 19389F;

    public float per_rate_mat;
    public float com_rate_mat = 0.08F;
    public float min_base_mat = 3878F;
    public float max_base_mat = 19389F;

    public float per_rate_uni = 0.002F;
    public float com_rate_uni = 0.01F;
    public float min_base_uni = 2585F;
    public float max_base_uni = 19389F;

    public float f1_rate_tax = 0.03F;
    public float f2_rate_tax = 0.1F;
    public float f3_rate_tax = 0.2F;
    public float f4_rate_tax = 0.25F;
    public float f5_rate_tax = 0.3F;
    public float f6_rate_tax = 0.35F;
    public float f7_rate_tax = 0.45F;
    public float f1_base_tax = 0;
    public float f2_base_tax = 105;
    public float f3_base_tax = 555;
    public float f4_base_tax = 1005;
    public float f5_base_tax = 2755;
    public float f6_base_tax = 5505;
    public float f7_base_tax = 13505;
    public float f1 =1500;
    public float f2 =4500;
    public float f3 =9000;
    public float f4 =35000;
    public float f5 =55000;
    public float f6 =80000;


}
