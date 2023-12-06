package com.example.freefood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button entredButton, registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entredButton = (Button) findViewById(R.id.enterButton);
        entredButton.setOnClickListener(this);

        registerButton = (Button) findViewById(R.id.registrationButton);
        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


    }
}