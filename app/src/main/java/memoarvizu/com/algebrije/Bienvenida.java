package memoarvizu.com.algebrije;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class Bienvenida extends Activity {
    LinearLayout l1, l2;
    Button btnsub;
    Animation uptodown, downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bienvenida);

        btnsub = (Button)findViewById(R.id.buttonsub);
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentF = new Intent(Bienvenida.this, Dashboard.class);
                startActivity(intentF);

            }
        });

        l1 = (LinearLayout)findViewById(R.id.l1);
        l2 = (LinearLayout)findViewById(R.id.l2);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);



    }
}
