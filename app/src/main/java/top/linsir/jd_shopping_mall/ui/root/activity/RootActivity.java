package top.linsir.jd_shopping_mall.ui.root.activity;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.widget.FrameLayout;

import com.tbruyelle.rxpermissions.RxPermissions;

import javax.inject.Inject;

import butterknife.BindView;
import top.linsir.jd_shopping_mall.R;
import top.linsir.jd_shopping_mall.base.BaseActivity;
import top.linsir.jd_shopping_mall.di.component.AppComponent;
import top.linsir.jd_shopping_mall.ui.root.contract.RootContract;
import top.linsir.jd_shopping_mall.ui.root.presenter.RootPresenter;

/**
 * 作者：潇湘夜雨 on 2018/1/29.
 * 邮箱：879689064@qq.com
 */

public class RootActivity extends BaseActivity<RootPresenter> implements RootContract.View{
    @BindView(R.id.maincontent)
    FrameLayout maincontent;
    @BindView(android.R.id.tabcontent)
    FrameLayout tabcontent;
    @BindView(R.id.tabHost)
    FragmentTabHost tabHost;
    @Inject
    RxPermissions mRxPermissions;
    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void initView() {


    }

    @Override
    protected void initInject(AppComponent appComponent) {
       // DaggerRootCompoent.builder().appComponent(appComponent).build().inject(this);
    }


    @Override
    public RxPermissions getRxPermissions() {
        return mRxPermissions;
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }
}

