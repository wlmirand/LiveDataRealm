package dummyapp.miranda.william.rxpoc.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Date;

import dummyapp.miranda.william.rxpoc.app.services.BlaService;
import dummyapp.miranda.william.rxpoc.framework.Bla;

public class AddReceiver extends BroadcastReceiver {

    private BlaService service = new BlaService();

    @Override
    public void onReceive(Context context, Intent intent) {
        Bla bla = new Bla(new Date().getTime(), "Carlos");
        service.insert(bla);
    }

}
