package com.example.administrator.subscriberidgetcomponents;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GetSubscriberIdActivity extends AppCompatActivity {

    Button getIdBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_subscriber_id);
        getIdBtn = (Button)findViewById(R.id.getid_btn);
        getIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                String id = telephonyManager.getSubscriberId();
                if(id!=null){
                    Toast.makeText(GetSubscriberIdActivity.this,id,Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(GetSubscriberIdActivity.this,"can not find",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
