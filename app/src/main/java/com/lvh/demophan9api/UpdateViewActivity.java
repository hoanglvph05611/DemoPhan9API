package com.lvh.demophan9api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class UpdateViewActivity extends AppCompatActivity {

    private TextView tvResult;
    private BroadcastReceiver mBroadcastReceiver;
    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_view);
        tvResult = findViewById(R.id.tvResult);

    }
    public void startUpdateView(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                count++;
                tvResult.setText(" " + count);


            }
        };
        registerReceiver(mBroadcastReceiver,intentFilter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startUpdateView();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mBroadcastReceiver);
    }
}
