package top.linsir.jd_shopping_mall.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;
import top.linsir.jd_shopping_mall.app.App;
import top.linsir.jd_shopping_mall.di.component.ActivityComponent;
import top.linsir.jd_shopping_mall.di.component.DaggerActivityComponent;
import top.linsir.jd_shopping_mall.di.module.ActivityModule;


/**
 * 作者：潇湘夜雨 on 2018/1/28.
 * 邮箱：879689064@qq.com
 */

public abstract class BaseActivity<T extends BasePresenter> extends BaseSimpleActivity {
    @Inject
    protected T mPresenter;

    protected abstract void initInject();

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
