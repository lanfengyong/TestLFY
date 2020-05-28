package com.example.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testlfy.R;

public class FiveFragment extends Fragment {
    private TextView tv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_five,null);
        tv = view.findViewById(R.id.tv);
//        Bundle bundle = getArguments();
//        String data ;
//        if(bundle!=null){
//            data = bundle.getString("data");
//            if(!TextUtils.isEmpty(data)){
//                tv.setText(data);
//            }
//        }
        return view;
    }
    public void setTv(String text){
        tv.setText(text);
    }
}
