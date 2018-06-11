package memoarvizu.com.algebrije;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultados extends Activity {
    TextView textT;
    Button btnShare, btnMenu;
    String shareSub="He completado la figura";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        btnShare = findViewById(R.id.buttonCompartir);
        btnMenu = findViewById(R.id.buttonMenu);
        textT = findViewById(R.id.textTiempo);

        //Se supone que esto debe recibir los datos de la actividad "Vista1"
        Bundle datos = this.getIntent().getExtras();
        long recupTiempo = datos.getLong("tiempo"); //hasta aqui

        //Para compartir
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                //intent.putExtra(Intent.EXTRA_TEXT, "He completado la figura");
                startActivity(Intent.createChooser(intent, "Compartir con"));
            }
        });

        //Regresa al menu principal
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resultados.this, Dashboard.class);
                startActivity(intent);
            }
        });

        //TODO: mostrar el tiempo realizado en un textView o algo
    }
}
