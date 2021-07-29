package com.example.biologiaapp.ui.coleccion;

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
import com.example.biologiaapp.databinding.FragmentColeccionBinding;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ColeccionFragment extends Fragment {

    private ColeccionViewModel coleccionViewModel;
    private FragmentColeccionBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        coleccionViewModel =
                new ViewModelProvider(this).get(ColeccionViewModel.class);

        binding = FragmentColeccionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = binding.recyclerview;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://473bb64523bf.ngrok.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONConsultas jsonConsultas = retrofit.create(JSONConsultas.class);
        Call<List<Coleccion>> call = jsonConsultas.getColeccion();
        call.enqueue(new Callback<List<Coleccion>>() {
            @Override
            public void onResponse(Call<List<Coleccion>> call, Response<List<Coleccion>> response) {
                if (!response.isSuccessful()){
                    return;
                }
                List<Coleccion> coleccionList = response.body();
                ColeccionAdapter coleccionAdapter = new ColeccionAdapter(getContext(), coleccionList);
                recyclerView.setAdapter(coleccionAdapter);
            }

            @Override
            public void onFailure(Call<List<Coleccion>> call, Throwable t) {

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