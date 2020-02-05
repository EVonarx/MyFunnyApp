package com.example.FunnyApp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.FunnyApp.R;
import com.example.FunnyApp.controller1.Controller1;

public class SecondActivity extends AppCompatActivity {

    private TextView myWelcomeText;
    private Controller1 myController1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        this.myController1 = Controller1.getMonInstance();
        myWelcomeText = (TextView) findViewById(R.id.idWelcomeText);

        String strToDisplay = getString(R.string.strHello);
        if (myController1.getMyPerson().getSex()==1)
            strToDisplay += " Mister " + myController1.getMyPerson().getName();
        else
            strToDisplay += " Miss " + myController1.getMyPerson().getName();
        myWelcomeText.setText(strToDisplay);
        listenBackButton();

    }


    private void listenBackButton(){
        Button clickButton = (Button) findViewById(R.id.idBtnBack);
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
