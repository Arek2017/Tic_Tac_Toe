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
    int gameCount = 0;
    boolean AIstarter;

    TextView textView3;

    Button buttonNext;
    Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        buttonNext = findViewById(R.id.buttonNext);
        button6 = findViewById(R.id.button6);
        textView3 = findViewById(R.id.textView3);

        selectedMode = (int)getIntent().getSerializableExtra("selectedMode");
        if(selectedMode==1){
            AIstarter = (boolean)getIntent().getSerializableExtra("AIstarter");
            replaceFragment2(new gameAI(), AIstarter);
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

        buttonNext.setOnClickListener(v -> {
            AIstarter = !AIstarter;
            if(selectedMode==1){
                setButtonsGone1();
            }
            else{
                setButtonsGone2();
            }
            buttonNext.setEnabled(false);
            gameCount++;
        });
    }

    public void setButtonsGone2() {

        fragmentClear();
        replaceFragment(new gameOnPhone());
    }

    public void setButtonsGone1() {

        fragmentClear();
        replaceFragment2(new gameAI(), AIstarter);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment, "main");
        fragmentTransaction.commit();
    }

    private void replaceFragment2(Fragment fragment, boolean temp) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("AIstarter", temp);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment, "main");
        fragmentTransaction.commit();
    }

    private void fragmentClear() {
        Fragment fragmentMain = getSupportFragmentManager().findFragmentByTag("main");
        getSupportFragmentManager().beginTransaction().remove(fragmentMain).commitAllowingStateLoss();
    }
}