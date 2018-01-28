package top.linsir.jd_shopping_mall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import top.linsir.jd_shopping_mall.app.App;
import top.linsir.jd_shopping_mall.app.AppManager;
import top.linsir.jd_shopping_mall.di.component.AppComponent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
