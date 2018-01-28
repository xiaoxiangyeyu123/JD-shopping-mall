
package top.linsir.jd_shopping_mall.api;

public class ApiConstants {
public static final String BASEURL="http://www.chewuyou.vip/index.php/Home/";
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
