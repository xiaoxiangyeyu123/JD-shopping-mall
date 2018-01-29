package top.linsir.jd_shopping_mall.ui.main.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.widget.FrameLayout;
import butterknife.BindView;
import io.reactivex.functions.Consumer;
import top.linsir.jd_shopping_mall.R;
import top.linsir.jd_shopping_mall.base.BaseActivity;
import top.linsir.jd_shopping_mall.base.BaseSimpleActivity;
//    RxView.clicks(button)
//            //   .sample(1,TimeUnit.SECONDS)
//            .throttleFirst(3, TimeUnit.SECONDS)//在一秒内只取第一次点击
//            .subscribe(new Consumer<Object>() {
//@Override
//public void accept(Object o) throws Exception {
//        Toast.makeText(MainActivity.this,"狗子", Toast.LENGTH_SHORT).show();
//        }
//        });
//防止点击

/**
 * 作者：潇湘夜雨 on 2018/1/29.
 * 邮箱：879689064@qq.com
 */

public class MainActivity extends BaseSimpleActivity {
    @BindView(R.id.maincontent)
    FrameLayout maincontent;
    @BindView(android.R.id.tabcontent)
    FrameLayout tabcontent;
    @BindView(R.id.tabHost)
    FragmentTabHost tabHost;

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


}
