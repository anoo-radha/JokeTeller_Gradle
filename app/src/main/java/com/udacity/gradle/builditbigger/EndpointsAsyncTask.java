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

/* Async task to retrieve joke */

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
        mContext = params[0];
        if (myApiService == null) {  // Only do this once
            // end options for devappserver
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new
                    AndroidJsonFactory(), null)
                    .setRootUrl(mContext.getString(R.string.api_engine_url));
            myApiService = builder.build();
        }

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
        //launch the activity from your Android Library to display the joke
        Intent intent = new Intent(mContext, DisplayJoke.class);
        intent.putExtra(DisplayJoke.JOKE_KEY, result);
        mContext.startActivity(intent);
    }
}
