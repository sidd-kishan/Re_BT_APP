/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.lianhezhuli.btnotification.Constants
 *  com.lianhezhuli.btnotification.MApplication
 *  com.lianhezhuli.btnotification.advert.AdHelper
 *  com.lianhezhuli.btnotification.network.NetWorkManager
 *  com.lianhezhuli.btnotification.network.bean.AdvertReportBean
 *  com.lianhezhuli.btnotification.network.exception.ApiException
 *  com.lianhezhuli.btnotification.network.request._$$Lambda$RequestUtils$7ao4400uqxc5AkQ_OKqxyXE3JLU
 *  com.lianhezhuli.btnotification.network.request._$$Lambda$RequestUtils$8h4Ya5hRppIX1nm67Qc5vwNRDME
 *  com.lianhezhuli.btnotification.network.request._$$Lambda$RequestUtils$AxbTd69H8UCp6lC2ewrsTDEvEE8
 *  com.lianhezhuli.btnotification.network.request._$$Lambda$RequestUtils$ERR_IWm4nQnhSJ8O8v4OoQeANP0
 *  com.lianhezhuli.btnotification.network.request._$$Lambda$RequestUtils$N8RMoAIOUFtGP737MbX2CwaHC3s
 *  com.lianhezhuli.btnotification.network.request._$$Lambda$RequestUtils$Nk9LsCqsSD1hWshy4mPoCiueqMs
 *  com.lianhezhuli.btnotification.network.request._$$Lambda$RequestUtils$WEROxsCVPl6YgjbYWu_xAL_TExY
 *  com.lianhezhuli.btnotification.network.request._$$Lambda$RequestUtils$bZ9LOZc3tpXxAzV0bzs7snA_NG8
 *  com.lianhezhuli.btnotification.network.request._$$Lambda$RequestUtils$fXrPJ02YXRs9zBB4uvnn3itckNY
 *  com.lianhezhuli.btnotification.network.request._$$Lambda$RequestUtils$gJEqCGWRogg6IwCwFUxXjac7LfA
 *  com.lianhezhuli.btnotification.utils.SignUtils
 *  com.lianhezhuli.btnotification.utils.SpUtils
 *  com.lianhezhuli.btnotification.utils.Utils
 *  io.reactivex.Observable
 *  io.reactivex.functions.Consumer
 */
package com.lianhezhuli.btnotification.network.request;

import android.content.Context;
import com.lianhezhuli.btnotification.Constants;
import com.lianhezhuli.btnotification.MApplication;
import com.lianhezhuli.btnotification.advert.AdHelper;
import com.lianhezhuli.btnotification.network.NetWorkManager;
import com.lianhezhuli.btnotification.network.bean.AdvertReportBean;
import com.lianhezhuli.btnotification.network.exception.ApiException;
import com.lianhezhuli.btnotification.network.request._$;
import com.lianhezhuli.btnotification.utils.SignUtils;
import com.lianhezhuli.btnotification.utils.SpUtils;
import com.lianhezhuli.btnotification.utils.Utils;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.Map;

public class RequestUtils {
    static /* synthetic */ void lambda$postAdvertClick$4(AdvertReportBean advertReportBean) throws Exception {
        RequestUtils.setAdvertLimit(advertReportBean);
    }

    static /* synthetic */ void lambda$postAdvertClick$5(Throwable throwable) throws Exception {
    }

    static /* synthetic */ void lambda$postAdvertError$6(AdvertReportBean advertReportBean) throws Exception {
        RequestUtils.setAdvertLimit(advertReportBean);
    }

    static /* synthetic */ void lambda$postAdvertError$7(Throwable throwable) throws Exception {
        if (!"no_login".equalsIgnoreCase(((ApiException)throwable).getCode())) return;
        RequestUtils.setLogout();
    }

    static /* synthetic */ void lambda$postAdvertLoad$0(AdvertReportBean advertReportBean) throws Exception {
        RequestUtils.setAdvertLimit(advertReportBean);
    }

    static /* synthetic */ void lambda$postAdvertLoad$1(Throwable throwable) throws Exception {
        if (!"no_login".equalsIgnoreCase(((ApiException)throwable).getCode())) return;
        RequestUtils.setLogout();
    }

    static /* synthetic */ void lambda$postAdvertPlayed$8(AdvertReportBean advertReportBean) throws Exception {
        RequestUtils.setAdvertLimit(advertReportBean);
    }

    static /* synthetic */ void lambda$postAdvertPlayed$9(Throwable throwable) throws Exception {
    }

    static /* synthetic */ void lambda$postAdvertShow$2(AdvertReportBean advertReportBean) throws Exception {
        RequestUtils.setAdvertLimit(advertReportBean);
    }

    static /* synthetic */ void lambda$postAdvertShow$3(Throwable throwable) throws Exception {
        if (!"no_login".equalsIgnoreCase(((ApiException)throwable).getCode())) return;
        RequestUtils.setLogout();
    }

