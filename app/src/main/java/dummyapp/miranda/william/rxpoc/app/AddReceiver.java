package dummyapp.miranda.william.rxpoc.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Date;

import dummyapp.miranda.william.rxpoc.app.services.BlaService;
import dummyapp.miranda.william.rxpoc.framework.Bla;

public class AddReceiver extends BroadcastReceiver {

    private BlaService service = BlaService.getInstance();

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        if ((action == null) || !action.equals("test")) {
            return;
        }

        Bla bla = new Bla(new Date().getTime(), "Carlos");
        this.service.insert(bla);
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction("action");
        context.sendBroadcast(broadcastIntent);
    }

}
