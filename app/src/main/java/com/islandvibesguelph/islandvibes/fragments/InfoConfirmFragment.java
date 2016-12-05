package com.islandvibesguelph.islandvibes.fragments;

import android.app.FragmentManager;
import android.content.Context;
import android.net.Uri;
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
import com.islandvibesguelph.islandvibes.models.UserInfo;
import com.islandvibesguelph.islandvibes.utilities.ValidationUtility;
import com.islandvibesguelph.islandvibes.widgets.StyledEditText;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoConfirmFragment extends Fragment{


    public InfoConfirmFragment() {
        // Required empty public constructor
    }

    private FragmentManager mFragmentManager;
    private com.islandvibesguelph.islandvibes.fragments.InfoFragment mInfoFragment;
    private static final String INFO_TAG = "info_confirmation";
    private TextView mTxtGreeting;
    private ArrayList<UserInfo> user;
    private InfoActivity mInfoActivity;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        user = (ArrayList<UserInfo>)UserInfo.getUser();
        initializeUI(view);
        goToMain();
        Log.v("Info Fragment", " - initialized");
//        populateData();
    }

    private void goToMain() {
        mInfoActivity = (InfoActivity) getActivity();
        mInfoActivity.navToMain();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("Info Fragment", getActivity().toString());
        return inflater.inflate(R.layout.fragment_info_confirm, container, false);
    }

    private void initializeUI(View v) {
        mTxtGreeting = (TextView) v.findViewById(R.id.infoConfirmationTitle);
        mTxtGreeting.setText("Thanks for your info " + user.get(0).getFirstName() + "!");
    }

}
