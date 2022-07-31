package com.example.bibliotecaunir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Remocao extends AppCompatActivity {

    private EditText edt_id_remover;
    private Button btn_remocao;
    private Button btn_voltar_remover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remocao);

        edt_id_remover = findViewById(R.id.edt_id_remocao);
        btn_remocao = findViewById(R.id.btn_apagar_remocao);
        btn_voltar_remover = findViewById(R.id.btn_voltar_remocao);

        btn_remocao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(edt_id_remover.getText().toString());
                BancoControlador bd = new BancoControlador(getApplicationContext());

                bd.deletarRegistro(id);

                Toast.makeText(Remocao.this, "Livro removido com sucesso!!", Toast.LENGTH_SHORT).show();
            }
        });

        btn_voltar_remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}