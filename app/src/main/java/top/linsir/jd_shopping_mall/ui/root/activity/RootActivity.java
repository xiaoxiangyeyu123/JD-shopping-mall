package top.linsir.jd_shopping_mall.ui.root.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.widget.FrameLayout;
import android.widget.TabHost;

import butterknife.BindView;
import top.linsir.jd_shopping_mall.R;
import top.linsir.jd_shopping_mall.base.BaseActivity;
import top.linsir.jd_shopping_mall.base.rxbase.RxPermissions;
import top.linsir.jd_shopping_mall.ui.root.contract.RootContract;
import top.linsir.jd_shopping_mall.ui.root.model.RootModel;
import top.linsir.jd_shopping_mall.ui.root.presenter.RootPresenter;

/**
 * 作者：潇湘夜雨 on 2018/1/29.
 * 邮箱：879689064@qq.com
 */

public class RootActivity extends BaseActivity<RootPresenter, RootModel> implements RootContract.View, TabHost.OnTabChangeListener {
    @BindView(R.id.maincontent)
    FrameLayout maincontent;
    @BindView(android.R.id.tabcontent)
    FrameLayout tabcontent;
    @BindView(R.id.tabHost)
    FragmentTabHost tabHost;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void initView() {
        checkPermissions();
        initFragment(getSupportFragmentManager(),tabHost);
    }


    public void checkPermissions() {
        mPresenter.checkPermissions(new RxPermissions(this));
    }


    @Override
    public void initFragment(FragmentManager supportFragmentManager, FragmentTabHost tabHost) {
        mPresenter.initFragment(supportFragmentManager,tabHost);
    }

    @Override
    public void setIndexTab(int index) {
        tabHost.setCurrentTab(index);
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {
        showShortToast(msg);
    }

    @Override
    public void onTabChanged(String s) {

    }
}

