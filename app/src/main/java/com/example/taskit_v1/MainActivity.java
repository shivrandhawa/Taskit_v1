package com.example.taskit_v1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save_btn = (Button) findViewById(R.id.goto_activity);
        final EditText et = (EditText) findViewById(R.id.editText);
        final TextView dt = (TextView) findViewById(R.id.displayText);
        Button createtaskbtn = (Button) findViewById(R.id.add_task_btn);

        createtaskbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent = new Intent(MainActivity.this,AddTask.class);
                startActivity(intent);

            }
        });

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = et.getText().toString();
                Log.e("Logging what is saved", data);
                dt.setText(data);
            }
        });
    }

}

