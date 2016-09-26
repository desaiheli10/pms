package com.example.common.pms;

import android.app.ListActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Heli.Desai on 25-09-2016.
 */
public class ViewDriveActivity extends ListActivity{

    ArrayList<HashMap<String,String>> driveList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_drives);

        driveList = new ArrayList<HashMap<String,String>>()
    }
}
