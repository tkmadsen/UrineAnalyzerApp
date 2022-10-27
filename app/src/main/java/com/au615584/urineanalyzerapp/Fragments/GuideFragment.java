package com.au615584.urineanalyzerapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.au615584.urineanalyzerapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GuideFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GuideFragment extends Fragment {
    private TextView txtGuide;
    private ImageView imgGuide;

    public GuideFragment() {
        // Required empty public constructor
    }

    public static GuideFragment newInstance(String param1, String param2) {
        return new GuideFragment();
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
        View v = inflater.inflate(R.layout.fragment_guide, container, false);
        txtGuide = v.findViewById(R.id.guideTB);
        imgGuide = v.findViewById(R.id.imageView);

        return  v;
    }
}