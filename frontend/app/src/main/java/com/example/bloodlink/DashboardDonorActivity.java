package com.example.bloodlink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

public class DashboardDonorActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_dashboard_donor);
        tvUserName = findViewById(R.id.tvUserName);
        tvUserMeta = findViewById(R.id.tvUserMeta);
        loadUserData();

        BottomNavigationView bottomNav=findViewById(R.id.bottomNav);
        bottomNav.setSelectedItemId(R.id.nav_home);
        bottomNav.setOnItemSelectedListener(item->{
            if (item.getItemId()==R.id.nav_profile){
                startActivity(new Intent(DashboardDonorActivity.this,ProfileActivity.class));
                return true;
            }
            return true;
        });



    }
    @Override
    protected void onResume() {
        super.onResume();
        loadUserData();
    }
}