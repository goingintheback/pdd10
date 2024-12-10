package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private Button buttonOneAnswer, buttonTwoAnswer, buttonThreeAnswer, buttonFourAnswer;
    private TextView answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonOneAnswer = (Button) findViewById(R.id.questionOne);
        buttonTwoAnswer = (Button) findViewById(R.id.questionTwo);
        buttonThreeAnswer = (Button) findViewById(R.id.questionThree);
        buttonFourAnswer = (Button) findViewById(R.id.questionFour);

        answer = (TextView) findViewById(R.id.answer);

        buttonOneAnswer.setOnClickListener(this);
        buttonTwoAnswer.setOnClickListener(this);
        buttonThreeAnswer.setOnClickListener(this);
        buttonFourAnswer.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        clearColor();
        int successAnswerId = R.id.questionThree;
        if(v.getId() == successAnswerId) {
            Intent intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
        }else {
            Button noRight = findViewById(v.getId());

            noRight.setBackgroundColor(getResources().getColor(R.color.red));
            answer.setText("Неправильно");

        }
    }


    public void clearColor() {
        int color = getResources().getColor(R.color.gray);
        buttonOneAnswer.setBackgroundColor(color);
        buttonTwoAnswer.setBackgroundColor(color);
        buttonThreeAnswer.setBackgroundColor(color);
        buttonFourAnswer.setBackgroundColor(color);
    }



}