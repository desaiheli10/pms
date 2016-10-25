package com.example.common.pms;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class AddDriveActivity extends FragmentActivity {

    // Progress Dialog
    private ProgressDialog pDialog;

    JSONParser jsonParser = new JSONParser();
    EditText inputName;
    EditText inputPrice;
    EditText inputDomain;
    EditText inputSalary;
    EditText inputBond;
    EditText inputLocation;
    EditText inputCriteriaone;
    EditText inputCriteriatwo;
    EditText inputCpi;
    String branch;
    DatePicker picker;

    public void onCheckboxClicked(View view){

        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()){
            case R.id.checkBox:
                if(checked){
                    branch = "CE";
                }
        }
    }
    // url to create new product


    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    private TextView Output;
    private Button changeDate;

    private int year;
    private int month;
    private int day;

    static final int DATE_PICKER_ID = 1111;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_drive);

        // Edit Text
        inputName = (EditText) findViewById(R.id.inputName);
        inputPrice = (EditText) findViewById(R.id.inputPrice);
        inputDomain = (EditText) findViewById(R.id.editText);
        inputSalary = (EditText) findViewById(R.id.editText2);
        inputBond = (EditText) findViewById(R.id.editText3);
        inputLocation = (EditText) findViewById(R.id.editText4);
        inputCriteriaone = (EditText) findViewById(R.id.inputCriteriaone);
        inputCriteriatwo = (EditText) findViewById(R.id.inputCriteriatwo);
        inputCpi = (EditText) findViewById(R.id.inputCpi);
        Output = (TextView) findViewById(R.id.Output);
        changeDate = (Button) findViewById(R.id.changeDate);
        picker=(DatePicker)findViewById(R.id.datePicker1);
        final Calendar c = Calendar.getInstance();
        year  = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day   = c.get(Calendar.DAY_OF_MONTH);

        Output.setText(getCurrentDate());

        changeDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // On button click show datepicker dialog
                Output.setText(getCurrentDate());

            }

        });



        // Create button
        Button btnCreateDrive = (Button) findViewById(R.id.btnCreateDrive);

        // button click event
        btnCreateDrive.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // creating new product in background thread
                new CreateNewDrive().execute(inputName.getText().toString(),inputPrice.getText().toString(),inputDomain.getText().toString(),inputSalary.getText().toString(),inputBond.getText().toString(),inputLocation.getText().toString(),inputCriteriaone.getText().toString(),inputCriteriatwo.getText().toString(),inputCpi.getText().toString(),branch,Output.getText().toString());

            }
        });
    }
    public String getCurrentDate(){
        StringBuilder builder=new StringBuilder();
        builder.append("Current Date: ");
        builder.append((picker.getMonth() + 1)+"/");//month is 0 based
        builder.append(picker.getDayOfMonth()+"/");
        builder.append(picker.getYear());
        return builder.toString();
    }

    /**
     * Background Async Task to Create new product
     * */
    class CreateNewDrive extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(AddDriveActivity.this);
            pDialog.setMessage("Creating Product..");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        /**
         * Creating product
         * */
        protected String doInBackground(String... args) {
         /*   runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    name=inputName.getText().toString();
                    price =inputPrice.getText().toString();
                    description = inputDesc.getText().toString();

                }
            }); */




            // Building Parameters
           /* List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("name", name));
            params.add(new BasicNameValuePair("price", price));
            params.add(new BasicNameValuePair("description", description));
            */

            LinkedHashMap<String,String> params = new LinkedHashMap<String, String>();
            params.put("name",args[0]);
            params.put("post",args[1]);
            params.put("domain",args[2]);
            params.put("salary",args[3]);
            params.put("bond",args[4]);
            params.put("location",args[5]);
            params.put("tenth",args[6]);
            params.put("twelfth",args[7]);
            params.put("cpi",args[8]);
            params.put("branch",args[9]);
            params.put("date",args[10]);
            
            // getting JSON Object
            // Note that create product url accepts POST method

            //Log.d(args[0],"msg");
            JSONObject json = jsonParser.makeHttpRequest(AppConfig.URL_ADD_DRIVE,
                    "POST", params);


            // check log cat fro response
            Log.d("Create Response", json.toString());

            // check for success tag
            try {
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    // successfully created product
                    Intent i = new Intent(getApplicationContext(), AllProductsActivity.class);
                    startActivity(i);

                    // closing this screen
                    finish();
                } else {
                    // failed to create product
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once done
            pDialog.dismiss();
        }

    }
}