package es.schooleando.ejercicio2;

import android.os.AsyncTask;
import android.os.SystemClock;

/**
 * Created by tito_ on 11/11/2016.
 */

public class AsyncDescarga extends AsyncTask<Void,Integer,Integer> {

    private MainActivity clase;

    public AsyncDescarga(MainActivity clase){
        this.clase=clase;
    }

    @Override
    protected Integer doInBackground(Void... params) {
        //progreso por porcentaje
        for (int i=1;i<101;i++){
            SystemClock.sleep(100);
            publishProgress(i);
            if (isCancelled()){
                //para dar sensacion de que hace algo
                SystemClock.sleep(1000);
                break;
            }
        }
        return 0;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        clase.updateBar(values[0]);//actualizacion en onProgress de la barra y texto
    }

    @Override
    protected void onPostExecute(Integer integer) {
        clase.finDescarga();//fin de la descarga
    }

    @Override
    protected void onCancelled() {
        clase.cancelaDescarga();//cancelado de la descarga
    }
}