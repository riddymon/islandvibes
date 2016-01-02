package com.islandvibesguelph.islandvibes.fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.islandvibesguelph.islandvibes.MainActivity;
import com.islandvibesguelph.islandvibes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private TextView mIdentification;
    private MainActivity mHomeActivity;
    private Button testButton;

    private OnClickListener mOnToEventsListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            mHomeActivity.onClickEvents();
        }

    };

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeUI(view);
        Log.v("Home Fragment", " - initialized");
//        populateData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("Home Fragment", getActivity().toString());
        return inflater.inflate(R.layout.fragment_home, container, false);
        //initializeUI();
    }

    private void initializeUI(View v) {
        testButton = (Button) v.findViewById(R.id.btnToEvents);
        testButton.setOnClickListener(mOnToEventsListener);
        mHomeActivity = (MainActivity) getActivity();
    }

}
