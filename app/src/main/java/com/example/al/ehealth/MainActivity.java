package com.example.al.ehealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

<<<<<<< HEAD
    private MainActivity thisContext = this;
    private Button videoButton;
    private Button operacionesButton;
    private Button tokenButton;

    private Button resultButton;
    public static int puntaje_videos = 0;
    public static int puntaje_tokens = 0;
    public static int puntaje_operaciones = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoButton = (Button)findViewById(R.id.videoButton);
        videoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(thisContext, Video.class);
                startActivity(i);
            }
        });

        operacionesButton = (Button)findViewById(R.id.operacionesButton);
        operacionesButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent i = new Intent(thisContext, Operations.class);
                startActivity(i);
            }
        });

        tokenButton = (Button)findViewById(R.id.tokenButton);
        tokenButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent i = new Intent(thisContext, Token.class);
                startActivity(i);
            }
        });

        resultButton = (Button)findViewById(R.id.resultadosButton);
        resultButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent i = new Intent(thisContext, Results.class);
                startActivity(i);
            }
        });

        //Hola
        //Hola Henzer
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
            Intent i = new Intent(this, Token.class);
            startActivity(i);
        }
        else if(id == R.id.action_activity_results)
        {
            Intent i = new Intent(this, Results.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
