package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button exo1=findViewById(R.id.exo1);
        Button exo2=findViewById(R.id.exo2);
        Button exo3=findViewById(R.id.exo3);

        exo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenExo(1);
            }
        });

        exo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenExo(2);
            }
        });

        exo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenExo(3);
            }
        });
    }

    public void OpenExo(int exo){
        switch (exo){
            case 1:startActivity(new Intent(MainActivity.this,Activity1.class));break;

            case 2:startActivity(new Intent(MainActivity.this,Activity2.class));break;

            case 3:startActivity(new Intent(MainActivity.this,Activity3.class));break;
        }
    }


}