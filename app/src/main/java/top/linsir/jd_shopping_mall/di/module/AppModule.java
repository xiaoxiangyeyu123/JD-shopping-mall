package top.linsir.jd_shopping_mall.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import top.linsir.jd_shopping_mall.app.App;


/**
 * 作者：潇湘夜雨 on 2018/1/28.
 * 邮箱：879689064@qq.com
 */
@Module
public class AppModule {
    private final App application;
    public AppModule(App application) {
        this.application = application;
    }
    @Provides
    @Singleton
    App provideApplicationContext() {
        return application;
    }


}
