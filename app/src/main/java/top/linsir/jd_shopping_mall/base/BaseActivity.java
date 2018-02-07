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

import butterknife.ButterKnife;
import butterknife.Unbinder;
import top.linsir.jd_shopping_mall.R;
import top.linsir.jd_shopping_mall.app.AppManager;
import top.linsir.jd_shopping_mall.receiver.netstatereciver.NetChangeObserver;
import top.linsir.jd_shopping_mall.receiver.netstatereciver.NetStateReceiver;
import top.linsir.jd_shopping_mall.utils.ToastUtils;
import top.linsir.jd_shopping_mall.utils.instance.InstanceUtil;
import top.linsir.jd_shopping_mall.widght.LoadingDialog;
import top.linsir.jd_shopping_mall.widght.StatusBarCompat;

/**
 * 作者：潇湘夜雨 on 2018/1/29.
 * 邮箱：879689064@qq.com
 */

public abstract class BaseActivity<T extends BasePresenter, M extends BaseModel> extends AppCompatActivity {
    protected final String TAG = this.getClass().getSimpleName();
    public Toolbar mToolbar;
    public TextView title;
    public View back;
    public Context mContext;
    public RxManager mRxManager;
    private Unbinder bind;
    protected NetChangeObserver mNetChangeObserver = null;
    protected boolean network = true;
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRxManager = new RxManager();
        doBeforeSetcontentView();
        setContentView(getLayoutId());
        bind = ButterKnife.bind(this);
        mContext = this;
        mPresenter = InstanceUtil.getInstance(this, 0);
        M mModel = InstanceUtil.getInstance(this, 1);
        if (mPresenter != null && this instanceof BaseView) {
            mPresenter.mContext = this;
            mPresenter.setVM(this, mModel);
        }
        initNetWorkState();
        mToolbar = findViewById(R.id.toolbar);
        if (null != mToolbar) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        initTitle();
        Bundle extras = getIntent().getExtras();
        if (null != extras) {
            getBundleExtras(extras);
        }
        initView();

    }

    protected void initNetWorkState() {
        mNetChangeObserver = new NetChangeObserver() {
            @Override
            public void onNetConnected() {

                onNetworkConnected();
                network = true;
            }

            @Override
            public void onNetDisConnect() {
                network = false;
                onNetworkDisConnected();
            }
        };

        NetStateReceiver.registerObserver(mNetChangeObserver);
    }

    /**
     * 网络连接状态
     */
    protected void onNetworkConnected() {
    }

    /**
     * 网络断开的时候调用
     */
    protected void onNetworkDisConnected() {
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
        initStatusBarColor();
    }

    protected void initTitle() {
        title = findViewById(R.id.toolbar_title);
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
    protected void initStatusBarColor() {
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


    //初始化view
    public abstract void initView();

    /**
     * @param clazz
     * @param bundle 跳转页面
     */
    protected void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle)
            intent.putExtras(bundle);
        startActivity(intent);
    }

    protected void readyGo(Class<?> clazz) {
        readyGo(clazz, null);
    }

    /**
     * @param clazz  目标Activity
     * @param bundle 数据
     */
    protected void readyGoThenKill(Class<?> clazz, Bundle bundle) {
        readyGo(clazz, bundle);
        finish();
    }

    /**
     * startActivityForResult
     *
     * @param clazz       目标Activity
     * @param requestCode 发送判断值
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     *
     * @param clazz       目标Activity
     * @param requestCode 发送判断值
     * @param bundle      数据
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 显示默认加载动画 默认加载文字
     */
    protected void showLoadingDialog() {
        LoadingDialog.showLoadingDialog(this);
    }

    /**
     * 取消加载动画
     */
    protected void cancelLoadingDialog() {
        LoadingDialog.cancelLoadingDialog();
    }

    //Toast显示
    protected void showShortToast(String string) {
        ToastUtils.showShortToast(this, string);
    }

    protected void showShortToast(int stringId) {
        ToastUtils.showShortToast(this, stringId);
    }

    protected void showLongToast(String string) {
        ToastUtils.showShortToast(this, string);
    }

    protected void showLongToast(int stringId) {
        ToastUtils.showShortToast(this, stringId);
    }

    public <T> T findViewbyId(int id) {
        return (T) findViewById(id);
    }

    @Override
    public Resources getResources() {
        //获取到resources对象
        Resources res = super.getResources();
        //修改configuration的fontScale属性
        res.getConfiguration().fontScale = 1;
        //将修改后的值更新到metrics.scaledDensity属性上
        res.updateConfiguration(null, null);
        return res;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
        this.mPresenter = null;
        mRxManager.clear();
        if (bind != null && bind != Unbinder.EMPTY)
            bind.unbind();
        NetStateReceiver.removeRegisterObserver(mNetChangeObserver);
        LoadingDialog.cancelLoadingDialog();
        AppManager.getAppManager().finishActivity(this);
    }

}
