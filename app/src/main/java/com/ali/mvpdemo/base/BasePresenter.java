package com.ali.mvpdemo.base;

import android.content.Context;

import com.ali.mvpdemo.app.MyApp;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by mumu on 2018/6/12.
 */

public abstract class BasePresenter<V extends IView> {
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();
    protected V view;

    public BasePresenter(V view) {
        this.view = view;
        initModel();
    }

    //初始化model
    protected abstract void initModel();

    //内存泄漏的解决
    void onDestroy() {
        view = null;
        compositeDisposable.clear();
    }

    //如果view.cotext()环境变量为null的话就提供全局环境变量
    protected Context context() {
        if (view != null && view.cotext() !=null) {
         return view.cotext();
        }
        return MyApp.getAppContext();
    }
}
