package com.example.tp1;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Activity1 extends AppCompatActivity implements View.OnClickListener {
    Button plus,minus,multiply,divide;
    TextInputEditText op1,op2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        Button b= this.findViewById(R.id.bt);
        b.setOnClickListener(this);
    }

    public void onClick(View v){
        TextInputEditText editText=this.findViewById(R.id.edittext);
        TextView textView=this.findViewById(R.id.rtext);
        RadioButton r1=this.findViewById(R.id.eur);
        RadioButton r2=this.findViewById(R.id.dz);
        if(TextUtils.isEmpty(editText.getText())){
            Toast.makeText(this,"Veuillez entrer une valeur",Toast.LENGTH_SHORT).show();
        }
        else {
            double resultat= Double.parseDouble(editText.getText().toString());
            if(r1.isChecked()){
                resultat=resultat*144.192;
                textView.setText(Double.toString(resultat));
            } else if (r2.isChecked()) {
                resultat=resultat*0.0069;
                textView.setText(Double.toString(resultat));

            }
            else
                Toast.makeText(this,"Aucune conversion choisie",Toast.LENGTH_SHORT).show();
        }
    }
}
