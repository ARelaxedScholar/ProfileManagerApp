package com.example.profilemanagerapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {
    ImageView teamLogo;
    TextView teamName, postalCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setup();

    }

    private void setup() {
        teamLogo = findViewById(R.id.teamLogo);
        teamName = findViewById(R.id.sampleTeamName);
        postalCode = findViewById(R.id.samplePostalCode);
        //Set the images
        teamLogo.setImageResource(getIntent().getIntExtra("drawableId", R.drawable.ic_logo_00));
        teamName.setText(getIntent().getStringExtra("teamName"));
        postalCode.setText(getIntent().getStringExtra("postalCode"));

    }

}
