package com.example.administrator.deviceidgetbetweencomponent;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CheckAndRequestActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkandrequest);
        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkSelfPermission("android.permission.READ_PHONE_STATE")!= PackageManager.PERMISSION_GRANTED){
                    requestPermissions(new String[]{"android.permission.READ_PHONE_STATE"}, 1);
                }
                else{
                    Intent it = new Intent(CheckAndRequestActivity.this,getDeviceIdActivity.class);
                    startActivity(it);
                }

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1){
            if(grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(CheckAndRequestActivity.this,"权限申请成功",Toast.LENGTH_LONG).show();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent it = new Intent(CheckAndRequestActivity.this,getDeviceIdActivity.class);
                startActivity(it);
            }
            else
                Toast.makeText(CheckAndRequestActivity.this,"权限申请失败",Toast.LENGTH_LONG).show();
        }
    }
}
