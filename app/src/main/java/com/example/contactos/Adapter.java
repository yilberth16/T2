package com.example.contactos;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.contactos.R;
import com.example.contactos.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Adapter extends BaseAdapter {

    private ArrayList<Usuario> arrayList;
    private List<Usuario> usuarioList = null;
    LayoutInflater inflater;
     Context context;

    private int resourceLayout;

    public Adapter(Context context,int resource, List<Usuario> usuariosList) {
        this.usuarioList = usuariosList;
        this.arrayList = new ArrayList<Usuario>();
        this.arrayList.addAll(usuariosList);
        this.context = context;
        this.resourceLayout = resource;

    }

    public  void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        usuarioList.clear();
        if (charText.length() == 0) {
            usuarioList.addAll(arrayList);
        }
        else
        {
            for (Usuario wp : arrayList)
            {
                if (wp.getNombre().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    usuarioList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

    public class ViewHolder{
        TextView  txt_nombre,txt_telefono,txt_grupo,txt_saldo;
    }

    @Override
    public int getCount() {
        return usuarioList.size();
    }

    @Override
    public Usuario getItem(int position) {
        return usuarioList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(resourceLayout,null);
            holder.txt_nombre = view.findViewById(R.id.txt_nombre);
            holder.txt_telefono = view.findViewById(R.id.txt_telefono);
            holder.txt_grupo = view.findViewById(R.id.txt_grupo);
            holder.txt_saldo = view.findViewById(R.id.txt_saldo);
            view.setTag(holder);

        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.txt_nombre.setText(usuarioList.get(position).getNombre());
        holder.txt_telefono.setText(usuarioList.get(position).getTelefono());
        holder.txt_grupo.setText(usuarioList.get(position).getAhorro());
        holder.txt_saldo.setText(usuarioList.get(position).getSaldo());




        return view;
    }



}
