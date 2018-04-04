package br.com.senaijandira.gestodegastos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 17170083 on 20/03/2018.
 */

public class DbHelper extends SQLiteOpenHelper{

    private static  String DB_NAME = "controle_gastos.db";

    private  static  int DB_VERSION = 1;

    public DbHelper(Context ctx) { super(ctx, DB_NAME,null, DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Tabela de Lançamentos de valores

        String sql = "create table tbl_lancamentos("+
                "id INTEGER primary key autoincrement,"+
                " categoria TEXT,"+
                " valor INTEGER"+
                " data INTEGER"+
                "descricao TEXT"+
                "tipo TEXT);";

        //Tabela de categorias
       // String sql1 = "create table tbl_categoria(id_categoria INTEGER primary key autoincrement, nome_categoria TEXT);";

        db.execSQL(sql);

        //db.execSQL(sql1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
