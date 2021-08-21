package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {

    TextView comment, score;
    Button retry, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        comment = findViewById(R.id.comment);
        score = findViewById(R.id.score);
        retry = findViewById(R.id.retry);
        exit = findViewById(R.id.exit);

        Bundle bundle = getIntent().getExtras();
        Integer number = bundle.getInt("result");
        if (number > 8){
            comment.setText("Excellent!!");
        } else if (number <= 8 && number >= 7){
            comment.setText("Very Good!!");
        } else if (number <= 6 && number >= 5){
            comment.setText("You Passed!!");
        } else{
            comment.setText("You Failed!!");
        }

        score.setText(number.toString() + "/10");

        retry.setOnClickListener(v -> {
            Intent intent = new Intent(result.this, QuizScreen.class);
            startActivity(intent);
        });
        exit.setOnClickListener(v -> finish());

    }
}