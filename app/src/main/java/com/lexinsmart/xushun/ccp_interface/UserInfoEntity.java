package com.lexinsmart.xushun.ccp_interface;

/**
 * Created by xushun on 2017/10/29.
 * 功能描述：
 * 心情：
 */

public class UserInfoEntity {
    private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    @Override
    public String toString() {
        return "UserInfoEntity{" +
                "cardnumber='" + cardnumber + '\'' +
                '}';
    }
}
