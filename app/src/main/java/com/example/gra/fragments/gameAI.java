package com.example.gra.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gra.Login;
import com.example.gra.R;
import com.example.gra.SharedPreferencesManager;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

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
    TextView textView7;
    TextView textView8;
    boolean AIstarter;
    boolean AImove;
    boolean AImv1 = true;
    int ys;
    int tys;
    int whoWonThisRound;
    boolean XmarkIsAI;
    String WhoPlaysX;
    boolean makeMethodWhoStartsWorkOnlyOnce = false;
    public void whoStarts(){
        String numberOfGame = textView7.getText().toString();
        int numberOfGameInt = Integer.parseInt(numberOfGame);
        if ( numberOfGameInt%2 == 0)
        {
            xTurn = true;
        }
        else{
            xTurn = false;
        }
        if(AImove==true)
        {
            AIturn();
        }
    }
    boolean xTurn = true;
    String[][] matrix = new String[3][3];

    public void placeMark(Button button){
        if(xTurn == true) {
            button.setBackground(getResources().getDrawable(R.drawable.cross_shape));
        }
        else{
            button.setBackground(getResources().getDrawable(R.drawable.circle_shape));
        }
        button.setEnabled(false);
        gameTerminate();
        xTurn = !xTurn;
        AImove = !AImove;
        if(tys==0){
            AIturn();
            gameTerminate();
        }
        tys=0;
    }

    public void AIturn(){
        int r = 0;
        while(r==0) {
            Random rand2 = new Random();
            int upperbound2 = 9;
            int int_random2 = rand2.nextInt(upperbound2);
            int swicz = int_random2 + 1;
            switch (swicz) {
                case 1:
                    if (matrix[0][0] == null) {
                        matrix[0][0] = xTurn ? "X" : "O";
                        if (xTurn == true) {
                            button21.setBackground(getResources().getDrawable(R.drawable.cross_shape));
                        } else {
                            button21.setBackground(getResources().getDrawable(R.drawable.circle_shape));
                        }
                        button21.setEnabled(false);
                        r++;
                    }
                    break;
                case 2:
                    if (matrix[0][1] == null) {
                        matrix[0][1] = xTurn ? "X" : "O";
                        if (xTurn == true) {
                            button22.setBackground(getResources().getDrawable(R.drawable.cross_shape));
                        } else {
                            button22.setBackground(getResources().getDrawable(R.drawable.circle_shape));
                        }
                        button22.setEnabled(false);
                        r++;
                    }
                    break;
                case 3:
                    if (matrix[0][2] == null) {
                        matrix[0][2] = xTurn ? "X" : "O";
                        if (xTurn == true) {
                            button23.setBackground(getResources().getDrawable(R.drawable.cross_shape));
                        } else {
                            button23.setBackground(getResources().getDrawable(R.drawable.circle_shape));
                        }
                        button23.setEnabled(false);
                        r++;
                    }
                    break;
                case 4:
                    if (matrix[1][0] == null) {
                        matrix[1][0] = xTurn ? "X" : "O";
                        if (xTurn == true) {
                            button24.setBackground(getResources().getDrawable(R.drawable.cross_shape));
                        } else {
                            button24.setBackground(getResources().getDrawable(R.drawable.circle_shape));
                        }
                        button24.setEnabled(false);
                        r++;
                    }
                    break;
                case 5:
                    if (matrix[1][1] == null) {
                        matrix[1][1] = xTurn ? "X" : "O";
                        if (xTurn == true) {
                            button25.setBackground(getResources().getDrawable(R.drawable.cross_shape));
                        } else {
                            button25.setBackground(getResources().getDrawable(R.drawable.circle_shape));
                        }
                        button25.setEnabled(false);
                        r++;
                    }
                    break;
                case 6:
                    if (matrix[1][2] == null) {
                        matrix[1][2] = xTurn ? "X" : "O";
                        if (xTurn == true) {
                            button26.setBackground(getResources().getDrawable(R.drawable.cross_shape));
                        } else {
                            button26.setBackground(getResources().getDrawable(R.drawable.circle_shape));
                        }
                        button26.setEnabled(false);
                        r++;
                    }
                    break;
                case 7:
                    if (matrix[2][0] == null) {
                        matrix[2][0] = xTurn ? "X" : "O";
                        if (xTurn == true) {
                            button27.setBackground(getResources().getDrawable(R.drawable.cross_shape));
                        } else {
                            button27.setBackground(getResources().getDrawable(R.drawable.circle_shape));
                        }
                        button27.setEnabled(false);
                        r++;
                    }
                    break;
                case 8:
                    if (matrix[2][1] == null) {
                        matrix[2][1] = xTurn ? "X" : "O";
                        if (xTurn == true) {
                            button28.setBackground(getResources().getDrawable(R.drawable.cross_shape));
                        } else {
                            button28.setBackground(getResources().getDrawable(R.drawable.circle_shape));
                        }
                        button28.setEnabled(false);
                        r++;
                    }
                    break;
                case 9:
                    if (matrix[2][2] == null) {
                        matrix[2][2] = xTurn ? "X" : "O";
                        if (xTurn == true) {
                            button29.setBackground(getResources().getDrawable(R.drawable.cross_shape));
                        } else {
                            button29.setBackground(getResources().getDrawable(R.drawable.circle_shape));
                        }
                        button29.setEnabled(false);
                        r++;
                    }
                    break;
                default:
                    r=0;
                    break;
            }
        }
        xTurn = !xTurn;
        AImove = !AImove;
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
        makeMethodWhoStartsWorkOnlyOnce = false;
        tys=1;

        int thisGameCount = Integer.parseInt(textView7.getText().toString());
        textView7.setText(String.valueOf(thisGameCount+1));
        addStats();
    }

    public void gameTerminate(){
        if((matrix[0][0]=="X" && matrix[0][1]=="X" && matrix[0][2]=="X")||(matrix[1][0]=="X" && matrix[1][1]=="X" && matrix[1][2]=="X")||(matrix[2][0]=="X" && matrix[2][1]=="X" && matrix[2][2]=="X")||(matrix[0][0]=="X" && matrix[1][0]=="X" && matrix[2][0]=="X")||(matrix[0][1]=="X" && matrix[1][1]=="X" && matrix[2][1]=="X")||(matrix[0][2]=="X" && matrix[1][2]=="X" && matrix[2][2]=="X")||(matrix[0][0]=="X" && matrix[1][1]=="X" && matrix[2][2]=="X")||(matrix[0][2]=="X" && matrix[1][1]=="X" && matrix[2][0]=="X")) {
            Toast.makeText(getActivity(), "X wygrał", Toast.LENGTH_SHORT).show();
            if(XmarkIsAI==true){
                whoWonThisRound=1;
            }
            else{
                whoWonThisRound=2;
            }
            disableButtons();
            int xWinsNow = Integer.parseInt(xWinsInSession.getText().toString());
            xWinsInSession.setText(String.valueOf(xWinsNow+1));


        }
        else if((matrix[0][0]=="O" && matrix[0][1]=="O" && matrix[0][2]=="O")||(matrix[1][0]=="O" && matrix[1][1]=="O" && matrix[1][2]=="O")||(matrix[2][0]=="O" && matrix[2][1]=="O" && matrix[2][2]=="O")||(matrix[0][0]=="O" && matrix[1][0]=="O" && matrix[2][0]=="O")||(matrix[0][1]=="O" && matrix[1][1]=="O" && matrix[2][1]=="O")||(matrix[0][2]=="O" && matrix[1][2]=="O" && matrix[2][2]=="O")||(matrix[0][0]=="O" && matrix[1][1]=="O" && matrix[2][2]=="O")||(matrix[0][2]=="O" && matrix[1][1]=="O" && matrix[2][0]=="O")) {
            Toast.makeText(getContext(), "O wygrał", Toast.LENGTH_SHORT).show();
            if(XmarkIsAI==true){
                whoWonThisRound=2;
            }
            else{
                whoWonThisRound=1;
            }
            disableButtons();
            int oWinsNow = Integer.parseInt(oWinsInSession.getText().toString());
            oWinsInSession.setText(String.valueOf(oWinsNow+1));
        }
        else if(matrix[0][0]!=null && matrix[0][1]!=null && matrix[0][2]!=null && matrix[1][0]!=null && matrix[1][1]!=null && matrix[1][2]!=null && matrix[2][0]!=null && matrix[2][1]!=null && matrix[2][2]!=null){
            Toast.makeText(getContext(), "remis", Toast.LENGTH_SHORT).show();
            whoWonThisRound=3;
            disableButtons();
        }
    }

    public gameAI() {
        //very important!
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
        textView7 = getActivity().findViewById(R.id.textView7);
        textView8 = getActivity().findViewById(R.id.textView8);
        ys=Integer.parseInt(textView7.getText().toString());
        Bundle bundle = this.getArguments();

        AIstarter = bundle.getBoolean("AIstarter");

        if(AImv1==true){
            AImove = AIstarter;
            AImv1=false;
            if(ys%2==0){
                if(AImove==true){
                    XmarkIsAI=true;
                    WhoPlaysX = "X";
                    textView8.setText(WhoPlaysX);
                }
                else{
                    XmarkIsAI=false;
                    WhoPlaysX = "O";
                    textView8.setText(WhoPlaysX);
                }
            }
        }
        if(textView8.getText()=="X")
            XmarkIsAI=true;
        else
            XmarkIsAI=false;

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

        if (!makeMethodWhoStartsWorkOnlyOnce){
            whoStarts();
            makeMethodWhoStartsWorkOnlyOnce = true;
        }

        if(AImove==false){
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_a_i, container, false);
    }

    public void addStats(){
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                String[] field = new String[2];
                field[0] = "user_id";
                field[1] = "whoWonThisRound";
                String[] data = new String[2];
                data[0] = String.valueOf(SharedPreferencesManager.getInstance(getActivity()).getUserID());
                data[1] = Integer.toString(whoWonThisRound);
                PutData putData = new PutData("http://arek2017.ct8.pl/TTT/addtostats.php", "POST", field, data);
                if (putData.startPut() && putData.onComplete()) {

                    }
                if(putData == null){
                    Toast.makeText(getActivity().getApplicationContext(), "Wrong IP Address", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}