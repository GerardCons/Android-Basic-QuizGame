package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class mainScreen extends AppCompatActivity {

    ImageView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        header = findViewById(R.id.start);

        header.setOnClickListener(v -> {
            Intent intent = new Intent(mainScreen.this, QuizScreen.class);
            startActivity(intent);
            finish();
        });
    }
}