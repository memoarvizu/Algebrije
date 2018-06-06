package memoarvizu.com.algebrije;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class Vista1 extends Activity {
    Button botonRojo, botonVerde, botonAzul;
    GridLayout malla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista1);
        malla = findViewById(R.id.malla);
        botonRojo = findViewById(R.id.btnRojo);
        botonVerde = findViewById(R.id.btnVerde);
        botonAzul = findViewById(R.id.btnAzul);

        // Se define y se inicia el cronometro
        Chronometer simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer); // initiate a chronometer
        simpleChronometer.start(); // start a chronometer

        final long tiempo = simpleChronometer.getBase(); //Se obtiene la cadena del tiempo realizado

        //Parar el cronimetro y pasar a la pantalla de resultados al presionar el boton de finalizar
        final Button btnR = findViewById(R.id.btnFin);
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Chronometer simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer); // initiate a chronometer
                simpleChronometer.stop(); // stop a chronometer

                Intent intentF = new Intent(Vista1.this, Resultados.class);
                //intentF.putExtra("Tiempo: ", tiempo);
                startActivity(intentF);

            }
        });

       /*Button botonRojo = (Button)findViewById(R.id.btnRojo);
        botonRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }

    int[] gameState = {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
    boolean fichaRoja = true;
    boolean fichaVerde = true;
    boolean fichaAzul = true;
    boolean btnR = true;
    boolean btnV = true;
    boolean btnA = true;

    public void dropIn (View view){
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        //Hace que no se puedan sobreescribir las figuras
        if (gameState[tappedCounter] == 2){
            counter.setEnabled(false);

        }

        int ficha = fichaRoja? 1:0;
        Log.i("Info","Ficha selecionada: " + ficha);
        gameState[tappedCounter] = ficha;
        counter.setTranslationY(-1500);

        // Alternar fichas
        if (fichaRoja) {
            counter.setImageResource(R.drawable.crojo);
            fichaRoja = false;
        } else {
            counter.setImageResource(R.drawable.cverde);
            fichaRoja = true;
        }
        counter.animate().translationYBy(1500).setDuration(300);
    }

    /*public void onClick(View view) {
    }*/
}
