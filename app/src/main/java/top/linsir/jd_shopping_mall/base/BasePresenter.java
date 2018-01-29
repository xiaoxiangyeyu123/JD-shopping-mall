package top.linsir.jd_shopping_mall.base;

import android.app.Activity;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import top.linsir.jd_shopping_mall.utils.PreconditionUtils;

/**
 * 作者：潇湘夜雨 on 2018/1/28.
 * 邮箱：879689064@qq.com
 */

public class BasePresenter<M extends BaseModel, V extends BaseView> implements IPresenter {
    protected final String TAG = this.getClass().getSimpleName();
    protected CompositeDisposable mCompositeDisposable;

    protected M mModel;
    protected V mRootView;
    public RxManager mRxManage = new RxManager();

    /**
     * 如果当前页面同时需要 Model 层和 View 层,则使用此构造函数(默认)
     *
     * @param model
     * @param rootView
     */
    public BasePresenter(M model, V rootView) {
        PreconditionUtils.checkNotNull(model, "%s cannot be null", BaseModel.class.getName());
        PreconditionUtils.checkNotNull(rootView, "%s cannot be null", BaseView.class.getName());
        this.mModel = model;
        this.mRootView = rootView;
        onStart();
    }

    /**
     * 如果当前页面不需要操作数据,只需要 View 层,则使用此构造函数
     *
     * @param rootView
     */
    public BasePresenter(V rootView) {
        PreconditionUtils.checkNotNull(rootView, "%s cannot be null", BaseView.class.getName());
        this.mRootView = rootView;
        onStart();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {
        mRxManage.clear();
        if (mModel != null)
            mModel.onDestroy();
        unDispose();//解除订阅
        this.mModel = null;
        this.mRootView = null;
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
