package com.example.biologiaapp.ui.coleccion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biologiaapp.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ColeccionAdapter extends RecyclerView.Adapter<ColeccionAdapter.ColeccionViewHolder>{
    List<Coleccion> coleccionList;
    Context context;

    public ColeccionAdapter(Context context, List<Coleccion> coleccions){
        this.context = context;
        coleccionList = coleccions;
    }

    @NonNull
    @NotNull
    @Override
    public ColeccionViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_coleccion, parent, false);
        return new ColeccionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ColeccionAdapter.ColeccionViewHolder holder, int position) {
        Coleccion coleccion = coleccionList.get(position);
        holder.nombre.setText(coleccion.getNombreColeccion());
    }

    @Override
    public int getItemCount() {
        return coleccionList.size();
    }

    public class ColeccionViewHolder extends RecyclerView.ViewHolder{
        TextView nombre;


        public ColeccionViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.textView);
        }
    }
}
