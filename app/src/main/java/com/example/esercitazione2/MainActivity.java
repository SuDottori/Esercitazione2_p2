package com.example.esercitazione2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    TextView gone;
    EditText nome, cognome, data, indirizzo, input, cap, email;
    Button inserisci,clean;
    Persona persona;
    SeekBar seekbar;
    int modelValue= 50;
    int minValue= 0;
    int maxValue= 100;
    public static final String PERSONA_PATH ="com.example.esercitazione2.Persona";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.attrNome);
        cognome = findViewById(R.id.attrCognome);
        data = findViewById(R.id.attrDataNascita);
        indirizzo = findViewById(R.id.attrIndirizzo);
        cap= findViewById(R.id.attrCAP);
        email= findViewById(R.id.attrEmail);
        inserisci = findViewById(R.id.saveButton);
        clean = findViewById(R.id.clean);
        input = findViewById(R.id.input);
        gone= findViewById(R.id.gone);
        persona = new Persona();
        seekbar =findViewById(R.id.seekbar);

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        data.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){

                    showDialog();
                }
            }
        });

        inserisci.setOnClickListener(v -> {
            Intent showResult = new Intent(MainActivity.this, ResultActivity.class);
            if(checkInput()){
                updatePersona();
                showResult.putExtra( PERSONA_PATH , persona);
                startActivity(showResult);

            }

        });

        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome.setText("");
                cognome.setText("");
                data.setText("");
                indirizzo.setText("");
                cap.setText("");
                email.setText("");
            }
        });
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateValue(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateValue(seekBar.getProgress());

            }
        });
    }

    public void updatePersona(){

        this.persona.setNome(this.nome.getText().toString());
        this.persona.setCognome(this.cognome.getText().toString());
        this.persona.setIndirizzo(this.indirizzo.getText().toString());
        this.persona.setCap(this.cap.getText().toString());

    }

    public void updateDataNascita(Calendar date){
        this.persona.setDataNascita(date);
    }

    protected void updateValue(int newValue) {
        newValue = newValue > maxValue ? maxValue : newValue;
        newValue = newValue < minValue ? minValue : newValue;
        this.modelValue = newValue;
        input.setText("" + this.modelValue);
    }

    public boolean checkInput() {
        int eta = Integer.parseInt(input.getText().toString());
        int errors = 0;
        if (nome.getText() == null || nome.getText().length() == 0){

            errors++;
            nome.setError("Inserire il nome");
        } else nome.setError(null);

        if (cognome.getText() == null || cognome.getText().length() == 0){

            errors++;
            cognome.setError("Inserire il cognome");
        } else cognome.setError(null);

        if (data.getText() == null || data.getText().length() == 0){

            errors++;
            data.setError("Inserire la data di nascita");
        } else data.setError(null);

        if (indirizzo.getText() == null || indirizzo.getText().length() == 0){

            errors++;
            indirizzo.setError("Inserire l'indirizzo");
        } else indirizzo.setError(null);

        if (cap.getText() == null || cap.getText().length() <5){

            errors++;
            cap.setError("Inserire il CAP");
        } else cap.setError(null);

        if (email.getText() == null || email.getText().length() ==0 || !email.getText().toString().matches(".*[@].*") ||
                !email.getText().toString().matches(".*[.].*")){

            errors++;
            email.setError("Inserire l'Email");
        } else email.setError(null);

        if (eta < 18){

            errors++;
            input.setError("Non adatto ai minori di 18");
        } else input.setError(null);

        switch (errors){
            case 0:
                gone.setVisibility(View.GONE);
                gone.setText("");
                break;
            case 1:
                gone.setVisibility(View.VISIBLE);
                gone.setText("Si è verificato un errore");
                break;
            default:
                gone.setVisibility(View.VISIBLE);
                gone.setText("Si sono verificati " +errors+ " errori");
                break;

        }
        return errors==0;
    }



    void showDialog() {
        DialogFragment newFragment = DatePickerFragment.newInstance();
        newFragment.show(getSupportFragmentManager(), "dialog");
    }

    public void doPositiveClick(Calendar date) {
        // Do stuff here.
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        data.setText(format.format(date.getTime()));

    }

    public void doNegativeClick() {
        // Do stuff here.

    }

}