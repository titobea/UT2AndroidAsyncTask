package es.schooleando.ejercicio2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declaracion de variables
    private Button botonDescarga;
    private ProgressBar pb;
    private TextView tv;
    private AsyncDescarga ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //recoger variables del layout
        botonDescarga = (Button)findViewById(R.id.botonDescarga);
        pb = (ProgressBar)findViewById(R.id.pb);
        tv = (TextView)findViewById(R.id.tv);
    }

    public void onClickBotonDescarga(View view) {
        if (botonDescarga.getText().equals("Descargar")) {//si queremos descargar
            botonDescarga.setText("Cancelar");
            tv.setText("Descargando...");
            ad= new AsyncDescarga(this);
            ad.execute();
        }else if (botonDescarga.getText().equals("Cancelar")) {//si queremos cancelar
            botonDescarga.setText("Cancelando");
            botonDescarga.setEnabled(false);
            ad.cancel(true);
        }
    }

    public void cancelaDescarga(){//funcion para avisar que se ha cancelado
        Toast.makeText(this,"Desgarga cancelada",Toast.LENGTH_SHORT).show();
        restablecer();
    }

    public void updateBar(int progreso){//funcion para actualizar la descarga
        pb.setProgress(progreso);
        tv.setText("Descargando... "+progreso+"/100");
    }

    public void finDescarga(){//funcion de din de descarga
        Toast.makeText(this,"Desgarga finalizada",Toast.LENGTH_SHORT).show();
        restablecer();
    }

    private void restablecer(){//funcion para restablescer la pantalla
        botonDescarga.setText("Descargar");
        botonDescarga.setEnabled(true);
        pb.setProgress(0);
        tv.setText("");
    }

}
