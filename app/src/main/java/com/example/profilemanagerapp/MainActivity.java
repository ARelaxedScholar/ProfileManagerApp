package com.example.profilemanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    EditText teamName, postalCode;
    Button googleMapCheck, submit;
    ImageButton logoSelector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
        addListeners();
    }

    private void setup() {
        teamName = findViewById(R.id.editTextTeamName);
        postalCode = findViewById(R.id.editTextPostalCode);
        googleMapCheck = findViewById(R.id.buttonGoogleMaps);
        submit = findViewById(R.id.buttonSubmit);
        logoSelector = findViewById(R.id.imageButton);

    }
    private void addListeners() {
        logoSelector.setOnClickListener(this::logoSelectorClicked);
        googleMapCheck.setOnClickListener(this::googleMapClicked);
        submit.setOnClickListener(this::submitClicked);
    }
    private void logoSelectorClicked(View view) {
        Intent logoSelector = (this, )

    }

    private void googleMapClicked(View view) {
    }

    private void submitClicked(View view) {

    }




}