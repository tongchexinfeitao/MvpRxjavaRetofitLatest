package com.ali.mvpdemo.mvp.home.model;


import com.ali.mvpdemo.mvp.home.model.bean.LoginBean;
import com.ali.mvpdemo.utils.RetrofitManager;

import io.reactivex.Observable;

/**
 * Created by mumu on 2018/7/11.
 */

public class LoginModel {
    public Observable<LoginBean> login(final String account, String password) {
        return RetrofitManager.getDefault().create(IHomeApi.class).login(account, password);
    }
}
