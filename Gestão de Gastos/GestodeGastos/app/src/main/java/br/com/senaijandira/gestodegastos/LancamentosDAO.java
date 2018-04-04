package br.com.senaijandira.gestodegastos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;

import br.com.senaijandira.gestodegastos.DbHelper;
import br.com.senaijandira.gestodegastos.Lancamentos;

/**
 * Created by 17170112 on 26/03/2018.
 */

public class LancamentosDAO {
    private static LancamentosDAO instance;

    public  static LancamentosDAO getInstance(){

        if (instance == null)
            instance = new LancamentosDAO();

        return instance;
    }
    public Boolean inserir (Context context, Lancamentos l){

        SQLiteDatabase db = new DbHelper(context).getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("categoria", l.getCategoria());
        valores.put("descricao", l.getDescricao());
        valores.put("tipo", l.getTipo());
//        valores.put("data", l.getData().getTime());
        valores.put("valor",l.getValor());

        Long id = db.insert("tbl_lancamentos",null, valores);
        if (id != -1)
            return true;
        else
            return false;
    }

    public ArrayList<Lancamentos> selecionarTodosReceitas(Context context) {
        //Banco de dados de leitura
        ArrayList<Lancamentos> retorno = new ArrayList<>();
        SQLiteDatabase db = new DbHelper(context).getReadableDatabase();

        String sql ="select * from tbl_lancamentos where tipo=receitas";
        Cursor cursor = db.rawQuery(sql,null);

        while (cursor.moveToNext()){
            Lancamentos lancamento = new Lancamentos();
            lancamento.setId(cursor.getInt(0));
            lancamento.setCategoria(cursor.getString(1));
            lancamento.setDescricao(cursor.getString(2));
            lancamento.setTipo(cursor.getString(3));
            lancamento.setData(new Date(cursor.getLong(4)));

            retorno.add(lancamento);

        }
        return retorno;
    }
    public ArrayList<Lancamentos> selecionarTodosDespesas(Context context) {
        //Banco de dados de leitura
        ArrayList<Lancamentos> retorno = new ArrayList<>();
        SQLiteDatabase db = new DbHelper(context).getReadableDatabase();

        String sql ="select * from tbl_lancamentos where tipo=despesas";
        Cursor cursor = db.rawQuery(sql,null);

        while (cursor.moveToNext()){
            Lancamentos lancamento = new Lancamentos();
            lancamento.setId(cursor.getInt(0));
            lancamento.setCategoria(cursor.getString(1));
            lancamento.setDescricao(cursor.getString(2));
            lancamento.setTipo(cursor.getString(3));
            lancamento.setData(new Date(cursor.getLong(4)));

            retorno.add(lancamento);

        }
        return retorno;
    }

    public Lancamentos selecionarUm(Context context,int id){

        SQLiteDatabase db = new DbHelper(context).getWritableDatabase();
        String sql ="select * from tbl_lancamentos  where _id = " + id;
        Cursor cursor = db.rawQuery(sql,null);

        if (cursor.getCount()>0){

            cursor.moveToNext();
           Lancamentos lancamento = new Lancamentos();
            lancamento.setId(cursor.getInt(0));
            lancamento.setCategoria(cursor.getString(1));
            lancamento.setDescricao(cursor.getString(2));
            lancamento.setTipo(cursor.getString(3));
            lancamento.setData(new Date(cursor.getLong(4)));
            cursor.close();
            return lancamento;
        }

        return  null;
    }

    public Boolean remover(Context context, Integer id) {
        SQLiteDatabase db = new DbHelper(context).getWritableDatabase();
        db.delete("tbl_contato","_id=?",new String[]{id.toString()});
        return false;
    }

    public Boolean atualizar(Context context,Lancamentos l){
        SQLiteDatabase db = new DbHelper(context).getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("id_categoria", l.getCategoria());
        valores.put("descricao", l.getDescricao());
        valores.put("tipo", l.getTipo());
        valores.put("data", l.getData().getTime());
        valores.put("valor",l.getValor());
        db.update("tbl_lancamentos", valores,"_id=?", new String[]{l.getId().toString()});

        return true;
    }

}
