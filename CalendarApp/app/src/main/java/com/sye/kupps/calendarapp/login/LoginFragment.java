package com.sye.kupps.calendarapp.login;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sye.kupps.calendarapp.FragmentHandler;
import com.sye.kupps.calendarapp.R;

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

                if (false) {
                    // login successful, move onto main app
                } else {
                    // unsuccessful, prompt user to retry
                    usernameView.setBackgroundColor(getResources().getColor(R.color.textedit_error, null));
                    passwordView.setBackgroundColor(getResources().getColor(R.color.textedit_error, null));
                    Toast.makeText(getActivity(), "Your login information is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button signUp = (Button) root.findViewById(R.id.sign_up_button);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO
                // Redirect to a separate sign up fragment
                FragmentHandler fh = new FragmentHandler(getActivity());
                fh.replace(R.id.login_activity_container, new SignUpFragment());
            }
        });

        Button forgotPassword = (Button) root.findViewById(R.id.forgot_password_button);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO
                // This is in the could category of features...
                Toast.makeText(getActivity(), "Sucks to suck fuckboi", Toast.LENGTH_SHORT).show();
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
