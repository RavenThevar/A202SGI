package com.example.ewallet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

public class DatabaseA extends SQLiteOpenHelper
{
    public static final String TABLE_Payment = "payment";
    public static final String Column_ID = "_id";
    public static final String Column_Account = "account";
    public static final String Column_Amount = "amount";

    private static final String DATABASE_NAME = "payments.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_Payment + "( " + Column_ID
            + " integer primary key autoincrement, " + Column_Account
            + " integer not null, " + Column_Amount + "integer not null);";

    public DatabaseA (Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.w(DatabaseA.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Payment);
        onCreate(db);
    }
}