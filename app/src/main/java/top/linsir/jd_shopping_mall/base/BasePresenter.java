package top.linsir.jd_shopping_mall.base;


import android.app.Activity;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 作者：潇湘夜雨 on 2018/1/28.
 * 邮箱：879689064@qq.com
 */

public abstract class BasePresenter<M extends BaseModel, T> {
    protected final String TAG = this.getClass().getSimpleName();
    protected CompositeDisposable mCompositeDisposable;
    public RxManager mRxManage = new RxManager();


    public M mModel;
    public T mView;

    public void setVM(T mView, M mModel) {
        this.mView = mView;
        this.mModel = mModel;

    }

    public  void detachView(){
        mRxManage.clear();
        unDispose();//解除订阅
        this.mView = null;
        this.mCompositeDisposable = null;
    }
    /**
     * 将 {@link Disposable} 添加到 {@link CompositeDisposable} 中统一管理
     * 可在 {@link Activity#onDestroy()} 中使用 {@link #unDispose()} 停止正在执行的 RxJava 任务,避免内存泄漏
     *
     * @param disposable
     */
    public void addDispose(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);//将所有 Disposable 放入集中处理
    }

    /**
     * 停止集合中正在执行的 RxJava 任务
     */
    public void unDispose() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();//保证 Activity 结束时取消所有正在执行的订阅
        }
    }
}
