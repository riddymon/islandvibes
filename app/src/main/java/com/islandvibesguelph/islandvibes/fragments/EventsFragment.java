package com.islandvibesguelph.islandvibes.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.islandvibesguelph.islandvibes.MainActivity;
import com.islandvibesguelph.islandvibes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {
    private TextView mIdentification;
    private MainActivity mHomeActivity;
    private Button testButton;

    private View.OnClickListener mOnToHomeListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Log.v("Event Fragment", " - To Home Started");
            getFragmentManager().popBackStackImmediate();
            Log.v("Event Fragment", " - Back To Home");
        }

    };

    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_events, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeUI(view);
        Log.v("Event Fragment", " - initialized");
//        populateData();
    }

    private void initializeUI(View v) {
        testButton = (Button) v.findViewById(R.id.btnToHome);
        testButton.setOnClickListener(mOnToHomeListener);
        mHomeActivity = (MainActivity) getActivity();
    }

}
