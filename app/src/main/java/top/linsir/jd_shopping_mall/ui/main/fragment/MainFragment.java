package top.linsir.jd_shopping_mall.ui.main.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import top.linsir.jd_shopping_mall.R;
import top.linsir.jd_shopping_mall.base.BaseFragment;
import top.linsir.jd_shopping_mall.imgloader.GlideImageLoader;
import top.linsir.jd_shopping_mall.model.bean.Goods;
import top.linsir.jd_shopping_mall.ui.main.adapter.MainRecyclerViewAdapter;

/**
 * 作者：潇湘夜雨 on 2018/2/2.
 * 邮箱：879689064@qq.com
 */

public class MainFragment extends BaseFragment {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.title_bar_layout)
    RelativeLayout titleBarLayout;


    private int mDistanceY = 0;


    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {
        MainRecyclerViewAdapter mAdapter = new MainRecyclerViewAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

//        Banner banner = new Banner(getActivity());
//        banner.setImageLoader(new GlideImageLoader());
//        List<String> list = new ArrayList<>();
//        list.add("http://f.hiphotos.baidu.com/image/pic/item/503d269759ee3d6db032f61b48166d224e4ade6e.jpg");
//        list.add("http://f.hiphotos.baidu.com/image/pic/item/503d269759ee3d6db032f61b48166d224e4ade6e.jpg");
//        list.add("http://f.hiphotos.baidu.com/image/pic/item/503d269759ee3d6db032f61b48166d224e4ade6e.jpg");
//
//        LinearLayout layout = new LinearLayout(getActivity());
//        layout.addView(banner, 1080, 400);
//        banner.setImages(list);
//
//        mAdapter.addHeaderView(layout, 1080, 400);
//        banner.start();

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mDistanceY += dy;
                int toolbarHeight = 56 * 3;
                if (mDistanceY <= toolbarHeight) {
                    float scale = mDistanceY / toolbarHeight;
                    float alpha = scale * 255;
                    titleBarLayout.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
                } else {
                    titleBarLayout.setBackgroundResource(R.color.colorWhite);
                }
            }
        });


        List<Goods> list2 = new ArrayList<>();
        list2.add(new Goods());
        list2.add(new Goods());
        list2.add(new Goods());
        list2.add(new Goods());
        list2.add(new Goods());
        list2.add(new Goods());
        list2.add(new Goods());
        mAdapter.setNewData(list2);


        Toast.makeText(getActivity(), "---lin---> 111", Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(), "---lin---> 111", Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(), "---lin---> 111", Toast.LENGTH_SHORT).show();





    }
}
