package com.example.administrator.camaraopen;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button openCamerabtn;
    private static final int CAMERA_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openCamerabtn = (Button)findViewById(R.id.openCamera_btn);
        openCamerabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkSelfPermission("android.permission.CAMERA")!=PackageManager.PERMISSION_GRANTED){
                    requestPermissions(new String[]{"android.permission.CAMERA"},1);
                    Camera.open(CAMERA_ID);
                }
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);
            }
        });
    }
}
