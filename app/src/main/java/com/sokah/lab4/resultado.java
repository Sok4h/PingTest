package com.sokah.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class resultado extends AppCompatActivity {

    TextView resultadoPing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        resultadoPing = findViewById(R.id.resultadoPing);
        String resultado;
        String Ip = getIntent().getExtras().getString("Ip");

        new Thread(

                () ->{

                    try {
                        int prueba = 0;
                         while (prueba<6){
                        InetAddress inetAddress = InetAddress.getByName(Ip);
                        boolean isReachable = inetAddress.isReachable(1000);
                        Thread.sleep(2000);
                        Log.e("TAG", "" + isReachable);
                        if (isReachable) {

                            runOnUiThread(() ->

                                    {
                                        resultadoPing.setText(resultadoPing.getText().toString() + "Recibido\n");
                                    }

                            );
                        } else {

                            runOnUiThread(
                                    () -> {

                                        resultadoPing.setText(resultadoPing.getText().toString() + "Perdido \n");
                                    }

                            );
                        }

                        prueba++;
                    }
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                ).start();
    }
}