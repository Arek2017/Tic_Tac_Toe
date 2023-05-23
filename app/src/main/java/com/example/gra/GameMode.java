package com.example.gra;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class GameMode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);

        Button button11 = findViewById(R.id.button11);
        Button button12 = findViewById(R.id.button12);
        Button button13 = findViewById(R.id.button13);

        button11.setOnClickListener(v -> {
            Intent intent = new Intent(GameMode.this, Game.class);
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(this);
            builder.setTitle("Zanim zaczniesz")
                    .setMessage("Wybierz, kto ma zaczynać")
                    .setCancelable(true)
                    .setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            boolean AIstarter = false;
                            intent.putExtra("AIstarter", (Serializable) AIstarter);
                            int selectedMode = 1;
                            intent.putExtra("selectedMode", (Serializable) selectedMode);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Komputer", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            boolean AIstarter = true;
                            intent.putExtra("AIstarter", (Serializable) AIstarter);
                            int selectedMode = 1;
                            intent.putExtra("selectedMode", (Serializable) selectedMode);
                            startActivity(intent);
                        }
                    })
                    .show();
        });

        button12.setOnClickListener(v -> {
            Intent intent = new Intent(GameMode.this, Game.class);
            int selectedMode = 2;
            intent.putExtra("selectedMode", (Serializable) selectedMode);
            startActivity(intent);
        });

        button13.setOnClickListener(v -> {
            Intent intent = new Intent(GameMode.this, MainPage.class);
            startActivity(intent);
        });
    }
}