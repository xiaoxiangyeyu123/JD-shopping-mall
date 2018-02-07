package top.linsir.jd_shopping_mall.ui.mine.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import top.linsir.jd_shopping_mall.R;
import top.linsir.jd_shopping_mall.base.BaseFragment;
import top.linsir.jd_shopping_mall.ui.root.activity.LoginActivity;


/**
 * Created by linSir
 * date at 2018/2/5.
 * describe:
 */

public class MeFragment extends BaseFragment {

    @BindView(R.id.linear_layout)
    LinearLayout linearLayout;

    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    @Override
    protected int getLayoutResource() {


        return R.layout.fragment_me;
    }

    @Override
    protected void initView() {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
