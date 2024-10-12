package br.edu.fatec.quizbandeiras;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtNome;
    Button btnIniciar;
    Button btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = new Intent(getApplicationContext(), Exercicio2.class);

        edtNome = findViewById(R.id.edtNome);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnSair = findViewById(R.id.btnSair);

        // Start activity Exercicio1 on btnIniciar
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = edtNome.getText().toString().trim(); // Get the text from EditText and trim whitespace
                if (!nome.isEmpty()) { // Check if the text is not empty
                    Intent intent = new Intent(MainActivity.this, Exercicio1.class);
                    startActivity(intent);
                } else {
                    // Show a message to the user indicating that the name is required
                    Toast.makeText(MainActivity.this, "Nome não pode ser vazio", Toast.LENGTH_SHORT).show();
                    edtNome.setError("Nome não pode ser vazio");
                }
            }
        });

        // Handle btnSair
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close the activity
            }
        });
    }
}
