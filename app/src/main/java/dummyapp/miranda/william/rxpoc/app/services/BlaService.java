package dummyapp.miranda.william.rxpoc.app.services;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;

import java.util.ArrayList;
import java.util.List;

import dummyapp.miranda.william.rxpoc.framework.Bla;
import dummyapp.miranda.william.rxpoc.framework.BlaObject;
import dummyapp.miranda.william.rxpoc.framework.BlaRepository;
import dummyapp.miranda.william.rxpoc.framework.ICallback;

public class BlaService {

    private static BlaService service;

    private BlaRepository repository;

    private BlaService(BlaRepository repository) {
        this.repository = repository;
    }

    public static BlaService getInstance() {
        synchronized (BlaService.class) {
            if (service == null) {
                service = new BlaService(new BlaRepository());
            }
        }

        return service;
    }

    public void insert(Bla bla) {
        repository.add(bla);
    }

    public LiveData<List<BlaObject>> getAllBla(ICallback callback) {
        return Transformations.map(repository.getAll(callback), sources -> {
            List<BlaObject> destinations = new ArrayList<>();

            for (Bla source : sources) {
                destinations.add(new BlaObject(source.getId(), source.getName()));
            }
            return destinations;
        });
    }
}
