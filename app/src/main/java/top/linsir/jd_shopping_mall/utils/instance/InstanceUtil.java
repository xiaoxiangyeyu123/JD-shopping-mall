package top.linsir.jd_shopping_mall.utils.instance;

import java.lang.reflect.ParameterizedType;




/**
 * 作者：潇湘夜雨 on 2018/2/2.
 * 邮箱：879689064@qq.com
 */

public class InstanceUtil {
    private static IFactory iFactory;
    public static void init(IFactory factory){
        iFactory=factory;
    }

    public static <T> T getInstance(Object o,int i) {
        try {
            Class mClass = (Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i];
            return (T) iFactory.create(mClass);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
