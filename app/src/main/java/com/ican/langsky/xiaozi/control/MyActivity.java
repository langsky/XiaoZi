package com.ican.langsky.xiaozi.control;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ican.langsky.xiaozi.model.Formula;
import com.ican.langsky.xiaozi.utils.RealmTool;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by swd1 on 16-8-28.
 */
public abstract class MyActivity extends AppCompatActivity implements Control {

    protected Realm realm;
    private Formula formula;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (realm == null)
            realm = Realm.getDefaultInstance();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (realm != null) {
            realm.removeAllChangeListeners();
            realm.close();
        }
    }


    public Formula getFormula(){
        if (formula==null){
            setFormula(new Formula());
        }
        return formula;
    }

    public void setFormula(final Formula formula) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insertOrUpdate(formula);
            }
        });
        this.formula = formula;
    }
}
