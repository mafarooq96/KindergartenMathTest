package com.example.mafar.kindergartenmathtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Button backToTestList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        addListenerOnButton();


        //Intent mIntent = getIntent();
        Bundle bundle = getIntent().getExtras();
        String testName = bundle.getString("testName").toUpperCase();
        int totalNumberOfProblems = bundle.getInt("totalNumberOfProblems");
        int correctAnsCount = bundle.getInt("correctAnsCount");
        print(testName);
        print("totalNumberOfProblems: " + totalNumberOfProblems);
        print ("correctAnsCount: "+ correctAnsCount);

        TextView tn = (TextView) findViewById(R.id.testName);
       TextView score = (TextView) findViewById(R.id.score);
       TextView correctAns = (TextView) findViewById(R.id.correctAnswers);TextView incorrectAns = (TextView) findViewById(R.id.incorrectAnswers);

        int scoreInPercent= (correctAnsCount*100)/totalNumberOfProblems;
        print ("Score "+ scoreInPercent);
        tn.setText(testName);
        score.setText(scoreInPercent+"%");
        correctAns.setText("Correct Answers: "+correctAnsCount);
        incorrectAns.setText("Incorrect Answers: "+ (totalNumberOfProblems-correctAnsCount));
    }


    public void addListenerOnButton() {

        final Context context = this;
        backToTestList = (Button) findViewById(R.id.backToTestList);
        backToTestList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, SelectYourTest.class);
                startActivity(intent);

            }

        });


    }

    private void print(String msg){
        System.out.println(msg);

    }
}
