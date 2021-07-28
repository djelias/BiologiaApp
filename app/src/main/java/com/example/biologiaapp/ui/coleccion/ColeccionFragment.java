package com.example.biologiaapp.ui.coleccion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.biologiaapp.databinding.FragmentColeccionBinding;

public class ColeccionFragment extends Fragment {

    private ColeccionViewModel coleccionViewModel;
    private FragmentColeccionBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        coleccionViewModel =
                new ViewModelProvider(this).get(ColeccionViewModel.class);

        binding = FragmentColeccionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textColeccion;
        coleccionViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
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