package com.au615584.urineanalyzerapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.au615584.urineanalyzerapp.R;


public class ProcessingFragment extends Fragment {
  private TextView txtProgress;
  private ProgressBar spinner;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_processing, container, false);
    txtProgress = v.findViewById(R.id.txtProgress);
    spinner = v.findViewById(R.id.progressBar);
    spinner.setVisibility(View.VISIBLE);
    return  v;
  }
}