package com.example.esercitazione2;

import java.io.Serializable;
import java.util.Calendar;

public class Persona implements Serializable {




    public String nome;
    public String cognome;
    public String indirizzo;
    public String email;
    public String cap;


    public String eta;

    private Calendar dataNascita; ;

    public Persona (){

        this.nome="";
        this.cognome="";
        this.indirizzo="";
        this.cap="";
        this.email="";
        this.eta="";

    }

    public Persona(String nome, String cognome, String indirizzo, String cap, String email, String eta){
        this.nome=nome;
        this.cognome=cognome;
        this.indirizzo=indirizzo;
        this.cap=cap;
        this.email=email;
        this.eta=eta;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setDataNascita(Calendar dataNascita) {
        this.dataNascita = dataNascita;
    }

    public Calendar getDataNascita() {
        return dataNascita;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }
}
