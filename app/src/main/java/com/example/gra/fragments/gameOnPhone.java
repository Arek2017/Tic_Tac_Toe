package com.example.gra.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.gra.R;

public class gameOnPhone extends Fragment {

    Button buttonNext;
    Button button31;
    Button button32;
    Button button33;
    Button button34;
    Button button35;
    Button button36;
    Button button37;
    Button button38;
    Button button39;

    boolean xTurn = true;
    String[][] matrix = new String[3][3];
    int ys = 0;

    public void placeMark(Button button){
        if(xTurn == true) {
            button.setBackground(getResources().getDrawable(R.drawable.cross_shape));
        }
        else{
            button.setBackground(getResources().getDrawable(R.drawable.circle_shape));
        }
        xTurn = !xTurn;
        button.setEnabled(false);
        gameTerminate();
    }

    public void disableButtons(){
        button31.setEnabled(false);
        button32.setEnabled(false);
        button33.setEnabled(false);
        button34.setEnabled(false);
        button35.setEnabled(false);
        button36.setEnabled(false);
        button37.setEnabled(false);
        button38.setEnabled(false);
        button39.setEnabled(false);
        buttonNext.setEnabled(true);
    }

    public void gameTerminate(){
        if((matrix[0][0]=="X" && matrix[0][1]=="X" && matrix[0][2]=="X")||(matrix[1][0]=="X" && matrix[1][1]=="X" && matrix[1][2]=="X")||(matrix[2][0]=="X" && matrix[2][1]=="X" && matrix[2][2]=="X")||(matrix[0][0]=="X" && matrix[1][0]=="X" && matrix[2][0]=="X")||(matrix[0][1]=="X" && matrix[1][1]=="X" && matrix[2][1]=="X")||(matrix[0][2]=="X" && matrix[1][2]=="X" && matrix[2][2]=="X")||(matrix[0][0]=="X" && matrix[1][1]=="X" && matrix[2][2]=="X")||(matrix[0][2]=="X" && matrix[1][1]=="X" && matrix[2][0]=="X")) {
            Toast.makeText(getActivity(), "X wygrał", Toast.LENGTH_SHORT).show();
            disableButtons();
        }
        else if((matrix[0][0]=="O" && matrix[0][1]=="O" && matrix[0][2]=="O")||(matrix[1][0]=="O" && matrix[1][1]=="O" && matrix[1][2]=="O")||(matrix[2][0]=="O" && matrix[2][1]=="O" && matrix[2][2]=="O")||(matrix[0][0]=="O" && matrix[1][0]=="O" && matrix[2][0]=="O")||(matrix[0][1]=="O" && matrix[1][1]=="O" && matrix[2][1]=="O")||(matrix[0][2]=="O" && matrix[1][2]=="O" && matrix[2][2]=="O")||(matrix[0][0]=="O" && matrix[1][1]=="O" && matrix[2][2]=="O")||(matrix[0][2]=="O" && matrix[1][1]=="O" && matrix[2][0]=="O")) {
            Toast.makeText(getContext(), "O wygrał", Toast.LENGTH_SHORT).show();
            disableButtons();
        }
        else if(matrix[0][0]!=null && matrix[0][1]!=null && matrix[0][2]!=null && matrix[1][0]!=null && matrix[1][1]!=null && matrix[1][2]!=null && matrix[2][0]!=null && matrix[2][1]!=null && matrix[2][2]!=null){
            Toast.makeText(getContext(), "remis", Toast.LENGTH_SHORT).show();
            buttonNext.setEnabled(true);
        }
    }

    public gameOnPhone() {
        //very important
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
        button34 = getActivity().findViewById(R.id.button34);
        button35 = getActivity().findViewById(R.id.button35);
        button36 = getActivity().findViewById(R.id.button36);
        button37 = getActivity().findViewById(R.id.button37);
        button38 = getActivity().findViewById(R.id.button38);
        button39 = getActivity().findViewById(R.id.button39);

        buttonNext = getActivity().findViewById(R.id.buttonNext);

        button31.setOnClickListener(view31 -> {
            matrix[0][0] = xTurn ? "X" : "O";
            placeMark(button31);
        });

        button32.setOnClickListener(view32 -> {
            matrix[0][1] = xTurn ? "X" : "O";
            placeMark(button32);
        });

        button33.setOnClickListener(view33 -> {
            matrix[0][2] = xTurn ? "X" : "O";
            placeMark(button33);
        });

        button34.setOnClickListener(view34 -> {
            matrix[1][0] = xTurn ? "X" : "O";
            placeMark(button34);
        });

        button35.setOnClickListener(view35 -> {
            matrix[1][1] = xTurn ? "X" : "O";
            placeMark(button35);
        });

        button36.setOnClickListener(view36 -> {
            matrix[1][2] = xTurn ? "X" : "O";
            placeMark(button36);
        });

        button37.setOnClickListener(view37 -> {
            matrix[2][0] = xTurn ? "X" : "O";
            placeMark(button37);
        });

        button38.setOnClickListener(view38 -> {
            matrix[2][1] = xTurn ? "X" : "O";
            placeMark(button38);
        });

        button39.setOnClickListener(view39 -> {
            matrix[2][2] = xTurn ? "X" : "O";
            placeMark(button39);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_on_phone, container, false);
    }
}