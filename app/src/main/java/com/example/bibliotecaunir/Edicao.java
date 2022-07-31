package com.example.bibliotecaunir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Edicao extends AppCompatActivity {

    private EditText edt_id_edicao;
    private EditText edt_titulo_edicao;
    private EditText edt_autor_edicao;
    private EditText edt_ano_edicao;
    private Button btn_salvar_edicao;
    private Button btn_voltar_edicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao);

        edt_id_edicao = findViewById(R.id.edt_id_edicao);
        edt_titulo_edicao = findViewById(R.id.edt_titulo_edicao);
        edt_autor_edicao = findViewById(R.id.edt_autor_edicao);
        edt_ano_edicao = findViewById(R.id.edt_ano_edicao);
        btn_salvar_edicao = findViewById(R.id.btn_salvar_edicao);
        btn_voltar_edicao = findViewById(R.id.btn_voltar_edicao);

        btn_salvar_edicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(edt_id_edicao.getText().toString());
                String titulo = edt_titulo_edicao.getText().toString();
                String autor = edt_autor_edicao.getText().toString();
                int ano = Integer.parseInt(edt_ano_edicao.getText().toString());;

                BancoControlador bd = new BancoControlador(getApplicationContext());
                bd.alterarRegistro(id,titulo,autor,ano);

                Toast.makeText(Edicao.this, "Edição feita com sucesso!", Toast.LENGTH_SHORT).show();

            }
        });
        
        btn_voltar_edicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}