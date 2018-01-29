package top.linsir.jd_shopping_mall.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
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

import butterknife.ButterKnife;
import butterknife.Unbinder;
import top.linsir.jd_shopping_mall.R;
import top.linsir.jd_shopping_mall.app.App;
import top.linsir.jd_shopping_mall.app.AppManager;
import top.linsir.jd_shopping_mall.di.component.ActivityComponent;
import top.linsir.jd_shopping_mall.di.component.DaggerActivityComponent;
import top.linsir.jd_shopping_mall.di.module.ActivityModule;
import top.linsir.jd_shopping_mall.widght.StatusBarCompat;

/**
 * 作者：潇湘夜雨 on 2018/1/28.
 * 邮箱：879689064@qq.com
 */

public abstract class BaseActivity<T extends IPresenter> extends AppCompatActivity {
    protected final String TAG = this.getClass().getSimpleName();
    public Toolbar mToolbar;
    public TextView title;
    public ImageView back;


    @Inject
    protected T mPresenter;
    public Context mContext;
    public RxManager mRxManager;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRxManager = new RxManager();
        doBeforeSetcontentView();
        setContentView(getLayoutId());
        bind = ButterKnife.bind(this);
        mContext = this;
        initInject();
       
        SetStatusBarColor();

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (null != mToolbar) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            initTitle();
        }
        Bundle extras = getIntent().getExtras();
        if (null != extras) {
            getBundleExtras(extras);
        }
        initView();

    }
    protected ActivityComponent getActivityComponent(){
        return  DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }
    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    protected abstract void getBundleExtras(Bundle extras);
    /**
     * 设置layout前配置
     */
    private void doBeforeSetcontentView() {
        // 把actvity放到application栈中管理
        AppManager.getAppManager().addActivity(this);
        // 无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // 默认着色状态栏
        SetStatusBarColor();
    }
    protected void initTitle() {
        title = (TextView) findViewById(R.id.toolbar_title);
        back = findViewById(R.id.toolbar_back);
        if (null != back) {
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    /**
     * 着色状态栏（4.4以上系统有效）
     */
    protected void SetStatusBarColor() {
        StatusBarCompat.setStatusBarColor(this, ContextCompat.getColor(this, R.color.main_color));
    }

    /**
     * 着色状态栏（4.4以上系统有效）
     */
    protected void SetStatusBarColor(int color) {
        StatusBarCompat.setStatusBarColor(this, color);
    }

    /**
     * 沉浸状态栏（4.4以上系统有效）
     */
    protected void SetTranslanteBar() {
        StatusBarCompat.translucentStatusBar(this);
    }

    //获取布局文件
    public abstract int getLayoutId();


    public abstract void initInject();

    //初始化view
    public abstract void initView();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();
        mRxManager.clear();
        if (bind != null && bind != Unbinder.EMPTY)
            bind.unbind();
        AppManager.getAppManager().finishActivity(this);
    }


}
