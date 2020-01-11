package com.example.customroom;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public class FatchData {
    private Context context;
    private static FatchData fatchData;

    //create object AppDatabase
    private AppDatabase appDatabase;

    private FatchData(Context context){
        this.context= context;
        appDatabase= Room.databaseBuilder(context, AppDatabase.class, "MyData").build();
    }

    public static synchronized FatchData getInstance(Context context){
        if (fatchData == null){
            fatchData= new FatchData(context);
        }
        return fatchData;
    }

    public AppDatabase getAppDatabase(){
        return appDatabase;
    }
}
