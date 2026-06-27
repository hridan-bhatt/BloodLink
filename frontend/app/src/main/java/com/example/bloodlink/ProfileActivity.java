package com.example.bloodlink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {


    private void loadUserData() {
        User user = SessionManager.currentUser;

        if(user==null){
            startActivity(new Intent(this, MainActivity.class));
            finish();
            return;
        }

        TextView tvAvatar=findViewById(R.id.tvAvatar);

        TextView tvUserName = findViewById(R.id.tvUserName);
        TextView tvRole = findViewById(R.id.tvRole);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvPhone = findViewById(R.id.tvPhone);
        TextView tvBloodGroup = findViewById(R.id.tvBloodGroup);
        TextView tvCity = findViewById(R.id.tvCity);
        TextView tvState = findViewById(R.id.tvState);

        tvUserName.setText(user.getFullName());
        tvEmail.setText(user.getEmail());
        tvRole.setText(user.getRole());
        tvPhone.setText(user.getPhone());
        tvBloodGroup.setText(user.getBloodGroup());
        tvCity.setText(user.getCity());
        tvState.setText(user.getState());

        String[] names = user.getFullName().trim().split("\\s+");
        StringBuilder initials = new StringBuilder();

        for (String name : names) {
            if (!name.isEmpty()) {
                initials.append(Character.toUpperCase(name.charAt(0)));
            }
        }

        tvAvatar.setText(initials.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        User user=SessionManager.currentUser;

        if(user==null){
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
            return;
        }
        loadUserData();

        Button btnEditProfile=findViewById(R.id.btnEditProfile);
        Button btnLogout=findViewById(R.id.btnLogout);
        BottomNavigationView bottomNav=findViewById(R.id.bottomNav);


        bottomNav.getMenu().clear();
        if ("DONOR".equals(user.getRole())) {
            bottomNav.inflateMenu(R.menu.donor_bottom_nav);
        } else {
            bottomNav.inflateMenu(R.menu.recipient_bottom_nav);
        }

        bottomNav.setSelectedItemId(R.id.nav_profile);
        bottomNav.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.nav_home) {

                Intent intent;

                if ("DONOR".equals(user.getRole())) {
                    intent = new Intent(ProfileActivity.this, DashboardDonorActivity.class);
                } else {
                    intent = new Intent(ProfileActivity.this, DashBoardRecipient.class);
                }

                startActivity(intent);
                finish();
                return true;
            }

            if (item.getItemId() == R.id.nav_my_requests) {
                startActivity(new Intent(ProfileActivity.this, ViewRequestsActivity.class));
                return true;
            }

            if (item.getItemId() == R.id.nav_history) {

                if ("DONOR".equals(user.getRole())) {
                    startActivity(new Intent(ProfileActivity.this, DonationHistoryActivity.class));
                } else {
                    startActivity(new Intent(ProfileActivity.this, RequestHistory.class));
                }

                return true;
            }

            if (item.getItemId() == R.id.nav_profile) {
                return true;
            }

            return false;
        });
        btnLogout.setOnClickListener(n->{
            SessionManager.currentUser=null;
            Intent intent=new Intent(ProfileActivity.this,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
        btnEditProfile.setOnClickListener(n->{
            startActivity(new Intent(ProfileActivity.this,EditProfileActivity.class));
        });
    }
    @Override
    protected void onResume() {
        super.onResume();

        loadUserData();
    }
}