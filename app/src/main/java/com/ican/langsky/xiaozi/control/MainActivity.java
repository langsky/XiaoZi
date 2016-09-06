package com.ican.langsky.xiaozi.control;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ican.langsky.xiaozi.R;
import com.ican.langsky.xiaozi.model.Wage;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
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
    public RealmResults query(QueryMode mode) {
        return realm.where(Wage.class).findAll();
    }

    @Override
    public void doWhenDataChange(Object object) {

    }

    @Override
    public void update(RealmObject object) {
    }

    @Override
    public void delete(RealmObject object) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                update(null);
                Wage myIncome = (Wage) query(null).get(0);
                tvBhos.setText(myIncome.insBigHospital.getAllExpend()+"");
                tvEmi.setText(myIncome.insEmployInjury.getAllExpend()+"");
                tvEnd.setText(myIncome.insEndowment.getAllExpend()+"");
                tvHos.setText(myIncome.insHospital.getAllExpend()+"");
                tvHou.setText(myIncome.housingFund.getAllExpend()+"");
                tvMat.setText(myIncome.insMaternity.getAllExpend()+"");
                tvUni.setText(myIncome.insUnemployed.getAllExpend()+"");
                tvOut.setText(myIncome.expenditure +"");
                break;
            }
        }
}
