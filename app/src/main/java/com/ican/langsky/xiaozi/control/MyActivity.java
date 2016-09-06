package com.ican.langsky.xiaozi.control;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ican.langsky.xiaozi.utils.RealmTool;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by swd1 on 16-8-28.
 */
public abstract class MyActivity extends AppCompatActivity implements Control {

    protected Realm realm;
    protected RealmChangeListener listener = new RealmChangeListener() {
        @Override
        public void onChange(Object element) {
            doWhenDataChange(element);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (realm == null)
            realm = Realm.getDefaultInstance();
        realm.addChangeListener(listener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (realm != null) {
            realm.removeAllChangeListeners();
            realm.close();
        }
    }

    @Override
    public RealmResults query(QueryMode mode) {
        return RealmTool.query(mode);
    }
}
