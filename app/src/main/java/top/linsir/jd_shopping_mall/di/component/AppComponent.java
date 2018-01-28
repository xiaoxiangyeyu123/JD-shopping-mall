package top.linsir.jd_shopping_mall.di.component;

import javax.inject.Singleton;
import dagger.Component;
import top.linsir.jd_shopping_mall.app.App;
import top.linsir.jd_shopping_mall.app.AppManager;
import top.linsir.jd_shopping_mall.di.module.AppModule;
import top.linsir.jd_shopping_mall.model.db.RealmHelper;

/**
 * 作者：潇湘夜雨 on 2018/1/28.
 * 邮箱：879689064@qq.com
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    App getContext();  // 提供App的Context

    RealmHelper realmHelper();    //提供数据库帮助类

}
