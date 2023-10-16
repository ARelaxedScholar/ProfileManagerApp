package com.uottawa.eecs.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText postalCode;
    Button openInMaps;
    Button submitButton;

    String drawableName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openInMaps = findViewById(R.id.buttonMaps);
        submitButton = findViewById(R.id.buttonSubmit);
    }

    public void openInGoogleMaps(View view){
        postalCode  = findViewById(R.id.TeamPostalCode);

        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + postalCode.getText());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);

    }
    public void setLogo(View view){
       Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
       startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult( requestCode,  resultCode,  data);

        ImageView logoImage = (ImageView) findViewById(R.id.Mainlogo);

        drawableName = "ic_logo_00";

        int imageID = data.getIntExtra("imageID", R.id.logo01);
        if (imageID == R.id.Mainlogo) {
            drawableName = "ic_logo_00";
        } else if (imageID == R.id.logo01) {
            drawableName = "ic_logo_01";
        } else if (imageID == R.id.logo02) {
            drawableName = "ic_logo_02";
        } else if (imageID == R.id.logo03) {
            drawableName = "ic_logo_03";
        } else if (imageID == R.id.logo04) {
            drawableName = "ic_logo_04";
        } else if (imageID == R.id.logo05) {
            drawableName = "ic_logo_05";
        } else {
            drawableName = "ic_logo_00";
        }
        int resID = getResources().getIdentifier(drawableName, "drawable",
                getPackageName());
          logoImage.setImageResource(resID);
    }

   public void submit(View view){
       EditText teamNameView = (EditText) findViewById(R.id.TeamName);
       EditText postalCodeView = (EditText) findViewById(R.id.TeamPostalCode);

       String teamName = teamNameView.getText().toString();
       String postalCode = postalCodeView.getText().toString();
       Team team = new Team(teamName, postalCode, drawableName);
       Intent intent = new Intent(MainActivity.this, ConfirmationActivity.class);
       intent.putExtra("teamInfo", team);
       startActivity(intent);
   }





}