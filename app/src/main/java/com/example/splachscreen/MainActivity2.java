package com.example.splachscreen;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        // Récupérer les données envoyées depuis MainActivity
        String nom = getIntent().getStringExtra("NOM");
        String email = getIntent().getStringExtra("EMAIL");
        String phone = getIntent().getStringExtra("PHONE");
        String adresse = getIntent().getStringExtra("ADRESSE");
        String genre = getIntent().getStringExtra("GENRE");
        String ville = getIntent().getStringExtra("VILLE");

        // Trouver les TextView dans le layout
        TextView textNom = findViewById(R.id.nom);
        TextView textEmail = findViewById(R.id.email);
        TextView textPhone = findViewById(R.id.phone);
        TextView textAdresse = findViewById(R.id.adresse);
        TextView textGenre = findViewById(R.id.genre);
        TextView textVille = findViewById(R.id.villes);

        // Remplir les TextView avec les données reçues
        textNom.setText("Nom : " +nom);
        textPhone.setText("Phone : "+phone);
        textEmail.setText("Email : " +email);
        textAdresse.setText("Adresse : "+adresse);
        textGenre.setText("Genre : "+genre);
        textVille.setText("Ville : " +ville);


        // Appliquer les marges du système
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}