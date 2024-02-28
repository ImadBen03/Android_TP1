package com.example.tp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity implements View.OnClickListener{

    Button b1,b2,b3;
    EditText e1,e2,e3,e4;
    RadioGroup r1;
    RadioButton rb1;
    LinearLayout l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        getSupportActionBar().setTitle("Exo 3");
        r1=findViewById(R.id.r1);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        e4=findViewById(R.id.e4);
        l1=findViewById(R.id.l1);
        l1.setOnCreateContextMenuListener(this);
        b1=(Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b3=(Button) findViewById(R.id.b3);
        b3.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.optionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.i1) {
            calcul();
        } else if (item.getItemId() == R.id.i2) {
            init();
        } else exit();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.contextmenu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.ci1) {
            calcul();
        } else if (item.getItemId() == R.id.ci2) {
            init();
        } else exit();
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View v){

        if (v.getId() == R.id.b1) {
            calcul();
        }

        if(v.getId() == R.id.b2) {
            init();
        }

        if(v.getId() == R.id.b3) {
            exit();
        }

    }

    public void calcul(){
        if (e1.getText().toString().equals("") || e2.getText().toString().equals(""))
            Toast.makeText(this, "Please enter values", Toast.LENGTH_SHORT).show();
        else {
            if (r1.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Please select a VAT", Toast.LENGTH_SHORT).show();
            } else {
                int percent;
                int sr = r1.getCheckedRadioButtonId();
                if (sr == R.id.rb1) {
                    percent = 0;
                } else if (sr == R.id.rb2) {
                    percent = 10;
                } else percent = 20;

                double PET, PAT;
                PET = Double.parseDouble(e1.getText().toString()) * Double.parseDouble(e2.getText().toString());
                PAT = ((PET * percent) / 100) + PET;

                e3.setText(Double.toString(PET));
                e4.setText(Double.toString(PAT));
            }
        }
    }

    public void init(){
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        rb1=findViewById(R.id.rb1);
        rb1.setChecked(true);
    }

    public void exit(){
        startActivity(new Intent(Activity3.this,MainActivity.class));
    }
}
