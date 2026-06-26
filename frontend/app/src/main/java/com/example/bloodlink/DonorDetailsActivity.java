package com.example.bloodlink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DonorDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_donor_details);

        TextView tvBack=findViewById(R.id.tvBack);
        TextView tvAvatar = findViewById(R.id.tvAvatar);
        TextView tvDonorName = findViewById(R.id.tvDonorName);
        TextView tvBloodGroup = findViewById(R.id.tvBloodGroup);
        TextView tvCity = findViewById(R.id.tvCity);
        TextView tvState = findViewById(R.id.tvState);
        TextView tvPhone = findViewById(R.id.tvPhone);
        Button btnContact=findViewById(R.id.btnContact);

        Intent intent=getIntent();
        String name = intent.getStringExtra("NAME");
        String city = intent.getStringExtra("CITY");
        String state = intent.getStringExtra("STATE");
        String phone = intent.getStringExtra("PHONE");
        String bloodgrp = intent.getStringExtra("BLOODGRP");


        tvDonorName.setText(name);
        tvBloodGroup.setText(bloodgrp);
        tvCity.setText(city);
        tvState.setText(state);
        tvPhone.setText(phone);

        String[] names=name.trim().split("\\s+");
        StringBuilder initials=new StringBuilder();
        for (String nam:names){
            if(!nam.isEmpty()){
                initials.append(Character.toUpperCase(nam.charAt(0)));
            }
        }

        tvAvatar.setText(initials.toString());




        tvBack.setOnClickListener(v->finish());
        btnContact.setOnClickListener(v->{
            Toast.makeText(DonorDetailsActivity.this,"Calling "+name,Toast.LENGTH_SHORT).show();
        });
    }
}