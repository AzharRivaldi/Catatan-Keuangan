package com.azhar.hitungpengeluaran.database;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {

    private static DatabaseClient mInstance;
    private AppDatabase mAppDatabase;

    private DatabaseClient(Context context){
        mAppDatabase = Room.databaseBuilder(context, AppDatabase.class, "keuangan_db")
                .fallbackToDestructiveMigration()
                .build();
    }

    public static synchronized DatabaseClient getInstance(Context context){
        if (mInstance == null){
            mInstance = new DatabaseClient(context);
        }
        return mInstance;
    }

    public static DatabaseClient getInstance() {
        if (mInstance != null) {
            return mInstance;
        }
        throw new IllegalArgumentException("Should use getInstance(Context) " +
                "at least once before using this method.");
    }

    public AppDatabase getAppDatabase(){
        return mAppDatabase;
    }
}
