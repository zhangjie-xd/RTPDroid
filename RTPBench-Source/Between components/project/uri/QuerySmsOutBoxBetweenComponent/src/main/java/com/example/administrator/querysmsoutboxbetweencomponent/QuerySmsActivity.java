package com.example.administrator.querysmsoutboxbetweencomponent;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuerySmsActivity extends AppCompatActivity implements View.OnClickListener {

    Button querySmsBtn;
    TextView smsTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_sms);
        querySmsBtn = (Button)findViewById(R.id.query_btn);
        smsTxt = (TextView)findViewById(R.id.sms_txt);
        querySmsBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.query_btn:
                smsTxt.setText("");
                Cursor cursor = getContentResolver().query(Uri.parse("content://sms/outbox"),null,null,null,null);
                while(cursor.moveToNext()){
                    StringBuilder sb = new StringBuilder();
                    sb.append("address=").append(cursor.getString(cursor.getColumnIndex("address")));
                    sb.append("body=").append(cursor.getString(cursor.getColumnIndex("body")));
                    smsTxt.setText(sb.toString());
                }
        }
    }
}
