package com.au615584.urineanalyzerapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.au615584.urineanalyzerapp.R;


public class EpjFailureFragment extends Fragment {

  private String result;
  private TextView txtResult;


  public EpjFailureFragment() {

  }

  public EpjFailureFragment(String Result) {
    result = Result.substring(1);
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
    View v = inflater.inflate(R.layout.fragment_epj_failure, container, false);
    txtResult = v.findViewById(R.id.resultsTxt);
    txtResult.setText(result);
    return inflater.inflate(R.layout.fragment_epj_failure, container, false);
  }
}