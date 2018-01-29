package top.linsir.jd_shopping_mall.base;


import javax.inject.Inject;
import top.linsir.jd_shopping_mall.app.App;
import top.linsir.jd_shopping_mall.di.component.AppComponent;


/**
 * 作者：潇湘夜雨 on 2018/1/28.
 * 邮箱：879689064@qq.com
 */

public abstract class BaseActivity<T extends BasePresenter> extends BaseSimpleActivity {
    @Inject
    protected T mPresenter;

    protected abstract void initInject(AppComponent appComponent);


    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject(App.getAppComponent());
    }

    @Override
    protected void onDestroy() {

        if (mPresenter != null)
            mPresenter.onDestroy();
        this.mPresenter=null;
        super.onDestroy();
    }

}
