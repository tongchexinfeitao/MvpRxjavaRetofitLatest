package com.ali.mvpdemo.mvp.home.view.iview;

import com.ali.mvpdemo.base.IView;
import com.ali.mvpdemo.mvp.home.model.bean.LoginBean;

/**
 * Created by mumu on 2018/6/12.
 */

public interface ILoginView  extends IView{
    void onLoginSuccess(LoginBean loginBean);

    void onLoginFaild(String error);



}

