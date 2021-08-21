package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quizgame.QuizModal;
import com.example.quizgame.R;
import com.example.quizgame.result;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class QuizScreen extends AppCompatActivity {
    private static int SPLASH_SCREEN = 1200;
    private TextView question, numberAttempted;
    private Button option1, option2, option3, option4;
    private ImageView image;
    private ArrayList<QuizModal> quizModalArrayList;
    Random random;
    Animation correct;
    int currentScore = 0, questionAttempted = 1, currentPos;
    int [] images = {R.drawable.principal_nezu, R.drawable.black_hole, R.drawable.eraser_head, R.drawable.class_1a, R.drawable.oboro, R.drawable.dabi, R.drawable.decay, R.drawable.nabu, R.drawable.hosu, R.drawable.eijiro, R.drawable.mirio, R.drawable.april3, R.drawable.himiko};
    String [] questions = {"What is the name of U.A. High School Principal?", "What is the Quirk of the hero name Thirteen?", "What is the hero name of Shota Aizawa?", "How many students are there in Class 1-A?", "What is the real name of this Character?","What is alia of Toya Todoroki?","What is the quirk of Tomoura Shigaraki?", "what do you call this Island?","Where is this Hospital Located from?", "what is the real name of Sturdy Hero: Red Riot?",  "what is the real name of Lemillion?", "When did Season 1 original ran?", "What is the name of this Villian?"};
    String [] opt1 = {"Gran Torino", "Black Hole", "Snipe", "16", "Dabi","kurogiri", "All-for-one", "Nabu Island","Seijin City", "Katsuki Bakugo", "Mezo Shoji", "April 3, 2016", "Lady Nagant"};
    String [] opt2 = {"Vlad King", "Somnambulist", "Eraser Head", "22", "Hizashi Yamada", "Himiko", "posion", "Hosu Island", "Hosu City", "Denki Kaminari", "Mirio Togata", "June 26, 2016", "Chitose Kizuki"};
    String [] opt3 = {"All Might", "Clones", "Cementoss", "25", "Oboro ShiraKumo", "Dabi" , "melt", "Seketo Island","Isamu City", "Eijiro Kirishima", "Mashirao Ojiro", "May 5, 2018", "Himiko Toga"};
    String [] opt4 = {"Nezu", "All-for-One", "Ectoplasm", "20", "Shota Aizawa", "Tomura", "decay" ,"Takoba Island", "Jaku City", "Mashirao Ojiro", "Tamaki Amajiki", "July 11, 2016", "Oji Harima"};
    String [] answer = {"Nezu", "Black Hole", "Eraser Head", "20", "Oboro ShiraKumo", "Dabi", "decay", "Nabu Island", "Hosu City","Eijiro Kirishima", "Mirio Togata", "April 3, 2016","Himiko Toga"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);
        question = findViewById(R.id.question);
        numberAttempted = findViewById(R.id.questionAttempted);
        correct = AnimationUtils.loadAnimation(this, R.anim.correct_animation);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        image = findViewById(R.id.samplePicture);
        quizModalArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestions(quizModalArrayList);
        currentPos = random.nextInt(quizModalArrayList.size());
        setDataToViews(currentPos);

        getQuizQuestions(quizModalArrayList);
        option1.setOnClickListener(v -> {
            if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1.getText().toString().trim().toLowerCase())) {
                currentScore++;
            }
            questionAttempted++;
            currentPos =random.nextInt(quizModalArrayList.size());
            setDataToViews(currentPos);
        });
        option2.setOnClickListener(v -> {
            if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2.getText().toString().trim().toLowerCase())){
                currentScore++;
            }
            questionAttempted++;
            currentPos =random.nextInt(quizModalArrayList.size());
            setDataToViews(currentPos);
        });
        option3.setOnClickListener(v -> {
            if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3.getText().toString().trim().toLowerCase())){
                currentScore++;
            }
            questionAttempted++;
            currentPos =random.nextInt(quizModalArrayList.size());
            setDataToViews(currentPos);
        });
        option4.setOnClickListener(v -> {
            if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4.getText().toString().trim().toLowerCase())){
                currentScore++;
            }
            questionAttempted++;
            currentPos =random.nextInt(quizModalArrayList.size());
            setDataToViews(currentPos);
        });
    }


    private void setDataToViews(int currentPos) {
        numberAttempted.setText("Question Attempted: "+questionAttempted+"/10");
        if(questionAttempted == 11){
            Intent intent = new Intent(QuizScreen.this, result.class);
            intent.putExtra("result", currentScore);
            startActivity(intent);
        }else{
                 image.setImageResource(quizModalArrayList.get(currentPos).getImg());
                 question.setText(quizModalArrayList.get(currentPos).getQuestion());
                 option1.setText(quizModalArrayList.get(currentPos).getOption1());
                 option2.setText(quizModalArrayList.get(currentPos).getOption2());
                 option3.setText(quizModalArrayList.get(currentPos).getOption3());
                 option4.setText(quizModalArrayList.get(currentPos).getOption4());

        }
    }

    private void getQuizQuestions(ArrayList<QuizModal> quizModalArrayList) {
        Log.e("questions", "Number of Questions" + questions.length);
        for (int i = 0; i <questions.length; i++){
            quizModalArrayList.add(new QuizModal(images[i], questions[i], opt1[i], opt2[i], opt3[i], opt4[i], answer[i]));
        }
    }
}