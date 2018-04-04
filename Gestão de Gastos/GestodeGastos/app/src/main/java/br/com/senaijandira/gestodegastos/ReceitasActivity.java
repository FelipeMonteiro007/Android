package br.com.senaijandira.gestodegastos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class ReceitasActivity extends AppCompatActivity {

    EditText txt_categoria_receita,txt_valor_receita,txt_data_receita,txt_descricao_receita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receitas2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txt_categoria_receita = (EditText) findViewById(R.id.txt_categoria_receita);
        txt_valor_receita = (EditText) findViewById(R.id.txt_valor_receita);
        txt_descricao_receita = (EditText) findViewById(R.id.txt_descricao_receita);
        txt_data_receita = (EditText) findViewById(R.id.txt_data_receita);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void categoria(View view) {
    }

    public void valor_receita(View view) {
    }

    public void data_receita(View view) {
    }



}
