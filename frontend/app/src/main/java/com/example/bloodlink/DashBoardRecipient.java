package com.example.bloodlink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;

public class DashBoardRecipient extends AppCompatActivity {
    private TextView tvUserName;
    private TextView tvUserMeta;

    private void loadUserData() {
        User user = SessionManager.currentUser;
        tvUserName.setText(user.getFullName());
        tvUserMeta.setText(user.getBloodGroup() + " • " + user.getCity());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dash_board_recipient);

        User user = SessionManager.currentUser;
        tvUserName = findViewById(R.id.tvUserName);
        tvUserMeta = findViewById(R.id.tvUserMeta);
        loadUserData();

        TextView tvViewAll = findViewById(R.id.tvViewAll);
            MaterialCardView cardDonor1 = findViewById(R.id.cardDonor1);
        Button btnCreateRequest = findViewById(R.id.btnCreateRequest);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        btnCreateRequest.setOnClickListener(v -> {
            Intent intent = new Intent(DashBoardRecipient.this, CreateRequestActivity.class);
            startActivity(intent);
        });

        bottomNav.setSelectedItemId(R.id.nav_home);

        bottomNav.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.nav_profile) {
                startActivity(new Intent(DashBoardRecipient.this, ProfileActivity.class));
                return true;
            }

            return true;
        });
        tvViewAll.setOnClickListener(v ->
                startActivity(new Intent(
                        DashBoardRecipient.this,
                        DonorListActivity.class
                ))
        );
        cardDonor1.setOnClickListener(v -> {
            startActivity(new Intent(
                    DashBoardRecipient.this,
                    DonorListActivity.class
            ));
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        loadUserData();
    }
}