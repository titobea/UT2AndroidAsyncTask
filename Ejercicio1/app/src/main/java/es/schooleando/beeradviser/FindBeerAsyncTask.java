package es.schooleando.beeradviser;

import android.os.AsyncTask;
import android.os.SystemClock;

/**
 * Created by ruben on 17/10/16.
 */

public class FindBeerAsyncTask extends AsyncTask<String, Integer, String[]> {
    @Override
    protected String[] doInBackground(String... params) {
        SystemClock.sleep(14000);//realizamos aqui la tarea que es asincrona en segundo plano
        return new String[0];
    }
}
