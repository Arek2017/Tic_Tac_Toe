package com.example.gra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Statistics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        TextView textViewS6 = findViewById(R.id.textViewS6);
        TextView textViewS7 = findViewById(R.id.textViewS7);
        TextView textViewS8 = findViewById(R.id.textViewS8);
        TextView textViewS9 = findViewById(R.id.textViewS9);
        Button button10 = findViewById(R.id.button10);

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Statistics.this, MainPage.class);
                startActivity(intent);
            }
        });
    }
}