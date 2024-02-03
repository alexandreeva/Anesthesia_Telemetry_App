package com.example.anesthesiatelemetryapp;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    // --- declare values
    private String email, password; //
    private EditText emailInput, passwordInput; // user input
    private Button loginButton; // button

    /**
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page); // connect loginActivity.java to activity_login.xml

        // --- intialize values
        // user's input is stored in EditText value
        emailInput = (EditText) findViewById(R.id.inputEmail_); //
        passwordInput = (EditText) findViewById(R.id.inputPassword_);

        loginButton = (Button) findViewById(R.id.loginButton_);

        // when users presses the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the user's input
                email = emailInput.getText().toString();
                password = passwordInput.getText().toString();

                // what is being typed is shown for a brief moment
                showToast(email);
                showToast(password);

                openVitalSignActivity();  // opens to next page
            }
        });

    }

    /**
     *
     * @param text it
     */
    private void showToast (String text) {
        Toast.makeText(LoginActivity.this, text, Toast.LENGTH_SHORT).show();
    }


    /** method is used to open to the nex
     *
     */
    public void openVitalSignActivity(){
        Intent intent = new Intent(LoginActivity.this, VitalSignsActivity.class);
        startActivity(intent);
    }


} // end of class
