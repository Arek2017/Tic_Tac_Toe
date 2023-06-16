package com.example.gra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    TextInputEditText textInputEditTextUsername, textInputEditTextPassword;
    Button buttonSignUp;
    TextView textViewLogin;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        textInputEditTextUsername = findViewById(R.id.username);
        textInputEditTextPassword = findViewById(R.id.password);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        textViewLogin = findViewById(R.id.loginText);
        progressBar = findViewById(R.id.progress);

        textViewLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username, password;
                username = String.valueOf(textInputEditTextUsername.getText());
                password = String.valueOf(textInputEditTextPassword.getText());

                if (CheckAllFields()==true) {
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[2];
                            field[0] = "username";
                            field[1] = "password";
                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = password;
                            PutData putData = new PutData("http://192.168.0.158/TTT/signup.php", "POST", field, data);
                            if(putData == null){
                                Toast.makeText(getApplicationContext(), "Wrong IP Address", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                if (putData.startPut() && putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.matches("[0-9]+")) {
                                        addStatsTableUser(Integer.parseInt(result));
                                        Intent intent = new Intent(getApplicationContext(), Login.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(), "Błędne dane rejestracji", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void addStatsTableUser(int idUser){
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                String[] field = new String[1];
                field[0] = "user_id";
                String[] data = new String[1];
                data[0] = String.valueOf(idUser);
                PutData putData = new PutData("http://192.168.0.158/TTT/addstatstouser.php", "POST", field, data);
                if(putData == null){
                    Toast.makeText(getApplicationContext(), "Wrong IP Address", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (putData.startPut() && putData.onComplete()) {
                        String result = putData.getResult();
                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean CheckAllFields() {
        if (textInputEditTextUsername.length() == 0) {
            textInputEditTextUsername.setError("This field is required");
            return false;
        }

        if (textInputEditTextPassword.length() == 0) {
            textInputEditTextPassword.setError("This field is required");
            return false;
        }

        if (textInputEditTextUsername.length() < 5 && textInputEditTextUsername.length() > 25) {
            textInputEditTextUsername.setError("Must be between 5 and 25 characters long");
            return false;
        }

        if (textInputEditTextPassword.length() < 8 && textInputEditTextPassword.length() > 25) {
            textInputEditTextPassword.setError("Must be between 8 and 25 characters long");
            return false;
        }

        String regex = "[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(String.valueOf(textInputEditTextUsername.getText()));

        if (!matcher.matches()) {
            textInputEditTextUsername.setError("Only uppercase and lowercase letters, Polish characters and numbers allowed");
            return false;
        }

        return true;
    }
}