package com.haldhami.connectfourandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout rr = null;
    private ImageView board = null;
    private ImageView[] counters = new ImageView[42];

    private Float[] row = new Float[6];
    private Float[] col = new Float[7];

    private float x;
    private float y;
    private float xi;
    private float yi;
    private int count;
    private int counterSize;
    private float counterCentre;
    private float initialY;



    public void LaunchGame(View view) {

        TextView message = findViewById(R.id.message);
        Button button = findViewById(R.id.button);
        ImageView redCounter = findViewById(R.id.redCounter);
        ImageView yellowCounter = findViewById(R.id.yellowCounter);

        rr.removeView(button);
        yellowCounter.setVisibility(View.VISIBLE);
        yellowCounter.setClickable(true);
        yellowCounter.setTranslationX(350f);
        yellowCounter.setTranslationY(1600f);
        redCounter.setVisibility(View.VISIBLE);
        redCounter.setClickable(true);
        redCounter.setTranslationX(-350f);
        redCounter.setTranslationY(1600f);

        ConnectFourGame game = new ConnectFourGame();

        Random rand = new Random();
        int userTurn = (rand.nextInt(2) + 1);
        message.setText(game.genMessage(userTurn));
        //game.startGame();
        /*rr.addView(message);
        message.setGravity(Gravity.CENTER);
        message.setText("Would you like to play again?");
        rr.addView(button);*/
        //button.setText("Restart?");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rr = (RelativeLayout) findViewById(R.id.rr);
        /* board = (ImageView) findViewById(R.id.connect4);
        count = 0;
        row[0] = 481f;
        row[1] = 684f;
        row[2] = 887f;
        row[3] = 1090f;
        row[4] = 1294f;
        row[5] = 1497f;
        col[0] = -117.25f;
        col[1] = 86f;
        col[2] = 288.5f;
        col[3] = 493f;
        col[4] = 696f;
        col[5] = 901f;
        col[6] = 1103.5f;
        initialY = 380f;

        rr.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                x = motionEvent.getX();
                y = motionEvent.getY();
                System.out.println(x);

                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    counters[count] = (ImageView) new ImageView(MainActivity.this);
                    counters[count].setImageResource(R.drawable.red);
                    counterSize = 450;
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(counterSize, counterSize);
                    rr.addView(counters[count],layoutParams);
                    rr.removeView(board);
                    rr.addView(board);
                    counterCentre = (float) counterSize/2f;
                    if (x >= 1328f) {
                        counters[count].setX(1328f - counterCentre);
                        counters[count].setY(515f - counterCentre);
                    } else if (x <= 107f) {
                        counters[count].setX(107f - counterCentre);
                        counters[count].setY(515f - counterCentre);
                    } else {
                        counters[count].setX(x - counterCentre);
                        counters[count].setY(515f - counterCentre);
                    }
                }

                if(motionEvent.getAction() == MotionEvent.ACTION_MOVE && (x < 107f)) {
                    counters[count].setX(107f - counterCentre);
                    counters[count].setY(515f - counterCentre);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_MOVE && (x >= 1328f)) {
                    counters[count].setX(1328f - counterCentre);
                    counters[count].setY(515f - counterCentre);
                } else {
                    counters[count].setX(x - counterCentre);
                    counters[count].setY(515f - counterCentre);
                }

                if(motionEvent.getAction() == MotionEvent.ACTION_UP) {

                    if (x < 107f) {
                        counters[count].setX(107f - counterCentre);
                        counters[count].setY(515f - counterCentre);
                    } else if (x >= 1328f) {
                        counters[count].setX(1328f - counterCentre);
                        counters[count].setY(515f - counterCentre);
                    } else {
                        counters[count].setX(x - counterCentre);
                        counters[count].setY(515f - counterCentre);
                    }       // Needed to ensure that counter is not placed off screen on release

                    if (x <= 203f) {    // If counter above first column
                        ObjectAnimator animator = ObjectAnimator.ofFloat(counters[count],"translationX", col[0]);
                        animator.setRepeatCount(0);
                        animator.setDuration(50);

                        ObjectAnimator animator1 = ObjectAnimator.ofFloat(counters[count], "translationY", initialY);
                        animator1.setRepeatCount(0);
                        animator1.setDuration(50);

                        ObjectAnimator animator2 = ObjectAnimator.ofFloat(counters[count], "translationY", 1497f);
                        animator2.setRepeatCount(0);
                        animator2.setDuration(500);

                        AnimatorSet set = new AnimatorSet();
                        set.play(animator).with(animator1);
                        set.play(animator2).after(animator1);
                        set.start();
                    }

                    count++;
                }


                return true;
            }
        });*/

    }


}