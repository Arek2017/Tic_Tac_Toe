package com.example.gra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class MainPage extends AppCompatActivity {

    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        textView2 = findViewById(R.id.textView2);
        downloadUserName();
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, GameMode.class);
                startActivity(intent);
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, Statistics.class);
                startActivity(intent);
                finish();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesManager.getInstance(getApplicationContext()).logOut();
                Toast.makeText(getBaseContext(), "Logged out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainPage.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesManager.getInstance(getApplicationContext()).logOut();
                Toast.makeText(getBaseContext(), "Logged out", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    public void downloadUserName() {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                String[] field = new String[1];
                field[0] = "id";
                String[] data = new String[1];
                data[0] = String.valueOf(SharedPreferencesManager.getInstance(getApplicationContext()).getUserID());
                PutData putData = new PutData("http://192.168.0.158/TTT/downloadname.php", "POST", field, data);
                if (putData == null) {
                    Toast.makeText(getApplicationContext(), "Wrong IP Address", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (putData.startPut() && putData.onComplete()) {
                        if (putData.getResult().equals("Error: Data is null")) {
                            textView2.setText("");
                            Toast.makeText(getApplicationContext(), "Błąd wczytywania nazwy użytkownika", Toast.LENGTH_SHORT).show();
                        } else {
                            String result = putData.getResult();
                            String[] lines = result.split("<br>");
                            textView2.setText(lines[0]);
                        }
                    }
                }
            }
        });
    }
}