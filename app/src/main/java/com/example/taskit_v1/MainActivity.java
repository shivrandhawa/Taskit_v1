package com.example.taskit_v1;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    LinearLayout mparent;
    LayoutInflater layoutInflater;
    GlobalVars g = GlobalVars.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save_btn = (Button) findViewById(R.id.goto_activity);
        final EditText et = (EditText) findViewById(R.id.editText);
        final TextView dt = (TextView) findViewById(R.id.displayText);
        Button createtaskbtn = (Button) findViewById(R.id.add_task_btn);

        mparent = findViewById(R.id.mparent);
        layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);


        Bundle extras = getIntent().getExtras();
        @SuppressLint("NewApi") String listString = String.join(", ", g.getTasks());
        String str = String.valueOf(g.getSize());
        Log.e( "arraylistcontents: ", listString);
        Log.e( "arraylistcontents: ", str);

        if (g.getSize()>0){

            for(int i =0; i< g.getSize();i++){
                View myview = layoutInflater.inflate(R.layout.myrow,null,false);
                View layout = layoutInflater.inflate(R.layout.myrow,null,false);

                TextView textView = (TextView) layout.findViewById(R.id.postid);
//                textView.setId(x);
//                View.generateViewId();
                textView.setText(g.getTasks().get(i));
                ViewGroup insertpoint = (ViewGroup) findViewById(R.id.mparent);
                insertpoint.addView(layout,0,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));


//                TextView t1 = new TextView(this);
//
//                t1.setText(g.getTasks().get(x));
//                Log.e( "t1.settext: ", g.getTasks().get(x));
//
//                mparent.addView(t1);
//                mparent.addView(myview);


            }

        }





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

