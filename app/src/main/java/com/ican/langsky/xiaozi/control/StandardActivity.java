package com.ican.langsky.xiaozi.control;

import android.os.Bundle;
import android.widget.TextView;

import com.ican.langsky.xiaozi.R;
import com.ican.langsky.xiaozi.model.Formula;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class StandardActivity extends MyActivity {
    @BindView(R.id.tv_st_emi)
    TextView emi;
    @BindView(R.id.seek_st_emi)
    DiscreteSeekBar emiBar;

    Formula standard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);
        ButterKnife.bind(this);
        standard = new Formula();

        emiBar.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(final DiscreteSeekBar seekBar) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        standard.per_rate_emi = seekBar.getProgress();
                        realm.copyToRealmOrUpdate(standard);
                        emi.setText(standard.per_rate_emi+"");
                    }
                });
            }
        });
    }


    @Override
    public void queryToView(QueryMode mode) {

    }

    @Override
    public void changeToView(Object object) {

    }
}
