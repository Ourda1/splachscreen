package com.example.splachscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText editNom = findViewById(R.id.editTextText2);
        EditText editEmail = findViewById(R.id.editTextTextEmailAddress);
        EditText editPhone = findViewById(R.id.editTextPhone);
        EditText editAdresse = findViewById(R.id.editTextText3);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Spinner spinnerVille = findViewById(R.id.spinner);
        Button btnEnv = findViewById(R.id.btn_Env);

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

            btnEnv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nom = editNom.getText().toString();
                    String email = editEmail.getText().toString();
                    String phone = editPhone.getText().toString();
                    String adresse = editAdresse.getText().toString();
                    String ville = spinnerVille.getSelectedItem().toString();

                    // Récupérer le genre sélectionné
                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String genre = (selectedRadioButton != null) ? selectedRadioButton.getText().toString() : "Non défini";

                    // Envoi des données avec Intent
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("NOM", nom);
                    intent.putExtra("EMAIL", email);
                    intent.putExtra("PHONE", phone);
                    intent.putExtra("ADRESSE", adresse);
                    intent.putExtra("GENRE", genre);
                    intent.putExtra("VILLE", ville);
                    startActivity(intent);
                }
            });

    }
}