package com.example.administrator.subscriberidget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    Button SubscriberIdGetBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SubscriberIdGetBtn = (Button) findViewById(R.id.getSubscriberId_btn);
        SubscriberIdGetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check() != PackageManager.PERMISSION_GRANTED) {
                    request();
                }
                TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                String id = telephonyManager.getSubscriberId();
                if(id!=null){
                    Toast.makeText(MainActivity.this,id,Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"can not find",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private int check() {
        return checkSelfPermission("android.permission.READ_PHONE_STATE");
    }

    private void request() {
        requestPermissions(new String[]{"android.permission.READ_PHONE_STATE"}, 1);
    }
}
