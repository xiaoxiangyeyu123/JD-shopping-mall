package top.linsir.jd_shopping_mall.base;



import top.linsir.jd_shopping_mall.app.App;
import top.linsir.jd_shopping_mall.base.BasePresenter;

import top.linsir.jd_shopping_mall.utils.instance.InstanceUtil;


/**
 * 作者：潇湘夜雨 on 2018/1/28.
 * 邮箱：879689064@qq.com
 */

public abstract class MvpBaseActivity<T extends BasePresenter,M extends BaseModel> extends BaseActivity {
    protected T mPresenter;

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        mPresenter= InstanceUtil.getInstance(this,0);
        M mModel=InstanceUtil.getInstance(this,1);
        if(mPresenter!=null&&this instanceof BaseView)mPresenter.setVM(this,mModel);

    }

    @Override
    protected void onDestroy() {

        if (mPresenter != null)
            mPresenter.detachView();
        this.mPresenter=null;
        super.onDestroy();
    }

}
