package top.linsir.jd_shopping_mall.ui.root.model;

import io.reactivex.Flowable;
import jd_shopping_mall.linsir.top.anno.InstanceFactory;
import top.linsir.jd_shopping_mall.base.BaseRespose;
import top.linsir.jd_shopping_mall.model.bean.User;
import top.linsir.jd_shopping_mall.ui.root.contract.RootContract;

/**
 * 作者：潇湘夜雨 on 2018/2/2.
 * 邮箱：879689064@qq.com
 */
@InstanceFactory()
public class RootModel implements RootContract.Model {


    @Override
    public Flowable<BaseRespose<User>> postRegister(String userName, String password) {
        return null;
    }
}
