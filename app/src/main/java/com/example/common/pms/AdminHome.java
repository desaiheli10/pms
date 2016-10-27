package com.example.common.pms;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.app.Activity;

import com.example.common.helper.*;
import com.example.common.helper.SessionManager;


public class AdminHome extends Activity {

    Button btnViewProducts;
    Button btnNewProduct;
    Button btnNewDrive;
    Button btnLogout;

    private com.example.common.helper.SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_admin);
        session = new SessionManager(getApplicationContext());
        btnViewProducts = (Button) findViewById(R.id.btnViewProducts);
        btnNewProduct = (Button) findViewById(R.id.btnCreateProduct);
        btnNewDrive = (Button) findViewById(R.id.btnCreateDrive);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        btnViewProducts.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(),ViewStudents.class);
                startActivity(i);
            }
        });

        btnNewProduct.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(),AddCompany.class);
                startActivity(i);
            }
        });

        btnNewDrive.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(),AddDriveActivity.class);
                startActivity(i);
            }
        });


        if (!session.isLoggedIn()) {
            logoutUser();
        }

        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });

    }
    private void logoutUser() {
        session.setLogin(false);


        // Launching the login activity
        Intent intent = new Intent(getApplicationContext(), AdminLogin.class);
        startActivity(intent);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}