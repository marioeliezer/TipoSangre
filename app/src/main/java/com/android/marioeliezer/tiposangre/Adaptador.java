package com.android.marioeliezer.tiposangre;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Adaptador extends ArrayAdapter {
    Context context;
    int resource;
    List<TipoSangre> list;
    public Adaptador(@NonNull Context context, int resource, @NonNull List<TipoSangre> objects) {
        super(context, resource, objects);
        this.resource=resource;
        this.context=context;
        this.list=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(resource,parent,false);
        TextView nombre=convertView.findViewById(R.id.nombre);
        TextView edad=convertView.findViewById(R.id.edad);
        TextView genero=convertView.findViewById(R.id.genero);
        TextView tiposangre=convertView.findViewById(R.id.tiposangre);

        nombre.setText(list.get(position).getNombre());
        edad.setText(list.get(position).getEdad());
        genero.setText(list.get(position).getGenero());
        tiposangre.setText(list.get(position).getTipo_sangre());
        return super.getView(position, convertView, parent);
    }
}
