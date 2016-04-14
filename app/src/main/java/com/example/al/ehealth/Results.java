package com.example.al.ehealth;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Results extends ActionBarActivity {

    int pVideos;
    int pTokens;
    int pOperaciones;
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

        btRe = (Button)findViewById(R.id.button);

        pVid.setText(pVid.getText()+" "+pVideos);
        pTok.setText(pTok.getText()+" "+pTokens);
        pOp.setText(pOp.getText()+" "+pOperaciones);

        btRe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.puntaje_operaciones = 0;
                MainActivity.puntaje_tokens = 0;
                MainActivity.puntaje_videos = 0;

                pVideos = MainActivity.puntaje_videos;
                pTokens = MainActivity.puntaje_tokens;
                pOperaciones = MainActivity.puntaje_operaciones;

                pVid = (TextView)findViewById(R.id.textView2);
                pTok = (TextView)findViewById(R.id.textView3);
                pOp = (TextView)findViewById(R.id.textView4);
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
