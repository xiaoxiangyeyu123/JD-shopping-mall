package top.linsir.jd_shopping_mall.ui.root.presenter;

import javax.inject.Inject;
import top.linsir.jd_shopping_mall.base.BasePresenter;
import top.linsir.jd_shopping_mall.di.scope.ActivityScope;
import top.linsir.jd_shopping_mall.ui.root.contract.RootContract;

/**
 * 作者：潇湘夜雨 on 2018/1/29.
 * 邮箱：879689064@qq.com
 */
@ActivityScope
public class RootPresenter extends BasePresenter<RootContract.View> implements RootContract.RoootModel<RootContract.View>{
    @Inject
    public RootPresenter() {

    }

}

