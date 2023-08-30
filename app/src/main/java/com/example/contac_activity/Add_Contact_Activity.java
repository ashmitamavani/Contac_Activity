package com.example.contac_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Add_Contact_Activity extends AppCompatActivity {
    AppCompatEditText tname,tnumber;

   My_Database myDatabase=new My_Database(Add_Contact_Activity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        tname=findViewById(R.id.tname);
        tnumber=findViewById(R.id.tnumber);


    String name=getIntent().getStringExtra("n1");
    String number=getIntent().getStringExtra("n2");
        Log.d("YYY", "onCreate: "+name);


                tname.setText(""+name);
                tnumber.setText(""+number);

                myDatabase.AddContact(""+tname.getText().toString(),""+tnumber.getText().toString());
                Toast.makeText(this, "Add Data", Toast.LENGTH_SHORT).show();



    }
}