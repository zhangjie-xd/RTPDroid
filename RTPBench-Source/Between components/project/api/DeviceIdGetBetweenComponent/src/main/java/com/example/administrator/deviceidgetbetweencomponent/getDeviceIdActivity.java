package com.example.administrator.deviceidgetbetweencomponent;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class getDeviceIdActivity extends AppCompatActivity {

    Button getDeviceIdBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_device_id);
        getDeviceIdBtn = (Button)findViewById(R.id.getId_btn);
        getDeviceIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                String id = telephonyManager.getDeviceId();
                if(id!=null){
                    Toast.makeText(getDeviceIdActivity.this,id,Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getDeviceIdActivity.this,"can not find",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
