package com.example.mafar.kindergartenmathtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Random intGenerator = new Random();
        int add1 = intGenerator.nextInt(10);
        int add2= intGenerator.nextInt(10);
        int max = (add1>add2)? add1:add2;
        int sum = add1+add2;
        //print("Add the following numbers");
        //print( add1 + " + "+ add2 + " = ? ");

        //int[] ints = new Random().ints(max, 18).distinct().limit(4).toArray();
       // System.out.println(Arrays.toString(ints));



        int[] a = new int[19- max];
        for (int i = 0; i < (19- max); i++){
            a[i]= max+i;
        }
        int[] answers = new int[4];
        for (int count = 0; count < 4; count++){
            answers[count] = a[(int)(Math.random() * a.length)];
        }

       CheckIfContains (answers,sum);
        //System.out.println(Arrays.toString(answers));

        TextView int1 = (TextView) findViewById(R.id.number1);
        TextView int2 = (TextView) findViewById(R.id.number2);
        Button ans1 = (Button)findViewById(R.id.answer1);
        Button ans2 = (Button)findViewById(R.id.answer2);
        Button ans3 = (Button)findViewById(R.id.answer2);
        Button ans4 = (Button)findViewById(R.id.answer4);

        int1.setText(add1+"");
        //int2.setText(add2);
        //ans1.setText(answers[0]);
        //ans2.setText(answers[1]);
       // ans3.setText(answers[2]);
        //ans4.setText(answers[3]);



        // Check if the randomly generated array with 4 ints contains the result or the addition.
        //If the array doesn't contain the result then add the result by over writing element 0 and then shuffle the array.
        //if (!contains(ints, sum)){
            //ints[0] = sum;
           // RandomizeArray(ints);
        //}


    }

    public static void CheckIfContains(int[] array, final int key) {
        for (final int i : array) {
            if (i == key) {
                return;
            }
        }

        array[(int)(Math.random() * array.length)]= key;
        return;
    }

}
