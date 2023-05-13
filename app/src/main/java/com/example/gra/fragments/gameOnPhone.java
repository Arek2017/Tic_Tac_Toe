package com.example.gra.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gra.R;

public class gameOnPhone extends Fragment {

    Button button31;
    Button button32;
    Button button33;


    public gameOnPhone() {

    }

    public static gameOnPhone newInstance(String param1, String param2) {
        gameOnPhone fragment = new gameOnPhone();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button31 = getActivity().findViewById(R.id.button31);
        button32 = getActivity().findViewById(R.id.button32);
        button33 = getActivity().findViewById(R.id.button33);

        button31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button31.setBackground(getResources().getDrawable(R.drawable.cross_shape));
            }
        });

        button32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button32.setBackground(getResources().getDrawable(R.drawable.circle_shape));
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_on_phone, container, false);
    }
}