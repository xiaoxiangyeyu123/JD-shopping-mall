package top.linsir.jd_shopping_mall.ui.root.module;

import com.tbruyelle.rxpermissions.RxPermissions;

import dagger.Module;
import dagger.Provides;
import top.linsir.jd_shopping_mall.di.scope.ActivityScope;
import top.linsir.jd_shopping_mall.ui.root.contract.RootContract;

/**
 * 作者：潇湘夜雨 on 2018/1/29.
 * 邮箱：879689064@qq.com
 */
@Module
public class RootModule {
    private RootContract.View view;

    public RootModule(RootContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    RootContract.View provideUserView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    RootContract.Model provideUserModel(RootContract.Model model) {
        return model;
    }

    @ActivityScope
    @Provides
    RxPermissions provideRxPermissions() {
        return new RxPermissions(view.getActivity());
    }
}
