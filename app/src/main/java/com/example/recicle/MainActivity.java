package com.example.recicle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ArrayList<Model> models = new ArrayList<>();
    RecyclerView mRecycleView;
    Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleView = findViewById(R.id.recycleview1);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new Adapter(this, getMyList());
        mRecycleView.setAdapter(myAdapter);
    }

    private ArrayList<Model> getMyList() {

        Model m = new Model();

        m.setTitle("Facultativa II");
        m.setDescripcion("Trabajos Practicos Android Studio");
        m.setProfesor("Sayra Urbina");
        m.setHora("2:10 - 3:20");
        m.setDia("Jueves");
        m.setFechaProxima("28/05/20");
        m.setImage(R.drawable.app);
        models.add(m);

        m = new Model();
        m.setTitle("Investigación aplicada");
        m.setDescripcion("Documentacion");
        m.setProfesor("Jazcar Bravo");
        m.setHora("1:00 - 2:10");
        m.setDia("Miercoles");
        m.setFechaProxima("28/05/20");
        m.setImage(R.drawable.files);
        models.add(m);

        m = new Model();
        m.setTitle("Planificación TIC");
        m.setDescripcion("clases practicas");
        m.setProfesor("Mirian Téllez");
        m.setHora("2:20 - 3:20");
        m.setDia("Miercoles");
        m.setFechaProxima("01/06/20");
        m.setImage(R.drawable.pc);
        models.add(m);

        return models;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.closet:
                System.exit(0);

            case R.id.addNew:

                final Dialog dlg = new Dialog(this);
                dlg.setContentView(R.layout.activity_actividad_registro);
                dlg.setCancelable(false);

                Button addNew = (Button) dlg.findViewById(R.id.btnGuardar);
                Button Cancelar = (Button) dlg.findViewById(R.id.btnCancelar);

                addNew.setOnClickListener(new View.OnClickListener() { //metodo onclick para el boton guardar
                    @Override
                    public void onClick(View v) { //se asignan variables a los Editex del formulario actividadRegistro.xml
                        EditText asignatura_Edt = (EditText) dlg.findViewById(R.id.asignaturaEdt);
                        EditText dia_Edt = (EditText) dlg.findViewById(R.id.diaEdt);
                        EditText hora_Edt = (EditText) dlg.findViewById(R.id.horaEdt);
                        EditText profesor_Edt = (EditText) dlg.findViewById(R.id.profesorEdt);
                        EditText descripcion_Edt = (EditText) dlg.findViewById(R.id.descripcionEdt);
                        EditText entregaPrx_Edt = (EditText) dlg.findViewById(R.id.fechaproxEdt);

                        Model add = new Model(); //se declara un objeto de tipo model
                        //se agragan los objetos a los campos del arreglo correspondiente
                        add.setTitle(asignatura_Edt.getText().toString());
                        add.setDescripcion(descripcion_Edt.getText().toString());
                        add.setDia(dia_Edt.getText().toString());
                        add.setHora(hora_Edt.getText().toString());
                        add.setProfesor(profesor_Edt.getText().toString());
                        add.setTitle(asignatura_Edt.getText().toString());
                        add.setFechaProxima(entregaPrx_Edt.getText().toString());
                        add.setImage(R.drawable.pencil);//se toma la imagen por defecto de la carpeta drawable

                        models.add(add); /*se agrega al arreglo models todo lo que tiene el objeto add*/
                        myAdapter = new Adapter(v.getContext(), models);
                        mRecycleView.setAdapter(myAdapter);
                        dlg.cancel();

                    }
                });
                Cancelar.setOnClickListener(new View.OnClickListener() { //metodo onclick para el botn cancelar
                    @Override
                    public void onClick(View v) {
                        dlg.cancel();
                    }
                });
                dlg.show(); //se manda a mostrar el formulario xml del Registro
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


