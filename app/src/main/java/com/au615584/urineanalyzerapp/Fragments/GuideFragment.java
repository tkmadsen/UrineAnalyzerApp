package com.au615584.urineanalyzerapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.au615584.urineanalyzerapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuideFragment extends Fragment {
    private TextView txtGuide, txtCpr;
    private ImageView imgGuide;
    private String cpr;

    public GuideFragment() {
        // Required empty public constructor
    }
    public GuideFragment(String Cpr) {
        cpr = Cpr;
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
        txtCpr = v.findViewById(R.id.cprTB);
        txtCpr.setText("Velkommen " + cpr);

        Runnable delayedTask = new Runnable() {
            @Override
            public void run() {
                txtCpr.setText("");
            }
        };
        v.postDelayed(delayedTask, 3000);

        return  v;
    }

    public void removeCpr() {
        txtCpr.setText("");
    }
}