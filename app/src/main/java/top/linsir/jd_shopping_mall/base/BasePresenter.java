package top.linsir.jd_shopping_mall.base;

import android.app.Activity;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 作者：潇湘夜雨 on 2018/1/28.
 * 邮箱：879689064@qq.com
 */

public interface BasePresenter<T extends BaseView>{
    void attachView(T view);

    void detachView();
}
