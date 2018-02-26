package top.linsir.jd_shopping_mall.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import top.linsir.jd_shopping_mall.R;
import top.linsir.jd_shopping_mall.utils.ToastUtils;
import top.linsir.jd_shopping_mall.utils.instance.InstanceUtil;
import top.linsir.jd_shopping_mall.widght.LoadingDialog;
import top.linsir.jd_shopping_mall.widght.StatusBarCompat;


/**
 * 作者：潇湘夜雨 on 2018/2/1.
 * 邮箱：879689064@qq.com
 */

public abstract class BaseFragment<T extends BasePresenter, M extends BaseModel> extends Fragment {
    public Toolbar mToolbar;
    public TextView title;
    public View back;
    protected View rootView;
    public RxManager mRxManager;
    private Unbinder bind;
    protected final String TAG = this.getClass().getSimpleName();
    public T mPresenter;
    private boolean isPrepared;

    public BaseFragment() { /* compiled code */ }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (null != getArguments()) {
            getBundleExtras(getArguments());
        }
        if (rootView == null)
            rootView = inflater.inflate(getLayoutResource(), container, false);
        mRxManager = new RxManager();
        bind = ButterKnife.bind(this, rootView);
        if(getUserVisibleHint()){
            if (isFirstVisible) {
                onFirstUserVisible();
                isFirstVisible = false;
            }
        }
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPrepare();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (rootView == null) {
            return;
        }
        if (isFirstVisible && isVisibleToUser) {
            onFirstUserVisible();
            isFirstVisible = false;
        }
    }

    public synchronized void initPrepare() {
        if (isPrepared) {
            onFirstUserVisible();
        } else {
            isPrepared = true;
        }
    }

    private boolean isFirstVisible  = true;


    private void onFirstUserVisible() {
        if (rootView == null) {
            return;
        }
        mPresenter = InstanceUtil.getInstance(this, 0);
        M mModel = InstanceUtil.getInstance(this, 1);

        if (mPresenter != null) {
            mPresenter.mContext = this.getActivity();
        }
        mToolbar = rootView.findViewById(R.id.toolbar);
        initTitle();

        if (mPresenter != null && this instanceof BaseView) {
            mPresenter.mContext = this.getActivity();
            mPresenter.setVM(this, mModel);
        }
        initView();
        SetStatusBarColor();
    }


    private void SetStatusBarColor() {
        StatusBarCompat.setStatusBarColor(getActivity(), ContextCompat.getColor(getActivity(), R.color.main_color));
    }

    /**
     * 获取bundle信息
     *
     * @param bundle
     */
    protected abstract void getBundleExtras(Bundle bundle);

    //获取布局文件
    protected abstract int getLayoutResource();

    //初始化view
    protected abstract void initView();

    public <T> T findViewbyId(int id) {
        return (T) rootView.findViewById(id);
    }

    protected void initTitle() {
        title = rootView.findViewById(R.id.toolbar_title);
        back = rootView.findViewById(R.id.toolbar_back);
    }

    protected void showLoadingDialog() {
        LoadingDialog.showLoadingDialog(getActivity());
    }

    protected void cancelLoadingDialog() {
        LoadingDialog.cancelLoadingDialog();
    }

    //Toast显示
    protected void showShortToast(String string) {
        ToastUtils.showShortToast(getActivity(), string);
    }

    protected void showShortToast(int stringId) {
        ToastUtils.showShortToast(getActivity(), stringId);
    }

    protected void showLongToast(String string) {
        ToastUtils.showShortToast(getActivity(), string);
    }

    protected void showLongToast(int stringId) {
        ToastUtils.showShortToast(getActivity(), stringId);
    }

    protected void readyGo(Class<?> clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
    }

    protected void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivityForResult(intent, requestCode);
    }

    protected void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isPrepared=false;
        isFirstVisible=true;
        cancelLoadingDialog();
        bind.unbind();
        if (mPresenter != null)
            mPresenter.detachView();
        mRxManager.clear();
    }
}
