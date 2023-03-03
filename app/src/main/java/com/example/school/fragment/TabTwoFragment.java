package com.example.school.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.example.school.BaseFragment;
import com.example.school.R;
import com.example.school.databinding.FragmentTabTwoBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabTwoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabTwoFragment extends BaseFragment<FragmentTabTwoBinding> {
    Animation mAnimation = null ;

    public static TabTwoFragment newInstance() {
        TabTwoFragment fragment = new TabTwoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //binding.textView ……
        mAnimation = AnimationUtils.loadAnimation(getActivity(),R.anim. balloonscale);
        viewBinding.imageBalloon2.setAnimation(mAnimation );
        mAnimation.start();

    }


}