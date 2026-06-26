package com.example.bloodlink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ProfileSetupActivity extends AppCompatActivity {
    String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setup);

        role=getIntent().getStringExtra("ROLE");
        String fullName = getIntent().getStringExtra("FULL_NAME");
        String email = getIntent().getStringExtra("EMAIL");
        String phone = getIntent().getStringExtra("PHONE");
        MaterialAutoCompleteTextView actBloodGroup=findViewById(R.id.actBloodGroup);
        MaterialAutoCompleteTextView actState=findViewById(R.id.actState);
        TextInputLayout bloodGroupLayout=findViewById(R.id.bloodGroupLayout);
        TextInputLayout stateLayout=findViewById(R.id.stateLayout);
        TextInputLayout cityLayout=findViewById(R.id.cityLayout);
        TextInputEditText etCity=findViewById(R.id.etCity);
        Button btnCompleteSetup=findViewById(R.id.btnCompleteSetup);
        TextView tvBack=findViewById(R.id.tvBack);

        String[] bloodGroups={"A+","A-","B+","B-","AB+","AB-","O+","O-"};
        ArrayAdapter<String> bloodGroupAdapter=new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,bloodGroups);
        actBloodGroup.setAdapter(bloodGroupAdapter);


        String[] states=getResources().getStringArray(R.array.indian_states);
        ArrayAdapter<String> statesAdapter=new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,states);
        actState.setAdapter(statesAdapter);



        btnCompleteSetup.setOnClickListener(n->{
            String bloodGroup=actBloodGroup.getText().toString().trim();
            String state=actState.getText().toString().trim();
            String city=etCity.getText().toString().trim();

            if(bloodGroup.isEmpty()){
                bloodGroupLayout.setError("Please select a Blood Group");
                return;
            }
            if(state.isEmpty()){
                stateLayout.setError("Please Select a State");
                return;
            }
            if(city.isEmpty()){
                cityLayout.setError("Please Select a City");
                return;
            }
            User user=new User(fullName,email,phone,bloodGroup,city,state,role);
            SessionManager.currentUser=user;
            Toast.makeText(this,"Profile Setup Complete!",Toast.LENGTH_SHORT).show();
            Intent intent;
            if("DONOR".equals(role)){
                intent=new Intent(ProfileSetupActivity.this, DashboardDonorActivity.class);
            }
            else{
                intent=new Intent(ProfileSetupActivity.this, DashBoardRecipient.class);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    tvBack.setOnClickListener(n->finish());}



}