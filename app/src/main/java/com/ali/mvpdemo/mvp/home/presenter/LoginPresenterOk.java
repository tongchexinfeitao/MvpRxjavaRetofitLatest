package com.ali.mvpdemo.mvp.home.presenter;

import com.ali.mvpdemo.base.BasePresenter;
import com.ali.mvpdemo.mvp.home.model.LoginModelOk;
import com.ali.mvpdemo.mvp.home.model.bean.LoginBean;
import com.ali.mvpdemo.mvp.home.view.iview.ILoginView;

/**
 * Created by mumu on 2018/6/12.
 */

public class LoginPresenterOk extends BasePresenter<ILoginView> {

    private LoginModelOk mLoginModel;

    public LoginPresenterOk(ILoginView loginView) {
        super(loginView);
    }

    @Override
    protected void initModel() {
        mLoginModel = new LoginModelOk();
    }

    public void login(String account, String password) {
        if (account == null) {
            if (view != null) {
                view.onLoginFaild("手机号不能为空");
            }
            return;
        }

        mLoginModel.login(account, password, new LoginModelOk.ILoginModelCallback() {
            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                if (view != null) {
                    view.onLoginSuccess(loginBean);
                }
            }

            @Override
            public void onLoginFaild(String error) {
                if (view != null) {
                    view.onLoginFaild(error);
                }
            }
        });
    }
}
