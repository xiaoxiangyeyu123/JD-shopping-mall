package top.linsir.jd_shopping_mall.ui.root.contract;

import android.widget.EditText;

import io.reactivex.Flowable;
import top.linsir.jd_shopping_mall.base.BaseModel;
import top.linsir.jd_shopping_mall.base.BasePresenter;
import top.linsir.jd_shopping_mall.base.BaseRespose;
import top.linsir.jd_shopping_mall.base.BaseView;
import top.linsir.jd_shopping_mall.model.bean.User;

/**
 * Created by linSir
 * date at 2018/2/19.
 * describe:
 */

public interface RegisterContract {

    interface Model extends BaseModel {
        Flowable<BaseRespose<User>> postRegister(String userName, String password);

    }

    interface View extends BaseView {
        void finish();
    }

    abstract static class Presenter extends BasePresenter<RegisterContract.Model, RegisterContract.View> {
        public abstract void initView(EditText username, EditText password, EditText password2);

        public abstract void register();
    }


}
