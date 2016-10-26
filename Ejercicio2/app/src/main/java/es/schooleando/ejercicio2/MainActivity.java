package es.schooleando.ejercicio2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.os.SystemClock.sleep;

public class MainActivity extends AppCompatActivity {
    private Button botonDescarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonDescarga = (Button)findViewById(R.id.botonDescarga);
    }

    public void onClickBotonDescarga(View view) {
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                sleep(10000);
                botonDescarga.setText("Descargado!");
                botonDescarga.setEnabled(false);
            }

        }).start();*/
        
        //El funcionamiento correcto seria el siguiente:
        botonDescarga.post(new Runnable() {
            @Override
            public void run() {
                sleep(10000);
                botonDescarga.setText("Descargado!");
                botonDescarga.setEnabled(false);
            }
        });
    }

}
