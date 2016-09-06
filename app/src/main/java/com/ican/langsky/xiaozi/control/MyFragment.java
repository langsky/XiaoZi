package com.ican.langsky.xiaozi.control;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.ican.langsky.xiaozi.utils.RealmTool;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by swd1 on 16-8-30.
 */
public abstract class MyFragment extends Fragment implements Control {

    protected Realm realm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (realm == null)
            realm = Realm.getDefaultInstance();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (realm != null) {
            realm.removeAllChangeListeners();
            realm.close();
        }
    }

}
