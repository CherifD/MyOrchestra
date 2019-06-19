package com.cherifcodes.myorchestra.model.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.cherifcodes.myorchestra.model.instruments.SimpleInstrument;

@Database(entities = {SimpleInstrument.class}, version = 1)
public abstract class OrchestraDb extends RoomDatabase {

    private static volatile OrchestraDb INSTANCE;

    static OrchestraDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (OrchestraDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            OrchestraDb.class, "orchestra_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract SimpleInstrumentDao wordDao();
}


