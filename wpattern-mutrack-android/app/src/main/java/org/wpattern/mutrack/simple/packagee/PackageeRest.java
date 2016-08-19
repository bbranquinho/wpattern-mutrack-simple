package org.wpattern.mutrack.simple.packagee;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.web.client.RestTemplate;

public class PackageeRest extends AsyncTask {

    @Override
    protected Object doInBackground(Object[] objects) {
        String url = "http://10.1.1.8:8080/api/private/packagee";

        RestTemplate restTemplate = new RestTemplate();

        try {
            Object[] result = restTemplate.getForObject(url, Object[].class, "Android");



            Log.w("%s", result + "");
        } catch (Exception ex) {
            Object asd = ex;
        }

        return null;
    }
}
