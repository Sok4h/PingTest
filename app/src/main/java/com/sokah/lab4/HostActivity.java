package com.sokah.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostActivity extends AppCompatActivity {

    String ipValida;
    int ip;
    TextView textView;
    Button regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);
        textView= findViewById(R.id.ipHost);
        ipValida="192.168.0.";
        ip=1;
        regresar= findViewById(R.id.buttonRegresar);

        regresar.setOnClickListener(

                v ->{

            finish();
        }

        );


        new Thread(

                ()->{
                    while (ip<255){

                    String datoFinal=Integer.toString(ip);

                        try {

                            Thread.sleep(1000);
                            InetAddress inetAddress = InetAddress.getByName(ipValida+""+datoFinal);
                            Boolean isReachable = inetAddress.isReachable(1000);
                            if(isReachable){

                            runOnUiThread(

                                    () -> {

                                    textView.setText(textView.getText().toString()+""+ipValida+""+datoFinal+"\n");


                                    }
                            );

                            }
                            else {

                                Log.e("TAG", "false"+ip );
                            }
                            ip++;
                        }

                        catch (UnknownHostException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }

                }
        ).start();


        if(ip==254){


            Toast.makeText(this, "prueba terminada", Toast.LENGTH_SHORT).show();
        }


    }
}
