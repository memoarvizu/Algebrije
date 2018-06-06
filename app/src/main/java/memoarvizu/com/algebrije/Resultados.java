package memoarvizu.com.algebrije;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultados extends Activity {
    Button btnShare, btnMenu;
    String shareSub="He completado la figura";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        btnShare = findViewById(R.id.buttonCompartir);
        btnMenu = findViewById(R.id.buttonMenu);

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

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resultados.this, Dashboard.class);
                startActivity(intent);
            }
        });

    }
}
