package com.lexinsmart.xushun.ccp_interface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private Observer<UserInfoEntity> subscribe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("ddd");
        subscribe = new Observer<UserInfoEntity>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("tag1");

            }

            @Override
            public void onNext(UserInfoEntity userInfoEntity) {
                System.out.println("tag:"+ userInfoEntity.toString());
                System.out.println("tag4");
            }


            @Override
            public void onError(Throwable e) {
                System.out.println("tag3");
                e.printStackTrace();

            }

            @Override
            public void onComplete() {
                System.out.println("tag2");

            }
        };
        GetUserInfoMethod.getInstance().getUserInfo(subscribe,"11111");

    }
}
