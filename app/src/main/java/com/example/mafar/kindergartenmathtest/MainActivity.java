package com.example.mafar.kindergartenmathtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    boolean isAddition;
    int totalNumberOfProblems=5;
    int curProbNum=0;
    int correctAnsCount=0;

    ArrayList<RandomMathMCQ> problems=new ArrayList<RandomMathMCQ>();//creating arraylist


    // Bundle bundle = getIntent().getExtras();
   // String testName = bundle.getString("testName");

    //Extract the data…
   // String testName = getIntent().getExtras().getString("testName");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        String testName = bundle.getString("testName").toUpperCase();
       // print(testName);

        //isAddition = (testName == "ADDITION TEST")? true:false;
        isAddition = testName.equals("ADDITION TEST");

        TextView operator = (TextView) findViewById(R.id.textView2);
        if(!isAddition)
            operator.setText(" - ");

        for (int i= 0; i < totalNumberOfProblems; i++)
            problems.add(new RandomMathMCQ(isAddition));
        populate(problems.get(curProbNum));

    }

   private void populate(RandomMathMCQ q1) {

        TextView int1 = (TextView) findViewById(R.id.number1);
        TextView int2 = (TextView) findViewById(R.id.number2);
       TextView result = (TextView) findViewById(R.id.result);
       TextView problemNum = (TextView) findViewById(R.id.problemNum);

        Button ans1 = (Button)findViewById(R.id.answer1);
        Button ans2 = (Button)findViewById(R.id.answer2);
        Button ans3 = (Button)findViewById(R.id.answer3);
        Button ans4 = (Button)findViewById(R.id.answer4);



       problemNum.setText((curProbNum+1)+"/"+totalNumberOfProblems);
        int1.setText(q1.getInt1()+"");
        int2.setText(q1.getInt2()+"");
        ans1.setText(q1.getAnswers()[0]+"");
        ans2.setText(q1.getAnswers()[1]+"");
        ans3.setText(q1.getAnswers()[2]+"");
        ans4.setText(q1.getAnswers()[3]+"");
        result.setText("?");

    }

    public void buttonOnClick (View v) {

        Button b = (Button) v;
        String buttonText = b.getText().toString();
        int selected = Integer.parseInt(buttonText);
        int answer= (isAddition)?problems.get(curProbNum).getSum():problems.get(curProbNum).getSub();

        TextView result = (TextView) findViewById(R.id.result);
        //TextView operator = (TextView) findViewById(R.id.textView2);
        //if(!isAddition)
            //operator.setText(" - ");

        if (selected!=answer) {
            Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Correct answer", Toast.LENGTH_SHORT).show();
            correctAnsCount++;
            }
        result.setText(answer + "");

        //populate(problems.get(curProbNum));

        }


    public void nextButtonOnClick (View v) {

        final Context context = this;
        curProbNum++;
        String testName = (isAddition)? "Addition Test":"Subtraction Test";
        Button b = (Button) v;
        //String buttonText = b.getText().toString();
        if ((curProbNum)<totalNumberOfProblems)
            populate(problems.get(curProbNum));
        else {

            Intent intent = new Intent(context, ResultActivity.class);
            intent.putExtra("testName", testName);
            intent.putExtra("totalNumberOfProblems", totalNumberOfProblems);
            intent.putExtra("correctAnsCount", correctAnsCount);
            startActivity(intent);
        }
    }

    private void print(String msg){
        System.out.println(msg);

    }

}
