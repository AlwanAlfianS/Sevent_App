package com.sevent.seventapp.Profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sevent.seventapp.R;

/**
 * Created by Gizmo on 06/11/2016.
 */
public class ProfileFrag extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v =  inflater.inflate(R.layout.fragment_profile,container,false);
        return v;
    }
}