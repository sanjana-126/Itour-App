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

public class SignUpFragment extends Fragment {

    EditText Name, Contact, EmailId, Password;
    Button Register;
    Context thisContext;
    private DataBaseHelper dataBaseHelper;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataBaseHelper = new DataBaseHelper(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_fragment, container, false);

        thisContext = container.getContext();

        Name = root.findViewById(R.id.Name);
        Contact = root.findViewById(R.id.Contact);
        EmailId = root.findViewById(R.id.SignUpEmail);
        Password = root.findViewById(R.id.SignUpPassword);
        Register = root.findViewById(R.id.Register);

        dataBaseHelper = new DataBaseHelper(thisContext);
        insertUser();

        return root;
    }

    private void insertUser() {
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = dataBaseHelper.RegisterUser(Name.getText().toString(),
                        Contact.getText().toString(), EmailId.getText().toString(),
                        Password.getText().toString());
                if (var) {
                    Toast.makeText(getActivity(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), StateScreeen.class);
                    startActivity(intent);
                    getActivity().finish();
                } else {
                    Toast.makeText(getActivity(), "Registration Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
