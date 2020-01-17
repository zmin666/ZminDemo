package com.example.zmindemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewById;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewById = findViewById(R.id.vp);
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SimpleFragment simpleFragment = SimpleFragment.newInstance(i);
            list.add(simpleFragment);
        }
        MineAdapter mineAdapter = new MineAdapter(getSupportFragmentManager(),list);
        viewById.setOffscreenPageLimit(0);
        viewById.setAdapter(mineAdapter);
    }

    public void onclickbt(View view) {
        startActivity(new Intent(this,SecondActivity.class));
    }
}
