package com.example.taskit_v1;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerNonConfig;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
        @SuppressLint({"NewApi", "LocalSuppress"}) String listString = String.join(", ", g.getTasks());
        String str = String.valueOf(g.getSize());
        Log.e( "arraylistcontents: ", listString);
        Log.e( "arraylistcontents: ", str);

        if (g.getSize()>0){

            for(int i =0; i< g.getSize();i++){
                View myview = layoutInflater.inflate(R.layout.myrow,null,false);
                View layout = layoutInflater.inflate(R.layout.myrow,null,false);

                layout.setId(i);
                layout.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View layout){
                        Log.e("onClick: ","Layoutclick" );
                        FragmentManager fm = getSupportFragmentManager();
                        TaskFragment fragment = new TaskFragment();
                        fm.beginTransaction().replace(R.id.Container,fragment).commit();
                     for(int i=0 ; i<g.getSize();i++){
//                         DialogBox.setDialog(g.getTasks().get(i));

                         String ss = g.getTasks().get(i);
                         openDialog(ss);
                     }



                    }
                });
                TextView textView = (TextView) layout.findViewById(R.id.postid);
                textView.setText(g.getTasks().get(i));
                textView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
//                        Log.e("onClick: ","clicklcikclsickclickclick" );
                    }
                });
                ViewGroup insertpoint = (ViewGroup) findViewById(R.id.mparent);
                insertpoint.addView(layout,0,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));


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
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                TaskFragment taskfrag = new TaskFragment();

                fragmentTransaction.add(R.id.Container,taskfrag);
                fragmentTransaction.commit();

                dt.setText(data);
            }
        });
    }
public void openDialog(String s){
        DialogBox dialog = new DialogBox(s);

        dialog.show(getSupportFragmentManager(),"example dialog");
}
}

