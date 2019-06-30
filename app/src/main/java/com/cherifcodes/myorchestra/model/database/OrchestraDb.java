package com.cherifcodes.myorchestra.model.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.cherifcodes.myorchestra.model.ModelConstants;
import com.cherifcodes.myorchestra.model.instruments.InstrumentFactory;
import com.cherifcodes.myorchestra.model.instruments.SimpleInstrument;

import java.util.concurrent.Executors;

@Database(entities = {SimpleInstrument.class}, version = 1, exportSchema = false)
public abstract class OrchestraDb extends RoomDatabase {

    private static volatile OrchestraDb INSTANCE;

    static OrchestraDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (OrchestraDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            OrchestraDb.class, "orchestra_database2")
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            OrchestraDb db = getDatabase(context);
                                            initDatabase(db);
                                        }
                                    });
                                }
                            })
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static void initDatabase(OrchestraDb db) {
        initStringsSection(db);
        initWoodwindsSection(db);
        initBrasswindsSection(db);
        initPercussionsSection(db);
    }

    private static void initStringsSection(OrchestraDb db) {
        String strings = ModelConstants.STRINGS;
        insertInitInstruments(db, strings, "2nd violin", ModelConstants.INIT_NUM_2ND_VIOLINS);
        insertInitInstruments(db, strings, "1st violins", ModelConstants.INIT_NUM_1ST_VIOLINS);
        insertInitInstruments(db, strings, "viola", ModelConstants.INIT_NUM_VIOLAS);
        insertInitInstruments(db, strings, "cello", ModelConstants.INIT_NUM_CELLOS);
        insertInitInstruments(db, strings, "double bass", ModelConstants.INIT_NUM_DOUBLE_BASSES);
    }

    private static void initWoodwindsSection(OrchestraDb db) {
        String woodwinds = ModelConstants.WOODWINDS;
        insertInitInstruments(db, woodwinds, "clarinet", ModelConstants.INIT_NUM_CLARINETS);
        insertInitInstruments(db, woodwinds, "bassoon", ModelConstants.INIT_NUM_BASSOONS);
        insertInitInstruments(db, woodwinds, "flute", ModelConstants.INIT_NUM_FLUTES);
        insertInitInstruments(db, woodwinds, "oboe", ModelConstants.INIT_NUM_OBOES);
    }

    private static void initBrasswindsSection(OrchestraDb db) {
        String brasswinds = ModelConstants.BRASSWINDS;
        insertInitInstruments(db, brasswinds, "trumpet", ModelConstants.INIT_NUM_TRUMPETS);
        insertInitInstruments(db, brasswinds, "trombone", ModelConstants.INIT_NUM_TROMBONES);
        insertInitInstruments(db, brasswinds, "tuba", ModelConstants.INIT_NUM_TUBAS);
        insertInitInstruments(db, brasswinds, "French horn", ModelConstants.INIT_NUM_FRENCH_HORNS);
    }

    private static void initPercussionsSection(OrchestraDb db) {
        String percussions = ModelConstants.PERCUSSIONS;
        insertInitInstruments(db, percussions, "snare", ModelConstants.INIT_NUM_SNARES);
        insertInitInstruments(db, percussions, "bass drum", ModelConstants.INIT_NUM_BRASS_DRUMS);
        insertInitInstruments(db, percussions, "timpani", ModelConstants.INIT_NUM_TIMPANIS);
        insertInitInstruments(db, percussions, "piano", ModelConstants.INIT_NUM_PIANOS);
    }

    private static void insertInitInstruments(
            OrchestraDb db, String sectionName, String instrumentName, int numInstruments) {
        Log.i("OrchestraDb", "!!!! reached inside inserInitInstruments()");
        for (int i = 0; i < numInstruments; i++) {
            SimpleInstrument simpleInstrument =
                    (SimpleInstrument) InstrumentFactory.createInstrument(instrumentName, sectionName);
            long insertedId = db.getInstrumentDao().insert(simpleInstrument);
            System.out.println("!!!! Inserted this id: " + insertedId);
        }
    }

    public abstract SimpleInstrumentDao getInstrumentDao();
}


