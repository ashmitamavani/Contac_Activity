package com.example.contac_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Show_Contact_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton Add;
    Recyclerview_Adapter adapter;
    ArrayList<Model_List>contactList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact);
        Add=findViewById(R.id.Add);
        recyclerView=findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(Show_Contact_Activity.this));

        ShowData();

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Show_Contact_Activity.this,Add_Contact_Activity.class);
                startActivity(intent);
            }
        });
        adapter=new Recyclerview_Adapter(Show_Contact_Activity.this,contactList);
        recyclerView.setAdapter(adapter);

    }

    private void ShowData() {
     My_Database myDatabase=new My_Database(Show_Contact_Activity.this);
        Cursor cursor=myDatabase.ShowData();
        while (cursor.moveToNext())
        {
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            String number=cursor.getString(2);

            Model_List modelList=new Model_List(id,name,number);
            contactList.add(modelList);
            Log.d("TTT", "ShowData: "+modelList);
        }

    }
}