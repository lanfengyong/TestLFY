package com.example.testlfy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.fragment.FiveFragment;
import com.example.fragment.FourFragment;
import com.example.fragment.OneFragment;
import com.example.fragment.ThreeFragment;
import com.example.fragment.AnimationFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, OneFragment.sendinterface {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private LinearLayout framgment, fragment_one;
    private RadioButton one, two, three, four;
    static {
        System.loadLibrary("native-lib");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,stringFromJNI(),Toast.LENGTH_SHORT).show();
        framgment = findViewById(R.id.fragment);
        fragment_one = findViewById(R.id.fragment_one);
        one = findViewById(R.id.one_tab);
        two = findViewById(R.id.two_tab);
        three = findViewById(R.id.three_tab);
        four = findViewById(R.id.four_tab);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment, new OneFragment());
        fragmentTransaction.add(R.id.fragment_one, new FiveFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        fragmentManager = getSupportFragmentManager();
        switch (v.getId()) {
            case R.id.one_tab:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new OneFragment());
                fragmentTransaction.replace(R.id.fragment_one, new FiveFragment());
                fragment_one.setVisibility(View.VISIBLE);
                break;
            case R.id.two_tab:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new AnimationFragment());
                fragment_one.setVisibility(View.GONE);
                break;
            case R.id.three_tab:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new ThreeFragment());
                fragment_one.setVisibility(View.GONE);
                break;
            case R.id.four_tab:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new FourFragment());
                fragment_one.setVisibility(View.GONE);
                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    public void send(String data) {
        if (!TextUtils.isEmpty(data)) {
            Toast.makeText(this,data,Toast.LENGTH_SHORT).show();
//            Bundle bundle = new Bundle();
//            bundle.putString("data",data);

        }
    }
    public native String stringFromJNI();
}
