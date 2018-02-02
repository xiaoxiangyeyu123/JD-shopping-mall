package top.linsir.jd_shopping_mall.utils.instance;

/**
 * 作者：潇湘夜雨 on 2018/2/2.
 * 邮箱：879689064@qq.com
 */

public interface IFactory {
    Object create(Class clazz) throws Exception;
}
