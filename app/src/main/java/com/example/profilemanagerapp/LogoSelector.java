package com.example.profilemanagerapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class LogoSelector extends AppCompatActivity {
    ImageButton logoOttawaButton, logoStarButton, logoBMVButton, logoFCBButton, logoCanadaButton, logoRandomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_selector);
        setup();
        addListeners();
    }

    private void setup() {
        logoOttawaButton = findViewById(R.id.ottawaLogo);
        logoStarButton = findViewById(R.id.starLogo);
        logoBMVButton = findViewById(R.id.bmvLogo);
        logoFCBButton = findViewById(R.id.fcbLogo);
        logoCanadaButton = findViewById(R.id.imageButton);
        logoRandomButton = findViewById(R.id.randomLogo);

    }

    private void addListeners() {
        logoOttawaButton.setOnClickListener(this::logoSelected);
        logoStarButton.setOnClickListener(this::logoSelected);
        logoBMVButton.setOnClickListener(this::logoSelected);
        logoFCBButton.setOnClickListener(this::logoSelected);
        logoCanadaButton.setOnClickListener(this::logoSelected);
        logoRandomButton.setOnClickListener(this::logoSelected);
    }

    private void logoSelected(View view) {
        ImageButton logoClicked = findViewById(view.getId());
        Drawable logo = logoClicked.getDrawable() ;
        Intent backToMain = new Intent(this, MainActivity.class);
        backToMain.putExtra("Drawable", logo);
    }
}
