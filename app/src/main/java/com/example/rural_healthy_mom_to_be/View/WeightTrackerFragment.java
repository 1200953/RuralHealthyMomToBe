package com.example.rural_healthy_mom_to_be.View;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rural_healthy_mom_to_be.R;

public class WeightTrackerFragment extends Fragment {
    View vWeightTracker;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        vWeightTracker = inflater.inflate(R.layout.weighttrackerfragment, container, false);
        return vWeightTracker;
    }
}
