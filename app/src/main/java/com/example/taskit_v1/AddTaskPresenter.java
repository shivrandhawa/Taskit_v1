package com.example.taskit_v1;

import android.util.Log;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.taskit_v1.data.AddTaskInteractor;
import com.example.taskit_v1.data.AddTaskModel;
import com.example.taskit_v1.view.AddTask;

public class AddTaskPresenter implements Contract.AddtaskListener {

    private Contract.AddtaskView addtaskView;

    private AddTaskInteractor addTaskInteractor;


    public AddTaskPresenter(Contract.AddtaskView addtaskView){
        this.addtaskView=addtaskView;
        addTaskInteractor = new AddTaskInteractor(this);
    }




    public void start(AddTaskModel model){
        addTaskInteractor.getData(model);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Log.e("tago","adasdasdsad");
    }

    @Override
    public void onFailed(String message) {

    }


}
