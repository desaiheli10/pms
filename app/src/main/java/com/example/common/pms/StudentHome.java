package com.example.common.pms;

import com.example.common.helper.SQLiteHandler;
import com.example.common.helper.SessionManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.common.helper.*;

/**
 * Created by JigarSoni on 9/26/2016.
 */
public class StudentHome extends Activity {
    Button btnViewProfile;
    Button btnViewDrive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_home);

        btnViewProfile = (Button) findViewById(R.id.btnViewProfile);

        btnViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ViewProfileActivity.class);
                startActivity(i);
            }

        });

        btnViewDrive = (Button) findViewById(R.id.btnViewDrives);

        btnViewDrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ViewDrivesActivity.class);
                startActivity(i);
            }
        });
    }
}
