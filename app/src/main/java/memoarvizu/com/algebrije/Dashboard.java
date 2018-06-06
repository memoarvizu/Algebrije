package memoarvizu.com.algebrije;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Dashboard extends Activity implements View.OnClickListener {
    private CardView card1, card2, card3, card4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        //Definir cards
        card1 = (CardView) findViewById(R.id.card_1);
        card2 = (CardView) findViewById(R.id.card_2);
        card3 = (CardView) findViewById(R.id.card_3);
        card4 = (CardView) findViewById(R.id.card_4);

        //Agregar clickListener a cada card
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.card_1: i = new Intent(this, FiguraMuestra.class);
            startActivity(i);
            break;

            case R.id.card_2: i = new Intent(this, VistaPrevia.class);
                startActivity(i);
                break;

            case R.id.card_3: i = new Intent(this, VistaPrevia2.class);
                startActivity(i);
                break;

            case R.id.card_4: i = new Intent(this, VistaPrevia3.class);
                startActivity(i);
                break;
            default:break;
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder myBulid = new AlertDialog.Builder(this);
        myBulid.setMessage("Quieres volver a la pantalla de bienvenida?");
        myBulid.setTitle("Mensaje");
        myBulid.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();;
            }
        });
        myBulid.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = myBulid.create();
        dialog.show();
    }
}
