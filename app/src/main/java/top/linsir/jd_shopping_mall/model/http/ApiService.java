package top.linsir.jd_shopping_mall.model.http;


import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import top.linsir.jd_shopping_mall.base.BaseRespose;
import top.linsir.jd_shopping_mall.model.bean.User;


/**
 * Created by boxu on 2017/4/4. ApiService
 */

public interface ApiService {

    @FormUrlEncoded
    @POST("app/mock/373/POST//login")
    Flowable<BaseRespose<User>> postLogin(@Field("phone") String phone
            , @Field("password") String password);


    @FormUrlEncoded
    @POST("app/mock")
    Flowable<BaseRespose<User>> postRegister(@Field("phone") String phone
            , @Field("password") String password);



}
