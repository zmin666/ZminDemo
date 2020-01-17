package com.example.zmindemo;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author: ZhangMin
 * @date: 2020/1/16 17:34
 * @version: 1.0
 * @desc: 见面可见和隐藏的监听
 */
public class BaseAppearFragment extends Fragment {

    private boolean isViewPrepared; // 标识fragment视图已经初始化完毕
    private boolean hasAppear;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i("zmin........." + getArguments().getInt("key"), ".............setUserVisibleHint..." + isVisibleToUser);

        //当前fragment转为可见状态
        if (isVisibleToUser && isViewPrepared && !hasAppear) {
            onFragmentAppear();
            hasAppear = true;
        }
        //当前fragment转为不可见状态
        if (!isVisibleToUser && hasAppear) {
            onFragmentDismiss();
            hasAppear = false;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("zmin........." + getArguments().getInt("key"), ".............onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("zmin........." + getArguments().getInt("key"), ".............onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("zmin........." + getArguments().getInt("key"), ".............onCreateView");
        return inflater.inflate(R.layout.activity_fragment, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewPrepared = true;
        TextView tv = getView().findViewById(R.id.tv);
        tv.setText(String.valueOf(getArguments().getInt("key")));
        Log.i("zmin........." + getArguments().getInt("key"), ".............onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("zmin........." + getArguments().getInt("key"), ".............onStart(");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("zmin........." + getArguments().getInt("key"), ".............onResume(");
        if (getUserVisibleHint()) {
            onFragmentAppear();
            hasAppear = true;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("zmin........." + getArguments().getInt("key"), ".............onPause(");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("zmin........." + getArguments().getInt("key"), ".............onStop(");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("zmin........." + getArguments().getInt("key"), ".............onDestroy(");
    }

    @Override
    public void onDestroyView() {
        isViewPrepared = true;
        super.onDestroyView();
        Log.i("zmin........." + getArguments().getInt("key"), ".............onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("zmin........." + getArguments().getInt("key"), ".............onDetach");
    }

    /**
     * 界面可见
     */
    public void onFragmentAppear() {
        Log.i("zmin........." + getArguments().getInt("key"), "......界面可见..onFragmentAppear");
    }

    /**
     * 界面由可见转为不可见
     */
    public void onFragmentDismiss() {
        Log.i("zmin........." + getArguments().getInt("key"), "...由可见转为不可见.........onFragmentDismiss");
    }
}
