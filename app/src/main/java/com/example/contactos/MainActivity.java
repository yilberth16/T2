package com.example.contactos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity{

    EditText edt_nombre, edt_telefono;
    Button btn_guardar;
    String nombre,telefono, ahorro,corriente;
    Usuario mi_usuario;
    String doc;
    ArrayList<Usuario> listaUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_nombre = (EditText)findViewById(R.id.edt_nombre);
        edt_telefono = (EditText)findViewById(R.id.edt_telefono);
        btn_guardar = (Button)findViewById(R.id.btn_guardar);
        final RadioButton rdAhorro = (RadioButton)findViewById(R.id.rdAhorro);
        final RadioButton rdCorriente = (RadioButton)findViewById(R.id.rdCorriente);
        final EditText edtSaldo = (EditText)findViewById(R.id.edtSaldo);
        Button btn_ver = findViewById(R.id.btnVer);
        listaUsuario = new ArrayList<>();

        registerForContextMenu(edt_telefono);
        registerForContextMenu(edt_nombre);


        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = edt_nombre.getText().toString();
                telefono = edt_telefono.getText().toString();
                ahorro = rdAhorro.getText().toString();
                corriente = rdCorriente.getText().toString();


                if (nombre.isEmpty() || telefono.isEmpty()  || edtSaldo.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Te falto llenar un campo", Toast.LENGTH_SHORT).show();
                }
                else if (rdAhorro.isChecked()){
                    Toast.makeText(MainActivity.this, "Se guardo correctamente", Toast.LENGTH_SHORT).show();
                    mi_usuario = new Usuario();
                    mi_usuario.setNombre(nombre);
                    mi_usuario.setAhorro(ahorro);
                    mi_usuario.setTelefono(telefono);
                    mi_usuario.setSaldo(edtSaldo.getText().toString());
                    mi_usuario.setAhorro(rdAhorro.getText().toString());
                    listaUsuario.add(mi_usuario);

                }
                else{
                    Toast.makeText(MainActivity.this, "Se guardo correctamente", Toast.LENGTH_SHORT).show();
                    mi_usuario = new Usuario();
                    mi_usuario.setNombre(nombre);
                    mi_usuario.setAhorro(ahorro);
                    mi_usuario.setTelefono(telefono);
                    mi_usuario.setSaldo(edtSaldo.getText().toString());
                    mi_usuario.setAhorro(rdCorriente.getText().toString());
                    listaUsuario.add(mi_usuario);
                }
            }
        });

        btn_ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Registros.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("usuario",mi_usuario);
                intent.putExtra("lista",listaUsuario);
                startActivity(intent);
            }
        });


    }




}