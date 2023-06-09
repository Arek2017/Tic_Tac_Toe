package com.example.gra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Login extends AppCompatActivity {

    TextInputEditText textInputEditTextUsername, textInputEditTextPassword;
    Button buttonLogin;
    TextView textViewSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEditTextUsername = findViewById(R.id.username);
        textInputEditTextPassword = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.btnLogin);
        textViewSignUp = findViewById(R.id.signUpText);

        if(SharedPreferencesManager.getInstance(getApplicationContext()).getStatus()==true){
            goToMainActivity();
        }
        textViewSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
                finish();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username, password;
                username = String.valueOf(textInputEditTextUsername.getText());
                password = String.valueOf(textInputEditTextPassword.getText());

                if (!username.equals("") && !password.equals("")) {
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

                            PutData putData = new PutData("http://arek2017.ct8.pl/TTT/login.php", "POST", field, data);
                            if (putData.startPut() && putData.onComplete()) {
                                String result = putData.getResult();
                                if(result.matches("[0-9]+")){
                                    SharedPreferencesManager.getInstance(getApplicationContext()).setStatus(true);
                                    SharedPreferencesManager.getInstance(getApplicationContext()).setUsername(data[0]);
                                    SharedPreferencesManager.getInstance(getApplicationContext()).setUserID(Integer.parseInt(result));
                                    Toast.makeText(getApplicationContext(), "Poprawnie zalogowano", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), MainPage.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else{
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void goToMainActivity() {
        Intent i = new Intent(this,MainPage.class);
        startActivity(i);
    }
}