package com.example.android.tellajoke;

import android.os.AsyncTask;

import com.example.tellajoke.backend.myJokeApi.MyJokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * AsyncTask that connects with the Google Cloud Endpoint backend to retrieve a joke
 * Uses a callback interface to notify the MainActivityFragment that the it has finished.
 */
public class EndpointAsyncTask extends AsyncTask<Void, Void, String> {

    /** Member Variables */
    private AsyncTaskCallback mCallback;
    private MyJokeApi mMyJokeApiService = null;

    /** Interface used to notify the MainActivityFragment that the AsyncTask has finished */
    public interface AsyncTaskCallback {
        void onComplete(String result);
    }

    /** Constructor storing the callback */
    public EndpointAsyncTask setCallbackListener(AsyncTaskCallback callback) {
        mCallback = callback;
        return this;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (mMyJokeApiService == null) { // Only do this once
            MyJokeApi.Builder builder = new MyJokeApi.Builder(
                    AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest)
                                throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            mMyJokeApiService = builder.build();
        }

        try {
            return mMyJokeApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        // Pass the joke to the callback
        if (mCallback != null) {
            mCallback.onComplete(result);
        }
    }
}
