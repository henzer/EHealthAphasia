package com.example.al.ehealth;

import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Video extends ActionBarActivity {
    private ArrayList<ExerciseVideo> exercises = new ArrayList<>();

    private VideoView video;
    private ExerciseVideo current;
    private Button[][] buttons;
    private int cont = -1;
    private int success;
    private int failure;
    private float time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        video = (VideoView)findViewById(R.id.videoView);
        buttons = new Button[2][2];
        buttons[0][0] = (Button)findViewById(R.id.option1);
        buttons[0][1] = (Button)findViewById(R.id.option2);
        buttons[1][0] = (Button)findViewById(R.id.option3);
        buttons[1][1] = (Button)findViewById(R.id.option4);
        loadResources();
        loadNextExercise();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_video, menu);
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

    public void loadResources(){
        exercises.add(new ExerciseVideo(R.raw.amigo, "Amigo", new ArrayList<>(Arrays.asList("Amigo", "Perro", "Gato", "Lapicero"))));
        exercises.add(new ExerciseVideo(R.raw.botella, "Botella", new ArrayList<>(Arrays.asList("Manzana", "Botella", "Celular", "Conejo"))));
        exercises.add(new ExerciseVideo(R.raw.camisa, "Camisa", new ArrayList<>(Arrays.asList("Frijoles", "Camisa", "Cabeza", "Comida"))));
        exercises.add(new ExerciseVideo(R.raw.comida, "Comida", new ArrayList<>(Arrays.asList("Comida", "Cebollas", "Melocotones", "Zanahoria"))));
        exercises.add(new ExerciseVideo(R.raw.mariposa, "Mariposa", new ArrayList<>(Arrays.asList("Mariposa", "Gato", "Telefono", "Trabajo"))));
        exercises.add(new ExerciseVideo(R.raw.medicina, "Medicina", new ArrayList<>(Arrays.asList("Medicina", "Comida", "Cabeza", "Trabajo"))));
        exercises.add(new ExerciseVideo(R.raw.mochila, "Mochila", new ArrayList<>(Arrays.asList("Mochila", "Gato", "Celular", "Trabajo"))));
        exercises.add(new ExerciseVideo(R.raw.telefono, "Telefono", new ArrayList<>(Arrays.asList("Telefono", "Gato", "Botella", "Lapicero"))));
        exercises.add(new ExerciseVideo(R.raw.vestido, "Vestido", new ArrayList<>(Arrays.asList("Vestido", "Manzana", "Telefono", "Conejo"))));

        Collections.shuffle(exercises);
    }

    public void loadNextExercise(){
        cont++;
        if(cont==exercises.size()){
            MainActivity.puntaje_videos = success / (float) cont;
            finish();
            return;
        }
        current = exercises.get(cont);
        List<String> options = current.getOptions();
        Collections.shuffle(options);
        buttons[0][0].setText(options.get(0));
        buttons[0][1].setText(options.get(1));
        buttons[1][0].setText(options.get(2));
        buttons[1][1].setText(options.get(3));
        buttons[0][0].setBackgroundColor(0xFF3F51B5);
        buttons[0][1].setBackgroundColor(0xFF3F51B5);
        buttons[1][0].setBackgroundColor(0xFF3F51B5);
        buttons[1][1].setBackgroundColor(0xFF3F51B5);
        Uri uri = Uri.parse("android.resource://com.example.al.ehealth/" + current.getVideo());
        video.setVideoURI(uri);
        video.start();
    }

    public void validate(View v){
        switch (v.getId()) {
            case R.id.option1:
                if(buttons[0][0].getText().equals(current.getCorrect())){
                    Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
                    success++;
                    buttons[0][0].setBackgroundColor(Color.GREEN);
                }else{
                    Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show();
                    failure++;
                    buttons[0][0].setBackgroundColor(Color.RED);
                }
                break;
            case R.id.option2:
                if(buttons[0][1].getText().equals(current.getCorrect())){
                    Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
                    buttons[0][1].setBackgroundColor(Color.GREEN);
                    success++;
                }else{
                    Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show();
                    buttons[0][1].setBackgroundColor(Color.RED);
                    failure++;
                }
                break;
            case R.id.option3:
                if(buttons[1][0].getText().equals(current.getCorrect())){
                    Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
                    buttons[1][0].setBackgroundColor(Color.GREEN);
                    success++;
                }else{
                    Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show();
                    buttons[1][0].setBackgroundColor(Color.RED);
                    failure++;
                }
                break;
            case R.id.option4:
                if(buttons[1][1].getText().equals(current.getCorrect())){
                    Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
                    buttons[1][1].setBackgroundColor(Color.GREEN);
                    success++;
                }else{
                    Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show();
                    buttons[1][1].setBackgroundColor(Color.RED);
                    failure++;
                }
                break;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadNextExercise();
            }
        }, 1000);


    }

    public void next(View v){
        loadNextExercise();
    }

    public void cancel(View v){
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
