package top.linsir.jd_shopping_mall.base;

/**
 * 作者：潇湘夜雨 on 2018/1/28.
 * 邮箱：879689064@qq.com
 */

public interface BaseView {

    void showLoading(String title);
    void stopLoading();
    void showErrorTip(String msg);
}