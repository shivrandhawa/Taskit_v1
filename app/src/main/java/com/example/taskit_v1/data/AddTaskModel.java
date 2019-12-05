package com.example.taskit_v1.data;

import com.example.taskit_v1.GlobalVars;

public class AddTaskModel {
    GlobalVars g = GlobalVars.getInstance();

    private String task_data;

    public AddTaskModel(String task_data) {
        this.task_data = task_data;
    }

    public String getTask_data() {
        return task_data;
    }

    public void addToArray(String task_string){
        g.setTasks(task_string);

    }
}
