package com.example.biologiaapp.ui.coleccion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ColeccionViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ColeccionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is coleccion fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}