package top.linsir.jd_shopping_mall.ui.root.model;

import io.reactivex.Flowable;
import jd_shopping_mall.linsir.top.anno.InstanceFactory;
import top.linsir.jd_shopping_mall.base.BaseRespose;
import top.linsir.jd_shopping_mall.base.rxbase.RxSchedulers;
import top.linsir.jd_shopping_mall.model.bean.User;
import top.linsir.jd_shopping_mall.model.http.Api;
import top.linsir.jd_shopping_mall.ui.root.contract.LoginContract;

/**
 * Created by linSir
 * date at 2018/2/7.
 * describe:
 */

@InstanceFactory()
public class LoginModel implements LoginContract.Model {
    @Override
    public Flowable<BaseRespose<User>> postLogin(String userName, String password) {
        return Api.getDefault().postLogin(userName, password).compose(RxSchedulers.<BaseRespose<User>>io_main());
    }
}
