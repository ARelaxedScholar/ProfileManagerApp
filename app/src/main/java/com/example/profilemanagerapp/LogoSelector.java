package com.example.profilemanagerapp;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;

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
        logoCanadaButton = findViewById(R.id.canadaLogo);
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
        Drawable logoDrawable = logoClicked.getDrawable();
        int myDrawableId = findResourceIdFromDrawable(logoDrawable);

        Log.d("Logo Selector", "THe logo id: " + myDrawableId);
        Intent backToMain = new Intent(this, MainActivity.class);
        backToMain.putExtra("drawableId", myDrawableId);
        startActivity(backToMain);
    }

    public int findResourceIdFromDrawable(Drawable targetDrawable) {
        Resources resources = getResources();

        // Iterate through known resource IDs and compare with the targetDrawable
        for (Field field : R.drawable.class.getFields()) {
            try {
                int resourceId = field.getInt(null); // Get the resource ID
                Drawable drawableFromResource = resources.getDrawable(resourceId); // Get the drawable from the resource

                // Compare the targetDrawable with the drawable from the resource
                if (targetDrawable.getConstantState().equals(drawableFromResource.getConstantState())) {
                    return resourceId; // Return the resource ID when a match is found
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return 0; // Return 0 or another default value if no match is found
    }

}
