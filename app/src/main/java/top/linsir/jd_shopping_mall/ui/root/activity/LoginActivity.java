package top.linsir.jd_shopping_mall.ui.root.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import top.linsir.jd_shopping_mall.R;

/**
 * Created by linSir
 * date at 2018/2/7.
 * describe:
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.back)
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        back.setOnClickListener(this);
        visiblePassword.setOnClickListener(this);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.back:
                finish();
                break;

            case R.id.visible_password:
                if (password.getInputType() == InputType.TYPE_CLASS_TEXT) {
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    password.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                break;

            case R.id.login:
                /*
                    请求网络
                    地址: http://rap2api.taobao.org/app/mock/373/POST//login
                    入参:
                    {
                        "code": 0,
                        "msg": "success",
                        "data": {}
                    }

                    登录成功跳转主页
                */


            case R.id.login_wechat:

                break;
        }

    }
}
