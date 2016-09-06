package com.ican.langsky.xiaozi.control;

import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by swd1 on 16-8-28.
 */
public interface Control {
    RealmResults query(QueryMode mode);
    void doWhenDataChange(Object object);
    void update(RealmObject object);
    void delete(RealmObject object);
}
