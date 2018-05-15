package com.andres00099216.labo6_drawer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Andres on 14/5/2018.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuItemViewHolder>{

    private Context contexto;
    private List<modelo> list;

    public MenuAdapter(Context contexto){
        this.contexto = contexto;
        this.list = MainActivity.list;
    }

    @NonNull
    @Override
    public MenuItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(contexto);
        View view = inflater.inflate(R.layout.item_menu, parent, false);
        return  new MenuItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItemViewHolder holder, int position) {
        modelo item = list.get(position);
        holder.nombre.setText(item.getNombre());
        holder.descripcion.setText(item.getDescripcion());
        holder.foto.setImageResource(item.getFoto());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MenuItemViewHolder extends RecyclerView.ViewHolder{

        private TextView nombre;
        private TextView descripcion;
        private ImageView foto;

        public MenuItemViewHolder(View view){
            super(view);
            nombre = view.findViewById(R.id.nombre_comida);
            descripcion = view.findViewById(R.id.descripcion_comida);
            foto = view.findViewById(R.id.foto_comida);
        }
    }
}