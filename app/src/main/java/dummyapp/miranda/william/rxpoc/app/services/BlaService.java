package dummyapp.miranda.william.rxpoc.app.services;

import dummyapp.miranda.william.rxpoc.framework.Bla;
import dummyapp.miranda.william.rxpoc.framework.BlaRepository;
import dummyapp.miranda.william.rxpoc.framework.LiveRealmResults;

public class BlaService {

    private BlaRepository repository = new BlaRepository();

    public void insert(Bla bla) {
        repository.add(bla);
    }

    public LiveRealmResults<Bla> getAllBla() {
        return repository.getAll();
    }

}
