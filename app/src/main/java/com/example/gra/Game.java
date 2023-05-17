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

    Button buttonNext;
    Button button6;
    Button button31, button32, button33, button34, button35, button36, button37, button38, button39;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        buttonNext = findViewById(R.id.buttonNext);
        button6 = findViewById(R.id.button6);
        textView3 = findViewById(R.id.textView3);


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

        buttonNext.setOnClickListener(v -> {
            setButtonsGone();
            buttonNext.setEnabled(false);

            //button31.setEnabled(true); button32.setEnabled(true); button33.setEnabled(true); button34.setEnabled(true); button35.setEnabled(true); button36.setEnabled(true); button37.setEnabled(true); button38.setEnabled(true); button39.setEnabled(true);
            //button31.setBackground(getResources().getDrawable(R.drawable.empty_shape)); button32.setBackground(getResources().getDrawable(R.drawable.empty_shape)); button33.setBackground(getResources().getDrawable(R.drawable.empty_shape)); button34.setBackground(getResources().getDrawable(R.drawable.empty_shape)); button35.setBackground(getResources().getDrawable(R.drawable.empty_shape)); button36.setBackground(getResources().getDrawable(R.drawable.empty_shape)); button37.setBackground(getResources().getDrawable(R.drawable.empty_shape)); button38.setBackground(getResources().getDrawable(R.drawable.empty_shape)); button39.setBackground(getResources().getDrawable(R.drawable.empty_shape));
        });
    }

    public void setButtonsGone() {
        /*Fragment fragmentTwoPlayers = getSupportFragmentManager().findFragmentByTag("mainFragment");
        button31 = fragmentTwoPlayers.getView().findViewById(R.id.button31);
        button32 = fragmentTwoPlayers.getView().findViewById(R.id.button32);
        button33 = fragmentTwoPlayers.getView().findViewById(R.id.button33);
        button34 = fragmentTwoPlayers.getView().findViewById(R.id.button34);
        button35 = fragmentTwoPlayers.getView().findViewById(R.id.button35);
        button36 = fragmentTwoPlayers.getView().findViewById(R.id.button36);
        button37 = fragmentTwoPlayers.getView().findViewById(R.id.button37);
        button38 = fragmentTwoPlayers.getView().findViewById(R.id.button38);
        button39 = fragmentTwoPlayers.getView().findViewById(R.id.button39);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button31.setBackgroundResource(R.drawable.empty_shape);
                button32.setBackgroundResource(R.drawable.empty_shape);
                button33.setBackgroundResource(R.drawable.empty_shape);
                button34.setBackgroundResource(R.drawable.empty_shape);
                button35.setBackgroundResource(R.drawable.empty_shape);
                button36.setBackgroundResource(R.drawable.empty_shape);
                button37.setBackgroundResource(R.drawable.empty_shape);
                button38.setBackgroundResource(R.drawable.empty_shape);
                button39.setBackgroundResource(R.drawable.empty_shape);
            }
        });*/
        fragmentClear();
        replaceFragment(new gameOnPhone());
    }

    private void replaceFragment(Fragment fragment) {
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