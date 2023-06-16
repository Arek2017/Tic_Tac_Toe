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

public class Statistics extends AppCompatActivity {


    TextView textViewS6;
    TextView textViewS7;
    TextView textViewS8;
    TextView textViewS9;
    Button button10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        textViewS6 = findViewById(R.id.textViewS6);
        textViewS7 = findViewById(R.id.textViewS7);
        textViewS8 = findViewById(R.id.textViewS8);
        textViewS9 = findViewById(R.id.textViewS9);
        button10 = findViewById(R.id.button10);

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Statistics.this, MainPage.class);
                startActivity(intent);
                finish();
            }
        });
        downloadStats();
    }

    public void downloadStats() {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                String[] field = new String[1];
                field[0] = "user_id";
                String[] data = new String[1];
                data[0] = String.valueOf(SharedPreferencesManager.getInstance(getApplicationContext()).getUserID());
                PutData putData = new PutData("http://192.168.0.158/TTT/displaystats.php", "POST", field, data);
                if (putData == null) {
                    Toast.makeText(getApplicationContext(), "Wrong IP Address", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (putData.startPut() && putData.onComplete()) {
                        if (putData.getResult().equals("Error: Data is null")) {
                            textViewS6.setText("Brak danych");
                            textViewS7.setText("Brak danych");
                            textViewS8.setText("Brak danych");
                            textViewS9.setText("Brak danych");
                            Toast.makeText(getApplicationContext(), "Nie masz jeszcze żadnych rozgrywek", Toast.LENGTH_SHORT).show();
                        } else {
                            String result = putData.getResult();
                            String[] lines = result.split("<br>");
                            textViewS6.setText(lines[0]);
                            textViewS7.setText(lines[1]);
                            textViewS8.setText(lines[2]);
                            textViewS9.setText(lines[3]);
                        }
                    }
                }
            }
        });
    }
}