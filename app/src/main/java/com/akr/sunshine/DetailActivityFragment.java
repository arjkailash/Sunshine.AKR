package com.akr.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.ShareActionProvider;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {
    public static final String SUFFIX = "#SunshineApp";
    public static final String FORECAST = "Forecast";

    ShareActionProvider shareActionProvider;

    public DetailActivityFragment() {
    setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.detail_fragment, menu);

        MenuItem item = menu.findItem(R.id. action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        if(intent!=null && intent.hasExtra(FORECAST)) {
            String string = intent.getStringExtra(FORECAST);
            if (string != null) {
                Log.v("DetailActivity", string);
            }
            TextView textView = (TextView) view.findViewById(R.id.forecast_text);
            textView.setText(string);

            if (shareActionProvider != null ){
                shareActionProvider.setShareIntent(new Intent().setAction(Intent.ACTION_SEND)
                        .putExtra(Intent.EXTRA_TEXT,string + SUFFIX)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
                        .setType("text/plain"));
            }
        }
        return view;
    }
}
