package com.example.taskit_v1;

import java.util.ArrayList;

public class GlobalVars {

    private static GlobalVars instance;
    static ArrayList<String> all_tasks2 = new ArrayList<String>();

    private GlobalVars(){}

    public void setTasks(String s){
        GlobalVars.all_tasks2.add(s);
    }

    public ArrayList<String> getTasks(){
        return GlobalVars.all_tasks2;
    }

    public int getSize(){
        return all_tasks2.size();
    }

    public static synchronized GlobalVars getInstance(){
        if(instance==null){
            instance=new GlobalVars();
        }
        return instance;
    }


}
