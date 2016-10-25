package com.example.mafar.kindergartenmathtest;

import java.util.Random;

/**
 * Created by mafar on 10/3/2016.
 */
public class RandomMathMCQ {

    public int getInt1() {
        return int1;
    }

    public int getInt2() {
        return int2;
    }

    private int int1;
    private int int2;
    //private boolean isAddition;

    private int max;
    private int min;

    private int sum;
    private int sub;

    public int[] getAnswers() {
        return answers;
    }

    public int getSub() {
        return sub;
    }

    public int getSum() {
        return sum;
    }

    private  int[] answers = new int[4];


    public RandomMathMCQ(boolean isAdd)
    {
        Random intGenerator = new Random();
        int1 = intGenerator.nextInt(10);
        int2= intGenerator.nextInt(10);
        max = (int1>int2)? int1:int2;
        min = (int1>int2)? int2:int1;

        sum = int1+int2;
        sub=max-min;

        //isAdition = add;

        int[] a;

        if (isAdd) {
            a = new int[19 - max];
            for (int i = 0; i < (19 - max); i++) {
                a[i] = max + i;
            }
            Shuffle(a);
            //int[] answers = new int[4];
            System.arraycopy(a, 0, answers, 0, 4);
            CheckIfContains (answers,sum);
        }
        else
        {
            int arraySize =(max>3)? max:4;

            a = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                a[i] = 1 + i;
            }
            Shuffle(a);
            //int[] answers = new int[4];
            System.arraycopy(a, 0, answers, 0, 4);
            CheckIfContains (answers,sub);
        }
        //Shuffle(a);
        //int[] answers = new int[4];
        //System.arraycopy(a, 0, answers, 0, 4);

    }

// checks if the result already exist in the answers array. If not it inserts the result
// in the answers array by replacing a random element from the answers array.

    public static void CheckIfContains(int[] array, final int key) {
        for (final int i : array) {
            if (i == key) {
                return;
            }
        }

        array[(int)(Math.random() * array.length)]= key;
        return;
    }

    // shuffles an array randomly
    public static void Shuffle(int[] a)
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
    }

}


