package com.lexinsmart.xushun.ccp_interface;

import java.util.concurrent.TimeUnit;

import javax.security.auth.login.LoginException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xushun on 2017/10/29.
 * 功能描述：
 * 心情：
 */

public class GetUserInfoMethod {
    public static  final  String BASE_URL = "http://10.0.2.2:8080/CCP/";
    private static final int DEFAULT_TIMEOUT = 5;
    private Retrofit mRetrofit;
    private GetUserInfoService mGetUserInfoService;

    private static class SingletonHolder{
        private static final GetUserInfoMethod INSTANCE = new GetUserInfoMethod();

    }
    public static GetUserInfoMethod getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private GetUserInfoMethod(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        mGetUserInfoService = mRetrofit.create(GetUserInfoService.class);
    }

    public void getUserInfo(Observer<UserInfoEntity> subscriber ,String cardnumber){
        Observable observable = mGetUserInfoService.getUserInfo(cardnumber);

        toSubscribe(observable,subscriber);
    }
    private <T> void toSubscribe(Observable<T> o, Observer<T> s){
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Observer<? super T>) s);
    }
}
