package top.linsir.jd_shopping_mall.receiver.screestate;

/**
 * 作者：潇湘夜雨 on 2018/1/29.
 * 邮箱：879689064@qq.com
 */

public interface  ScreenStateListener {
     void onScreenOn();// 开屏

     void onScreenOff();// 锁屏

     void onUserPresent();// 解锁
}
