package top.linsir.jd_shopping_mall.ui.root.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import top.linsir.jd_shopping_mall.R;

/**
 * Created by linSir
 * date at 2018/2/7.
 * describe:
 */

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.back)
    ImageView back;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
}
