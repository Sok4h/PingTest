package com.sokah.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText uno,dos,tres,cuatro;
    Button ping,host;
    String ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uno=findViewById(R.id.uno);
        dos = findViewById(R.id.dos);
        tres = findViewById(R.id.tres);
        cuatro = findViewById(R.id.cuatro);
        ping = findViewById(R.id.buttonPing);
        host = findViewById(R.id.buttonHost);
        ping.setOnClickListener(this);
        host.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.buttonPing:

            ip=uno.getText().toString()+"."+dos.getText().toString()+"."+tres.getText().toString()+"."+cuatro.getText().toString();

                Intent intent= new Intent(this,resultado.class);
                intent.putExtra("Ip",ip);
                startActivity(intent);
                Log.e("TAG", ip);

                break;

            case R.id.buttonHost :

                Intent intent1= new Intent(this,HostActivity.class);
                startActivity(intent1);

                break;


        }

    }
}
