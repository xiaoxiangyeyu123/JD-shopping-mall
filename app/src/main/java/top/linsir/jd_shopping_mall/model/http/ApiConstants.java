
package top.linsir.jd_shopping_mall.model.http;

public class ApiConstants {
public static final String BASEURL="http://rap2api.taobao.org/";
public static final boolean LOG_DEBUG = false;


    /**
     * 获取对应的host
     *
     * @param hostType host类型
     * @return host
     */
    public static String getHost(int hostType) {
        String host;
        switch (hostType) {
            case HostType.HOME_NEW_LIST:
                host = "";
                break;
            case HostType.PICTURE_NEW_LIST:
                host = "";
                break;

            default:
                host = "";
                break;
        }
        return host;
    }
}
