package com.ali.mvpdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mumu on 2018/6/12.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {


    protected  P  presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideLayoutId());
        initView();
        initListener();
        //提供presenter
        presenter =  providePresenter();
        initData();
    }

    protected abstract P providePresenter();

    protected  void initData(){}

    protected  void initListener(){}

    protected  void initView(){}

    protected abstract int provideLayoutId();

    //解决内存泄漏

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
