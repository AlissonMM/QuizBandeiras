package br.edu.fatec.quizbandeiras;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Exercicio1 extends AppCompatActivity {

    String mensagemExer1;

    RadioButton rdbBrasil;
    RadioButton rdbAfrica;
    RadioButton rdbAlemanha;
    RadioButton rdbVenezuela;

    Button btnResponder;

    public int pontuacao = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercicio1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rdbBrasil = findViewById(R.id.rdbBrasil);
        rdbAfrica = findViewById(R.id.rdbAfrica);
        rdbAlemanha = findViewById(R.id.rdbAlemanha);
        rdbVenezuela = findViewById(R.id.rdbVenezuela);

        btnResponder = findViewById(R.id.btnResponder);

        //add method responder to btnResponder
        btnResponder.setOnClickListener(this::responder);
    }

    public void responder(View view) {
        if (rdbBrasil.isChecked()) {
            pontuacao++;
            mensagemExer1 = "Brasil é a resposta correta";

        } else if (rdbAfrica.isChecked()) {
            mensagemExer1 = "África do Sul não é a resposta";

        } else if (rdbAlemanha.isChecked()) {
            mensagemExer1 = "A Alemanha não é a resposta";

        } else if (rdbVenezuela.isChecked()) {
            mensagemExer1 = "Venezuela não é a resposta";
        };
        Toast.makeText(Exercicio1.this, mensagemExer1, Toast.LENGTH_SHORT).show();

    }

}





