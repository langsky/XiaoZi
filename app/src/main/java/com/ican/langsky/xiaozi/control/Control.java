package com.ican.langsky.xiaozi.control;

import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by swd1 on 16-8-28.
 */
public interface Control {
    void queryToView(QueryMode mode);
    void changeToView(Object object);
}
