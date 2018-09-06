package com.android.marioeliezer.tiposangre;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TipoSangreDao {

    @Insert
    void insertar(TipoSangre tipoSangre);
    @Update
    void actualizar(TipoSangre tipoSangre);
    @Delete
    void borrar(TipoSangre tipoSangre);

    @Query("SELECT * FROM TipoSangre ")
    List<TipoSangre> obtenerSangres();
    @Query("SELECT * FROM TipoSangre where id=:id")
    TipoSangre obtenerSangre(int id);

    @Query("SELECT * FROM TipoSangre where tipo_sangre=:tiposangre" )
    List<TipoSangre> obtenerportiposangre(String tiposangre);
}
