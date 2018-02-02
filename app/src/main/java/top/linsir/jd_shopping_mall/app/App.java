package top.linsir.jd_shopping_mall.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.multidex.MultiDex;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import top.linsir.jd_shopping_mall.di.component.AppComponent;


import top.linsir.jd_shopping_mall.di.module.AppModule;
import top.linsir.jd_shopping_mall.receiver.netstatereciver.NetStateReceiver;
import top.linsir.jd_shopping_mall.service.InitializeService;

import static java.lang.System.exit;

/**
 * 作者：潇湘夜雨 on 2018/1/28.
 * 邮箱：879689064@qq.com
 */

public class App extends Application {
    private static App instance;
  //  public static AppComponent appComponent;

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
        //初始化数据库
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
        //在子线程中完成其他初始化
        InitializeService.start(this);
        //网络状态监听
        NetStateReceiver.registerNetworkStateReceiver(this);//初始化网络监听

    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        NetStateReceiver.unRegisterNetworkStateReceiver(this);

        android.os.Process.killProcess(android.os.Process.myPid());
        exit(0);
    }

//    public static AppComponent getAppComponent() {
//        if (appComponent == null) {
//            appComponent = DaggerAppComponent.builder()
//                    .appModule(new AppModule(instance))
//                    .build();
//
//        }
//        return appComponent;
//    }
}
