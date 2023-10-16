package com.example.profilemanagerapp;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

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
        //tried calling this to newIntent, but for whatever reason it doesn't work.
        boolean notFirstTime = getIntent() != null;
        if (notFirstTime){
            int currentLogo = getIntent().getIntExtra("drawableId", -1);
            if (currentLogo != -1){
                logoSelector.setImageResource(currentLogo);
            }
            else {
                logoSelector.setImageResource(R.drawable.ic_logo_00);
            }
        }
    }



    private void setup() {
        teamName = findViewById(R.id.editTextTeamName);
        postalCode = findViewById(R.id.editTextPostalCode);
        googleMapCheck = findViewById(R.id.buttonGoogleMaps);
        submit = findViewById(R.id.buttonSubmit);
        logoSelector = findViewById(R.id.logoSelectorButton);

    }
    private void addListeners() {
        logoSelector.setOnClickListener(this::logoSelectorClicked);
        googleMapCheck.setOnClickListener(this::googleMapClicked);
        submit.setOnClickListener(this::submitClicked);
    }
    private void logoSelectorClicked(View view) {
        Intent logoSelector = new Intent(this, LogoSelector.class);
        logoSelector.setFlags(FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(logoSelector);
    }

    private void googleMapClicked(View view) {
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + postalCode.getText());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    private void submitClicked(View view) {
        String teamNameText = teamName.getText().toString();
        String postalCodeText = postalCode.getText().toString();
        int currentImageId = getIntent().getIntExtra("drawableId",R.drawable.ic_logo_00);


        if (teamNameText.trim().isEmpty() || postalCodeText.trim().isEmpty()){
            Toast.makeText(this, "Please make sure to fill all fields", Toast.LENGTH_SHORT);
            return;
        }
        Intent toConfirmation = new Intent(this, ProfileActivity.class);
        toConfirmation.putExtra("teamName", teamNameText);
        toConfirmation.putExtra("postalCode", postalCodeText);
        toConfirmation.putExtra("drawableId", currentImageId);
        startActivity(toConfirmation);



    }




}