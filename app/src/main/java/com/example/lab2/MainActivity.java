package com.example.lab2;

import android.os.Bundle;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    // Saisie
    private EditText saisiesurface, saisiepieces;
    // Check
    private CheckBox piscineCheck;
    // Affichage
    private TextView resulttt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Liaison XML au Java
        setContentView(R.layout.activity_main);
        saisiesurface = findViewById(R.id.Surface);
        saisiepieces = findViewById(R.id.nbpieces);
        piscineCheck = findViewById(R.id.checkbox_Piiscinee);
        resulttt = findViewById(R.id.resultattt);

        // Déclenchement du calcul au clic
        findViewById(R.id.btnCalculll).setOnClickListener(v -> calculerImpot());
    }

    private void calculerImpot() {
        // Récupération des données saisies
        double Surf = Double.parseDouble(saisiesurface.getText().toString());
        int totPieces = Integer.parseInt(saisiepieces.getText().toString());
        boolean piscineee = piscineCheck.isChecked();

        // Calcul
        double Baseimpot = Surf * 2;
        double supplementaire = totPieces * 50 + (piscineee ? 100 : 0);
        double totall = Baseimpot + supplementaire;

        // Affichage du calcul
        String messagefinal = "Impôt de base : " + Baseimpot + "\n" +
                "Supplément : " + supplementaire + "\n" +
                "Total : " + totall;
        resulttt.setText(messagefinal);

    }
}