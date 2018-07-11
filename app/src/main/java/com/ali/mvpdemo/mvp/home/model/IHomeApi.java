package com.ali.mvpdemo.mvp.home.model;

import com.ali.mvpdemo.constant.ConstantApi;
import com.ali.mvpdemo.mvp.home.model.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mumu on 2018/7/11.
 * 一个大的功能模块用一个Api
 */

public interface IHomeApi {
    @GET(ConstantApi.LOGING)
    Observable<LoginBean> login(@Query("mobile") String mobile, @Query("password") String password);

}
