package top.linsir.jd_shopping_mall.ui.root.presenter;

import android.text.InputType;
import android.util.Log;
import android.widget.EditText;

import jd_shopping_mall.linsir.top.anno.InstanceFactory;
import top.linsir.jd_shopping_mall.base.BaseRespose;
import top.linsir.jd_shopping_mall.base.rxbase.RxSubscriber;
import top.linsir.jd_shopping_mall.model.bean.User;
import top.linsir.jd_shopping_mall.ui.root.contract.LoginContract;

/**
 * 作者：潇湘夜雨 on 2018/2/7.
 * 邮箱：879689064@qq.com
 */
@InstanceFactory()
public class LoginPresenter extends LoginContract.Presenter {
    private EditText userName;
    private EditText password;

    @Override
    public void initView(EditText userName, EditText password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public void visiblePassword() {
        if (password.getInputType() == InputType.TYPE_CLASS_TEXT) {
            password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        } else {
            password.setInputType(InputType.TYPE_CLASS_TEXT);
        }

    }

    @Override
    public void login() {
        addDispose(mModel.postLogin(userName.getText().toString(), password.getText().toString()).subscribeWith(new RxSubscriber<BaseRespose<User>>(mContext, false) {
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
