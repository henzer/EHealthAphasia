package com.example.al.ehealth;

import android.content.DialogInterface;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.Random;


public class Operations extends ActionBarActivity {

    private VideoView video;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private Uri uN1D1;
    private Uri uN1D2;
    private Uri uS;
    private Uri uN2D1;
    private Uri uN2D2;
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

    private TextView textR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations);
        //video = (VideoView)findViewById(R.id.videoView);
        image1 = (ImageView)findViewById(R.id.num1digit1);
        image2 = (ImageView)findViewById(R.id.num1digit2);
        image3 = (ImageView)findViewById(R.id.op);
        image4 = (ImageView)findViewById(R.id.num2digit1);
        image5 = (ImageView)findViewById(R.id.num2digit2);
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

        bE = (Button)findViewById(R.id.valE);
        bR = (Button)findViewById(R.id.valR);

        textR = (TextView)findViewById(R.id.textR);

        bSig = (Button)findViewById(R.id.valSiguiente);

        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                textR.setText(textR.getText()+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textR.setText(textR.getText()+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textR.setText(textR.getText()+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textR.setText(textR.getText()+"4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textR.setText(textR.getText()+"5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textR.setText(textR.getText()+"6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textR.setText(textR.getText()+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textR.setText(textR.getText()+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textR.setText(textR.getText()+"9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textR.setText(textR.getText()+"0");
            }
        });

        bR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if(textR.getText().charAt(textR.length()-1) != ':')
                {
                    textR.setText(textR.getText().subSequence(0,textR.length()-1));
                }
            }
        });
        bE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String res = (String) textR.getText().subSequence(10,textR.length());
                int resI = Integer.parseInt(res);
                System.out.println("--------------->>"+valor1);
                System.out.println("--------------->>"+valor2);
                System.out.println("--------------->>"+respuesta);
                if(resI == respuesta)
                {
                    Toast.makeText(Operations.this, "Correcto",
                            Toast.LENGTH_SHORT).show();
                    generarNueva();
                }
                else
                {
                    Toast.makeText(Operations.this, "Incorrecto",
                            Toast.LENGTH_SHORT).show();
                    generarNueva();
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
        textR.setText("Respuesta:");
        // Primero un random para el tipo de operacion
        Random r = new Random();
        int opT = r.nextInt(3);
        int dig1 = r.nextInt(10);
        int dig2 = r.nextInt(10);
        int dig3 = r.nextInt(10);
        int dig4 = r.nextInt(10);
        if (opT == 0) // Suma
        {
            operacion = "suma";
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
            operacion = "resta";
            digito1 = dig1;
            digito2 = dig2;
            digito3 = dig3;
            digito4 = dig4;
            // Generacion de numeros completos
            valor1 = dig1*10 + dig2;
            valor2 = dig3*10 + dig4;
            System.out.println("A------------>>"+valor1);
            System.out.println("A------------>>"+valor2);

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
            operacion = "mult";
            digito1 = 0;
            digito2 = dig2;
            digito3 = 0;
            digito4 = dig4;

            valor1 = digito1*10 + dig2;
            valor2 = digito3*10 + dig4;

            //System.out.println("A------------>>"+valor2);
            //System.out.println("A------------>>"+valor1);

            respuesta = valor1 * valor2;
        }

        // Digito 1 del primer numero
        if(digito1 == 0)
        {
            uN1D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.cero);
        }
        else if(digito1 == 1)
        {
            uN1D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.uno);
        }
        else if(digito1 == 2)
        {
            uN1D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.dos);
        }
        else if(digito1 == 3)
        {
            uN1D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.tres);
        }
        else if(digito1 == 4)
        {
            uN1D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.cuatro);
        }
        else if(digito1 == 5)
        {
            uN1D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.cinco);
        }
        else if(digito1 == 6)
        {
            uN1D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.seis);
        }
        else if(digito1 == 7)
        {
            uN1D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.siete);
        }
        else if(digito1 == 8)
        {
            uN1D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.ocho);
        }
        else if(digito1 == 9)
        {
            uN1D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.nueve);
        }

        // Digito 2 del primer numero
        if(digito2 == 0)
        {
            uN1D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.cero);
        }
        else if(digito2 == 1)
        {
            uN1D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.uno);
        }
        else if(digito2 == 2)
        {
            uN1D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.dos);
        }
        else if(digito2 == 3)
        {
            uN1D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.tres);
        }
        else if(digito2 == 4)
        {
            uN1D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.cuatro);
        }
        else if(digito2 == 5)
        {
            uN1D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.cinco);
        }
        else if(digito2 == 6)
        {
            uN1D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.seis);
        }
        else if(digito2 == 7)
        {
            uN1D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.siete);
        }
        else if(digito2 == 8)
        {
            uN1D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.ocho);
        }
        else if(digito2 == 9)
        {
            uN1D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.nueve);
        }

        // Digito 1 del segundo numero
        if(digito3 == 0)
        {
            uN2D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.cero);
        }
        else if(digito3 == 1)
        {
            uN2D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.uno);
        }
        else if(digito3 == 2)
        {
            uN2D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.dos);
        }
        else if(digito3 == 3)
        {
            uN2D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.tres);
        }
        else if(digito3 == 4)
        {
            uN2D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.cuatro);
        }
        else if(digito3 == 5)
        {
            uN2D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.cinco);
        }
        else if(digito3 == 6)
        {
            uN2D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.seis);
        }
        else if(digito3 == 7)
        {
            uN2D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.siete);
        }
        else if(digito3 == 8)
        {
            uN2D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.ocho);
        }
        else if(digito3 == 9)
        {
            uN2D1 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.nueve);
        }

        // Digito 2 del segundo numero
        if(digito4 == 0)
        {
            uN2D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.cero);
        }
        else if(digito4 == 1)
        {
            uN2D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.uno);
        }
        else if(digito4 == 2)
        {
            uN2D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.dos);
        }
        else if(digito4 == 3)
        {
            uN2D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.tres);
        }
        else if(digito4 == 4)
        {
            uN2D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.cuatro);
        }
        else if(digito4 == 5)
        {
            uN2D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.cinco);
        }
        else if(digito4 == 6)
        {
            uN2D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.seis);
        }
        else if(digito4 == 7)
        {
            uN2D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.siete);
        }
        else if(digito4 == 8)
        {
            uN2D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.ocho);
        }
        else if(digito4 == 9)
        {
            uN2D2 = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.nueve);
        }

        // simbolo
        if(operacion.equals("suma"))
        {
            uS = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.mas);
        }
        else if(operacion.equals("resta"))
        {
            uS = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.menos);
        }
        else if(operacion.equals("mult"))
        {
            uS = Uri.parse("android.resource://com.example.al.ehealth/" + R.raw.por);
        }

        // El seteo de imagenes
        image1.setImageURI(uN1D1);
        image2.setImageURI(uN1D2);
        image3.setImageURI(uS);
        image4.setImageURI(uN2D1);
        image5.setImageURI(uN2D2);

    }

}
