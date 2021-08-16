package com.example.multifacefilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    public MaterialCardView firstFilterCard,secondFilterCard,thirdFilterCard,fourthFilterCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstFilterCard = findViewById(R.id.firstFilterCard);
        secondFilterCard = findViewById(R.id.secondFilterCard);
        thirdFilterCard = findViewById(R.id.thirdFilterCard);
        fourthFilterCard = findViewById(R.id.fourthFilterCard);

        Intent intent = new Intent(this,FirstFilter.class);
        Intent intent2 = new Intent(this,SecondFilter.class);
        Intent intent3 = new Intent(this,ThirdFilter.class);
        Intent intent4 = new Intent(this,FourthFilter.class);

        firstFilterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });



        secondFilterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });

        thirdFilterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent3);
            }
        });



        fourthFilterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent4);
            }
        });


    }
}