package com.android.marioeliezer.tiposangre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;

public class TipoSangreActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText edad;
    private Spinner sexo;
    private Spinner tiposangre;
    private String[] generos ={"Masculino","Femenino"};
    private String[] tsangre ={"O-","O+","A-","A+","B-","B+","AB-","AB+"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_sangre);
     nombre=(EditText)findViewById(R.id.fmnombre);
     edad=(EditText)findViewById(R.id.fmedad);
     sexo=(Spinner)findViewById(R.id.fmgeneros);
     tiposangre=(Spinner)findViewById(R.id.sangritas);

        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            TipoSangre tipoSangr = (TipoSangre) extras.get("edit");
            nombre.setText(tipoSangr.getNombre());
            edad.setText(tipoSangr.getEdad());
            for (int i=0;i<generos.length;i++){
                if (generos[i]==tipoSangr.getGenero()){
                   sexo.setSelection(i);}}
            for (int i=0;i<tsangre.length;i++){
                if (tsangre[i]==tipoSangr.getTipo_sangre()){
                    tiposangre.setSelection(i);}}
                    }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuform,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.guardar:
                Intent intent=new Intent();
                 TipoSangre ts=new TipoSangre(nombre.getText().toString(),sexo.getSelectedItem().toString(),tiposangre.getSelectedItem().toString(),Integer.valueOf(edad.getText().toString()));
                 intent.putExtra("nuevo",ts);
                setResult(RESULT_OK,intent);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
