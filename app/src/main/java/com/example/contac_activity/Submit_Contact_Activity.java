package com.example.contac_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Submit_Contact_Activity extends AppCompatActivity {
    AppCompatEditText ename,enumber;
    AppCompatButton submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_contact);
        ename=findViewById(R.id.ename);
        enumber=findViewById(R.id.enumber);
        submit=findViewById(R.id.submit);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t1=ename.getText().toString();
                String t2=enumber.getText().toString();
                Intent intent=new Intent(Submit_Contact_Activity.this, Add_Contact_Activity.class);
                 intent.putExtra("n1",t1);
                 intent.putExtra("n2",t2);
                startActivity(intent);
            }
        });

    }
}