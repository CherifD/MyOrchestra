package com.cherifcodes.myorchestra.model.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.cherifcodes.myorchestra.model.instruments.Instrument;
import com.cherifcodes.myorchestra.model.instruments.SimpleInstrument;

import java.util.List;

public class Repository {
    private static Repository instance;
    private OrchestraDb db;

    private Repository(Application application) {
        this.db = OrchestraDb.getDatabase(application.getApplicationContext());
    }

    public static Repository getInstance(Application application) {
        if (instance == null) {
            synchronized (Repository.class) {
                if (instance == null) {
                    instance = new Repository(application);
                }
            }
        }
        return instance;
    }

    public void insertSimpleInstrument(final Instrument instrument) {
        new InsertIntoDbTask(this.db).execute(instrument);
    }

    public LiveData<List<SimpleInstrument>> getAllInstruments() {
        /*LiveData<List<SimpleInstrument>> liveList =  this.db.getInstrumentDao().getAllInstruments();
        Log.i("Repository", "There are: " + liveList.getValue().size() + " instruments!!!");*/
        //Note that LiveData will return NULL inside objects that are not listening to it!!!!.
        return this.db.getInstrumentDao().getAllInstruments();
    }

    private static class InsertIntoDbTask extends AsyncTask<Instrument, Void, Void> {
        private OrchestraDb orchestraDb;

        InsertIntoDbTask(OrchestraDb orchestraDb) {
            this.orchestraDb = orchestraDb;
        }

        @Override
        protected Void doInBackground(Instrument... instruments) {
            orchestraDb.getInstrumentDao().insert((SimpleInstrument) instruments[0]);
            return null;
        }
    }
}
