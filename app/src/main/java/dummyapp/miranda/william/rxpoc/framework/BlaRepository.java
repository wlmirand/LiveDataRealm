package dummyapp.miranda.william.rxpoc.framework;

import io.realm.Realm;
import io.realm.RealmResults;

public class BlaRepository implements IRepository<Bla> {

    @Override
    public void add(Bla bla) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(bla);
            }
        });
        realm.close();
    }

    @Override
    public LiveRealmResults<Bla> getAll() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Bla> results = realm.where(Bla.class).findAll();
        return new LiveRealmResults<>(results);
    }

}
