package com.akr.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        if(intent!=null && intent.hasExtra("String")) {
            String string = intent.getStringExtra("String");
            if (string != null) {
                Log.v("DetailActivity", string);
            }
            TextView textView = (TextView) view.findViewById(R.id.forecast_text);
            textView.setText(string);
        }

        return view;
    }
}
