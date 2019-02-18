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
    Rekensom momenteleRekensom;

    private boolean somgoed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        speler = new Speler(100, "", new HeelendZwaard(), "", 0);
        vijand = new Vijand(100, "");
        final Gevecht gevecht = new Gevecht(speler, vijand, 10, this);

        setContentView(R.layout.activity_main);
        Button klikhier = findViewById(R.id.test_generering);
        final TextView inputTxt = findViewById(R.id.rekensom_iput);


        final Button controleerSom = findViewById(R.id.kiesantwoordknop);
        final TextView antwoordtekst = findViewById(R.id.antwoordTekst);


        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                    boolean gevechtNogBezig = true;
                    while(gevechtNogBezig)
                    {
                        momenteleRekensom = rekensomgenerator.genereerSom(Rekenvorm.KEER);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                inputTxt.setText(momenteleRekensom.toString());
                            }
                        });

                        try {
                            int wachtmoment = 0;
                            while(wachtmoment < 50 && !somgoed) {
                                sleep(100);
                                wachtmoment++;
                            }
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(somgoed)
                        {
                            gevecht.doeSchade(momenteleRekensom.antwoord());
                        }
                        else
                        {
                            gevecht.krijgSchade(momenteleRekensom.antwoord());
                        }
                            somgoed = false;
                        if(gevecht.controleerDood())
                        {
                            gevechtNogBezig = false;

                        }

                    }
                }

        });
        thread.start();
        controleerSom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                somgoed = gevecht.controleerSom(Integer.valueOf(antwoordtekst.getText().toString()), momenteleRekensom);
            }
        });


    }
    }
