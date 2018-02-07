package top.linsir.jd_shopping_mall.ui.root.contract;

import android.widget.Button;
import android.widget.EditText;

import io.reactivex.Flowable;
import top.linsir.jd_shopping_mall.base.BaseModel;
import top.linsir.jd_shopping_mall.base.BasePresenter;
import top.linsir.jd_shopping_mall.base.BaseRespose;
import top.linsir.jd_shopping_mall.base.BaseView;
import top.linsir.jd_shopping_mall.model.bean.User;

/**
 * 作者：潇湘夜雨 on 2018/2/7.
 * 邮箱：879689064@qq.com
 */

public interface LoginContract {
    interface Model extends BaseModel {
        Flowable<BaseRespose<User>> postLogin(String userName, String password);
    }

    interface View extends BaseView {


    }

    abstract static class Presenter extends BasePresenter<LoginContract.Model, LoginContract.View> {
        public abstract void initView(EditText username,EditText password);
        public abstract void visiblePassword();
        public abstract void login();

    }
}
