package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.anuradha.backend.myApi.MyApi;
import com.anuradha.displayjoke.DisplayJoke;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context mContext;

    private ProgressBar mProgressBar;

    EndpointsAsyncTask(ProgressBar progressBar) {
        this.mProgressBar = progressBar;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }
    @Override
    protected String doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
//            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(), null)
//                    // options for running against local devappserver
//                    // - 10.0.2.2 is localhost's IP address in Android emulator
//                    // - turn off compression when running against local devappserver
//                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                        @Override
//                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                            abstractGoogleClientRequest.setDisableGZipContent(true);
//                        }
//                    });
            // end options for devappserver
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new
                    AndroidJsonFactory(), null)
                    .setRootUrl("https://joketeller-152721.appspot.com/_ah/api/");
            myApiService = builder.build();
        }

        mContext = params[0];
//        context = params[0].first;
//        String name = params[0].second;

        try {
            return myApiService.getAJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
        }
        Intent intent = new Intent(mContext, DisplayJoke.class);
//        String joke_from_jokefactory = new JokeFactory().JokeTeller();
//        intent.putExtra(DisplayJoke.JOKE_KEY, joke_from_jokefactory);
        intent.putExtra(DisplayJoke.JOKE_KEY, result);
        mContext.startActivity(intent);
//        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }
}
