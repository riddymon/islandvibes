package com.islandvibesguelph.islandvibes.fragments;


import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.islandvibesguelph.islandvibes.InfoActivity;
import com.islandvibesguelph.islandvibes.R;
import com.islandvibesguelph.islandvibes.utilities.ValidationUtility;
import com.islandvibesguelph.islandvibes.widgets.StyledEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment{


    public InfoFragment() {
        // Required empty public constructor
    }

    private InfoActivity mInfoActivity;
    private StyledEditText mName;
    private StyledEditText mLName;
    private StyledEditText mEmail;
    private Button submitButton;
    private FragmentManager mFragmentManager;
    private InfoFragment mInfoFragment;
    private static final String INFO_TAG = "info_confirmation";

    private View.OnClickListener mOnToEventsListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if(validateInfo()) {
                //goToConfirmation();
            }
        }

    };

//    private void goToConfirmation() {
//        mFragmentManager
//                .beginTransaction()
//                .replace(R.id.info, mInfoConfirmFragment, INFO_TAG)
//                .commit();
//    }

    private boolean validateInfo() {
        boolean validated = true;
        String errorString = "";
        if(mName.getValue().isEmpty() || mName.getValue() == null) {
           errorString = "First name field cannot be empty";
            mName.setError(errorString);
           validated = false;
        } else if(mLName.getValue().isEmpty() || mLName.getValue() == null) {
            errorString = "Last name field cannot be empty";
            mLName.setError(errorString);
            validated = false;
        } else if(mEmail.getValue().isEmpty() || mEmail.getValue() == null) {
            errorString = "Last name field cannot be empty";
            mEmail.setError(errorString);
            validated = false;
        } else if(!ValidationUtility.validate(mEmail.getValue())){
            errorString = "Please enter valid email address";
            mEmail.setError(errorString);
            validated = false;
        }

        return validated;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeUI(view);
        Log.v("Info Fragment", " - initialized");
//        populateData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("Info Fragment", getActivity().toString());
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    private void initializeUI(View v) {
        submitButton = (Button) v.findViewById(R.id.btnInfoSave);
        submitButton.setOnClickListener(mOnToEventsListener);
        mInfoActivity = (InfoActivity) getActivity();
        mName = (StyledEditText)v.findViewById(R.id.infoName);
        mLName = (StyledEditText)v.findViewById(R.id.infoLName);
        mEmail = (StyledEditText)v.findViewById(R.id.infoEmail);
    }

}
