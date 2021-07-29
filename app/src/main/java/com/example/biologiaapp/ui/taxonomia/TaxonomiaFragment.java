package com.example.biologiaapp.ui.taxonomia;

import android.graphics.Movie;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biologiaapp.ApiClient;
import com.example.biologiaapp.JSONConsultas;
import com.example.biologiaapp.databinding.FragmentTaxonomiaBinding;
import com.example.biologiaapp.ui.taxonomia.Taxonomia;
import com.example.biologiaapp.ui.taxonomia.TaxonomiaAdapter;
import com.example.biologiaapp.ui.taxonomia.TaxonomiaViewModel;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TaxonomiaFragment extends Fragment{

    private TaxonomiaViewModel taxonomiaViewModel;
    private FragmentTaxonomiaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        taxonomiaViewModel =
                new ViewModelProvider(this).get(TaxonomiaViewModel.class);

        binding = FragmentTaxonomiaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = binding.recyclerview;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://473bb64523bf.ngrok.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONConsultas jsonConsultas = retrofit.create(JSONConsultas.class);
        Call<List<Taxonomia>> call = jsonConsultas.getTaxonomia();
        call.enqueue(new Callback<List<Taxonomia>>() {
            @Override
            public void onResponse(Call<List<Taxonomia>> call, Response<List<Taxonomia>> response) {
                if (!response.isSuccessful()){
                    return;
                }
                List<Taxonomia> taxonomiaList = response.body();
                TaxonomiaAdapter taxonomiaAdapter = new TaxonomiaAdapter(getContext(), taxonomiaList);
                recyclerView.setAdapter(taxonomiaAdapter);
            }

            @Override
            public void onFailure(Call<List<Taxonomia>> call, Throwable t) {

            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
