package com.example.mafar.kindergartenmathtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    //RandomMathMCQ q1= new RandomMathMCQ(true);
    RandomMathMCQ q1;
    boolean isAddition;

   // Bundle bundle = getIntent().getExtras();
   // String testName = bundle.getString("testName");

    //Extract the data…
   // String testName = getIntent().getExtras().getString("testName");
   //boolean isAddition = (testName=="Addition Test")? true:false;
    //RandomMathMCQ q1= new RandomMathMCQ(isAddition);

/*    Random intGenerator = new Random();
    int add1 = intGenerator.nextInt(10);
    int add2= intGenerator.nextInt(10);
    int max = (add1>add2)? add1:add2;
    int sum = add1+add2;*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        String testName = bundle.getString("testName").toUpperCase();
        print(testName);

        //isAddition = (testName == "ADDITION TEST")? true:false;
        isAddition = testName.equals("ADDITION TEST");
        q1= new RandomMathMCQ(isAddition);
        TextView operator = (TextView) findViewById(R.id.textView2);
        if(!isAddition)
            operator.setText(" - ");

        //Get the bundle
       // Bundle bundle = getIntent().getExtras();


/*        Random intGenerator = new Random();
        int add1 = intGenerator.nextInt(10);
        int add2= intGenerator.nextInt(10);
        int max = (add1>add2)? add1:add2;
        int sum = add1+add2;*/


        //print("Add the following numbers");
        //print( add1 + " + "+ add2 + " = ? ");

        //int[] ints = new Random().ints(max, 18).distinct().limit(4).toArray();
       // System.out.println(Arrays.toString(ints));



/*        int[] a = new int[19- max];
        for (int i = 0; i < (19- max); i++){
            a[i]= max+i;
        }

        Shuffle(a);

        int[] answers = new int[4];

        System.arraycopy(a, 0, answers, 0, 4);*/

/*        for (int count = 0; count < 4; count++){
            answers[count] = a[(int)(Math.random() * a.length)];
        }*/

      // CheckIfContains (answers,sum);
        //System.out.println(Arrays.toString(answers));

        TextView int1 = (TextView) findViewById(R.id.number1);
        TextView int2 = (TextView) findViewById(R.id.number2);
        Button ans1 = (Button)findViewById(R.id.answer1);
        Button ans2 = (Button)findViewById(R.id.answer2);
        Button ans3 = (Button)findViewById(R.id.answer3);
        Button ans4 = (Button)findViewById(R.id.answer4);

/*        int1.setText(add1+"");
        int2.setText(add2+"");
        ans1.setText(answers[0]+"");
        ans2.setText(answers[1]+"");
        ans3.setText(answers[2]+"");
        ans4.setText(answers[3]+"");*/

        int1.setText(q1.getInt1()+"");
        int2.setText(q1.getInt2()+"");
        ans1.setText(q1.getAnswers()[0]+"");
        ans2.setText(q1.getAnswers()[1]+"");
        ans3.setText(q1.getAnswers()[2]+"");
        ans4.setText(q1.getAnswers()[3]+"");



        // Check if the randomly generated array with 4 ints contains the result or the addition.
        //If the array doesn't contain the result then add the result by over writing element 0 and then shuffle the array.
        //if (!contains(ints, sum)){
            //ints[0] = sum;
           // RandomizeArray(ints);
        //}


    }

    public void buttonOnClick (View v) {

        Button b = (Button) v;
        String buttonText = b.getText().toString();
        int selected = Integer.parseInt(buttonText);
        int answer= (isAddition)?q1.getSum():q1.getSub();

        TextView result = (TextView) findViewById(R.id.result);
        //TextView operator = (TextView) findViewById(R.id.textView2);
        //if(!isAddition)
            //operator.setText(" - ");

        if (selected!=answer)
            Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(this, "Correct answer", Toast.LENGTH_SHORT).show();
            result.setText(answer + "");
            }
        }
    private void print(String msg){
        System.out.println(msg);

    }

/*    public static void CheckIfContains(int[] array, final int key) {
        for (final int i : array) {
            if (i == key) {
                return;
            }
        }

        array[(int)(Math.random() * array.length)]= key;
        return;
    }*/

/*    public static void Shuffle(int[] a)
    {
        int n = a.length;
        for (int i = 0; i < n; i++)
        {
            // between i and n-1
            int r = i + (int) (Math.random() * (n-i));
            int tmp = a[i];    // swap
            a[i] = a[r];
            a[r] = tmp;
        }
    }*/

}
