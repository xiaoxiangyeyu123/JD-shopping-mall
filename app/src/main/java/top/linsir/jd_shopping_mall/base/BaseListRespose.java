package top.linsir.jd_shopping_mall.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hasee on 2017/6/11.
 */

public class BaseListRespose<T> implements Serializable {
        public String code;
        public String message;

        public List<T> data;

        public boolean success() {
            return "200".equals(code);
        }

        @Override
        public String toString() {
            return "BaseRespose{" +
                    "code='" + code + '\'' +
                    ", msg='" + message + '\'' +
                    ", data=" + data +
                    '}';
        }

}
