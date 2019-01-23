package dummyapp.miranda.william.rxpoc.framework;

import io.realm.Realm;

public class BlaRepository implements IRepository<Bla> {

    @Override
    public void add(Bla bla) {
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(realm1 -> realm1.copyToRealmOrUpdate(bla));
        }
    }

    @Override
    public LiveRealmResults<Bla> getAll(ICallback callback) {
        Realm realm = Realm.getDefaultInstance();
        callback.onInitialization(new ResourceManager(realm));
        return new LiveRealmResults<>(realm.where(Bla.class).findAll());
    }

}
