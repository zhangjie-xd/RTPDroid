package com.example.administrator.getcontactsbetweencomponent;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class GetContactsName extends AppCompatActivity {

    Button get_contacts_name_btn;
    ListView contact_listview;
    ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_contacts_name);
        get_contacts_name_btn = (Button)findViewById(R.id.get_contacts_name_btn);
        contact_listview = (ListView)findViewById(R.id.contact_listview);
        list = new ArrayList<>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.array_item,list);
        contact_listview.setAdapter(adapter);
        get_contacts_name_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
                while(cursor.moveToNext()){
                    StringBuilder sb = new StringBuilder();
                    sb.append(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID)));
                    sb.append("::");
                    sb.append(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
                    adapter.notifyDataSetChanged();
                }
            }
        });

    }
}
