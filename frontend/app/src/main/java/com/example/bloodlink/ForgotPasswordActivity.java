package com.example.bloodlink;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_password);

        TextInputLayout emailLayout = findViewById(R.id.emailLayout);
        TextInputLayout newPasswordLayout = findViewById(R.id.newPasswordLayout);
        TextInputLayout confirmPasswordLayout = findViewById(R.id.confirmPasswordLayout);

        TextInputEditText etEmail = findViewById(R.id.etEmail);
        TextInputEditText etNewPassword = findViewById(R.id.etNewPassword);
        TextInputEditText etConfirmPassword = findViewById(R.id.etConfirmPassword);

        Button btnResetPassword = findViewById(R.id.btnResetPassword);
        Button btnBackToLogin = findViewById(R.id.btnBackToLogin);

        emailLayout.getEditText().addTextChangedListener(new android.text.TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailLayout.setError(null);
            }
            public void afterTextChanged(android.text.Editable s) {}
        });
        newPasswordLayout.getEditText().addTextChangedListener(new android.text.TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                newPasswordLayout.setError(null);
            }
            public void afterTextChanged(android.text.Editable s) {}
        });
        confirmPasswordLayout.getEditText().addTextChangedListener(new android.text.TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                confirmPasswordLayout.setError(null);
            }
            public void afterTextChanged(android.text.Editable s) {}
        });

        btnResetPassword.setOnClickListener(n->{
            String email = etEmail.getText().toString().trim();
            String newPassword = etNewPassword.getText().toString().trim();
            String confirmPassword = etConfirmPassword.getText().toString().trim();

            emailLayout.setError(null);
            newPasswordLayout.setError(null);
            confirmPasswordLayout.setError(null);

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailLayout.setError("Enter a valid email address");
                return;
            }

            if (newPassword.isEmpty()) {
                newPasswordLayout.setError("Password cannot be empty");
                return;
            }

            if (newPassword.length() < 8) {
                newPasswordLayout.setError("Password must be at least 8 characters");
                return;
            }

            if (confirmPassword.isEmpty()) {
                confirmPasswordLayout.setError("Confirm your password");
                return;
            }

            if (!newPassword.equals(confirmPassword)) {
                confirmPasswordLayout.setError("Passwords do not match");
                return;
            }

            Toast.makeText(ForgotPasswordActivity.this, "Password updated successfully", Toast.LENGTH_SHORT).show();

            finish();
        });
        btnBackToLogin.setOnClickListener(n->{
            finish();
        });
    }
}