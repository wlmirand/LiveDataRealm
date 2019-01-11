package dummyapp.miranda.william.rxpoc.framework;

import java.util.List;

import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public abstract class CustomRealmChangeListener<T> implements RealmChangeListener<RealmResults<T>> {

    @Override
    public void onChange(RealmResults<T> ts) {
        onChanged(ts);
    }

    protected abstract void onChanged(List<T> list);
}
