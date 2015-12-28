package com.islandvibesguelph.islandvibes.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.islandvibesguelph.islandvibes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MixFragment extends Fragment {
    private TextView mIdentification;

    public MixFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mix, container, false);
        //initializeUI();
    }

    private void initializeUI() {

    }

}
