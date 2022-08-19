package com.example.baloons;

import android.os.*;

public class UpdateThreat extends Thread{
    Handler updateHandler;

    public UpdateThreat(Handler handler){
        updateHandler = handler;
    }

    @Override
    public void run(){
        while(true){
            try{
                sleep(100);
            }catch(Exception e){

            }

            updateHandler.sendEmptyMessage(0);
        }
    }
}
