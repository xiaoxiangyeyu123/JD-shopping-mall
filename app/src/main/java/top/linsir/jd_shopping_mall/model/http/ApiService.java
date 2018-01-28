package top.linsir.jd_shopping_mall.model.http;


import io.reactivex.Flowable;
import retrofit2.http.POST;
import top.linsir.jd_shopping_mall.base.BaseRespose;
import top.linsir.jd_shopping_mall.model.bean.User;


/**
 * Created by boxu on 2017/4/4.
 */

public interface ApiService {
    @POST("Home/User/login")
    Flowable<BaseRespose<User>> postData();

}
