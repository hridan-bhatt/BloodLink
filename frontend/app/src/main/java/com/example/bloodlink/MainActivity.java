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

public class MainActivity extends AppCompatActivity {
    private String selectedRole="DONOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnRegister=findViewById(R.id.btnRegister);
        MaterialButton btnDonor=findViewById(R.id.btnDonor);
        MaterialButton btnRecipient=findViewById(R.id.btnRecipient);
        Button btnLogin=findViewById(R.id.btnLogin);


        TextInputLayout emailLayout = findViewById(R.id.emailLayout);
        TextInputLayout passwordLayout = findViewById(R.id.passwordLayout);
        emailLayout.getEditText().addTextChangedListener(new android.text.TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) { emailLayout.setError(null); }
            public void afterTextChanged(android.text.Editable s) {}
        });
        passwordLayout.getEditText().addTextChangedListener(new android.text.TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) { passwordLayout.setError(null); }
            public void afterTextChanged(android.text.Editable s) {}
        });
        TextView tvForgotPassword = findViewById(R.id.tvForgotPassword);

        tvForgotPassword.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ForgotPasswordActivity.class));
        });

        btnLogin.setOnClickListener(n->{
            String email = emailLayout.getEditText().getText().toString().trim();
            String password = passwordLayout.getEditText().getText().toString().trim();
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                emailLayout.setError("Enter a valid email address");
                return;
            }
            if(password.isEmpty()){
                passwordLayout.setError("Password cannot be empty");
                return;
            }
            Intent intent;
            User user;
            if ("DONOR".equals(selectedRole)) {
                user = new User("Hridan Bhatt",email,"9876543210","B+","Vadodara","Gujarat","DONOR");
            } else {
                user = new User("Hridan Bhatt",email,"9876543210","B+","Vadodara","Gujarat","RECIPIENT");
            }

            SessionManager.currentUser=user;
            if("DONOR".equals(user.getRole())){
                intent=new Intent(MainActivity.this, DashboardDonorActivity.class);
            }
            else{
                intent=new Intent(MainActivity.this, DashBoardRecipient.class);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();

        });

        btnRegister.setOnClickListener(n->{
            Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(intent);
        });


        btnRecipient.setOnClickListener(n->{

            selectedRole="RECIPIENT";
            btnDonor.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.white)));
            btnRecipient.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.blood_red)));
            btnDonor.setTextColor(ContextCompat.getColor(this,R.color.blood_red));
            btnRecipient.setTextColor(ContextCompat.getColor(this,R.color.white));
            btnDonor.setStrokeWidth(4);
            btnDonor.setStrokeColor(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.blood_red)));
        });

        btnDonor.setOnClickListener(n->{
            selectedRole="DONOR";
            btnDonor.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.blood_red)));
            btnRecipient.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.white)));
            btnDonor.setTextColor(ContextCompat.getColor(this,R.color.white));
            btnDonor.setStrokeWidth(0);
            btnRecipient.setTextColor(ContextCompat.getColor(this,R.color.blood_red));
        });
    }
}