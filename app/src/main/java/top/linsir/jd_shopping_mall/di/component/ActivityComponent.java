package top.linsir.jd_shopping_mall.di.component;

import android.app.Activity;

import dagger.Component;
import top.linsir.jd_shopping_mall.di.scope.ActivityScope;
import top.linsir.jd_shopping_mall.ui.root.activity.RootActivity;

/**
 * 作者：潇湘夜雨 on 2018/1/30.
 * 邮箱：879689064@qq.com
 */
@ActivityScope
@Component(dependencies = AppComponent.class)
public interface ActivityComponent {

    RootActivity inject(RootActivity activity);
}
