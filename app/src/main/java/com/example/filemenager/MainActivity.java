package com.example.filemenager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLeggi;
    Button btnScrivi;
    TextView txtContenuto;
    GestoreFile gf;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLeggi = (Button) findViewById(R.id.btnR);
        btnScrivi = (Button) findViewById(R.id.btnW);
        txtContenuto = (TextView) findViewById(R.id.nFile);
        gf = new GestoreFile();

        btnLeggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), gf.readFIle("fileorigin.txt", getApplicationContext()), Toast.LENGTH_SHORT).show();
            }
        });

        btnScrivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String esito = gf.scrivFile("fileorigin.txt",getApplicationContext());
                Toast.makeText(getApplicationContext(), esito, Toast.LENGTH_SHORT).show();
            }
        });
    }
}