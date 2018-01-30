package top.linsir.jd_shopping_mall.ui.root.presenter;

import android.Manifest;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;
import top.linsir.jd_shopping_mall.base.BasePresenter;
import top.linsir.jd_shopping_mall.base.RxPresenter;
import top.linsir.jd_shopping_mall.base.rxbase.RxPermissions;
import top.linsir.jd_shopping_mall.di.scope.ActivityScope;
import top.linsir.jd_shopping_mall.ui.root.contract.RootContract;

/**
 * 作者：潇湘夜雨 on 2018/1/29.
 * 邮箱：879689064@qq.com
 */
@ActivityScope
public class RootPresenter extends RxPresenter<RootContract.View> implements RootContract.Presenter {
    @Inject
    public RootPresenter() {

    }

    @Override
    public void checkPermissions(RxPermissions rxPermissions) {
        addDispose(rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean granted) {
                        if (granted) {
                        } else {
                            mView.showErrorTip("请在应用界面给与权限");
                        }
                    }
                }));

    }
}

