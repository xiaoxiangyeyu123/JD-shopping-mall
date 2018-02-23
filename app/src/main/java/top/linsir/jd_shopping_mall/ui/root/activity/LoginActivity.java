package top.linsir.jd_shopping_mall.ui.root.activity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import top.linsir.jd_shopping_mall.R;
import top.linsir.jd_shopping_mall.base.BaseActivity;
import top.linsir.jd_shopping_mall.ui.root.contract.LoginContract;
import top.linsir.jd_shopping_mall.ui.root.model.LoginModel;
import top.linsir.jd_shopping_mall.ui.root.model.RootModel;
import top.linsir.jd_shopping_mall.ui.root.presenter.LoginPresenter;
import top.linsir.jd_shopping_mall.ui.root.presenter.RootPresenter;

/**
 * Created by linSir
 * date at 2018/2/7.
 * describe:
 */

public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View {


    @BindView(R.id.toolbar_back)
    ImageView back;
    @BindView(R.id.visible_password)
    ImageView visiblePassword;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.login_qq)
    ImageView loginQq;
    @BindView(R.id.login_wechat)
    ImageView loginWechat;
    @BindView(R.id.input_username)
    EditText username;
    @BindView(R.id.input_password)
    EditText password;


    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

        mPresenter.initView(username, password);
    }


    @OnClick({R.id.visible_password, R.id.login, R.id.login_wechat})
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.visible_password:
                mPresenter.visiblePassword();
                break;

            case R.id.login:
                mPresenter.login();

            case R.id.login_wechat:

                break;
        }

    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {
        showShortToast(msg);
    }

    @Override
    public void finish() {
        super.finish();
    }
}
