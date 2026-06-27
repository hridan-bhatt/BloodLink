package com.example.bloodlink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class RequestDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_request_details);

        TextView tvBack = findViewById(R.id.tvBack);

        TextView tvBloodGroup = findViewById(R.id.tvBloodGroup);
        TextView tvUrgency = findViewById(R.id.tvUrgency);
        TextView tvHospital = findViewById(R.id.tvHospital);
        TextView tvCity = findViewById(R.id.tvCity);
        TextView tvUnits = findViewById(R.id.tvUnits);
        TextView tvStatus = findViewById(R.id.tvStatus);

        Button btnRespond = findViewById(R.id.btnRespond);

        Intent intent=getIntent();
        String bloodGroup=intent.getStringExtra("BLOOD");
        String urgency=intent.getStringExtra("URGENCY");
        String hospitalName=intent.getStringExtra("HOSPITAL");
        String city=intent.getStringExtra("CITY");
        String units=intent.getStringExtra("UNITS");
        String status=intent.getStringExtra("STATUS");

        tvBloodGroup.setText(bloodGroup);
        tvCity.setText(city);
        tvHospital.setText(hospitalName);
        tvUnits.setText(units);
        tvStatus.setText(status);
        tvUrgency.setText(urgency);


        tvBack.setOnClickListener(n->finish());

        btnRespond.setOnClickListener(n->{
            Toast.makeText(RequestDetailsActivity.this,"Response Sent Successfully!",Toast.LENGTH_SHORT).show();
        });
    }
}