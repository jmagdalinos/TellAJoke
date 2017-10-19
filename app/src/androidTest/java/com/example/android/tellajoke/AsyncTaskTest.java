package com.example.android.tellajoke;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Instrumented test verifying that the AsyncTask in the MainActivity does not return an empty
 * string
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    @Test
    public void testAsyncResponse() {
        EndpointAsyncTask asyncTask = new EndpointAsyncTask();
        asyncTask.execute();
        String result;
        try {
            result = asyncTask.get(15, TimeUnit.SECONDS);

            assertNotNull(result);
            assertTrue(result.length() > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
}
