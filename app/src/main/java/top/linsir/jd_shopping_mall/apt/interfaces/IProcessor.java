package top.linsir.jd_shopping_mall.apt.interfaces;

import jd_shopping_mall.linsir.top.apt.AnnotationProcessor;

/**
 * 作者：潇湘夜雨 on 2018/2/2.
 * 邮箱：879689064@qq.com
 */

public interface IProcessor {
    void process(RoundEnvironment roundEnv, AnnotationProcessor mAbstractProcessor);
}

