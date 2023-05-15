package com.example.gra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.gra.fragments.gameAI;
import com.example.gra.fragments.gameOnPhone;

public class Game extends AppCompatActivity {

    int selectedMode;

    TextView textView3;
    TextView textView7;
    TextView textView8;
    Button button;
    Button button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        button = findViewById(R.id.button);
        button6 = findViewById(R.id.button6);
        textView3 = findViewById(R.id.textView3);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);

        selectedMode = (int)getIntent().getSerializableExtra("selectedMode");
        if(selectedMode==1){
            replaceFragment(new gameAI());
            textView3.setText("Gra z komputerem");
        }
        else if(selectedMode==2){
            replaceFragment(new gameOnPhone());
            textView3.setText("Gra ze znajomym");
        }

        button6.setOnClickListener(v -> {
            Intent intent = new Intent(Game.this, MainPage.class);
            startActivity(intent);
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}