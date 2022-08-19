package com.example.baloons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.*;

public class MainActivity extends AppCompatActivity {

    GameView gameView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameView = new GameView(this);
        setContentView(gameView);

        Handler handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message message){
                gameView.update();
                gameView.invalidate();
                //super.handleMessage(message);
            }

        };

        UpdateThreat threat = new UpdateThreat(handler);
        threat.start();
    }
}