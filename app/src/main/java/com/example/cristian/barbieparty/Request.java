package com.example.cristian.barbieparty;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by Cristian on 9/17/2017.
 */

public class Request extends AsyncTask<String, Void, Void> {

    private Exception exception;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    protected Void doInBackground(String... urls) {
        try {
            request();
            return null;
        } catch (Exception e) {
            this.exception = e;
            return null;
        }
    }

    protected void onPostExecute() {
        // TODO: check this.exception
        // TODO: do something with the feed
        System.out.println("fghjfghjfghjfghj");
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void request() throws Exception {
        String urlParameters = "url=https://img.michaels.com/L6/3/IOGLO/873480063/212543238/10093626_r.jpg?fit=inside|1024:1024";
        //byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
        //int postDataLength = postData.length;
        String request = "http://www.fashwell.com/api/hackzurich/v1/attributes?url=https://img.michaels.com/L6/3/IOGLO/873480063/212543238/10093626_r.jpg?fit=inside|1024:1024";
        URL url = new URL(request);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setInstanceFollowRedirects(false);
        conn.setRequestMethod("POST");

        conn.setRequestProperty("Content-Type", "application/json");
        //conn.setRequestProperty( "charset", "utf-8");
        conn.setRequestProperty("Content-Length", Integer.toString(urlParameters.getBytes(StandardCharsets.UTF_8).length));

        conn.setRequestProperty("Authorization", "Token 782aba3ce358d61a86e11b61da6433a8f04e1d7a");
        //conn.setRequestProperty("image", filePaths.get(0));
        //conn.setRequestProperty("url", "https://img.michaels.com/L6/3/IOGLO/873480063/212543238/10093626_r.jpg?fit=inside|1024:1024");
        conn.setUseCaches(false);

        conn.connect();

        conn.disconnect();
    }
}
