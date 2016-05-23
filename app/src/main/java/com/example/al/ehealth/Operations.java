package com.example.al.ehealth;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Random;


public class Operations extends ActionBarActivity {


    private Context thisContext = this;

    private String operacion;
    private int digito1, digito2, digito3, digito4;
    private int valor1, valor2, respuesta;

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b0;

    private Button bE;
    private Button bR;

    private Button bSig;

    private TextView textP;

    private int aciertos;
    private int preguntasSoFar = 0;
    private int contadorOperaciones = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations);

        contadorOperaciones = 0;

        b1 = (Button) findViewById(R.id.val1);
        b2 = (Button) findViewById(R.id.val2);
        b3 = (Button)findViewById(R.id.val3);
        b4 = (Button)findViewById(R.id.val4);
        b5 = (Button)findViewById(R.id.val5);
        b6 = (Button)findViewById(R.id.val6);
        b7 = (Button)findViewById(R.id.val7);
        b8 = (Button)findViewById(R.id.val8);
        b9 = (Button)findViewById(R.id.val9);
        b0 = (Button)findViewById(R.id.val0);

        bE = (Button)findViewById(R.id.valEn);
        bR = (Button)findViewById(R.id.valBo);

        textP = (TextView)findViewById(R.id.preguntaO);

        bSig = (Button)findViewById(R.id.valsiguiente);

        aciertos = 0;

        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                textP.setText(textP.getText()+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textP.setText(textP.getText()+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textP.setText(textP.getText()+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textP.setText(textP.getText()+"4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textP.setText(textP.getText()+"5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textP.setText(textP.getText()+"6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textP.setText(textP.getText()+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textP.setText(textP.getText()+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textP.setText(textP.getText()+"9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textP.setText(textP.getText()+"0");
            }
        });

        bR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if(textP.getText().charAt(textP.length()-1) != '=')
                {
                    textP.setText(textP.getText().subSequence(0,textP.length()-1));
                }
            }
        });
        bE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String res = (String) textP.getText().subSequence(10,textP.length());
                if (res.isEmpty())
                {
                    Toast.makeText(Operations.this, "Ingrese un valor por favor",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                int resI = Integer.parseInt(res);
                if(resI == respuesta)
                {
                    textP.setBackgroundColor(Color.GREEN);
                    Toast.makeText(Operations.this, "Correcto",
                            Toast.LENGTH_SHORT).show();
                    aciertos++;
                    if(preguntasSoFar<10){
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                generarNueva();
                            }
                        }, 1000);
                    }
                    else
                    {
                        MainActivity.puntaje_operaciones = aciertos / 10.0f;
                        finish();
                        Intent i = new Intent(thisContext, MainActivity.class);
                        startActivity(i);
                    }

                }
                else
                {
                    textP.setBackgroundColor(Color.RED);
                    Toast.makeText(Operations.this, "Incorrecto",
                            Toast.LENGTH_SHORT).show();
                    if(preguntasSoFar<10){
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                generarNueva();
                            }
                        }, 1000);
                    }
                    else{
                        MainActivity.puntaje_operaciones = aciertos / 10.0f;
                        finish();
                        Intent i = new Intent(thisContext, MainActivity.class);
                        startActivity(i);
                    }
                }

            }
        });
        bSig.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                generarNueva();
            }
        });

        generarNueva();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_operations, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void generarNueva()
    {
        contadorOperaciones++;
        //Coloca el color por defecto al TextView de la operacion
        textP.setBackgroundColor(0xFF000048);

        // Primero un random para el tipo de operacion
        Random r = new Random();
        int opT = r.nextInt(3);
        int dig1 = r.nextInt(1);
        int dig2 = r.nextInt(10);
        int dig3 = r.nextInt(1);
        int dig4 = r.nextInt(10);
        if(contadorOperaciones <= 5)
        {
            opT = r.nextInt(2);
            dig1 = r.nextInt(1);
            dig2 = r.nextInt(10);
            dig3 = r.nextInt(1);
            dig4 = r.nextInt(10);
        }
        else if(contadorOperaciones > 5)
        {
            opT = 2;//r.nextInt(2);
            dig1 = r.nextInt(1);
            dig2 = r.nextInt(10);
            dig3 = r.nextInt(10);
            dig4 = 10;//r.nextInt(10);
        }

        if (opT == 0) // Suma
        {
            operacion = "+";
            digito1 = dig1;
            digito2 = dig2;
            digito3 = dig3;
            digito4 = dig4;

            // Generacion de numeros completos
            valor1 = dig1*10 + dig2;
            valor2 = dig3*10 + dig4;
            //System.out.println("A------------>>"+valor2);
            //System.out.println("A------------>>"+valor1);

            // Generamos la respuesta
            respuesta = valor1 + valor2;
        }
        else if(opT == 1) // Resta
        {
            operacion = "-";
            digito1 = dig1;
            digito2 = dig2;
            digito3 = dig3;
            digito4 = dig4;
            // Generacion de numeros completos
            valor1 = dig1*10 + dig2;
            valor2 = dig3*10 + dig4;
            //System.out.println("A------------>>"+valor1);
            //System.out.println("A------------>>"+valor2);

            if(valor2>valor1) // esto daria un negativo lo que no queremos
            {
                int temp = valor2;
                int tempD1 = dig3;
                int tempD2 = dig4;
                valor2 = valor1;
                dig3 = dig1;
                dig4 = dig2;
                valor1 = temp;
                dig1 = tempD1;
                dig2 = tempD2;
                digito1 = dig1;
                digito2 = dig2;
                digito3 = dig3;
                digito4 = dig4;
            }
            System.out.println("B------------>>" + valor1);
            System.out.println("B------------>>"+valor2);

            respuesta = valor1 - valor2;
        }
        else if(opT == 2) // Multiplicacion
        {
            operacion = "x";
            digito1 = 0;
            digito2 = dig2;
            digito3 = dig3;
            digito4 = 0;

            valor1 = digito1*10 + dig2;
            valor2 = digito3*10 + dig4;

            System.out.println("A------------>>"+valor2);
            System.out.println("A------------>>"+valor1);

            respuesta = valor1 * valor2;
        }
        preguntasSoFar++;
        textP.setText(new DecimalFormat("00").format(valor1) +" "+operacion+" "+new DecimalFormat("00").format(valor2)+" = ");
    }
    public void cancel(View v){
        finish();
    }

}
