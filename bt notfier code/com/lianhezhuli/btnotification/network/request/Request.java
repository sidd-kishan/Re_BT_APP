/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.bean.AppVersionBean
 *  com.lianhezhuli.btnotification.network.bean.AdvertConfigBean
 *  com.lianhezhuli.btnotification.network.bean.AdvertReportBean
 *  com.lianhezhuli.btnotification.network.bean.AnonymousLoginBean
 *  com.lianhezhuli.btnotification.network.bean.LoginBean
 *  com.lianhezhuli.btnotification.network.response.Response
 *  io.reactivex.Flowable
 *  io.reactivex.Observable
 *  okhttp3.ResponseBody
 *  retrofit2.http.Field
 *  retrofit2.http.FieldMap
 *  retrofit2.http.FormUrlEncoded
 *  retrofit2.http.GET
 *  retrofit2.http.POST
 *  retrofit2.http.QueryMap
 *  retrofit2.http.Streaming
 *  retrofit2.http.Url
 */
package com.lianhezhuli.btnotification.network.request;

import com.lianhezhuli.btnotification.bean.AppVersionBean;
import com.lianhezhuli.btnotification.network.bean.AdvertConfigBean;
import com.lianhezhuli.btnotification.network.bean.AdvertReportBean;
import com.lianhezhuli.btnotification.network.bean.AnonymousLoginBean;
import com.lianhezhuli.btnotification.network.bean.LoginBean;
import com.lianhezhuli.btnotification.network.response.Response;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface Request {
    @GET
    @Streaming
    public Flowable<ResponseBody> download(@Url String var1);

    @GET(value="advert_config/get_advert_config")
    public Observable<Response<AdvertConfigBean>> getAdvertConfig(@QueryMap Map<String, String> var1);

    @FormUrlEncoded
    @POST(value="admin/v1/version/getNewAppVersion.v1")
    public Observable<Response<AppVersionBean>> getAppVersion(@Field(value="type") String var1, @Field(value="versionName") String var2);

    @FormUrlEncoded
    @POST(value="advert_census/on_click")
    public Observable<Response<AdvertReportBean>> postAdvertClick(@FieldMap Map<String, String> var1);

    @FormUrlEncoded
    @POST(value="advert_census/on_error")
    public Observable<Response<AdvertReportBean>> postAdvertError(@FieldMap Map<String, String> var1);

    @FormUrlEncoded
    @POST(value="advert_census/on_load")
    public Observable<Response<AdvertReportBean>> postAdvertLoad(@FieldMap Map<String, String> var1);

    @FormUrlEncoded
    @POST(value="advert_census/on_played")
    public Observable<Response<AdvertReportBean>> postAdvertPlayed(@FieldMap Map<String, String> var1);

    @FormUrlEncoded
    @POST(value="advert_census/on_show")
    public Observable<Response<AdvertReportBean>> postAdvertShow(@FieldMap Map<String, String> var1);

    @FormUrlEncoded
    @POST(value="login_anonymous/login")
    public Observable<Response<AnonymousLoginBean>> postAnonymousLogin(@FieldMap Map<String, String> var1);

    @FormUrlEncoded
    @POST(value="member_devices/bind_mac")
    public Observable<Response<String>> postBindMac(@FieldMap Map<String, String> var1);

    @FormUrlEncoded
    @POST(value="login_account/login")
    public Observable<Response<AnonymousLoginBean>> postLogin(@FieldMap Map<String, String> var1);

    @FormUrlEncoded
    @POST(value="login_renew/login")
    public Observable<Response<LoginBean>> postLoginRenew(@FieldMap Map<String, String> var1);
}
