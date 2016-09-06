package com.ican.langsky.xiaozi.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by swd1 on 16-8-28.
 */
public class Wage extends RealmObject {
    @PrimaryKey
    public String time_id;
    public InsEndowment insEndowment;
    public InsHospital insHospital;
    public InsBigHospital insBigHospital;
    public InsEmployInjury insEmployInjury;
    public InsMaternity insMaternity;
    public InsUnemployed insUnemployed;
    public HousingFund housingFund;
    public float myWage;
    public float myIncome;
    public float expenditure;
}
