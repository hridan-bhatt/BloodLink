package com.example.bloodlink;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {
    private String selectedRole = "DONOR";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        MaterialButton btnDonor=findViewById(R.id.btnDonor);
        MaterialButton btnRecipient=findViewById(R.id.btnRecipient);
        Button btnCreateAcc=findViewById(R.id.btnContinue);
        TextView already_Acc=findViewById(R.id.tvLogin);
        TextInputLayout fullNameLayout = findViewById(R.id.fullNameLayout);
        TextInputLayout emailLayout = findViewById(R.id.emailLayout);
        TextInputLayout phoneLayout = findViewById(R.id.phoneLayout);
        TextInputLayout passwordLayout = findViewById(R.id.passwordLayout);
        TextInputLayout confirmPasswordLayout = findViewById(R.id.confirmPasswordLayout);
        fullNameLayout.getEditText().addTextChangedListener(new android.text.TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) { fullNameLayout.setError(null); }
            public void afterTextChanged(android.text.Editable s) {}
        });
        emailLayout.getEditText().addTextChangedListener(new android.text.TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) { emailLayout.setError(null); }
            public void afterTextChanged(android.text.Editable s) {}
        });
        phoneLayout.getEditText().addTextChangedListener(new android.text.TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) { phoneLayout.setError(null); }
            public void afterTextChanged(android.text.Editable s) {}
        });
        passwordLayout.getEditText().addTextChangedListener(new android.text.TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) { passwordLayout.setError(null); }
            public void afterTextChanged(android.text.Editable s) {}
        });
        confirmPasswordLayout.getEditText().addTextChangedListener(new android.text.TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) { confirmPasswordLayout.setError(null); }
            public void afterTextChanged(android.text.Editable s) {}
        });

        btnCreateAcc.setOnClickListener(n->{
            String fullName = fullNameLayout.getEditText().getText().toString().trim();
            String email = emailLayout.getEditText().getText().toString().trim();
            String phone = phoneLayout.getEditText().getText().toString().trim();
            String password = passwordLayout.getEditText().getText().toString().trim();
            String confirmPassword = confirmPasswordLayout.getEditText().getText().toString().trim();

            if(fullName.isEmpty()){
                fullNameLayout.setError("Full Name cannot be empty");
                return;
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                emailLayout.setError("Enter a valid email address");
                return;
            }
            if(phone.length()!=10 || !phone.matches("[0-9]+")){
                phoneLayout.setError("Enter a valid phone number");
                return;
            }
            if(password.isEmpty() || confirmPassword.isEmpty()){
                passwordLayout.setError("Password cannot be empty");
                return;
            }
            if(!confirmPassword.equals(password)){
                confirmPasswordLayout.setError("Passwords should be matching");
                return;
            }
            Intent intent=new Intent(SignUpActivity.this,ProfileSetupActivity.class);
            intent.putExtra("FULL_NAME",fullName);
            intent.putExtra("EMAIL",email);
            intent.putExtra("PHONE", phone);
            intent.putExtra("PASSWORD", password); // temporary, until backend
            intent.putExtra("ROLE", selectedRole);

            startActivity(intent);
        });
        btnRecipient.setOnClickListener(n->{

            selectedRole = "RECIPIENT";
            btnDonor.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.white)));
            btnRecipient.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.blood_red)));
            btnDonor.setTextColor(ContextCompat.getColor(this,R.color.blood_red));
            btnRecipient.setTextColor(ContextCompat.getColor(this,R.color.white));
            btnDonor.setStrokeWidth(4);
            btnDonor.setStrokeColor(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.blood_red)));
        });

        btnDonor.setOnClickListener(n->{
            selectedRole = "DONOR";
            btnDonor.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.blood_red)));
            btnRecipient.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.white)));
            btnDonor.setTextColor(ContextCompat.getColor(this,R.color.white));
            btnDonor.setStrokeWidth(0);
            btnRecipient.setTextColor(ContextCompat.getColor(this,R.color.blood_red));
        });

        already_Acc.setOnClickListener(n->{


            Intent intent=new Intent(SignUpActivity.this,MainActivity.class);
            startActivity(intent);
        });

    }
}