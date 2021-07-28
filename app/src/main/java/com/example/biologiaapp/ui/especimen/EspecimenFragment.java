package com.example.biologiaapp.ui.especimen;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.biologiaapp.databinding.FragmentEspecimenBinding;

public class EspecimenFragment extends Fragment {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private EspecimenViewModel especimenViewModel;
    private FragmentEspecimenBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        especimenViewModel =
                new ViewModelProvider(this).get(EspecimenViewModel.class);

        binding = FragmentEspecimenBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCamara();
            }
        });
        
        return root;
    }

    private void abrirCamara() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}