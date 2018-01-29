package top.linsir.jd_shopping_mall.di.component;

import dagger.Component;
import top.linsir.jd_shopping_mall.di.scope.ActivityScope;
import top.linsir.jd_shopping_mall.ui.root.activity.RootActivity;
import top.linsir.jd_shopping_mall.ui.root.module.RootModule;

/**
 * 作者：潇湘夜雨 on 2018/1/29.
 * 邮箱：879689064@qq.com
 */
@ActivityScope
@Component(modules = RootModule.class,dependencies = AppComponent.class)
public interface RootCompoent {
    void inject(RootActivity activity);
}
