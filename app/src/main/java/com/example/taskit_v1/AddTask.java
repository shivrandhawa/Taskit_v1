package com.example.taskit_v1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;

public class AddTask extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);





        final Button open_date = findViewById(R.id.open_date_pick);
        open_date.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DialogFragment datepicker = new DatePickerFragment();
                datepicker.show(getSupportFragmentManager(),"date picker");
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
