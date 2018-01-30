package top.linsir.jd_shopping_mall.ui.root.contract;

import android.app.Activity;
import top.linsir.jd_shopping_mall.base.BasePresenter;
import top.linsir.jd_shopping_mall.base.BaseView;
import top.linsir.jd_shopping_mall.base.rxbase.RxPermissions;

/**
 * 作者：潇湘夜雨 on 2018/1/29.
 * 邮箱：879689064@qq.com
 */

public interface RootContract {

    interface View extends BaseView {


        Activity getActivity();
    }

    interface Presenter extends BasePresenter<View> {
        void checkPermissions(RxPermissions rxPermissions);

    }
}
