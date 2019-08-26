package com.example.rural_healthy_mom_to_be.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.rural_healthy_mom_to_be.R;

public class WelcomeActvity extends AppCompatActivity {
    private CheckBox checkBoxTNC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_actvity);
        checkBoxTNC = (CheckBox)findViewById(R.id.checkboxTNC);
    }

    // when welcome button is clicked
    public void welcomeClicked(View view){
        if(((checkBoxTNC)).isChecked()){
            Intent intent = new Intent(WelcomeActvity.this, FormActivity.class);
            startActivity(intent);
        }
        else{
            
        }
    }
}
