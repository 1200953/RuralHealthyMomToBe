package com.example.rural_healthy_mom_to_be.View;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rural_healthy_mom_to_be.MainActivity;
import com.example.rural_healthy_mom_to_be.Model.User;
import com.example.rural_healthy_mom_to_be.R;
import com.example.rural_healthy_mom_to_be.Repository.CheckUserNameClient;

public class FormActivity extends AppCompatActivity {

    private EditText etUserName;
    private EditText etHeight;
    private EditText etWeightBeforePreg;
    private String username;
    private double height;
    private double prePregnancyWeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
  }

    protected void nextForm(View view){

        etUserName = (EditText)findViewById(R.id.etUserName);

        //If username is empty
        if(etUserName.getText().toString().isEmpty()){
            etUserName.setError("This field is mandatory!");
        }
        else{
            username = etUserName.getText().toString();
        }
        etHeight = (EditText)findViewById(R.id.etHeight);
        //If height is empty
        if(etHeight.getText().toString().isEmpty()){
            etHeight.setError("This field is mandatory!");
        }
        else{
            height = Double.parseDouble(etHeight.getText().toString());
        }

        etWeightBeforePreg = (EditText)findViewById(R.id.etWeightBeforePreg);
        //If weight before pregnancy is empty
        if(etWeightBeforePreg.getText().toString().isEmpty()){
            etWeightBeforePreg.setError("This field is mandatory!");
        }
        else{
            prePregnancyWeight = Double.parseDouble(etWeightBeforePreg.getText().toString());
        }
        if(!etUserName.getText().toString().isEmpty() && !etHeight.getText().toString().isEmpty() && !etWeightBeforePreg.getText().toString().isEmpty()) {
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
                Intent intent = new Intent(FormActivity.this, Form2Activity.class);
             //   Sending user attributes
                intent.putExtra("username",username);
                intent.putExtra("height",height);
                intent.putExtra("prePregnancyWeight",prePregnancyWeight);
                startActivity(intent);
            }
            else{
                etUserName.setError("Username already exists!");
            }
        }
    }
}


