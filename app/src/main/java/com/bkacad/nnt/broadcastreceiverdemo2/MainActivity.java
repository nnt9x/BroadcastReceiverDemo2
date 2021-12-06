package com.bkacad.nnt.broadcastreceiverdemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyListener {

    private TextView tvStatus;
    private ConstraintLayout rootView;

    private MyReceiver myReceiver;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvStatus = findViewById(R.id.tvStatus);
        rootView = findViewById(R.id.rootView);
        // Tao ra broadcast
        myReceiver = new MyReceiver(this);
        // Tao intent filter
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myReceiver);
    }

    @Override
    public void powerConnected() {
        tvStatus.setText("Cắm sạc");
        rootView.setBackgroundResource(android.R.color.holo_green_light);
        Toast.makeText(MainActivity.this,"Cắm sạc",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void powerDisconnected() {
        tvStatus.setText("Rút sạc");
        rootView.setBackgroundResource(android.R.color.holo_red_light);
        Toast.makeText(MainActivity.this, "Rút sạc", Toast.LENGTH_SHORT).show();
    }
}