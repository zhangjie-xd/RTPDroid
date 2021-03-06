package com.example.administrator.deviceidget;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button getDeviceIdBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDeviceIdBtn = (Button)findViewById(R.id.getDeviceId_btn);
        getDeviceIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String permistr = "android.permission.READ_PHONE_STATE";
                TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                if (checkSelfPermission(permistr) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{permistr}, 1);
                }
                String id = telephonyManager.getDeviceId();
                if(id!=null){
                    Toast.makeText(MainActivity.this,id,Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"can not find",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
