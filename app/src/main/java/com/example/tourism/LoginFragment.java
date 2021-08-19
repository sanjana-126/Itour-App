package com.example.tourism;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    EditText email, password;
    Button forgotPassword, login;
    float v = 0;
    Context thisContext;
    private DataBaseHelper dataBaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_fragment, container, false);
        thisContext = container.getContext();

        email = root.<EditText>findViewById(R.id.LoginEmail);
        password = root.<EditText>findViewById(R.id.LoginPassword);
        forgotPassword = root.<Button>findViewById(R.id.ForgotPassword);
        login = root.<Button>findViewById(R.id.Login);

        email.setTranslationX(800);
        password.setTranslationX(800);
        forgotPassword.setTranslationX(800);
        login.setTranslationX(800);

        email.setAlpha(v);
        password.setAlpha(v);
        forgotPassword.setAlpha(v);
        login.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgotPassword.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        dataBaseHelper = new DataBaseHelper(thisContext);
        loginUser();
        ForgotPassword();

        return root;
    }

    private void loginUser() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = dataBaseHelper.checkUser(email.getText().toString(), password.getText().toString());
                if (var) {
                    Toast.makeText(getActivity(), "Logged in successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), StateScreeen.class);
                    startActivity(intent);
                    getActivity().finish();
                } else {
                    Toast.makeText(getActivity(), "Enter valid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void ForgotPassword() {
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(thisContext, com.example.tourism.forgotPassword.class);
                startActivity(intent);
            }
        });
    }
}
