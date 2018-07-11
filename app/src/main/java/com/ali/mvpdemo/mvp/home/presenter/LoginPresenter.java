package com.ali.mvpdemo.mvp.home.presenter;

import com.ali.mvpdemo.base.BasePresenter;
import com.ali.mvpdemo.mvp.home.model.LoginModel;
import com.ali.mvpdemo.mvp.home.model.bean.LoginBean;
import com.ali.mvpdemo.mvp.home.view.iview.ILoginView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mumu on 2018/7/11.
 */

public class LoginPresenter extends BasePresenter<ILoginView> {
    private LoginModel mLoginModel;

    public LoginPresenter(ILoginView loginView) {
        super(loginView);
    }

    @Override
    protected void initModel() {
        mLoginModel = new LoginModel();
    }

    public void login(String account, String password) {
        if (account == null) {
            if (view != null) {
                view.onLoginFaild("手机号不能为空");
            }
            return;
        }
        mLoginModel.login(account, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        if (view != null) {
                            view.onLoginSuccess(loginBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (view != null) {
                            view.onLoginFaild(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
