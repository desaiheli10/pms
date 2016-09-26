package com.example.common.pms;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btnViewAdmin;
    Button btnViewStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_choice);

        btnViewAdmin = (Button)findViewById(R.id.btnLogin);

        btnViewAdmin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(),AdminLogin.class);
                startActivity(i);
            }
        });

        btnViewStudent = (Button)findViewById(R.id.btnLogin1);

        btnViewStudent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(),StudentHome.class);
                startActivity(i);
            }
        });
    }
}
