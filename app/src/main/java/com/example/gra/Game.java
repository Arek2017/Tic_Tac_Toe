package com.example.gra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.gra.fragments.gameAI;
import com.example.gra.fragments.gameOnPhone;

public class Game extends AppCompatActivity {

    int selectedMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        selectedMode = (int)getIntent().getSerializableExtra("selectedMode");
        if(selectedMode==1){
            replaceFragment(new gameAI());
        }
        else if(selectedMode==2){
            replaceFragment(new gameOnPhone());
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}