package top.linsir.jd_shopping_mall.ui.root.contract;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;

import io.reactivex.Flowable;
import top.linsir.jd_shopping_mall.base.BaseModel;
import top.linsir.jd_shopping_mall.base.BasePresenter;
import top.linsir.jd_shopping_mall.base.BaseRespose;
import top.linsir.jd_shopping_mall.base.BaseView;
import top.linsir.jd_shopping_mall.base.rxbase.RxPermissions;
import top.linsir.jd_shopping_mall.model.bean.User;

/**
 * 作者：潇湘夜雨 on 2018/1/29.
 * 邮箱：879689064@qq.com
 */

public interface RootContract {
    interface Model extends BaseModel {
        Flowable<BaseRespose<User>> postRegister(String userName, String password);
    }

    interface View extends BaseView {
        void initFragment(FragmentManager supportFragmentManager, FragmentTabHost tabHost);

        void setIndexTab(int index);

    }

    abstract static class Presenter extends BasePresenter<RootContract.Model, RootContract.View> {
        public abstract void checkPermissions(RxPermissions rxPermissions);

        public abstract void initFragment(FragmentManager supportFragmentManager, FragmentTabHost tabHost);

    }
}
