package memoarvizu.com.algebrije;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Vista1 extends Activity {
    int colorN;
    Chronometer cronometro;
    long tiempo;
    String miTiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista1);

        // Se define y se inicia el cronometro al iniciar el activity
        cronometro = findViewById(R.id.simpleChronometer);
        cronometro.start(); // iniciar cronometro

        //Parar el cronimetro y pasar a la pantalla de resultados al presionar el boton de finalizar
        final Button btnR = findViewById(R.id.btnFin);
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cronometro = findViewById(R.id.simpleChronometer);
                cronometro.stop(); // detener cronometro

                Intent intentF = new Intent(Vista1.this, Resultados.class);
                intentF.putExtra("tiempo", miTiempo); // <-- Envií el tiempo a la activity de Resultados
                startActivity(intentF);

                showElapsedTime();
            }
        });
    }

    //Obtiene el valor del cronometo en milisegundos y lo convierte en segundos...despues es mostrado en un Toast
    private void showElapsedTime() {
        tiempo = SystemClock.elapsedRealtime() - cronometro.getBase();
        Date date = new Date(tiempo);
        SimpleDateFormat formatter = new SimpleDateFormat("mm:ss");
        miTiempo = formatter.format(date );
        Toast.makeText(Vista1.this, "Tu tiempo: " + miTiempo,
                Toast.LENGTH_SHORT).show();
    }

    int[] gameState = {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};

    public void dropIn (View view){
        final ImageView counter = (ImageView) view;
        final int tappedCounter = Integer.parseInt(counter.getTag().toString());

        //Hace que no se puedan sobreescribir las figuras
        if (gameState[tappedCounter] == 2){
            counter.setEnabled(false);counter.setTranslationY(-1500);

            final Button btnRo = findViewById(R.id.btnRojo);
            btnRo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    colorN = 0;//Rojo
                }
            });

            final Button btnVe = findViewById(R.id.btnVerde);
            btnVe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    colorN = 1;//Verde
                }
            });

            final Button btnAz = findViewById(R.id.btnAzul);
            btnAz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    colorN = 2;//Azul
                }
            });

            if (colorN==0){
                counter.setImageResource(R.drawable.crojo);
                counter.animate().translationYBy(1500).setDuration(300);
            } else if(colorN==1){
                counter.setImageResource(R.drawable.cverde);
                counter.animate().translationYBy(1500).setDuration(300);
            } else if (colorN==2){
                counter.setImageResource(R.drawable.cazul);
                counter.animate().translationYBy(1500).setDuration(300);
            }
        }
    }
}
