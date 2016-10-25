package com.example.mafar.kindergartenmathtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View.OnClickListener;


public class SelectYourTest extends AppCompatActivity {

    Button addButton;
    Button subButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_your_test);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        final Context context = this;

        addButton = (Button) findViewById(R.id.additiontest);
        final String addButtonText = addButton.getText().toString();
        addButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("testName", addButtonText);
                startActivity(intent);

            }

        });


        subButton = (Button) findViewById(R.id.subtractiontest);

        final String subButtonText = subButton.getText().toString();
        subButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("testName", subButtonText);
                startActivity(intent);

            }

        });

    }


}
