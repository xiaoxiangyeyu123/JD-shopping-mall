package top.linsir.jd_shopping_mall.base;

/**
 * 作者：潇湘夜雨 on 2018/1/29.
 * 邮箱：879689064@qq.com
 */

public interface BaseModel {
    /**
     * 在框架中 {@link BasePresenter#onDestroy()} 时会默认调用 {@link BaseModel#onDestroy()}
     */
    void onDestroy();
}
