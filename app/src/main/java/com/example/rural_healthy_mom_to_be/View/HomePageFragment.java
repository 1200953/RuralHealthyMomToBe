package com.example.rural_healthy_mom_to_be.View;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rural_healthy_mom_to_be.R;

public class HomePageFragment  extends Fragment {
    View vHomePage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        vHomePage = inflater.inflate(R.layout.homepagefragment, container, false);
        return vHomePage;
    }
}
