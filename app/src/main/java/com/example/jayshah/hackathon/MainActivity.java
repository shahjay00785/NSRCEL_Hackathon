package com.example.jayshah.hackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText DocTextName;
    Button buttonAdd;
    DatabaseReference addName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addName= FirebaseDatabase.getInstance().getReference("consultant");

        DocTextName =(EditText) findViewById(R.id.DocTextName);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            addName();
            }
        });
    }

    private void addName(){
        String name=DocTextName.getText().toString().trim();
                if(!TextUtils.isEmpty(name)){
                    String id=addName.push().getKey();
                    User u=new User(id,name);
                    addName.child(id).setValue(u);
                    Toast.makeText(this,"Added Successfully",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"enter the text",Toast.LENGTH_SHORT).show();

                }
    }
}
