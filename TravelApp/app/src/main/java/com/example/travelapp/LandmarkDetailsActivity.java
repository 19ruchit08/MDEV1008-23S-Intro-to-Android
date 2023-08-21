package com.example.travelapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class LandmarkDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landmark_details);

        Landmark selectedLandmark = (Landmark) getIntent().getSerializableExtra("landmark");

        ImageView imageView = findViewById(R.id.backgroundImageView);
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        ImageButton backButton = findViewById(R.id.backButton);
        Glide.with(this)
                .load(selectedLandmark.getImageResourceId())
                .centerCrop()
                .into(imageView);
        titleTextView.setText(selectedLandmark.getTitle());
        descriptionTextView.setText(selectedLandmark.getDescription());
        backButton.setOnClickListener(v->{
            startActivity(new Intent(LandmarkDetailsActivity.this, LandmarkListActivity.class));
        });
    }
}
