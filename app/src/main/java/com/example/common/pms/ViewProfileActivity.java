package com.example.common.pms;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.common.helper.*;
import com.example.common.helper.SQLiteHandler;

import java.util.HashMap;

/**
 * Created by JigarSoni on 9/26/2016.
 */
public class ViewProfileActivity extends Activity{
    private com.example.common.helper.SQLiteHandler db;
    private SessionManager session;
    private TextView txtName;
    private TextView txtEmail;
    private TextView txtBdate;
    private TextView txtBranch;
    private TextView txtCpi;

    @Override
    protected void onCreate(Bundle abc) {
        super.onCreate(abc);
        setContentView(R.layout.view_profile);

        txtName = (TextView) findViewById(R.id.textView11);
        txtEmail = (TextView) findViewById(R.id.textView16);
        txtBdate = (TextView) findViewById(R.id.textView17);
        txtBranch = (TextView) findViewById(R.id.textView18);
        txtCpi = (TextView) findViewById(R.id.textView19);

        db = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());

        HashMap<String, String> user = db.getUserDetails();

        String name = user.get("name");
        String email = user.get("email");
        String bdate = user.get("birthdate");
        String branch = user.get("branch");
        String cpi = user.get("cpi");


        // Displaying the user details on the screen
        txtName.setText(name);
        txtEmail.setText(email);
        txtBdate.setText(bdate);
        txtBranch.setText(branch);
        txtCpi.setText(cpi);

    }
}