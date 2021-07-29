package com.example.biologiaapp.ui.taxonomia;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TaxonomiaViewModel extends ViewModel{

    private MutableLiveData<String> mText;

    public TaxonomiaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is taxonomia fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
