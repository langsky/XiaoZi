package com.ican.langsky.xiaozi.control;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ican.langsky.xiaozi.R;
import com.ican.langsky.xiaozi.model.Wage;
import com.ican.langsky.xiaozi.utils.RealmTool;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MainActivity extends MyActivity implements View.OnClickListener {
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.tv_bhos)
    TextView tvBhos;
    @BindView(R.id.tv_emi)
    TextView tvEmi;
    @BindView(R.id.tv_end)
    TextView tvEnd;
    @BindView(R.id.tv_hos)
    TextView tvHos;
    @BindView(R.id.tv_hou)
    TextView tvHou;
    @BindView(R.id.mat)
    TextView tvMat;
    @BindView(R.id.tv_uni)
    TextView tvUni;
    @BindView(R.id.outcome)
    TextView tvOut;
    @BindView(R.id.time)
    TextView tvTime;
    @BindString(R.string.standardTransition)
    String trans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fab.setOnClickListener(this);
        tvTime.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        float wage = Float.valueOf(editText.getText().toString());
        String time = tvTime.getText().toString();
        switch (v.getId()){
            case R.id.fab:
                Wage myIncome = RealmTool.dataToWage(getFormula(),wage,time);
                RealmTool.dataToRealmAndView(myIncome,this);
                break;
            }
        }

    @Override
    public void queryToView(QueryMode mode) {

    }

    @Override
    public void changeToView(Object object) {
        Wage myIncome = (Wage) object;
        tvBhos.setText(myIncome.insBigHospital.getPerExpend()+"  "+myIncome.insBigHospital.getComExpend());
        tvEmi.setText(myIncome.insEmployInjury.getPerExpend()+"  "+myIncome.insEmployInjury.getComExpend());
        tvEnd.setText(myIncome.insEndowment.getPerExpend()+"  "+myIncome.insEndowment.getComExpend());
        tvHos.setText(myIncome.insHospital.getPerExpend()+"  "+myIncome.insHospital.getComExpend());
        tvHou.setText(myIncome.housingFund.getPerExpend()+"  "+myIncome.housingFund.getComExpend());
        tvMat.setText(myIncome.insMaternity.getPerExpend()+"  "+myIncome.insMaternity.getComExpend());
        tvUni.setText(myIncome.insUnemployed.getPerExpend()+"  "+myIncome.insUnemployed.getComExpend());
        tvOut.setText(myIncome.myIncome +"  "+myIncome.expenditure+"  "+myIncome.taxIncome.getIncomeTax());
    }
}
