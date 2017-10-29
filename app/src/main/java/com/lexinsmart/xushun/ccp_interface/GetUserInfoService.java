package com.lexinsmart.xushun.ccp_interface;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by xushun on 2017/10/29.
 * 功能描述：
 * 心情：
 */

public interface GetUserInfoService {

    @FormUrlEncoded
    @POST("MyServelt")
    Observable<UserInfoEntity> getUserInfo(@Field("cardnumber") String cardnumber);
}
