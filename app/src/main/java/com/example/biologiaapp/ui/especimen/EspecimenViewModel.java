package com.example.biologiaapp.ui.especimen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EspecimenViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public EspecimenViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is especimen fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}