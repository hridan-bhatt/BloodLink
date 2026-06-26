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

public class DashBoardRecipient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dash_board_recipient);

        User user = SessionManager.currentUser;

        TextView tvUserName = findViewById(R.id.tvUserName);
        TextView tvUserMeta = findViewById(R.id.tvUserMeta);

        tvUserName.setText(user.getFullName());
        tvUserMeta.setText(user.getBloodGroup() + " • " + user.getCity());

        Button btnCreateRequest = findViewById(R.id.btnCreateRequest);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        btnCreateRequest.setOnClickListener(v -> {
            Intent intent = new Intent(
                    DashBoardRecipient.this,
                    CreateRequestActivity.class
            );
            startActivity(intent);
        });

        bottomNav.setSelectedItemId(R.id.nav_home);

        bottomNav.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.nav_profile) {
                startActivity(new Intent(
                        DashBoardRecipient.this,
                        ProfileActivity.class
                ));
                return true;
            }

            return true;
        });
    }
}