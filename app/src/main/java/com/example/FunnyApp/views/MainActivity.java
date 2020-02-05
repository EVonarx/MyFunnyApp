package com.example.FunnyApp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.FunnyApp.R;
import com.example.FunnyApp.controller1.Controller1;

import static com.example.FunnyApp.R.drawable.imghomme;

public class MainActivity extends AppCompatActivity {


    private RadioButton mySex;
    private EditText myName;
    private EditText myAge;

    private TextView myWelcomeMessage;
    private ImageView myImage;

    private Controller1 myController1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        this.myController1 = Controller1.getMonInstance();
    }

    /* init Method
    *
    *
    */
    private void init(){
        mySex = (RadioButton) findViewById(R.id.radioButton);
        myName = (EditText) findViewById(R.id.IdInputName);
        myAge = (EditText) findViewById(R.id.IdInputAge);
        myWelcomeMessage = (TextView) findViewById(R.id.textView);
        myImage = (ImageView)findViewById(R.id.imageViewSex);

        myWelcomeMessage.setVisibility(View.INVISIBLE);
        myImage.setVisibility(View.INVISIBLE);

        listenExecuteButton();
    }

    //
    private void listenExecuteButton(){


        Button clickButton = (Button) findViewById(R.id.buttonExecute);
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                    /**
                     * Hide the keyboard
                     */
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                    try {
                        String lenom = myName.getText().toString();
                        Integer lage = Integer.parseInt(myAge.getText().toString());
                        Integer sex = 0;
                        if (mySex.isChecked()) {
                            sex = 1;
                        }
                        displayInfos(lenom, sex, lage);
                        //gotoSecondActivity();
                        gotoSecondActivityWithTimer();

                    } catch (Exception e) {
                        Toast toast = Toast.makeText(getApplicationContext(), R.string.strAgeErrMessage, Toast.LENGTH_SHORT);
                        TextView MessageToDisplay = (TextView) toast.getView().findViewById(android.R.id.message);
                        MessageToDisplay.setTextColor(Color.RED);
                        toast.show();

                    }



            }
        });
    }
    //

    public void displayInfos(String strNom, Integer iSexe, Integer iAge){
        this.myController1.createPerson(strNom, iSexe,iAge);

        String txtToDisplay;
       if (iSexe == 1) {
           txtToDisplay = getString(R.string.strSir) + " " + strNom;
           myWelcomeMessage.setVisibility(View.VISIBLE);
           myWelcomeMessage.setText(txtToDisplay);
           myImage.setVisibility(View.VISIBLE);
           myImage.setImageResource(imghomme);
       } else {
           txtToDisplay = getString(R.string.strMadam) + " " + strNom;
           myWelcomeMessage.setVisibility(View.VISIBLE);
           myWelcomeMessage.setText(txtToDisplay);
           myImage.setVisibility(View.VISIBLE);
           myImage.setImageResource(R.drawable.imgfemme);
       }

    }


    public void  gotoSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void gotoSecondActivityWithTimer() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // do something
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // If you just use this that is not a valid context. Use ActivityName.this
                startActivity(intent);
            }
        }, 2000);
    }

}
