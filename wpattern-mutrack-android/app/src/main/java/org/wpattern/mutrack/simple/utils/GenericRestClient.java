package org.wpattern.mutrack.simple.utils;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.web.client.RestTemplate;
import org.wpattern.mutrack.simple.R;

public abstract class GenericRestClient extends AsyncTask<RequestBean, Integer, Long> {

    private RestTemplate restTemplate;

    public GenericRestClient() {
        restTemplate = new RestTemplate();
    }

    @Override
    protected final Long doInBackground(RequestBean... params) {
        String url = R.string.root_url_rest + "/private/packagee";

        try {
            Object[] result = restTemplate.getForObject(url, Object[].class, "Android");

            Log.w("%s", result + "");
        } catch (Exception ex) {
            Object asd = ex;
        }

        return null;
    }



}
