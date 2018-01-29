package top.linsir.jd_shopping_mall.ui.root.contract;

import android.app.Activity;


import com.tbruyelle.rxpermissions.RxPermissions;

import top.linsir.jd_shopping_mall.base.BaseModel;
import top.linsir.jd_shopping_mall.base.BaseView;

/**
 * 作者：潇湘夜雨 on 2018/1/29.
 * 邮箱：879689064@qq.com
 */

public interface RootContract {

    interface View extends BaseView {
        //申请权限
        RxPermissions getRxPermissions();

        Activity getActivity();
    }
    interface Model extends BaseModel{
    }
}
