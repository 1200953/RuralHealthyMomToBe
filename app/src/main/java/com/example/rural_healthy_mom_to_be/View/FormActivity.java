package com.example.rural_healthy_mom_to_be.View;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.rural_healthy_mom_to_be.R;

public class FormActivity extends AppCompatActivity {

    private EditText etUserName;
    private EditText etHeight;
    private EditText etWeightBeforePreg;
    private EditText etCurrentWeight;
    private EditText etWeeksPregnant;
    private String username;
    private double height;
    private double prePregnancyWeight;
    private double currentWeight;
    private int weeksPregnant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
  }

    protected void nextForm(View view){
        int flag = 0;
        etUserName = (EditText)findViewById(R.id.etUserName);

        //If username is empty
        if(etUserName.getText().toString().isEmpty()){
            etUserName.setError("This field is mandatory!");
            flag = 1;
        }
        else{
            username = etUserName.getText().toString();
        }
        etHeight = (EditText)findViewById(R.id.etHeight);
        //If height is empty
        if(etHeight.getText().toString().isEmpty()){
            etHeight.setError("This field is mandatory!");
            flag = 1;
        }
        else{
            height = Double.parseDouble(etHeight.getText().toString());
        }

        etWeightBeforePreg = (EditText)findViewById(R.id.etWeightBeforePreg);
        //If weight before pregnancy is empty
        if(etWeightBeforePreg.getText().toString().isEmpty()){
            etWeightBeforePreg.setError("This field is mandatory!");
            flag = 1;
        }
        else{
            prePregnancyWeight = Double.parseDouble(etWeightBeforePreg.getText().toString());
        }
        etCurrentWeight = (EditText)findViewById(R.id.etCurrentWeight);

        //If etCurrentWeight is empty
        if(etCurrentWeight.getText().toString().isEmpty()){
            etCurrentWeight.setError("This field is mandatory!");
            flag = 1;
        }
        else{
            currentWeight = Double.parseDouble(etCurrentWeight.getText().toString());
        }



        etWeeksPregnant = (EditText)findViewById(R.id.etWeeksPregnant);
        //If etWeeksPregnant is empty
        if(etWeeksPregnant.getText().toString().isEmpty()){
            etWeeksPregnant.setError("This field is mandatory!");
            flag = 1;
        }
        else{
            weeksPregnant = Integer.parseInt(etWeeksPregnant.getText().toString());
        }
        if(flag == 0) {
            CheckUsernameIfExist checkUsernameIfExist = new CheckUsernameIfExist();
            checkUsernameIfExist.execute(etUserName.getText().toString());
        }
    }
    //Calls in repository to call rest method to check if user name already exists or not
    //ToChange
    private class CheckUsernameIfExist extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... params) {
            //ToChange
            String username = params[0];
            //return CheckUserNameClient.checkIfUserNameExist(username);
            return "true"; //delete this
        }
        @Override
        protected void onPostExecute(String match){
            //ToChange
            //if((match.equals("[]"))){
            if(true){
                Intent intent = new Intent(FormActivity.this, NavigationDrawer.class);
                startActivity(intent);            }
            else{
                etUserName.setError("Username already exists!");
            }
        }
    }
}


