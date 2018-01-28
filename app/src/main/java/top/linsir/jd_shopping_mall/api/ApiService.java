package top.linsir.jd_shopping_mall.api;


import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import top.linsir.jd_shopping_mall.base.BaseRespose;
import top.linsir.jd_shopping_mall.bean.User;


/**
 * Created by boxu on 2017/4/4.
 */

public interface ApiService {
    @POST("Home/User/login")
    Flowable<BaseRespose<User>> postData();

}
