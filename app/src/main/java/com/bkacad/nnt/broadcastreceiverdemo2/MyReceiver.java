package com.bkacad.nnt.broadcastreceiverdemo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    private MyListener myListener;

    public MyReceiver(MyListener myListener){
        this.myListener = myListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case "android.intent.action.ACTION_POWER_CONNECTED":
                myListener.powerConnected();
                break;
            case "android.intent.action.ACTION_POWER_DISCONNECTED":
                myListener.powerDisconnected();
                break;
        }
    }
}
