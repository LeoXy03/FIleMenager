package com.example.filemenager;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.sql.StatementEvent;

public class GestoreFile {
    String nomeFile;

    public GestoreFile(){

    }

    public GestoreFile(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    public String readFIle(String nf, Context c){
        String es;
        StringBuilder sb = new StringBuilder();
        String testoDaRestituire = "";
        try {

            BufferedReader bfr = new BufferedReader(new InputStreamReader(c.openFileInput(nf)));

            while ((testoDaRestituire = bfr.readLine())!=null){
                    sb.append(testoDaRestituire);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
             Log.d("eccezzioneuno", "file non letto");
        } catch (IOException e) {
             
        }
        return sb.toString();
    }
    public String scrivFile(String nomeFile, Context c){
        String esito;
        FileOutputStream file0;
        String testodascrivere = "questo è il testo del file creato";
        try {
            file0 = c.openFileOutput(nomeFile, Context.MODE_PRIVATE);
            file0.write(testodascrivere.getBytes(StandardCharsets.UTF_8));
            file0.close();
            esito = "file scritto correttamente";
        } catch (FileNotFoundException e) {
            esito = "attenzione non sono riuscito a creare il file";
        } catch (IOException e) {
            esito = "errore in fase di scrittura";
        }
        return esito;
    }
}
