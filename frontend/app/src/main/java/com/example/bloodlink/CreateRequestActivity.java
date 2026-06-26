package com.example.bloodlink;

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

public class CreateRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_request);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvBack=findViewById(R.id.tvBack);
        tvBack.setOnClickListener(v->finish());
        MaterialAutoCompleteTextView actBloodGroup = findViewById(R.id.actBloodGroup);
        MaterialAutoCompleteTextView actState = findViewById(R.id.actState);
        MaterialAutoCompleteTextView actUrgency = findViewById(R.id.actUrgency);

        TextInputEditText etUnits = findViewById(R.id.etUnits);
        TextInputEditText etHospital = findViewById(R.id.etHospital);
        TextInputEditText etCity = findViewById(R.id.etCity);
        TextInputEditText etNotes = findViewById(R.id.etNotes);

        Button btnCreateRequest=findViewById(R.id.btnCreateRequest);

        TextInputLayout bloodGroupLayout = findViewById(R.id.bloodGroupLayout);
        TextInputLayout unitsLayout = findViewById(R.id.unitsLayout);
        TextInputLayout hospitalLayout = findViewById(R.id.hospitalLayout);
        TextInputLayout stateLayout = findViewById(R.id.stateLayout);
        TextInputLayout cityLayout = findViewById(R.id.cityLayout);
        TextInputLayout urgencyLayout = findViewById(R.id.urgencyLayout);


        String[] bloodGroups = {"A+","A-","B+","B-","AB+","AB-","O+","O-"};
        actBloodGroup.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, bloodGroups));

        String[] states = getResources().getStringArray(R.array.indian_states);
        actState.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, states));

        String[] urgency = {"LOW","MEDIUM","HIGH","CRITICAL"};
        actUrgency.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, urgency));
        btnCreateRequest.setOnClickListener(v -> {

            String bloodGroup = actBloodGroup.getText().toString().trim();
            String units = etUnits.getText().toString().trim();
            String hospital = etHospital.getText().toString().trim();
            String state = actState.getText().toString().trim();
            String city = etCity.getText().toString().trim();
            String urgencyLevel = actUrgency.getText().toString().trim();

            bloodGroupLayout.setError(null);
            unitsLayout.setError(null);
            hospitalLayout.setError(null);
            stateLayout.setError(null);
            cityLayout.setError(null);
            urgencyLayout.setError(null);

            if (bloodGroup.isEmpty()) {
                bloodGroupLayout.setError("Select Blood Group");
                return;
            }

            if (units.isEmpty()) {
                unitsLayout.setError("Enter units required");
                return;
            }

            if (hospital.isEmpty()) {
                hospitalLayout.setError("Enter hospital name");
                return;
            }

            if (state.isEmpty()) {
                stateLayout.setError("Select state");
                return;
            }

            if (city.isEmpty()) {
                cityLayout.setError("Enter city");
                return;
            }

            if (urgencyLevel.isEmpty()) {
                urgencyLayout.setError("Select urgency");
                return;
            }

                Toast.makeText(CreateRequestActivity.this, "Requested Created Successfully", Toast.LENGTH_SHORT).show();
                finish();

        });
    }
}