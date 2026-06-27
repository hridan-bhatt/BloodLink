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

public class ViewRequestsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_requests);
        TextView tvBack = findViewById(R.id.tvBack);

        MaterialCardView cardRequest1 = findViewById(R.id.cardRequest1);
        MaterialCardView cardRequest2 = findViewById(R.id.cardRequest2);
        MaterialCardView cardRequest3 = findViewById(R.id.cardRequest3);


        tvBack.setOnClickListener(n-> finish());

        cardRequest1.setOnClickListener(n->{
            Intent intent=new Intent(ViewRequestsActivity.this, RequestDetailsActivity.class);
            intent.putExtra("BLOOD", "B+");
            intent.putExtra("URGENCY", "CRITICAL");
            intent.putExtra("HOSPITAL", "Civil Hospital");
            intent.putExtra("CITY", "Ahmedabad");
            intent.putExtra("UNITS", "2");
            intent.putExtra("STATUS", "Open");
            startActivity(intent);
        });
        cardRequest2.setOnClickListener(n->{
            Intent intent=new Intent(ViewRequestsActivity.this, RequestDetailsActivity.class);
            intent.putExtra("BLOOD", "O+");
            intent.putExtra("URGENCY", "HIGH");
            intent.putExtra("HOSPITAL", "Aartham Hospital");
            intent.putExtra("CITY", "Ahmedabad");
            intent.putExtra("UNITS", "1");
            intent.putExtra("STATUS", "Open");
            startActivity(intent);
        });
        cardRequest3.setOnClickListener(n->{
            Intent intent=new Intent(ViewRequestsActivity.this, RequestDetailsActivity.class);
            intent.putExtra("BLOOD", "A+");
            intent.putExtra("URGENCY", "MEDIUM");
            intent.putExtra("HOSPITAL", "Rajasthan Hospital");
            intent.putExtra("CITY", "Surat");
            intent.putExtra("UNITS", "3");
            intent.putExtra("STATUS", "Open");
            startActivity(intent);
        });

    }
}