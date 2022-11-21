package com.au615584.urineanalyzerapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.au615584.urineanalyzerapp.R;


public class WelcomeFragment extends Fragment {
    private TextView txtWelcome;
    private TextView txtScan;
    private ImageView imgScan;


    public static WelcomeFragment newInstance() {
        return new WelcomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_welcome, container, false);
        txtWelcome = v.findViewById(R.id.welcomeTB);
        txtScan = v.findViewById(R.id.scanTB);
        imgScan = v.findViewById(R.id.imgScan);

        return  v;
    }
}