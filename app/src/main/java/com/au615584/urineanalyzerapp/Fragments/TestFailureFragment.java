package com.au615584.urineanalyzerapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.au615584.urineanalyzerapp.R;

//Is shown in case of fail in Analysis of urine dipstick on UrineAnalyzerController.
//Is shown when "3Fejl på test" is received from UrineAnalyzerController.
public class TestFailureFragment extends Fragment {


  public TestFailureFragment() {
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
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_test_failure, container, false);
  }
}