package com.example.poids.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.poids.R;
import com.example.poids.controleur.Controle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        this.controle = Controle.getInstance();
    }

    //proprietés
    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private TextView lblIMG;
    private ImageView imgSmiley;
    private Controle controle;

    // initialisation des liens avec les objets graphiques
    private void init() {
        txtPoids = (EditText) findViewById(R.id.txtPoids);
        txtTaille = (EditText) findViewById(R.id.txtTaille);
        txtAge = (EditText) findViewById(R.id.txtAge);
        rdHomme = (RadioButton) findViewById(R.id.rdHomme);
        lblIMG = (TextView) findViewById(R.id.lblIMG);
        imgSmiley = (ImageView) findViewById(R.id.imgSmiley);
        ecouteCalcul();
    }
    // ecoute evenement sur bouton Calcul

    private void ecouteCalcul() {
        ((Button) findViewById(R.id.btnCalc)).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer poids = 0;
                Integer taille = 0;
                Integer age = 0;
                Integer genre = 0;
                try {
                    poids = Integer.parseInt(txtPoids.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    age = Integer.parseInt(txtAge.getText().toString());
                } catch (Exception e) {
                }
                ;
                if (rdHomme.isChecked()) {
                    genre = 1;
                }
                afficheResultat(poids, taille, age, genre);
            }
        });
    }

    // affichage de l'img du message et de l'image
    private void afficheResultat(Integer poids, Integer taille, Integer age, Integer genre) {
        // création de client et récupération des informations
        this.controle.createClient(poids, taille, age, genre);
        float img = this.controle.getImg();
        String message = this.controle.getMessage();
        // affichage
        if (message == "normal") {
            imgSmiley.setImageResource(R.drawable.normal);
        } else {
            if (message == "trop faible") {
                imgSmiley.setImageResource(R.drawable.maigre);
            } else {
                imgSmiley.setImageResource(R.drawable.graisse);
            }
        }
        lblIMG.setText(String.format("%.01f", img)+ " : IMG" + message);
    }
}