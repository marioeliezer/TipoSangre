package com.android.marioeliezer.tiposangre;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private ListView listView;
private List<TipoSangre> list=new ArrayList<>();
private BaseDatos db;
private int posicion=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView)findViewById(R.id.listita);
        db= Room.databaseBuilder(this,BaseDatos.class,"Data").allowMainThreadQueries().build();
        list.addAll(db.tipoSangreDao().obtenerSangres());
        Adaptador adaptador=new Adaptador(this,R.layout.lista,list);
        listView.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menumain,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.nuevo:
                Intent intent = new Intent(this,TipoSangreActivity.class);
                startActivityForResult(intent,1);
                break;
            case R.id.buscar:
                Intent buscar = new Intent(this,BuscarActivity.class);
                startActivityForResult(buscar,2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode==RESULT_OK){
           TipoSangre ts=(TipoSangre)data.getExtras().get("nuevo");
            if (requestCode==1){
                db.tipoSangreDao().insertar(ts);
                list.add(ts);
            }
            else {
                db.tipoSangreDao().actualizar(ts);
                list.set(posicion,ts);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.contextmenu,menu);
        menu.setHeaderTitle("OPCIONES");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.Actualizar:
                posicion=info.position;
                Intent intent = new Intent(this,TipoSangreActivity.class);
                intent.putExtra("edit",list.get(info.position));
                startActivityForResult(intent,3);
                break;
            case R.id.Borrar:
                db.tipoSangreDao().borrar(list.get(info.position));
                list.remove(info.position);
                break;
        }
        ((Adaptador)listView.getAdapter()).notifyDataSetChanged();
        return super.onContextItemSelected(item);
    }
}
