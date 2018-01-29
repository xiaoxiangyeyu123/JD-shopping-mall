package top.linsir.jd_shopping_mall.receiver.netstatereciver;

/**
 * 作者：潇湘夜雨 on 2018/1/29.
 * 邮箱：879689064@qq.com
 */

public interface NetChangeObserver {
    /**
     * 网络连接回调 type为网络类型
     */
    void onNetConnected();
    /**
     * 没有网络
     */
    void onNetDisConnect();
}
