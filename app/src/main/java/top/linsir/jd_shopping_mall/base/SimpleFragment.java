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

/**
 * 作者：潇湘夜雨 on 2018/1/30.
 * 邮箱：879689064@qq.com
 */

public abstract class SimpleFragment extends Fragment {

    public Toolbar mToolbar;
    public TextView title;
    public View back;
    protected View rootView;
    public RxManager mRxManager;
    private Unbinder bind;
    protected final String TAG = this.getClass().getSimpleName();
    private boolean mIsFirstVisible = true;

    public SimpleFragment() { /* compiled code */ }

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

    /**
     * 获取bundle信息
     *
     * @param bundle
     */
    protected abstract void getBundleExtras(Bundle bundle);

    //获取布局文件
    protected abstract int getLayoutResource();
}
