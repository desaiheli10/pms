package com.example.common.pms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Heli.Desai on 25-09-2016.
 */


public class StudentPageActivity extends Activity {
    Button btnViewProfile;
    Button btnViewDrive;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_view);

        btnViewProfile = (Button)findViewById(R.id.button);
        btnViewDrive = (Button)findViewById(R.id.button2);

        btnViewProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(),ShowProfileActivity.class);
                startActivity(i);
            }
        });

        btnViewDrive.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(),ViewDriveActivity.class);
                startActivity(i);
            }
        });
    }
}
