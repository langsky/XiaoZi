package com.ican.langsky.xiaozi.utils;

import com.ican.langsky.xiaozi.control.Control;
import com.ican.langsky.xiaozi.control.QueryMode;
import com.ican.langsky.xiaozi.model.Formula;
import com.ican.langsky.xiaozi.model.HousingFund;
import com.ican.langsky.xiaozi.model.InsBigHospital;
import com.ican.langsky.xiaozi.model.InsEmployInjury;
import com.ican.langsky.xiaozi.model.InsEndowment;
import com.ican.langsky.xiaozi.model.InsHospital;
import com.ican.langsky.xiaozi.model.InsMaternity;
import com.ican.langsky.xiaozi.model.InsUnemployed;
import com.ican.langsky.xiaozi.model.TaxIncome;
import com.ican.langsky.xiaozi.model.Wage;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by swd1 on 16-9-2.
 */
public class RealmTool {

    public static RealmResults query(QueryMode mode) {
        Realm realm = Realm.getDefaultInstance();
        switch (mode) {
            case big_hospitalization_insurance:
                return realm.where(InsBigHospital.class).findAllAsync();
            case hospitalization_insurance:
                return realm.where(InsHospital.class).findAllAsync();
            case housing_fund:
                return realm.where(HousingFund.class).findAllAsync();
            case employment_injury_insurance:
                return realm.where(InsEmployInjury.class).findAllAsync();
            case endowment_insurance:
                return realm.where(InsEndowment.class).findAllAsync();
            case maternity_insurance:
                return realm.where(InsMaternity.class).findAllAsync();
            case unemployed_insurance:
                return realm.where(InsUnemployed.class).findAllAsync();
            case wage:
                return realm.where(Wage.class).findAllAsync();
            case formula:
                return realm.where(Formula.class).findAllAsync();
            case income_tax:
                return realm.where(TaxIncome.class).findAllAsync();
            default:
                throw new IllegalArgumentException("wrong mode");
        }
    }

