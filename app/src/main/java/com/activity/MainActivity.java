package com.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.control.Gevecht;
import com.control.Rekensomgenerator;
import com.control.Rekenvorm;
import com.example.vluggericky.R;
import com.model.Rekensom;
import com.model.Speler;
import com.model.Vijand;
import com.model.wapens.HeelendZwaard;
import com.model.wapens.Houtenzwaard;

import org.w3c.dom.Text;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
    Rekensomgenerator rekensomgenerator = new Rekensomgenerator();
    Speler speler;
    Vijand vijand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        speler = new Speler(100, "", new HeelendZwaard(), "", 0);
        vijand = new Vijand(100, "");
        final Gevecht gevecht = new Gevecht(speler, vijand, 10, this);

        setContentView(R.layout.activity_main);
        Button klikhier = findViewById(R.id.test_generering);

        klikhier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(gevecht);
                thread.start();
            }
        });

        final Button controleerSom = findViewById(R.id.kiesantwoordknop);
        final TextView antwoordtekst = findViewById(R.id.antwoordTekst);
        controleerSom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gevecht.controleerSom(Integer.valueOf(antwoordtekst.getText().toString()));
            }
        });


    }
    }
