package com.example.taskit_v1;

import android.widget.DatePicker;

public interface Contract {

    interface  AddtaskView{
        void onDateSet(DatePicker view, int year, int month, int dayOfMonth);
        void onFailure(String message);


    }

    interface AddtaskListener{
        void onDateSet(DatePicker view, int year, int month, int dayOfMonth);
        void onFailed(String message);
    }

}