    public static void dataToRealmAndView(final RealmObject object, Control control) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insertOrUpdate(object);
            }
        });
        control.changeToView(object);
    }

    private static float[][] caculateData(final Formula formula, final float wage) {
        float[] per = {
                CalculationTool.BhosPer(formula, wage),
                CalculationTool.EmiPer(formula, wage),
                CalculationTool.EndPer(formula, wage),
                CalculationTool.HosPer(formula, wage),
                CalculationTool.HouPer(formula, wage),
                CalculationTool.MatPer(formula, wage),
                CalculationTool.UniPer(formula, wage),
                CalculationTool.TaxInc(formula, wage)};
        float[] com = {
                CalculationTool.BhosCom(formula, wage),
                CalculationTool.EmiCom(formula, wage),
                CalculationTool.EndCom(formula, wage),
                CalculationTool.HosCom(formula, wage),
                CalculationTool.HouCom(formula, wage),
                CalculationTool.MatCom(formula, wage),
                CalculationTool.UniCom(formula, wage),
        };
        return new float[][]{per, com};
    }

    public static Wage dataToWage(final Formula formula, final float wage, String time) {
        float[] per = caculateData(formula, wage)[0];
        float[] com = caculateData(formula, wage)[1];
        InsBigHospital _insBigHospital = new InsBigHospital().setTimeData(time).setPerExpend(per[0]).setComExpend(com[0]);
        InsEmployInjury emI_ins = new InsEmployInjury().setTimeData(time).setPerExpend(per[1]).setComExpend(com[1]);
        InsEndowment end_ins = new InsEndowment().setTimeData(time).setPerExpend(per[2]).setComExpend(com[2]);
        InsHospital hos_ins = new InsHospital().setTimeData(time).setPerExpend(per[3]).setComExpend(com[3]);
        HousingFund hou_fund = new HousingFund().setTimeData(time).setPerExpend(per[4]).setComExpend(com[4]);
        InsMaternity mat_ins = new InsMaternity().setTimeData(time).setPerExpend(per[5]).setComExpend(com[5]);
        InsUnemployed unI_ins = new InsUnemployed().setTimeData(time).setPerExpend(per[6]).setComExpend(com[6]);
        TaxIncome inc_tax = new TaxIncome().setTimeData(time).setTax(per[7]);
        Wage myIncome = new Wage();
        myIncome.time_id = time;
        myIncome.insBigHospital = _insBigHospital;
        myIncome.insEmployInjury = emI_ins;
        myIncome.insEndowment = end_ins;
        myIncome.insHospital = hos_ins;
        myIncome.housingFund = hou_fund;
        myIncome.insMaternity = mat_ins;
        myIncome.insUnemployed = unI_ins;
        myIncome.taxIncome = inc_tax;
        myIncome.myWage = wage;
        float y = 0;
        for (int i = 0; i < per.length; i++) {
            y += per[i];
        }
        myIncome.myIncome = wage - y;
        myIncome.expenditure = y;
        return myIncome;
    }

    /**
     * Created by swd1 on 16-9-2.
     */
    public static class CalculationTool {

        private static float Emi(Formula formula, float wage) {
            if (wage <= formula.min_base_emi)
                return formula.min_base_emi;
            if (wage >= formula.max_base_emi)
                return formula.max_base_emi;
            return wage;
        }

        private static float End(Formula formula, float wage) {
            if (wage <= formula.min_base_end)
                return formula.min_base_end;
            if (wage >= formula.max_base_end)
                return formula.max_base_end;
            return wage;
        }

        private static float Hos(Formula formula, float wage) {
            if (wage <= formula.min_base_hos)
                return formula.min_base_hos;
            if (wage >= formula.max_base_hos)
                return formula.max_base_hos;
            return wage;
        }

        private static float Hou(Formula formula, float wage) {
            if (wage <= formula.min_base_hou)
                return formula.min_base_hou;
            if (wage >= formula.max_base_hou)
                return formula.max_base_hou;
            return wage;
        }

        private static float Mat(Formula formula, float wage) {
            if (wage <= formula.min_base_mat)
                return formula.min_base_mat;
            if (wage >= formula.max_base_mat)
                return formula.max_base_mat;
            return wage;
        }

        private static float Uni(Formula formula, float wage) {
            if (wage <= formula.min_base_uni)
                return formula.min_base_uni;
            if (wage >= formula.max_base_uni)
                return formula.max_base_uni;
            return wage;
        }

        public static float BhosPer(Formula formula, float wage) {
            return 3;
        }

        public static float BhosCom(Formula formula, float wage) {
            return 0;
        }

        public static float EmiPer(Formula formula, float wage) {
            return Emi(formula, wage) * formula.per_rate_emi;
        }

        public static float EmiCom(Formula formula, float wage) {
            return Emi(formula, wage) * formula.com_rate_emi;
        }

        public static float EndPer(Formula formula, float wage) {
            return End(formula, wage) * formula.per_rate_end;
        }

        public static float EndCom(Formula formula, float wage) {
            return End(formula, wage) * formula.com_rate_end;
        }

        public static float HosPer(Formula formula, float wage) {
            return Hos(formula, wage) * formula.per_rate_hos;
        }

        public static float HosCom(Formula formula, float wage) {
            return Hos(formula, wage) * formula.com_rate_hos;
        }

        public static float HouPer(Formula formula, float wage) {
            return Hou(formula, wage) * formula.per_rate_hou;
        }

        public static float HouCom(Formula formula, float wage) {
            return Hou(formula, wage) * formula.com_rate_hou;
        }

        public static float MatPer(Formula formula, float wage) {
            return Mat(formula, wage) * formula.per_rate_mat;
        }

        public static float MatCom(Formula formula, float wage) {
            return Mat(formula, wage) * formula.com_rate_mat;
        }

        public static float UniPer(Formula formula, float wage) {
            return Uni(formula, wage) * formula.per_rate_uni;
        }

        public static float UniCom(Formula formula, float wage) {
            return Uni(formula, wage) * formula.com_rate_uni;
        }

        public static float TaxInc(Formula formula, float wage) {
            float v = wage - 3500;
            if (v<0)
                return 0;
            if (v < formula.f1)
                return v * formula.f1_rate_tax + formula.f1_base_tax;
            else if (v < formula.f2)
                return (v-formula.f1) * formula.f2_rate_tax + formula.f2_base_tax;
            else if (v < formula.f3)
                return (v-formula.f2) * formula.f3_rate_tax + formula.f3_base_tax;
            else if (v < formula.f4)
                return (v-formula.f3) * formula.f4_rate_tax + formula.f4_base_tax;
            else if (v < formula.f5)
                return (v-formula.f4) * formula.f5_rate_tax + formula.f5_base_tax;
            else if (v < formula.f6)
                return (v-formula.f5) * formula.f6_rate_tax + formula.f6_base_tax;
            else if (v >= formula.f6)
                return (v - formula.f6) * formula.f7_rate_tax + formula.f7_base_tax;
            return 0;
        }
    }
}
