package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testlfy.R;

public class OneFragment extends Fragment {
    private EditText ed;
    private Button btn;
    private sendinterface send;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        send = (sendinterface) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one,null);
        ed = view.findViewById(R.id.ed);
        btn = view.findViewById(R.id.commit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = ed.getText().toString().trim();
                send.send(data);
                FiveFragment fiveFragment = (FiveFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_one);
                fiveFragment.setTv(data);
            }
        });
        return view;
    }

    public interface sendinterface{
        public abstract void send(String data);
    }
}
