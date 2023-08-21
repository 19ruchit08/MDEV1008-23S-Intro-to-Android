package com.example.travelapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LandmarkListActivity extends AppCompatActivity implements ClickInterface {
    private RecyclerView recyclerView;
    private LandmarkAdapter adapter;
    private List<Landmark> landmarkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landmarklist);

        recyclerView = findViewById(R.id.recyclerView);


        landmarkList = new ArrayList<>();
        landmarkList.add(new Landmark(
                "CN Tower",
                R.drawable.cn,
                "The CN Tower is a communication and observation tower in downtown Toronto, Ontario, Canada. " +
                        "It was completed in 1976 and held the title of the world's tallest free-standing structure " +
                        "and world's tallest tower for over 30 years. With a height of approximately 553.3 meters (1,815 feet, 5 inches), " +
                        "including its antenna, the CN Tower remains an iconic symbol of the city and the country.\n\n" +
                        "The tower offers multiple observation decks for visitors to enjoy stunning panoramic views " +
                        "of the city and Lake Ontario. The SkyPod, located at a height of around 447 meters (1,465 feet), " +
                        "is one of the highest observation platforms in the world accessible to the public.\n\n" +
                        "In addition to its observation decks, the CN Tower features the Glass Floor, where visitors can " +
                        "stand on a transparent floor and look down to the ground below. For the daring, the EdgeWalk attraction " +
                        "allows participants to walk around the outside of the tower's main pod at a height of 356 meters (1,168 feet), " +
                        "attached to a harness for safety."
        ));
        landmarkList.add(new Landmark(
                "Royal Ontario Museum",
                R.drawable.rom,
                "The Royal Ontario Museum (ROM) is a renowned museum of art, world culture, and natural history located in Toronto, Ontario, Canada. " +
                        "It was founded in 1912 and is one of the largest museums in North America.\n\n" +
                        "The museum's diverse collection spans over six million items, including artifacts, specimens, " +
                        "and artworks from different cultures and time periods. The ROM's collections cover various fields " +
                        "such as anthropology, paleontology, archaeology, and decorative arts.\n\n" +
                        "The museum's distinctive architecture includes a blend of historic and modern elements. " +
                        "The Michael Lee-Chin Crystal, an iconic addition to the ROM's building, features a crystalline structure " +
                        "that contrasts with the museum's original heritage building.\n\n" +
                        "Visitors to the ROM can explore a wide range of exhibits and galleries, including those " +
                        "dedicated to ancient civilizations, natural history, art, and more."
        ));

        landmarkList.add(new Landmark(
                "Distillery District",
                R.drawable.distillery,
                "The Distillery District is a historic and entertainment district located in Toronto, Ontario, Canada. " +
                        "It is known for its charming cobblestone streets, Victorian-era architecture, and vibrant arts and culture scene.\n\n" +
                        "Originally established in the 19th century as the Gooderham and Worts Distillery, " +
                        "it was one of the largest distilleries in the world. Today, the Distillery District has been " +
                        "transformed into a pedestrian-friendly neighborhood that blends heritage with modern attractions.\n\n" +
                        "Visitors to the Distillery District can explore a variety of shops, galleries, restaurants, " +
                        "and artisanal boutiques. The district is home to a diverse range of cultural events, " +
                        "festivals, and performances throughout the year.\n\n" +
                        "One of the notable features of the Distillery District is its collection of well-preserved " +
                        "industrial architecture, including red brick buildings, chimneys, and warehouses. " +
                        "It has also served as a filming location for movies, TV shows"
        ));


        adapter = new LandmarkAdapter(landmarkList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(int position) {
        Landmark selectedLandmark = landmarkList.get(position);

        Intent intent = new Intent(this, LandmarkDetailsActivity.class);
        intent.putExtra("landmark", selectedLandmark);
        startActivity(intent);

    }
}
