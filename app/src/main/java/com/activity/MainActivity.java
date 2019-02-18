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

public class MainActivity extends AppCompatActivity {
    Rekensomgenerator rekensomgenerator = new Rekensomgenerator();
    Speler speler;
    Vijand vijand;
    Rekensom rekensom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        speler = new Speler(100,"",new HeelendZwaard(), "", 0);
        vijand = new Vijand(100,"");
        final Gevecht gevecht = new Gevecht(speler,vijand, 10);
        setContentView(R.layout.activity_main);
        Button klikhier = findViewById(R.id.test_generering);
        final TextView inputTxt = findViewById(R.id.rekensom_iput);
        klikhier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rekensom = rekensomgenerator.genereerSom(Rekenvorm.DELEN);
                inputTxt.setText(rekensom.toString());
            }
        });

        final Button controleerSom = findViewById(R.id.kiesantwoordknop);
        final TextView antwoordtekst = findViewById(R.id.antwoordTekst);
        controleerSom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.valueOf(antwoordtekst.getText().toString()) == rekensom.antwoord())
                {
                    gevecht.doeSchade(rekensom.antwoord());
                }
                else
                {
                    gevecht.krijgSchade(rekensom.antwoord());
                }
                rekensom = rekensomgenerator.genereerSom(Rekenvorm.DELEN);
                inputTxt.setText(rekensom.toString());
                antwoordtekst.setText("");
            }
        });





    }
}
