package com.example.android.tourguideflint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.android.tourguideflint.AttractionsFragment.KEY_DESCRIPTION;
import static com.example.android.tourguideflint.AttractionsFragment.KEY_DETAILS;
import static com.example.android.tourguideflint.AttractionsFragment.KEY_DRAWABLE;
import static com.example.android.tourguideflint.AttractionsFragment.KEY_LOCATION;
import static com.example.android.tourguideflint.AttractionsFragment.KEY_NAME;


public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String currentName = "";
        String currentLocation = "";
        String currentDetails = "";
        String currentDescription = "";

        Intent intent = getIntent();
        if (null != intent) {
            currentName = intent.getStringExtra(KEY_NAME);
            currentLocation = intent.getStringExtra(KEY_LOCATION);
            currentDetails = intent.getStringExtra(KEY_DETAILS);
            currentDescription = intent.getStringExtra(KEY_DESCRIPTION);
        }

        Bundle extras = getIntent().getExtras();
        int currentDrawable = extras.getInt(KEY_DRAWABLE);

        ImageView imageView = (ImageView) findViewById(R.id.current_drawable);
        imageView.setImageResource(currentDrawable);

        TextView currentNameText = (TextView) findViewById(R.id.current_name);
        currentNameText.setText(currentName);

        TextView currentLocationText = (TextView) findViewById(R.id.current_location);
        currentLocationText.setText(currentLocation);
        currentLocationText.setMovementMethod(LinkMovementMethod.getInstance());

        TextView currentDetailsText = (TextView) findViewById(R.id.current_details);
        currentDetailsText.setText(currentDetails);

        TextView currentDescriptionText = (TextView) findViewById(R.id.current_description);
        currentDescriptionText.setText(currentDescription);
        }
}
