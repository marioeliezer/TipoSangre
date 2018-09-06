package com.android.marioeliezer.tiposangre;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(version = 1,entities = {TipoSangre.class})
public abstract class BaseDatos extends RoomDatabase {
public abstract TipoSangreDao tipoSangreDao();
}
