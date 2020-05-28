package com.example.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testlfy.MyActivity;
import com.example.testlfy.R;

public class AnimationFragment extends Fragment {
    private Button alpha, suofang,translate,xuanzhuan,xubo1,xubo2,tiaozhuan;
    private ImageView animation;
    private Animation alphaAnimation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animation, null);
        animation = view.findViewById(R.id.animatiom);
        alpha = view.findViewById(R.id.alpha);
        suofang = view.findViewById(R.id.suofang);
        translate = view.findViewById(R.id.translate);
        xuanzhuan = view.findViewById(R.id.xuanzhuan);
        xubo1 = view.findViewById(R.id.xubo1);
        xubo2 = view.findViewById(R.id.xubo2);
        tiaozhuan = view.findViewById(R.id.tiaozhuan);
        alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.alpha);
                animation.startAnimation(alphaAnimation);
            }
        });
        suofang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.scale);
                animation.startAnimation(alphaAnimation);
            }
        });
        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.translate);
                animation.startAnimation(alphaAnimation);
            }
        });
        xuanzhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);
                animation.startAnimation(alphaAnimation);
            }
        });
        xubo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);
                animation.startAnimation(alphaAnimation);
                final Animation alphaAnimation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.translate);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation anim) {
                        animation.startAnimation(alphaAnimation2);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        xubo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.zuhe);
                animation.startAnimation(alphaAnimation);
            }
        });
        tiaozhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MyActivity.class));
            }
        });
        return view;

    }
}