    public static void postAdvertClick(int n, int n2, String string, String string2, String string3) {
        Map map = Constants.getPubQueryMap();
        map.put("app_version", Utils.getVersion((Context)MApplication.getInstance()));
        map.put("config_id", String.valueOf(MApplication.getInstance().getAdvertConfigBean().getConfig().getConfigId()));
        map.put("code_id", String.valueOf(n2));
        map.put("item_id", String.valueOf(n));
        map.put("posid", string3);
        map.put("position_id", string);
        map.put("union_id", string2);
        map.put("sign", SignUtils.getSign((Map)map, (boolean)true));
        NetWorkManager.toSubscribe((Observable)NetWorkManager.getRequest().postAdvertClick(map), (Consumer)_$.Lambda.RequestUtils.Nk9LsCqsSD1hWshy4mPoCiueqMs.INSTANCE, (Consumer)_$.Lambda.RequestUtils.AxbTd69H8UCp6lC2ewrsTDEvEE8.INSTANCE);
    }

    public static void postAdvertError(int n, int n2, String string, String string2, String string3, String string4) {
        Map map = Constants.getPubQueryMap();
        map.put("app_version", Utils.getVersion((Context)MApplication.getInstance()));
        map.put("config_id", String.valueOf(MApplication.getInstance().getAdvertConfigBean().getConfig().getConfigId()));
        map.put("code_id", String.valueOf(n2));
        map.put("item_id", String.valueOf(n));
        map.put("msg", string4);
        map.put("posid", string3);
        map.put("position_id", string);
        map.put("union_id", string2);
        map.put("sign", SignUtils.getSign((Map)map, (boolean)true));
        NetWorkManager.toSubscribe((Observable)NetWorkManager.getRequest().postAdvertError(map), (Consumer)_$.Lambda.RequestUtils.fXrPJ02YXRs9zBB4uvnn3itckNY.INSTANCE, (Consumer)_$.Lambda.RequestUtils.gJEqCGWRogg6IwCwFUxXjac7LfA.INSTANCE);
    }

    public static void postAdvertLoad(int n, int n2, String string, String string2, String string3) {
        Map map = Constants.getPubQueryMap();
        map.put("app_version", Utils.getVersion((Context)MApplication.getInstance()));
        map.put("config_id", String.valueOf(MApplication.getInstance().getAdvertConfigBean().getConfig().getConfigId()));
        map.put("code_id", String.valueOf(n2));
        map.put("item_id", String.valueOf(n));
        map.put("posid", string3);
        map.put("position_id", string);
        map.put("union_id", string2);
        map.put("sign", SignUtils.getSign((Map)map, (boolean)true));
        NetWorkManager.toSubscribe((Observable)NetWorkManager.getRequest().postAdvertLoad(map), (Consumer)_$.Lambda.RequestUtils.8h4Ya5hRppIX1nm67Qc5vwNRDME.INSTANCE, (Consumer)_$.Lambda.RequestUtils.7ao4400uqxc5AkQ_OKqxyXE3JLU.INSTANCE);
    }

    public static void postAdvertPlayed(int n, int n2, String string, String string2, String string3, int n3) {
        Map map = Constants.getPubQueryMap();
        map.put("app_version", Utils.getVersion((Context)MApplication.getInstance()));
        map.put("config_id", String.valueOf(MApplication.getInstance().getAdvertConfigBean().getConfig().getConfigId()));
        map.put("code_id", String.valueOf(n2));
        map.put("item_id", String.valueOf(n));
        map.put("play_time", String.valueOf(n3));
        map.put("posid", string3);
        map.put("position_id", string);
        map.put("union_id", string2);
        map.put("sign", SignUtils.getSign((Map)map, (boolean)true));
        NetWorkManager.toSubscribe((Observable)NetWorkManager.getRequest().postAdvertPlayed(map), (Consumer)_$.Lambda.RequestUtils.ERR_IWm4nQnhSJ8O8v4OoQeANP0.INSTANCE, (Consumer)_$.Lambda.RequestUtils.WEROxsCVPl6YgjbYWu_xAL_TExY.INSTANCE);
    }

    public static void postAdvertShow(int n, int n2, String string, String string2, String string3, String string4) {
        Map map = Constants.getPubQueryMap();
        map.put("app_version", Utils.getVersion((Context)MApplication.getInstance()));
        map.put("config_id", String.valueOf(MApplication.getInstance().getAdvertConfigBean().getConfig().getConfigId()));
        map.put("code_id", String.valueOf(n2));
        map.put("item_id", String.valueOf(n));
        map.put("posid", string3);
        map.put("msg", string4);
        map.put("position_id", string);
        map.put("union_id", string2);
        map.put("sign", SignUtils.getSign((Map)map, (boolean)true));
        NetWorkManager.toSubscribe((Observable)NetWorkManager.getRequest().postAdvertShow(map), (Consumer)_$.Lambda.RequestUtils.bZ9LOZc3tpXxAzV0bzs7snA_NG8.INSTANCE, (Consumer)_$.Lambda.RequestUtils.N8RMoAIOUFtGP737MbX2CwaHC3s.INSTANCE);
    }

    private static void setAdvertLimit(AdvertReportBean advertReportBean) {
        if (advertReportBean.getIsLogout() == 1) {
            MApplication.getInstance().setShowAd(false);
            SpUtils.clearShareData((String)"anonymous_last_login_time");
            return;
        }
        if (advertReportBean.getIsLimit() != 1) return;
        AdHelper.getInstance().setAdvertLimit(advertReportBean);
    }

    private static void setLogout() {
        SpUtils.saveData((String)"anonymous_last_login_time", (Object)0L);
        MApplication.getInstance().setShowAd(false);
    }
}
