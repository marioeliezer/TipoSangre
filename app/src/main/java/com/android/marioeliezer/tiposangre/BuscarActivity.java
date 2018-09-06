package com.android.marioeliezer.tiposangre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;

public class BuscarActivity extends AppCompatActivity {
private Spinner busqueda;
private ListView lvresultados;
private List<TipoSangre> resultados;
private BaseDatos bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        busqueda=(Spinner)findViewById(R.id.buscasangre);
        lvresultados=(ListView)findViewById(R.id.lvbuscar);

    }
 public void buscar(View view){
 resultados.addAll(bd.tipoSangreDao().obtenerportiposangre(busqueda.getSelectedItem().toString()));
 Adaptador adaptador=new Adaptador(this,R.layout.lista,resultados);
 lvresultados.setAdapter(adaptador);
 }
}
