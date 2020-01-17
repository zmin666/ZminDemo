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
 * @desc:
 */
public class BaseLazyFragment extends Fragment {

    private boolean isViewPrepared; // 标识fragment视图已经初始化完毕
    private boolean hasFetchData; // 标识已经触发过懒加载数据

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i("zmin........." + getArguments().getInt("key"), ".............setUserVisibleHint..." + isVisibleToUser);
        lazyFetchDataIfPrepared();
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
        lazyFetchDataIfPrepared();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("zmin........." + getArguments().getInt("key"), ".............onResume(");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("zmin........." + getArguments().getInt("key"), ".............onPause(");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("zmin........." + getArguments().getInt("key"), ".............onStart(");
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


    /**
     * 懒加载方法，获取数据什么的放到这边来使用，在切换到这个界面时才进行网络请求
     */
    private void lazyFetchDataIfPrepared() {
        // 用户可见fragment && 没有加载过数据 && 视图已经准备完毕
        if (getUserVisibleHint() && !hasFetchData && isViewPrepared) {
            hasFetchData = true; //已加载过数据
            lazyInit();
        }
    }

    /**
     * 执行懒加载
     */
    protected void lazyInit() {
        Log.i("zmin........." + getArguments().getInt("key"), ".............加载完成数据");
        Toast.makeText(getContext(), "加载数据..." + getArguments().getInt("key"), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        hasFetchData = false;
        isViewPrepared = false;
        Log.i("zmin........." + getArguments().getInt("key"), ".............onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("zmin........." + getArguments().getInt("key"), ".............onDetach");
    }



}
