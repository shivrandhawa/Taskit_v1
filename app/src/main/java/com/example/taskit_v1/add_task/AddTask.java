package com.example.taskit_v1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.taskit_v1.main.MainActivity;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class AddTask extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    ArrayList<String> all_tasks = new ArrayList<String>();

    GlobalVars g = GlobalVars.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        final TextView create_text = findViewById(R.id.create_textbox);   //do i need this one i declare it down there aswell
       // final View post1 = findViewById(R.id.post1);
//        final TextView tv1 = findViewById(R.id.tv1);

        //open date picker using fragment
        final Button open_date = findViewById(R.id.open_date_pick);
        open_date.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DialogFragment datepicker = new DatePickerFragment();
                datepicker.show(getSupportFragmentManager(),"date picker");
            }
        });

        //post button now takes contents of textbox and logs it
        final Button post_btn = findViewById(R.id.post_btn);
        post_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String data = create_text.getText().toString();
                Log.e( "data from postbutton::",data );
                //tv1.setText(data);  doesnt work
                g.setTasks(data);
                all_tasks.add(data);
                String listString = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    listString = String.join(", ", g.getTasks());
                }

                Log.d( "onClasdsadick: ,",listString);

                Bundle bundle = new Bundle();       //bundles to send information from one activity to anther
                bundle.putString("data",all_tasks.toString()); //This is for a String
                Intent i=new Intent(AddTask.this, MainActivity.class);
                i.putExtras(bundle);
                startActivity(i);

            }
        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH,month);
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(cal.getTime());

        TextView create_text = findViewById(R.id.create_textbox);
        create_text.append(System.getProperty("line.separator"));
        create_text.append(System.getProperty("line.separator"));

        create_text.append(currentDateString);

    }



}
