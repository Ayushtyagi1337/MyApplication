package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ename;
    private EditText epassword;
    private Button elogin;
    private TextView eattemptinfo;
    private String Username="Admin";
    private String Password="123";
    private TextView Url;

    boolean isvalid=false;
    private int counter=5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ename=findViewById(R.id.etname);
        epassword= findViewById(R.id.etpassword);
        elogin= findViewById(R.id.btlogin);
        eattemptinfo = findViewById(R.id.attemptinfo);
        Url=findViewById(R.id.url);

        elogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputName = ename.getText().toString();
                String inputPassword = epassword.getText().toString();

                if (inputName.isEmpty() || inputPassword.isEmpty())
                {


                    Toast.makeText(MainActivity.this, "Please Fill the credentials ", Toast.LENGTH_SHORT).show();

                }else{
                    isvalid=validate(inputName,inputPassword);

                    Toast.makeText(MainActivity.this, "login sucessful ", Toast.LENGTH_SHORT).show();
                    //add the code to go to the new activity
                    Intent intent= new Intent(MainActivity.this,Homepage.class);
                    startActivity(intent);
                }

            }
        });


        Url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://gateway.edu.in/");
            }
        });
    }

    private void gotourl(String s) {
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    private boolean validate(String name,String password){
        if (name.equals(Username)&& password.equals(Password)){
            return  true;
        }
        return false;
    }
}