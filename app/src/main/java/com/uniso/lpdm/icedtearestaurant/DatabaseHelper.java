package com.uniso.lpdm.icedtearestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "icedtearestaurant";
    private static final int DB_VERSION = 1;

    DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        buildDb(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        buildDb(db, oldVersion, newVersion);
    }


    private void buildDb(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql;

        // se a versão antigar é menor que um, criar o banco de dados
        if (oldVersion < 1) {
            sql = "CREATE TABLE PRODUTO(" +
                    "_id INTEGER," +
                    "name TEXT," +
                    "description TEXT," +
                    "unit_price REAL," +
                    "id_resource_image INTEGER" +
                    ");";

            db.execSQL(sql);
        }
    }

    // função que insereum registro na tabela de produtos de acordo com os parametros.
    private void insertProduto(SQLiteDatabase db, String name,
                               String description, double uniPrice, int idResourceImage){

        ContentValues produto = new ContentValues();

        produto.put("name", name);
        produto.put("description", description);
        produto.put("unit_Price", uniPrice);
        produto.put("id_resource_image", idResourceImage);

        db.insert("PRODUTO", null, produto);
    }
}
