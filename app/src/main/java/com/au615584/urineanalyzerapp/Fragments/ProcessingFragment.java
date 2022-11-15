package com.au615584.urineanalyzerapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.au615584.urineanalyzerapp.R;
import com.au615584.urineanalyzerapp.Repositories.EPJRepository;


public class ProcessingFragment extends Fragment {
  private TextView txtProgress;
  private ProgressBar spinner;
  private EPJRepository epjRepository;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    epjRepository = EPJRepository.getInstance();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_processing, container, false);
    txtProgress = v.findViewById(R.id.txtProgress);
    spinner = v.findViewById(R.id.progressBar);
    spinner.setVisibility(View.VISIBLE);

    epjRepository.saveToEPJ(2, 1, "2222225555"); //TODO delete this when done testing
    return  v;
  }
}