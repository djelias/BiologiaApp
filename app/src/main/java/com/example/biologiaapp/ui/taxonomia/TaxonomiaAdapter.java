package com.example.biologiaapp.ui.taxonomia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biologiaapp.R;
import com.example.biologiaapp.ui.taxonomia.Taxonomia;
import com.example.biologiaapp.ui.taxonomia.TaxonomiaAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TaxonomiaAdapter extends RecyclerView.Adapter<TaxonomiaAdapter.TaxonomiaViewHolder>{
    List<Taxonomia> taxonomiaList;
    Context context;

    public TaxonomiaAdapter(Context context, List<Taxonomia> taxonomias){
        this.context = context;
        taxonomiaList = taxonomias;
    }

    @NonNull
    @NotNull
    @Override
    public TaxonomiaAdapter.TaxonomiaViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_taxonomia, parent, false);
        return new TaxonomiaAdapter.TaxonomiaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TaxonomiaAdapter.TaxonomiaViewHolder holder, int position) {
        Taxonomia taxonomia = taxonomiaList.get(position);
        holder.nombreComun.setText(taxonomia.getNombreComun());
        holder.numVoucher.setText(taxonomia.getNumVoucher());
        holder.colector.setText(taxonomia.getColector());
        holder.codigoEspecimen.setText(taxonomia.getCodigoEspecimen());
        holder.caracteristicas.setText(taxonomia.getCarcateristicas());
        holder.habitat.setText(taxonomia.getHabitat());
        holder.nombreEspecie.setText(taxonomia.getNombreEspecie());

    }

    @Override
    public int getItemCount() {
        return taxonomiaList.size();
    }

    public class TaxonomiaViewHolder extends RecyclerView.ViewHolder{
        TextView nombreComun;
        TextView numVoucher;
        TextView colector;
        TextView codigoEspecimen;
        TextView caracteristicas;
        TextView latitud;
        TextView longitud;
        TextView habitat;
        TextView nombreEspecie;

        public TaxonomiaViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

            nombreComun = itemView.findViewById(R.id.txtNombreComun);
            numVoucher = itemView.findViewById(R.id.txtNumVoucher);
            colector = itemView.findViewById(R.id.txtColector);
            codigoEspecimen = itemView.findViewById(R.id.txtcodigoEspecimen);
            caracteristicas = itemView.findViewById(R.id.txtCaracteristicas);
            habitat = itemView.findViewById(R.id.txtHabitat);
            nombreEspecie = itemView.findViewById(R.id.txtNombreEspecie);
        }
    }
}
