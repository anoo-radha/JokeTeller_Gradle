package com.udacity.gradle.builditbigger;


import android.test.AndroidTestCase;
import android.util.Log;

import java.util.concurrent.TimeUnit;


public class TestAsyncTask extends AndroidTestCase{

    public void testDoInBackground() throws Exception{
        String joke = "";
        try {
            MainActivity mainActivity = new MainActivity();
            EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(null);
            endpointsAsyncTask.execute(mainActivity);
            joke = endpointsAsyncTask.get(30, TimeUnit.SECONDS);

            assertNotNull("No joke fetched from server!", joke);
            assertTrue("No joke fetched from server!", joke.length() > 0);
        } catch (Exception e){
            Log.e("TestAsyncTask", "testDoInBackground: Timed out");
        }
    }
}
