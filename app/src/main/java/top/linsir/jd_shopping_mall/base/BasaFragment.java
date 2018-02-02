package top.linsir.jd_shopping_mall.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import top.linsir.jd_shopping_mall.R;


/**
 * 作者：潇湘夜雨 on 2018/2/1.
 * 邮箱：879689064@qq.com
 */

public abstract class BasaFragment  extends Fragment  {
    public Toolbar mToolbar;
    public TextView title;
    public View back;
    protected View rootView;
    public RxManager mRxManager;
    private Unbinder bind;
    protected final String TAG = this.getClass().getSimpleName();
    private boolean mIsFirstVisible = true;

    public BasaFragment() { /* compiled code */ }

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
        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (rootView == null) {
            return;
        }
        if (mIsFirstVisible && isVisibleToUser) {
            mToolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
            if (null != mToolbar) {
                initTitle();
            }
            initTitle();
        //    initPresenter();
            initView();
          //  SetStatusBarColor();
            mIsFirstVisible = false;
        }
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

    protected void initTitle() {
        title = rootView.findViewById(R.id.toolbar_title);
        back = rootView.findViewById(R.id.toolbar_back);
    }
}
