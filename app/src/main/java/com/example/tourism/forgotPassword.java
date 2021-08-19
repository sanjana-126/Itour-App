package com.example.tourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class forgotPassword extends AppCompatActivity {

    EditText EmailId, newPassword, confirmPassword;
    Button updatePassword;
    FloatingActionButton fb, google, instagram;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        EmailId = findViewById(R.id.ForgotEmailId);
        newPassword = findViewById(R.id.NewPassowrd);
        confirmPassword = findViewById(R.id.ConfirmPassword);
        updatePassword = findViewById(R.id.UpdatePassword);
        fb = findViewById(R.id.facebook);
        google = findViewById(R.id.google);
        instagram = findViewById(R.id.instagram);

        dataBaseHelper = new DataBaseHelper(this);

        updatePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = EmailId.getText().toString();
                String Password = newPassword.getText().toString();
                String ConfirmPassword = confirmPassword.getText().toString();

                if (Password.equals(ConfirmPassword)){

                Boolean checkUser = dataBaseHelper.ForgotcheckUser(Email);
                if (checkUser) {
                    Boolean checkPasswordUpdate = dataBaseHelper.updatePassword(Email, Password);
                    if (checkPasswordUpdate) {
                        Intent intent = new Intent(forgotPassword.this, LoginFragment.class);
                        startActivity(intent);
                        Toast.makeText(forgotPassword.this, "Password updated successfully", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(forgotPassword.this, "Password not updated successfully", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(forgotPassword.this, "User does not exist", Toast.LENGTH_LONG).show();
                }
                }
                else {
                    Toast.makeText(forgotPassword.this, "Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}