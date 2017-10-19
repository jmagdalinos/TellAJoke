package com.example.android.tellajoke;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.joketeller.JokeActivity;

/**
 * Fragment launching the Android Library to display the joke.
 */
public class MainActivityFragment extends Fragment implements EndpointAsyncTask.AsyncTaskCallback {

    /** Member Variables */
    private TextView mTextView;
    private ImageButton mButton;
    private ProgressBar mProgressBar;

    /** Empty constructor */
    public MainActivityFragment() {}

    @Override
    public void onResume() {
        super.onResume();
                toggleProgressBar(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        // Find the ProgressBar, the TextView and the Button
        mProgressBar = (ProgressBar) root.findViewById(R.id.progress_bar);
        mTextView = (TextView) root.findViewById(R.id.tv_instructions);
        mButton = (ImageButton) root.findViewById(R.id.btn_tell_joke);

        // Set an OnClickListener to load the joke
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tellJoke();
            }
        });

        // Hide the ProgressBar
        toggleProgressBar(false);
        return root;
    }

    /** Creates a new AsyncTask to load a joke */
    public void tellJoke() {
        toggleProgressBar(true);
        new EndpointAsyncTask().setCallbackListener(this).execute();
    }

    /** Toggles visibility of the progress bar, the text view and the button */
    private void toggleProgressBar(boolean isProgressVisible) {
        if (isProgressVisible) {
            // Show only the progress bar
            mTextView.setVisibility(View.GONE);
            mButton.setVisibility(View.GONE);
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            // Hide only the progress bar
            mTextView.setVisibility(View.VISIBLE);
            mButton.setVisibility(View.VISIBLE);
            mProgressBar.setVisibility(View.GONE);
        }
    }

    /** Implemented to enable the callback functionality of the AsyncTask */
    @Override
    public void onComplete(String result) {
        if (result == null || TextUtils.isEmpty(result)) {
            // Show the no internet message and hide the ProgressBar
            Toast.makeText(getContext(), getString(R.string.no_jokes), Toast.LENGTH_SHORT)
                    .show();
            toggleProgressBar(false);
        } else {
            // Launch the activity displaying the joke
            Intent intent = new Intent(getContext(), JokeActivity.class);
            intent.putExtra(JokeActivity.KEY_JOKE, result);
            startActivity(intent);
        }
    }
}
