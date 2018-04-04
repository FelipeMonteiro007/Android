package br.com.senaijandira.gestodegastos;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class contasActivity extends AppCompatActivity {

    EditText txt_nome_conta,txt_valor_conta,txt_data_conta;
    RadioButton rb_despesa, rb_receita;
    Spinner sp_categoria;
    String ref;
    Context context;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txt_nome_conta = (EditText) findViewById(R.id.txt_nome_conta);
        txt_valor_conta = (EditText) findViewById(R.id.txt_valor_conta);
        txt_data_conta = (EditText) findViewById(R.id.txt_data_conta);
        sp_categoria = (Spinner) findViewById(R.id.sp_categoria);
        rb_despesa = (RadioButton) findViewById((R.id.rb_despesas));
        rb_receita = (RadioButton) findViewById((R.id.rb_receitas));
        context=this;
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Lancamentos c;

                c = new Lancamentos();

                c.setTipo(txt_nome_conta.getText().toString());
                c.setValor(txt_valor_conta.getText().toString());
                String datav = txt_data_conta.getText().toString();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date dt = df.parse(datav);
                } catch (ParseException e) {
                    txt_data_conta.setError("Digite uma data valida");
                    e.printStackTrace();
                }

                c.setCategoria(sp_categoria.getSelectedItem().toString());

                if (rb_receita.isSelected()) {
                    c.setTipo("receitas");
                } else if (rb_despesa.isSelected()) {
                    c.setTipo("despesas");
                }
                LancamentosDAO.getInstance().inserir(context,c);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void salvar(View view) {



    }
}
