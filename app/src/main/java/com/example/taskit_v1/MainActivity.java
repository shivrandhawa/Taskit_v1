package com.example.taskit_v1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save_btn = (Button) findViewById(R.id.save_btn);
        final EditText et = (EditText) findViewById(R.id.editText);
        final TextView dt = (TextView) findViewById(R.id.displayText);


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

