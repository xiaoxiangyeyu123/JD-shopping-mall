package top.linsir.jd_shopping_mall.ui.root.presenter;

import android.Manifest;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

import io.reactivex.functions.Consumer;
import jd_shopping_mall.linsir.top.anno.InstanceFactory;
import top.linsir.jd_shopping_mall.R;
import top.linsir.jd_shopping_mall.base.rxbase.RxPermissions;
import top.linsir.jd_shopping_mall.ui.main.fragment.MainFragment;
import top.linsir.jd_shopping_mall.ui.root.contract.RootContract;

/**
 * 作者：潇湘夜雨 on 2018/1/29.
 * 邮箱：879689064@qq.com
 */
@InstanceFactory()
public class RootPresenter extends RootContract.Presenter  {
    private Class fragmentArray[] = {MainFragment.class, MainFragment.class, MainFragment.class, MainFragment.class, MainFragment.class};
    private int imageButton[] = {R.drawable.ic_home, R.drawable.ic_sort, R.drawable.ic_discover, R.drawable.ic_shopping, R.drawable.ic_me};


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

    @Override
    public View getView(int i) {
        View view = View.inflate(mContext, R.layout.view_tab, null);
        ImageView imageView = view.findViewById(R.id.ivItem);
        imageView.setImageResource(imageButton[i]);
        return view;
    }

    @Override
    public void initFragment(FragmentManager supportFragmentManager, FragmentTabHost fragmentTabHost) {
        fragmentTabHost.setup(mContext, supportFragmentManager, R.id.maincontent);
        for (int i = 0; i < imageButton.length; i++) {
            TabHost.TabSpec spec = fragmentTabHost.newTabSpec(String.valueOf(i)).setIndicator(getView(i));
            fragmentTabHost.addTab(spec, fragmentArray[i], null);
        }
        fragmentTabHost.getTabWidget().setDividerDrawable(null);

    }
}

