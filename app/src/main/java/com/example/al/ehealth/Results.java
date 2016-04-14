package com.example.al.ehealth;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Results extends ActionBarActivity {

    Results thisContext = this;
    float pVideos;
    float pTokens;
    float pOperaciones;
    TextView pVid;
    TextView pTok;
    TextView pOp;
    Button btRe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        pVideos = MainActivity.puntaje_videos;
        pTokens = MainActivity.puntaje_tokens;
        pOperaciones = MainActivity.puntaje_operaciones;

        pVid = (TextView)findViewById(R.id.textView2);
        pTok = (TextView)findViewById(R.id.textView3);
        pOp = (TextView)findViewById(R.id.textView4);

        btRe = (Button)findViewById(R.id.reset);

        pVid.setText(pVid.getText()+" "+pVideos);
        pTok.setText(pTok.getText()+" "+pTokens);
        pOp.setText(pOp.getText()+" "+pOperaciones);

        btRe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.puntaje_operaciones = 0f;
                MainActivity.puntaje_tokens = 0f;
                MainActivity.puntaje_videos = 0f;

                pVideos = MainActivity.puntaje_videos;
                pTokens = MainActivity.puntaje_tokens;
                pOperaciones = MainActivity.puntaje_operaciones;

                pVid.setText("Puntaje en Videos: "+pVideos);
                pTok.setText("Puntaje en Tokens: "+pTokens);
                pOp.setText("Puntaje en Operaciones: "+pOperaciones);

                Toast t = Toast.makeText(thisContext, "Datos Reiniciados", Toast.LENGTH_SHORT);
                t.setGravity(Gravity.CENTER, 0, 0);
                t.show();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results, menu);
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
}
