package com.cherifcodes.myorchestra.model.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cherifcodes.myorchestra.model.instruments.SimpleInstrument;

import java.util.List;

@Dao
public interface SimpleInstrumentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(SimpleInstrument simpleInstrument);

    @Update
    int update(SimpleInstrument simpleInstrument);

    @Delete
    int delete(SimpleInstrument simpleInstrument);

    @Query("SELECT * FROM SimpleInstrument LIMIT 1")
    SimpleInstrument getAnySimpleInstrument();

    @Query("SELECT * FROM SimpleInstrument")
    LiveData<List<SimpleInstrument>> getAllInstruments();
}
