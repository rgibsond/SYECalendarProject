package com.sye.kupps.calendarapp;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class LoginFragment extends Fragment {

    private EditText usernameView;

    private EditText passwordView;

    private String username;

    private String password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_login, container, false);
        initViews(root);
        return root;
    }

    private void initViews(View root) {
        usernameView = (EditText) root.findViewById(R.id.username_text_field);
        passwordView = (EditText) root.findViewById(R.id.password_text_field);

        Button signIn = (Button) root.findViewById(R.id.sign_in_button);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO
                // Check that username and password match up and redirect to appropriate
                // activity. Made need AsyncTask to control what happens in wait time
            }
        });

        Button signUp = (Button) root.findViewById(R.id.sign_up_button);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO
                // Redirect to a separate sign up fragment
                Fragment signUpFragment = new SignUpFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.login_activity_container, signUpFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        Button forgotPassword = (Button) root.findViewById(R.id.forgot_password_button);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO
                // This is in the could category of features...
            }
        });
    }

    protected void retainInfo() {
        username = usernameView.getText().toString();
        password = passwordView.getText().toString();
    }

    protected void setInfo() {
        usernameView.setText(username);
        passwordView.setText(password);
    }

}
