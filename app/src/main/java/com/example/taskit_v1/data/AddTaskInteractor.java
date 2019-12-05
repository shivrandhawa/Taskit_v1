package com.example.taskit_v1.data;

import android.util.Log;

import com.example.taskit_v1.Contract;
import com.example.taskit_v1.GlobalVars;

import java.util.ArrayList;

public class AddTaskInteractor {

    GlobalVars g = GlobalVars.getInstance();

    private Contract.AddtaskListener addtaskListener;

    public AddTaskInteractor(Contract.AddtaskListener addtaskListener){
        this.addtaskListener = addtaskListener;
    }

    public  String getData(AddTaskModel model){

        if(hasError(model)){
            Log.e("add-task-interactor","to little charectors");
        }

        String task_string = model.getTask_data();
        return task_string;

    }

    public void addToArray(String task_string){
        g.setTasks(task_string);

    }

    private boolean hasError(AddTaskModel model){
        String task_string = model.getTask_data();
        if (task_string.length() < 3){
            addtaskListener.onFailed("asd");
            return true;
        }
        return false;
    }

}
