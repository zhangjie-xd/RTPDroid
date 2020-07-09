package com.example.administrator.subscriberidgetcomponents;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                if(check()!= PackageManager.PERMISSION_GRANTED){
                    request();
                }
                else{
                    Intent it = new Intent(CheckAndRequestActivity.this,GetSubscriberIdActivity.class);
                    startActivity(it);
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
                Intent it = new Intent(CheckAndRequestActivity.this,GetSubscriberIdActivity.class);
                startActivity(it);
            }
            else
                Toast.makeText(CheckAndRequestActivity.this,"权限申请失败",Toast.LENGTH_LONG).show();
        }
    }
}
