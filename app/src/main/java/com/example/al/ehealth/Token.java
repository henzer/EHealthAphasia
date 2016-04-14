package com.example.al.ehealth;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class Token extends ActionBarActivity {

    private Context thisContext = this;

    //Text View de Pregunta
    private TextView pregunta;

    //OPciones
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    //Siguiente o cancelar
    private Button buttonCancel;
    private Button buttonNext;

    //Posibles formas y colores
    private String[] formas = {"Circulo", "Cuadrado"};
    private String[] colores = {"Verde", "Blanco", "Rojo", "Azul", "Amarillo"};
    private int preguntasSoFar = 0;

    //Formas y colores ya preguntados
    private ArrayList<Integer> yaPreguntadas = new ArrayList<Integer>();
    private ArrayList<String> imagenesTokens = new ArrayList<String>();

    //Boton con la respuesta actual
    private String botonRespuesta;

    //Brandon
    private Random r = new Random();

    //Puntaje
    private int aciertos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token);

        //Cargar text view
        pregunta = (TextView)findViewById(R.id.pregunta);

        //Cargar Botones
        button1 = (Button)findViewById(R.id.option1);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                preguntasSoFar++;
                if(botonRespuesta.equals("option1")){
                    //correcta
                    Toast t = Toast.makeText(getApplicationContext(), "¡OK!", Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                    aciertos++;
                }
                else{
                    //incorrecta
                    Toast t = Toast.makeText(getApplicationContext(), "¡Respuesta Incorrecta!", Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                }
                if(preguntasSoFar<10){
                    loadNewQuery();
                }
            }
        });
        button2 = (Button)findViewById(R.id.option2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                preguntasSoFar++;
                if(botonRespuesta.equals("option2")){
                    //correcta
                    Toast t = Toast.makeText(getApplicationContext(), "¡OK!", Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                    aciertos++;
                }
                else{
                    //incorrecta
                    Toast t = Toast.makeText(getApplicationContext(), "¡Respuesta Incorrecta!", Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                }
                if(preguntasSoFar<10){
                    loadNewQuery();
                }
            }
        });
        button3 = (Button)findViewById(R.id.option3);
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                preguntasSoFar++;
                if(botonRespuesta.equals("option3")){
                    //correcta
                    Toast t = Toast.makeText(getApplicationContext(), "¡OK!", Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                    aciertos++;
                }
                else{
                    //incorrecta
                    Toast t = Toast.makeText(getApplicationContext(), "¡Respuesta Incorrecta!", Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                }
                if(preguntasSoFar<10){
                    loadNewQuery();
                }
            }
        });
        button4 = (Button)findViewById(R.id.option4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                preguntasSoFar++;
                if(preguntasSoFar<=10){
                    if (botonRespuesta.equals("option4")) {
                        //correcta
                        Toast t = Toast.makeText(getApplicationContext(), "¡OK!", Toast.LENGTH_SHORT);
                        t.setGravity(Gravity.CENTER, 0, 0);
                        t.show();
                        aciertos++;
                    } else {
                        //incorrecta
                        Toast t = Toast.makeText(getApplicationContext(), "¡Respuesta Incorrecta!", Toast.LENGTH_SHORT);
                        t.setGravity(Gravity.CENTER, 0, 0);
                        t.show();
                    }
                }
                if(preguntasSoFar<10){
                    loadNewQuery();
                }
            }
        });

        buttonCancel = (Button)findViewById(R.id.cancelar);
        buttonNext = (Button)findViewById(R.id.siguiente);
        buttonNext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                //cargar nueva pregunta e imagen
                preguntasSoFar++;
                if(preguntasSoFar>10){
                    finish();
                    Intent i = new Intent(thisContext, MainActivity.class);
                    startActivity(i);
                }
                else{
                    loadNewQuery();
                }
            }
        });


        //Cargar primera pregunta random
        int indice1 = r.nextInt(2);
        int indice2 = r.nextInt(5);
        int indiceUnico = indice1*10 + indice2;
        String formaInicial = formas[indice1];
        String colorInicial = colores[indice2];

        //Almacenar a Ya preguntadas la combinacion
        String[] temp = {formaInicial, colorInicial};
        yaPreguntadas.add(indiceUnico);

        //cargar pregunta
        pregunta.setText("Seleccione un " + formaInicial + " color " + colorInicial);

        //cargar imagen respuesta a boton random
        int respRand = r.nextInt(4)+1;

        if(formaInicial.equals("Circulo")){
            //Circulo
            if(colorInicial.equals("Verde")){
                //Verde
                if(respRand==1) {
                    //almacenar el id del boton de la respuesta actual
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.circlegreen);
                    //button1.set
                    button2.setBackgroundResource(R.drawable.cur);
                    button3.setBackgroundResource(R.drawable.cw);
                    button4.setBackgroundResource(R.drawable.cub);
                }
                else if(respRand==2) {
                    //almacenar el id del boton de la respuesta actual
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.cur);
                    button2.setBackgroundResource(R.drawable.circlegreen);
                    button3.setBackgroundResource(R.drawable.cw);
                    button4.setBackgroundResource(R.drawable.cub);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.cw);
                    button2.setBackgroundResource(R.drawable.cur);
                    button3.setBackgroundResource(R.drawable.circlegreen);
                    button4.setBackgroundResource(R.drawable.cub);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.cub);
                    button2.setBackgroundResource(R.drawable.cur);
                    button3.setBackgroundResource(R.drawable.cw);
                    button4.setBackgroundResource(R.drawable.circlegreen);
                }
            }
            else if(colorInicial.equals("Amarillo")){
                //Amarillo
                if(respRand==1) {
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.cy);
                    button2.setBackgroundResource(R.drawable.cub);
                    button3.setBackgroundResource(R.drawable.circlegreen);
                    button4.setBackgroundResource(R.drawable.cur);
                }
                else if(respRand==2) {
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.cub);
                    button2.setBackgroundResource(R.drawable.cy);
                    button3.setBackgroundResource(R.drawable.circlegreen);
                    button4.setBackgroundResource(R.drawable.cur);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.circlegreen);
                    button2.setBackgroundResource(R.drawable.cub);
                    button3.setBackgroundResource(R.drawable.cy);
                    button4.setBackgroundResource(R.drawable.cur);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.cur);
                    button2.setBackgroundResource(R.drawable.cub);
                    button3.setBackgroundResource(R.drawable.circlegreen);
                    button4.setBackgroundResource(R.drawable.cy);
                }
            }
            else if(colorInicial.equals("Blanco")){
                //Blanco
                if(respRand==1) {
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.cw);
                    button2.setBackgroundResource(R.drawable.cug);
                    button3.setBackgroundResource(R.drawable.cr);
                    button4.setBackgroundResource(R.drawable.cuy);
                }
                else if(respRand==2) {
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.cug);
                    button2.setBackgroundResource(R.drawable.cw);
                    button3.setBackgroundResource(R.drawable.cr);
                    button4.setBackgroundResource(R.drawable.cuy);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.cr);
                    button2.setBackgroundResource(R.drawable.cug);
                    button3.setBackgroundResource(R.drawable.cw);
                    button4.setBackgroundResource(R.drawable.cuy);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.cr);
                    button2.setBackgroundResource(R.drawable.cug);
                    button3.setBackgroundResource(R.drawable.cuy);
                    button4.setBackgroundResource(R.drawable.cw);
                }
            }
            else if(colorInicial.equals("Azul")){
                //Azul
                if(respRand==1) {
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.cb);
                    button2.setBackgroundResource(R.drawable.cuw);
                    button3.setBackgroundResource(R.drawable.circlegreen);
                    button4.setBackgroundResource(R.drawable.cur);
                }
                else if(respRand==2) {
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.cuw);
                    button2.setBackgroundResource(R.drawable.cb);
                    button3.setBackgroundResource(R.drawable.circlegreen);
                    button4.setBackgroundResource(R.drawable.cur);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.circlegreen);
                    button2.setBackgroundResource(R.drawable.cuw);
                    button3.setBackgroundResource(R.drawable.cb);
                    button4.setBackgroundResource(R.drawable.cur);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.cur);
                    button2.setBackgroundResource(R.drawable.cuw);
                    button3.setBackgroundResource(R.drawable.circlegreen);
                    button4.setBackgroundResource(R.drawable.cb);
                }
            }
            else if(colorInicial.equals("Rojo")){
                //Rojo
                if(respRand==1) {
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.cr);
                    button2.setBackgroundResource(R.drawable.cub);
                    button3.setBackgroundResource(R.drawable.cw);
                    button4.setBackgroundResource(R.drawable.cug);
                }
                else if(respRand==2) {
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.cub);
                    button2.setBackgroundResource(R.drawable.cr);
                    button3.setBackgroundResource(R.drawable.cw);
                    button4.setBackgroundResource(R.drawable.cug);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.cw);
                    button2.setBackgroundResource(R.drawable.cub);
                    button3.setBackgroundResource(R.drawable.cr);
                    button4.setBackgroundResource(R.drawable.cug);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.cug);
                    button2.setBackgroundResource(R.drawable.cub);
                    button3.setBackgroundResource(R.drawable.cw);
                    button4.setBackgroundResource(R.drawable.cr);
                }
            }
        }
        else{
            //Cuadrado
            if(colorInicial.equals("Verde")){
                //Verde
                if(respRand==1) {
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.cug);
                    button2.setBackgroundResource(R.drawable.cr);
                    button3.setBackgroundResource(R.drawable.cuw);
                    button4.setBackgroundResource(R.drawable.cb);
                }
                else if(respRand==2) {
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.cr);
                    button2.setBackgroundResource(R.drawable.cug);
                    button3.setBackgroundResource(R.drawable.cuw);
                    button4.setBackgroundResource(R.drawable.cb);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.cuw);
                    button2.setBackgroundResource(R.drawable.cr);
                    button3.setBackgroundResource(R.drawable.cug);
                    button4.setBackgroundResource(R.drawable.cb);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.cb);
                    button2.setBackgroundResource(R.drawable.cr);
                    button3.setBackgroundResource(R.drawable.cuw);
                    button4.setBackgroundResource(R.drawable.cug);
                }
            }
            else if(colorInicial.equals("Amarillo")){
                //Amarillo
                if(respRand==1) {
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.cuy);
                    button2.setBackgroundResource(R.drawable.cb);
                    button3.setBackgroundResource(R.drawable.cug);
                    button4.setBackgroundResource(R.drawable.cr);
                }
                else if(respRand==2) {
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.cb);
                    button2.setBackgroundResource(R.drawable.cuy);
                    button3.setBackgroundResource(R.drawable.cug);
                    button4.setBackgroundResource(R.drawable.cr);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.cug);
                    button2.setBackgroundResource(R.drawable.cb);
                    button3.setBackgroundResource(R.drawable.cuy);
                    button4.setBackgroundResource(R.drawable.cr);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.cr);
                    button2.setBackgroundResource(R.drawable.cb);
                    button3.setBackgroundResource(R.drawable.cug);
                    button4.setBackgroundResource(R.drawable.cuy);
                }
            }
            else if(colorInicial.equals("Blanco")){
                //Blanco
                if(respRand==1) {
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.cuw);
                    button2.setBackgroundResource(R.drawable.circlegreen);
                    button3.setBackgroundResource(R.drawable.cur);
                    button4.setBackgroundResource(R.drawable.cy);
                }
                else if(respRand==2) {
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.circlegreen);
                    button2.setBackgroundResource(R.drawable.cuw);
                    button3.setBackgroundResource(R.drawable.cur);
                    button4.setBackgroundResource(R.drawable.cy);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.cur);
                    button2.setBackgroundResource(R.drawable.circlegreen);
                    button3.setBackgroundResource(R.drawable.cuw);
                    button4.setBackgroundResource(R.drawable.cy);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.cur);
                    button2.setBackgroundResource(R.drawable.circlegreen);
                    button3.setBackgroundResource(R.drawable.cy);
                    button4.setBackgroundResource(R.drawable.cuw);
                }
            }
            else if(colorInicial.equals("Azul")){
                //Azul
                if(respRand==1) {
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.cub);
                    button2.setBackgroundResource(R.drawable.cw);
                    button3.setBackgroundResource(R.drawable.cug);
                    button4.setBackgroundResource(R.drawable.cr);
                }
                else if(respRand==2) {
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.cw);
                    button2.setBackgroundResource(R.drawable.cub);
                    button3.setBackgroundResource(R.drawable.cug);
                    button4.setBackgroundResource(R.drawable.cr);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.cug);
                    button2.setBackgroundResource(R.drawable.cw);
                    button3.setBackgroundResource(R.drawable.cub);
                    button4.setBackgroundResource(R.drawable.cr);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.cr);
                    button2.setBackgroundResource(R.drawable.cw);
                    button3.setBackgroundResource(R.drawable.cug);
                    button4.setBackgroundResource(R.drawable.cub);
                }
            }
            else if(colorInicial.equals("Rojo")){
                //Rojo
                if(respRand==1) {
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.cur);
                    button2.setBackgroundResource(R.drawable.cb);
                    button3.setBackgroundResource(R.drawable.cuw);
                    button4.setBackgroundResource(R.drawable.circlegreen);
                }
                else if(respRand==2) {
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.cb);
                    button2.setBackgroundResource(R.drawable.cur);
                    button3.setBackgroundResource(R.drawable.cuw);
                    button4.setBackgroundResource(R.drawable.circlegreen);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.cuw);
                    button2.setBackgroundResource(R.drawable.cb);
                    button3.setBackgroundResource(R.drawable.cur);
                    button4.setBackgroundResource(R.drawable.circlegreen);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.circlegreen);
                    button2.setBackgroundResource(R.drawable.cb);
                    button3.setBackgroundResource(R.drawable.cuw);
                    button4.setBackgroundResource(R.drawable.cur);
                }
            }
        }
    }

    private void loadNewQuery(){

        //Cargar primera pregunta random
        int indice1, indice2, indiceUnico;
        do{
            indice1 = r.nextInt(2);
            indice2 = r.nextInt(5);
            indiceUnico = indice1*10 + indice2;
        }while(yaPreguntadas.contains(indiceUnico));



        String formaInicial = formas[indice1];
        String colorInicial = colores[indice2];

        //Almacenar a Ya preguntadas la combinacion
        String[] temp = {formaInicial, colorInicial};
        yaPreguntadas.add(indiceUnico);

        //cargar pregunta
        pregunta.setText("Seleccione un " + formaInicial + " color " + colorInicial);

        //cargar imagen respuesta a boton random
        int respRand = r.nextInt(4)+1;

        if(formaInicial.equals("Circulo")){
            //Circulo
            if(colorInicial.equals("Verde")){
                //Verde
                if(respRand==1) {
                    //almacenar el id del boton de la respuesta actual
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.circlegreen);
                    button2.setBackgroundResource(R.drawable.cur);
                    button3.setBackgroundResource(R.drawable.cw);
                    button4.setBackgroundResource(R.drawable.cub);
                }
                else if(respRand==2) {
                    //almacenar el id del boton de la respuesta actual
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.cur);
                    button2.setBackgroundResource(R.drawable.circlegreen);
                    button3.setBackgroundResource(R.drawable.cw);
                    button4.setBackgroundResource(R.drawable.cub);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.cw);
                    button2.setBackgroundResource(R.drawable.cur);
                    button3.setBackgroundResource(R.drawable.circlegreen);
                    button4.setBackgroundResource(R.drawable.cub);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.cub);
                    button2.setBackgroundResource(R.drawable.cur);
                    button3.setBackgroundResource(R.drawable.cw);
                    button4.setBackgroundResource(R.drawable.circlegreen);
                }
            }
            else if(colorInicial.equals("Amarillo")){
                //Amarillo
                if(respRand==1) {
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.cy);
                    button2.setBackgroundResource(R.drawable.cub);
                    button3.setBackgroundResource(R.drawable.circlegreen);
                    button4.setBackgroundResource(R.drawable.cur);
                }
                else if(respRand==2) {
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.cub);
                    button2.setBackgroundResource(R.drawable.cy);
                    button3.setBackgroundResource(R.drawable.circlegreen);
                    button4.setBackgroundResource(R.drawable.cur);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.circlegreen);
                    button2.setBackgroundResource(R.drawable.cub);
                    button3.setBackgroundResource(R.drawable.cy);
                    button4.setBackgroundResource(R.drawable.cur);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.cur);
                    button2.setBackgroundResource(R.drawable.cub);
                    button3.setBackgroundResource(R.drawable.circlegreen);
                    button4.setBackgroundResource(R.drawable.cy);
                }
            }
            else if(colorInicial.equals("Blanco")){
                //Blanco
                if(respRand==1) {
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.cw);
                    button2.setBackgroundResource(R.drawable.cug);
                    button3.setBackgroundResource(R.drawable.cr);
                    button4.setBackgroundResource(R.drawable.cuy);
                }
                else if(respRand==2) {
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.cug);
                    button2.setBackgroundResource(R.drawable.cw);
                    button3.setBackgroundResource(R.drawable.cr);
                    button4.setBackgroundResource(R.drawable.cuy);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.cr);
                    button2.setBackgroundResource(R.drawable.cug);
                    button3.setBackgroundResource(R.drawable.cw);
                    button4.setBackgroundResource(R.drawable.cuy);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.cr);
                    button2.setBackgroundResource(R.drawable.cug);
                    button3.setBackgroundResource(R.drawable.cuy);
                    button4.setBackgroundResource(R.drawable.cw);
                }
            }
            else if(colorInicial.equals("Azul")){
                //Azul
                if(respRand==1) {
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.cb);
                    button2.setBackgroundResource(R.drawable.cuw);
                    button3.setBackgroundResource(R.drawable.circlegreen);
                    button4.setBackgroundResource(R.drawable.cur);
                }
                else if(respRand==2) {
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.cuw);
                    button2.setBackgroundResource(R.drawable.cb);
                    button3.setBackgroundResource(R.drawable.circlegreen);
                    button4.setBackgroundResource(R.drawable.cur);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.circlegreen);
                    button2.setBackgroundResource(R.drawable.cuw);
                    button3.setBackgroundResource(R.drawable.cb);
                    button4.setBackgroundResource(R.drawable.cur);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.cur);
                    button2.setBackgroundResource(R.drawable.cuw);
                    button3.setBackgroundResource(R.drawable.circlegreen);
                    button4.setBackgroundResource(R.drawable.cb);
                }
            }
            else if(colorInicial.equals("Rojo")){
                //Rojo
                if(respRand==1) {
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.cr);
                    button2.setBackgroundResource(R.drawable.cub);
                    button3.setBackgroundResource(R.drawable.cw);
                    button4.setBackgroundResource(R.drawable.cug);
                }
                else if(respRand==2) {
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.cub);
                    button2.setBackgroundResource(R.drawable.cr);
                    button3.setBackgroundResource(R.drawable.cw);
                    button4.setBackgroundResource(R.drawable.cug);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.cw);
                    button2.setBackgroundResource(R.drawable.cub);
                    button3.setBackgroundResource(R.drawable.cr);
                    button4.setBackgroundResource(R.drawable.cug);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.cug);
                    button2.setBackgroundResource(R.drawable.cub);
                    button3.setBackgroundResource(R.drawable.cw);
                    button4.setBackgroundResource(R.drawable.cr);
                }
            }
        }
        else{
            //Cuadrado
            if(colorInicial.equals("Verde")){
                //Verde
                if(respRand==1) {
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.cug);
                    button2.setBackgroundResource(R.drawable.cr);
                    button3.setBackgroundResource(R.drawable.cuw);
                    button4.setBackgroundResource(R.drawable.cb);
                }
                else if(respRand==2) {
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.cr);
                    button2.setBackgroundResource(R.drawable.cug);
                    button3.setBackgroundResource(R.drawable.cuw);
                    button4.setBackgroundResource(R.drawable.cb);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.cuw);
                    button2.setBackgroundResource(R.drawable.cr);
                    button3.setBackgroundResource(R.drawable.cug);
                    button4.setBackgroundResource(R.drawable.cb);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.cb);
                    button2.setBackgroundResource(R.drawable.cr);
                    button3.setBackgroundResource(R.drawable.cuw);
                    button4.setBackgroundResource(R.drawable.cug);
                }
            }
            else if(colorInicial.equals("Amarillo")){
                //Amarillo
                if(respRand==1) {
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.cuy);
                    button2.setBackgroundResource(R.drawable.cb);
                    button3.setBackgroundResource(R.drawable.cug);
                    button4.setBackgroundResource(R.drawable.cr);
                }
                else if(respRand==2) {
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.cb);
                    button2.setBackgroundResource(R.drawable.cuy);
                    button3.setBackgroundResource(R.drawable.cug);
                    button4.setBackgroundResource(R.drawable.cr);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.cug);
                    button2.setBackgroundResource(R.drawable.cb);
                    button3.setBackgroundResource(R.drawable.cuy);
                    button4.setBackgroundResource(R.drawable.cr);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.cr);
                    button2.setBackgroundResource(R.drawable.cb);
                    button3.setBackgroundResource(R.drawable.cug);
                    button4.setBackgroundResource(R.drawable.cuy);
                }
            }
            else if(colorInicial.equals("Blanco")){
                //Blanco
                if(respRand==1) {
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.cuw);
                    button2.setBackgroundResource(R.drawable.circlegreen);
                    button3.setBackgroundResource(R.drawable.cur);
                    button4.setBackgroundResource(R.drawable.cy);
                }
                else if(respRand==2) {
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.circlegreen);
                    button2.setBackgroundResource(R.drawable.cuw);
                    button3.setBackgroundResource(R.drawable.cur);
                    button4.setBackgroundResource(R.drawable.cy);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.cur);
                    button2.setBackgroundResource(R.drawable.circlegreen);
                    button3.setBackgroundResource(R.drawable.cuw);
                    button4.setBackgroundResource(R.drawable.cy);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.cur);
                    button2.setBackgroundResource(R.drawable.circlegreen);
                    button3.setBackgroundResource(R.drawable.cy);
                    button4.setBackgroundResource(R.drawable.cuw);
                }
            }
            else if(colorInicial.equals("Azul")){
                //Azul
                if(respRand==1) {
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.cub);
                    button2.setBackgroundResource(R.drawable.cw);
                    button3.setBackgroundResource(R.drawable.cug);
                    button4.setBackgroundResource(R.drawable.cr);
                }
                else if(respRand==2) {
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.cw);
                    button2.setBackgroundResource(R.drawable.cub);
                    button3.setBackgroundResource(R.drawable.cug);
                    button4.setBackgroundResource(R.drawable.cr);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.cug);
                    button2.setBackgroundResource(R.drawable.cw);
                    button3.setBackgroundResource(R.drawable.cub);
                    button4.setBackgroundResource(R.drawable.cr);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.cr);
                    button2.setBackgroundResource(R.drawable.cw);
                    button3.setBackgroundResource(R.drawable.cug);
                    button4.setBackgroundResource(R.drawable.cub);
                }
            }
            else if(colorInicial.equals("Rojo")){
                //Rojo
                if(respRand==1) {
                    botonRespuesta = "option1";
                    button1.setBackgroundResource(R.drawable.cur);
                    button2.setBackgroundResource(R.drawable.cb);
                    button3.setBackgroundResource(R.drawable.cuw);
                    button4.setBackgroundResource(R.drawable.circlegreen);
                }
                else if(respRand==2) {
                    botonRespuesta = "option2";
                    button1.setBackgroundResource(R.drawable.cb);
                    button2.setBackgroundResource(R.drawable.cur);
                    button3.setBackgroundResource(R.drawable.cuw);
                    button4.setBackgroundResource(R.drawable.circlegreen);
                }
                else if(respRand==3) {
                    botonRespuesta = "option3";
                    button1.setBackgroundResource(R.drawable.cuw);
                    button2.setBackgroundResource(R.drawable.cb);
                    button3.setBackgroundResource(R.drawable.cur);
                    button4.setBackgroundResource(R.drawable.circlegreen);
                }
                else if(respRand==4) {
                    botonRespuesta = "option4";
                    button1.setBackgroundResource(R.drawable.circlegreen);
                    button2.setBackgroundResource(R.drawable.cb);
                    button3.setBackgroundResource(R.drawable.cuw);
                    button4.setBackgroundResource(R.drawable.cur);
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //Navegacion hacia otras actividades

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id == R.id.action_activity_video){ //PRueba Video
            Intent i = new Intent(this, Video.class);
            startActivity(i);
        }
        else if(id == R.id.action_activity_operations){ //Prueba Operaciones
            Intent i = new Intent(this, Operations.class);
            startActivity(i);
        }
        else if(id == R.id.action_activity_token){ //Prueba Token
            //Nada, permanecer aqui
        }
        return super.onOptionsItemSelected(item);
    }
}
