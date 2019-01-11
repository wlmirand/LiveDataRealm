package dummyapp.miranda.william.rxpoc.app.main;

import android.arch.lifecycle.ViewModel;

import dummyapp.miranda.william.rxpoc.app.services.BlaService;
import dummyapp.miranda.william.rxpoc.framework.Bla;
import dummyapp.miranda.william.rxpoc.framework.LiveRealmResults;

public class MainViewModel extends ViewModel {

    //Service instance
    private BlaService service = new BlaService();

    public LiveRealmResults<Bla> getAllBlaLiveData() {
        return service.getAllBla();
    }
}
