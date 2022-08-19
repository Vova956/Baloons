package com.example.baloons;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {

    int locationX;
    int locationY;
    int speed;

    Paint balloonPaint;

    public GameView(Context context){
        super(context);
        balloonPaint = new Paint();
        nextBalloon();

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(locationX >= event.getX() - 50 && locationX <= event.getX() +50 && locationY >= event.getX() - 50 && locationY <= event.getX() +50)
                    nextBalloon();

               return  true;
            }
        });
    }

    @Override
    public void onDraw(Canvas canvas){
        balloonPaint.setColor(Color.RED);

        canvas.drawCircle(locationX,locationY,50,balloonPaint);
    }

    public void nextBalloon(){
        locationY = getHeight();
        locationX=(int)(Math.random()*getWidth());
        speed = 20 + (int)(50*Math.random());
    }

    public void update(){
        if(locationY < 0)
            nextBalloon();
        locationY -= speed;
    }



}
