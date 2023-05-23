package com.example.gra.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gra.R;

import java.util.Random;

public class gameAI extends Fragment {

    Button buttonNext;
    Button button21;
    Button button22;
    Button button23;
    Button button24;
    Button button25;
    Button button26;
    Button button27;
    Button button28;
    Button button29;
    TextView oWinsInSession;
    TextView xWinsInSession;
    boolean AIstarter;
    boolean AImove = AIstarter;
    Random rand = new Random();
    int upperbound = 100;
    int int_random = rand.nextInt(upperbound);

    boolean xTurn = true;
    String[][] matrix = new String[3][3];

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
        button21.setEnabled(false);
        button22.setEnabled(false);
        button23.setEnabled(false);
        button24.setEnabled(false);
        button25.setEnabled(false);
        button26.setEnabled(false);
        button27.setEnabled(false);
        button28.setEnabled(false);
        button29.setEnabled(false);
        buttonNext.setEnabled(true);
    }

    public void gameTerminate(){
        if((matrix[0][0]=="X" && matrix[0][1]=="X" && matrix[0][2]=="X")||(matrix[1][0]=="X" && matrix[1][1]=="X" && matrix[1][2]=="X")||(matrix[2][0]=="X" && matrix[2][1]=="X" && matrix[2][2]=="X")||(matrix[0][0]=="X" && matrix[1][0]=="X" && matrix[2][0]=="X")||(matrix[0][1]=="X" && matrix[1][1]=="X" && matrix[2][1]=="X")||(matrix[0][2]=="X" && matrix[1][2]=="X" && matrix[2][2]=="X")||(matrix[0][0]=="X" && matrix[1][1]=="X" && matrix[2][2]=="X")||(matrix[0][2]=="X" && matrix[1][1]=="X" && matrix[2][0]=="X")) {
            Toast.makeText(getActivity(), "X wygrał", Toast.LENGTH_SHORT).show();
            disableButtons();
            int xWinsNow = Integer.parseInt(xWinsInSession.getText().toString());
            xWinsInSession.setText(String.valueOf(xWinsNow+1));
        }
        else if((matrix[0][0]=="O" && matrix[0][1]=="O" && matrix[0][2]=="O")||(matrix[1][0]=="O" && matrix[1][1]=="O" && matrix[1][2]=="O")||(matrix[2][0]=="O" && matrix[2][1]=="O" && matrix[2][2]=="O")||(matrix[0][0]=="O" && matrix[1][0]=="O" && matrix[2][0]=="O")||(matrix[0][1]=="O" && matrix[1][1]=="O" && matrix[2][1]=="O")||(matrix[0][2]=="O" && matrix[1][2]=="O" && matrix[2][2]=="O")||(matrix[0][0]=="O" && matrix[1][1]=="O" && matrix[2][2]=="O")||(matrix[0][2]=="O" && matrix[1][1]=="O" && matrix[2][0]=="O")) {
            Toast.makeText(getContext(), "O wygrał", Toast.LENGTH_SHORT).show();
            disableButtons();
            int oWinsNow = Integer.parseInt(oWinsInSession.getText().toString());
            oWinsInSession.setText(String.valueOf(oWinsNow+1));
        }
        else if(matrix[0][0]!=null && matrix[0][1]!=null && matrix[0][2]!=null && matrix[1][0]!=null && matrix[1][1]!=null && matrix[1][2]!=null && matrix[2][0]!=null && matrix[2][1]!=null && matrix[2][2]!=null){
            Toast.makeText(getContext(), "remis", Toast.LENGTH_SHORT).show();
            buttonNext.setEnabled(true);
        }
    }

    public gameAI() {

    }

    public static gameAI newInstance(String param1, String param2) {
        gameAI fragment = new gameAI();
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
        button21 = getActivity().findViewById(R.id.button21);
        button22 = getActivity().findViewById(R.id.button22);
        button23 = getActivity().findViewById(R.id.button23);
        button24 = getActivity().findViewById(R.id.button24);
        button25 = getActivity().findViewById(R.id.button25);
        button26 = getActivity().findViewById(R.id.button26);
        button27 = getActivity().findViewById(R.id.button27);
        button28 = getActivity().findViewById(R.id.button28);
        button29 = getActivity().findViewById(R.id.button29);

        buttonNext = getActivity().findViewById(R.id.buttonNext);

        oWinsInSession = getActivity().findViewById(R.id.oWinsInSession);
        xWinsInSession = getActivity().findViewById(R.id.xWinsInSession);

        button21.setOnClickListener(view21 -> {
            matrix[0][0] = xTurn ? "X" : "O";
            placeMark(button21);
        });

        button22.setOnClickListener(view22 -> {
            matrix[0][1] = xTurn ? "X" : "O";
            placeMark(button22);
        });

        button23.setOnClickListener(view23 -> {
            matrix[0][2] = xTurn ? "X" : "O";
            placeMark(button23);
        });

        button24.setOnClickListener(view24 -> {
            matrix[1][0] = xTurn ? "X" : "O";
            placeMark(button24);
        });

        button25.setOnClickListener(view25 -> {
            matrix[1][1] = xTurn ? "X" : "O";
            placeMark(button25);
        });

        button26.setOnClickListener(view26 -> {
            matrix[1][2] = xTurn ? "X" : "O";
            placeMark(button26);
        });

        button27.setOnClickListener(view27 -> {
            matrix[2][0] = xTurn ? "X" : "O";
            placeMark(button27);
        });

        button28.setOnClickListener(view28 -> {
            matrix[2][1] = xTurn ? "X" : "O";
            placeMark(button28);
        });

        button29.setOnClickListener(view29 -> {
            matrix[2][2] = xTurn ? "X" : "O";
            placeMark(button29);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_a_i, container, false);
    }
}

/*
Minimax(s):

if Terminal(s);
    return Value(s);

if Player(s) == MAX:
    value = -infinity
    for a in Actions(s):
        value = Max(value, Minimax(Result(s, a)))
    return value

if Player(s) == MIN:
    value = infinity
    for a in Actions(s):
        value = Min(value, Minimax(Result(s, a)))
    return value

 */