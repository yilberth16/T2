package com.example.contactos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;


public class Registros extends AppCompatActivity {
    private ListView miLista;
    Adapter mAdapter;
    String nombre;
    TextView txt_nombre;
    Usuario usuario;
    EditText edtFiltrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);

        txt_nombre = findViewById(R.id.txt_nombre);

        nombre = getIntent().getStringExtra("nombre");
        edtFiltrar = findViewById(R.id.edt_filtrar);
        usuario = getIntent().getParcelableExtra("usuario");
        //listUsuario = new ArrayList<>();
        final ArrayList<Usuario> listUsuario = getIntent().getParcelableArrayListExtra("lista");
        TextView txtOrdenarSaldo = findViewById(R.id.ordenar_saldo);


        miLista = findViewById(R.id.lista_contacto);
        usuario = new Usuario();
        usuario.setNombre(nombre);


        mAdapter = new Adapter(Registros.this, R.layout.list_registros, listUsuario);
        miLista.setAdapter(mAdapter);
        registerForContextMenu(miLista);
        txtOrdenarSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(listUsuario, new Comparator<Usuario>() {
                    @Override
                    public int compare(Usuario o1, Usuario o2) {
                        int saldo1 = Integer.parseInt(o1.getSaldo());
                        int saldo2 = Integer.parseInt(o2.getSaldo());
                        if (o1.getSaldo() == o2.getSaldo()) {
                            return o1.getSaldo().compareTo(o2.getSaldo());
                        }else if(saldo1 > saldo2){
                            return 1;
                        }else{
                            return-1;
                        }
                    }
                });
                mAdapter.notifyDataSetChanged();
            }
        });

        edtFiltrar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                /*String nombre = edtFiltrar.getText().toString();
                for (int i = 0; i < listUsuario.size(); i++) {
                    Usuario us = listUsuario.get(i);
                    if (nombre.equals(us.getNombre())) {
                        mAdapter.getFilter().filter(us.toString());
                    }
                    else{
                        mAdapter.notifyDataSetChanged();
                    }
                }*/
            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = edtFiltrar.getText().toString().toLowerCase(Locale.getDefault());
               mAdapter.filter(text);
            }
        });


    }
}
