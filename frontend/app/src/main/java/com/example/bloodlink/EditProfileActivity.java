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

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_profile);

        User user=SessionManager.currentUser;
        Toast.makeText(this,
                "Current: " + user.getFullName(),
                Toast.LENGTH_LONG).show();
        if(user==null){
            Intent intent=new Intent(EditProfileActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
            return;
        }

        MaterialAutoCompleteTextView actBloodGroup = findViewById(R.id.actBloodGroup);
        MaterialAutoCompleteTextView actState = findViewById(R.id.actState);

        TextInputEditText etName = findViewById(R.id.etName);
        TextInputEditText etPhone = findViewById(R.id.etPhone);
        TextInputEditText etCity = findViewById(R.id.etCity);

        TextInputLayout nameLayout = findViewById(R.id.nameLayout);
        TextInputLayout phoneLayout = findViewById(R.id.phoneLayout);
        TextInputLayout bloodGroupLayout = findViewById(R.id.bloodGroupLayout);
        TextInputLayout stateLayout = findViewById(R.id.stateLayout);
        TextInputLayout cityLayout = findViewById(R.id.cityLayout);

        Button btnSave = findViewById(R.id.btnSave);
        Button btnCancel = findViewById(R.id.btnCancel);

        TextView tvBack = findViewById(R.id.tvBack);

        String[] bloodGroups = {"A+","A-","B+","B-","AB+","AB-","O+","O-"};
        ArrayAdapter<String> bloodGroupAdapter=new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,bloodGroups);
        actBloodGroup.setAdapter(bloodGroupAdapter);


        String[] states = getResources().getStringArray(R.array.indian_states);

        ArrayAdapter<String> statesAdapter=new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,states);
        actState.setAdapter(statesAdapter);


        etName.setText(user.getFullName());
        etPhone.setText(user.getPhone());
        etCity.setText(user.getCity());

        actBloodGroup.setText(user.getBloodGroup(), false);
        actState.setText(user.getState(), false);

        tvBack.setOnClickListener(n->finish());
        btnCancel.setOnClickListener(n->finish());

        btnSave.setOnClickListener(n->{
            String fullName = etName.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();
            String bloodGroup = actBloodGroup.getText().toString().trim();
            String state = actState.getText().toString().trim();
            String city = etCity.getText().toString().trim();

            nameLayout.setError(null);
            phoneLayout.setError(null);
            bloodGroupLayout.setError(null);
            stateLayout.setError(null);
            cityLayout.setError(null);

            if (fullName.isEmpty()) {
                nameLayout.setError("Full Name cannot be empty");
                return;
            }

            if (phone.length() != 10 || !phone.matches("[0-9]+")) {
                phoneLayout.setError("Enter a valid phone number");
                return;
            }

            if (bloodGroup.isEmpty()) {
                bloodGroupLayout.setError("Please select a Blood Group");
                return;
            }

            if (state.isEmpty()) {
                stateLayout.setError("Please Select a State");
                return;
            }

            if (city.isEmpty()) {
                cityLayout.setError("Please Select a City");
                return;
            }
            user.setFullName(fullName);
            user.setPhone(phone);
            user.setBloodGroup(bloodGroup);
            user.setState(state);
            user.setCity(city);

//            Toast.makeText(EditProfileActivity.this,"Profile Updated Successfully",Toast.LENGTH_SHORT).show();
            Toast.makeText(this,
                    user.getFullName(),
                    Toast.LENGTH_LONG).show();
            finish();
        });
    }
}