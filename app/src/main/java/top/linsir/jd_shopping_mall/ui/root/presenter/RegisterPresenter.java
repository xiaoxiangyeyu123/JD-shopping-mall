package top.linsir.jd_shopping_mall.ui.root.presenter;

import android.util.Log;
import android.widget.EditText;

import top.linsir.jd_shopping_mall.base.BaseRespose;
import top.linsir.jd_shopping_mall.base.rxbase.RxSubscriber;
import top.linsir.jd_shopping_mall.model.bean.User;
import top.linsir.jd_shopping_mall.ui.root.contract.RegisterContract;

/**
 * Created by linSir
 * date at 2018/2/19.
 * describe:
 */

public class RegisterPresenter extends RegisterContract.Presenter {


    private EditText username;
    private EditText password;
    private EditText password2;


    @Override
    public void initView(EditText username, EditText password, EditText password2) {
        this.username = username;
        this.password = password;
        this.password2 = password2;
    }

    @Override
    public void register() {
        addDispose(mModel.postRegister(username.getText().toString(), password.getText().toString()).subscribeWith(new RxSubscriber<BaseRespose<User>>(mContext, false) {
            @Override
            protected void _onNext(BaseRespose<User> userBaseRespose) {
                Log.e(TAG,userBaseRespose.data.toString());
                mView.finish();
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));

    }
}
