package top.linsir.jd_shopping_mall.base;

import android.content.Context;

/**
 * 作者：潇湘夜雨 on 2018/1/28.
 * 邮箱：879689064@qq.com
 */

public  abstract class BasePresenter<T extends BaseView>{
    public Context mContext;
    public RxManager mRxManage = new RxManager();

    public void onStart(){
    };
    public void onDestroy() {
        mRxManage.clear();
    }
}
