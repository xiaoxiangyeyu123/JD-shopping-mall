package top.linsir.jd_shopping_mall.ui.root.presenter;

import android.Manifest;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



import io.reactivex.functions.Consumer;
import jd_shopping_mall.linsir.top.anno.InstanceFactory;
import top.linsir.jd_shopping_mall.R;

import top.linsir.jd_shopping_mall.base.rxbase.RxPermissions;

import top.linsir.jd_shopping_mall.ui.root.contract.RootContract;

/**
 * 作者：潇湘夜雨 on 2018/1/29.
 * 邮箱：879689064@qq.com
 */
@InstanceFactory()
public class RootPresenter  extends RootContract.Presenter {
//    private Class fragmentArray[] = {MainFragment.class, MessageFragment.class, PersonFragment.class};
    private String texts[] = {"首页", "分类", "发现","购物车","我的"};
//    private int imageButton[] = {R.drawable.selector_home, R.drawable.selector_car, R.drawable.selector_person};

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
    @Override
    public View getView(Context context, int i) {
        View view = View.inflate(context, R.layout.view_tab, null);
        ImageView imageView =  view.findViewById(R.id.image);
        TextView textView = view.findViewById(R.id.text);
//        imageView.setImageResource(imageButton[i]);
//        textView.setText(texts[i]);
        return view;
    }
}

