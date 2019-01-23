package dummyapp.miranda.william.rxpoc.app.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;

import java.util.List;

import dummyapp.miranda.william.rxpoc.app.services.BlaService;
import dummyapp.miranda.william.rxpoc.framework.Bla;
import dummyapp.miranda.william.rxpoc.framework.BlaObject;
import dummyapp.miranda.william.rxpoc.framework.ICallback;
import dummyapp.miranda.william.rxpoc.framework.IResourceManager;

public class MainViewModel extends AndroidViewModel {

    private IResourceManager resourceManager;

    //Service instance
    private BlaService service = BlaService.getInstance();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<BlaObject>> getResultListLiveData() {
        return this.service.getAllBla(resourceManager -> MainViewModel.this.resourceManager = resourceManager);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        this.resourceManager.closeRealmResources();
    }
}
