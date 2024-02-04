package com.example.androidtutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.androidtutorial.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    TextView showCountTextView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // inflate fragment layout
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        // get count text view
        showCountTextView = binding.getRoot().findViewById(R.id.count);
        // return fragment layout
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increment(view);
            }
        });
    }

    private void increment(View view) {

        // get value of count number textview
        String countString = showCountTextView.getText().toString();
        // convert the string number into integer data type
        Integer count = Integer.parseInt(countString);
        // increment the number
        count++;
        // convert to string and set on textview
        showCountTextView.setText(count.toString());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}