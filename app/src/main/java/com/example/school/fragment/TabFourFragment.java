package com.example.school.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.school.BaseFragment;
import com.example.school.R;
import com.example.school.databinding.FragmentTabFourBinding;


public class TabFourFragment extends BaseFragment<FragmentTabFourBinding> {

    public static TabFourFragment newInstance() {
        TabFourFragment fragment = new TabFourFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //binding.textView ……
    }




}