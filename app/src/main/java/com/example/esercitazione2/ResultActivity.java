package com.example.esercitazione2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class ResultActivity extends AppCompatActivity {

    Persona persona;
    TextView nometext;
    TextView cognometext;
    TextView datatext;
    TextView indirizzotext;
    TextView captext;
    TextView emailtext;
    Button confirm;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        nometext= findViewById(R.id.titleNome);
        cognometext= findViewById(R.id.titleCognome);
        datatext= findViewById(R.id.titleDataNascita);
        indirizzotext= findViewById(R.id.titleIndirizzo);
        captext= findViewById(R.id.titlecap);
        emailtext=findViewById(R.id.titleEmail);
        back=findViewById(R.id.Back);
        confirm=findViewById(R.id.Confirm);

        Intent intent = getIntent();
        Serializable object = intent.getSerializableExtra(MainActivity.PERSONA_PATH);

        if(object instanceof Persona){
            this.persona = (Persona) object;
        }else{
            this.persona = new Persona();
        }

        nometext.setText(persona.getNome());
        cognometext.setText(persona.getCognome());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        datatext.setText(format.format(persona.getDataNascita().getTime()));
        indirizzotext.setText(persona.getIndirizzo());
        captext.setText(persona.getCap());
        emailtext.setText(persona.getEmail());


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showResult = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(showResult);
            }
        });

    }
}