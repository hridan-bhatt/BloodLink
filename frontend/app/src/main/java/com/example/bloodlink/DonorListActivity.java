package com.example.bloodlink;

import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;

public class DonorListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_donor_list);

        TextView tvBack = findViewById(R.id.tvBack);

        TextInputEditText etSearch = findViewById(R.id.etSearch);

        MaterialCardView cardDonor1 = findViewById(R.id.cardDonor1);
        MaterialCardView cardDonor2 = findViewById(R.id.cardDonor2);
        MaterialCardView cardDonor3 = findViewById(R.id.cardDonor3);
        MaterialCardView cardDonor4 = findViewById(R.id.cardDonor4);
        MaterialCardView cardDonor5 = findViewById(R.id.cardDonor5);

        tvBack.setOnClickListener(v->finish());
            cardDonor1.setOnClickListener(n -> {
                Intent intent = new Intent(DonorListActivity.this, DonorDetailsActivity.class);

                intent.putExtra("NAME", "Arjun Kumar");
                intent.putExtra("CITY", "Ahmedabad");
                intent.putExtra("STATE", "Gujarat");
                intent.putExtra("PHONE", "9876543210");
                intent.putExtra("BLOODGRP", "B+");

                startActivity(intent);
            });

        cardDonor2.setOnClickListener(v -> {
            Intent intent = new Intent(DonorListActivity.this, DonorDetailsActivity.class);

            intent.putExtra("NAME", "Rahul Patel");
            intent.putExtra("CITY", "Vadodara");
            intent.putExtra("STATE", "Gujarat");
            intent.putExtra("PHONE", "9123456789");
            intent.putExtra("BLOODGRP", "O-");

            startActivity(intent);
        });

        cardDonor3.setOnClickListener(v -> {
            Intent intent = new Intent(DonorListActivity.this, DonorDetailsActivity.class);

            intent.putExtra("NAME", "Priya Shah");
            intent.putExtra("CITY", "Surat");
            intent.putExtra("STATE", "Gujarat");
            intent.putExtra("PHONE", "9012345678");
            intent.putExtra("BLOODGRP", "A+");

            startActivity(intent);
        });

        cardDonor4.setOnClickListener(v -> {
            Intent intent = new Intent(DonorListActivity.this, DonorDetailsActivity.class);

            intent.putExtra("NAME", "Karan Mehta");
            intent.putExtra("CITY", "Rajkot");
            intent.putExtra("STATE", "Gujarat");
            intent.putExtra("PHONE", "9876501234");
            intent.putExtra("BLOODGRP", "AB+");

            startActivity(intent);
        });

        cardDonor5.setOnClickListener(v -> {
            Intent intent = new Intent(DonorListActivity.this, DonorDetailsActivity.class);

            intent.putExtra("NAME", "Neha Joshi");
            intent.putExtra("CITY", "Bhavnagar");
            intent.putExtra("STATE", "Gujarat");
            intent.putExtra("PHONE", "9988776655");
            intent.putExtra("BLOODGRP", "B-");

            startActivity(intent);
        });
    }
}