package top.linsir.jd_shopping_mall.di.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import top.linsir.jd_shopping_mall.di.scope.ActivityScope;

/**
 * 作者：潇湘夜雨 on 2018/1/29.
 * 邮箱：879689064@qq.com
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
