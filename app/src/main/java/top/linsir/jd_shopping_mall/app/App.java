package top.linsir.jd_shopping_mall.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.multidex.MultiDex;

import top.linsir.jd_shopping_mall.service.InitializeService;

import static java.lang.System.exit;

/**
 * 作者：潇湘夜雨 on 2018/1/28.
 * 邮箱：879689064@qq.com
 */

public class App extends Application {
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Context getAppContext() {
        return instance;
    }

    public static Resources getAppResources() {
        return instance.getResources();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
        //在子线程中完成其他初始化
        InitializeService.start(this);
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        android.os.Process.killProcess(android.os.Process.myPid());
        exit(0);
    }
}
