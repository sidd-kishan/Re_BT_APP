/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  androidx.core.app.ActivityCompat
 *  androidx.multidex.MultiDex
 *  com.google.android.gms.ads.MobileAds
 *  com.google.android.gms.ads.initialization.InitializationStatus
 *  com.google.android.gms.ads.initialization.OnInitializationCompleteListener
 *  com.lianhezhuli.btnotification._$$Lambda$MApplication$9hQKXxo7lRRbm0FcuuzLOWBFvOk
 *  com.lianhezhuli.btnotification.appstatus.ActivityLifecycleListener
 *  com.lianhezhuli.btnotification.greendao.manager.DaoManager
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  com.lianhezhuli.btnotification.mtk.service.PushAiderHelper
 *  com.lianhezhuli.btnotification.network.NetWorkManager
 *  com.lianhezhuli.btnotification.network.bean.AdvertConfigBean
 *  com.lianhezhuli.btnotification.utils.SoundPlayUtil
 *  com.lianhezhuli.btnotification.utils.SpUtils
 *  com.orhanobut.logger.LogAdapter
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.ActivityCompat;
import androidx.multidex.MultiDex;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.lianhezhuli.btnotification._$;
import com.lianhezhuli.btnotification.appstatus.ActivityLifecycleListener;
import com.lianhezhuli.btnotification.greendao.manager.DaoManager;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import com.lianhezhuli.btnotification.mtk.service.PushAiderHelper;
import com.lianhezhuli.btnotification.network.NetWorkManager;
import com.lianhezhuli.btnotification.network.bean.AdvertConfigBean;
import com.lianhezhuli.btnotification.utils.SoundPlayUtil;
import com.lianhezhuli.btnotification.utils.SpUtils;
import com.orhanobut.logger.LogAdapter;
import com.orhanobut.logger.Logger;

public class MApplication
extends Application {
    public static MApplication instance;
    private AdvertConfigBean advertConfigBean;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final boolean isDebug;
    private boolean isShowAd = false;
    private final Runnable startRun = new /* Unavailable Anonymous Inner Class!! */;

    public MApplication() {
        this.isDebug = false;
    }

    static /* synthetic */ Runnable access$000(MApplication mApplication) {
        return mApplication.startRun;
    }

    static /* synthetic */ Handler access$100(MApplication mApplication) {
        return mApplication.handler;
    }

    public static MApplication getInstance() {
        return instance;
    }

    private void initLogger() {
        Logger.addLogAdapter((LogAdapter)new /* Unavailable Anonymous Inner Class!! */);
    }

    static /* synthetic */ void lambda$onCreate$0(InitializationStatus initializationStatus) {
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install((Context)this);
    }

    public AdvertConfigBean getAdvertConfigBean() {
        return this.advertConfigBean;
    }

    public boolean isShowAd() {
        return this.isShowAd;
    }

    public void onCreate() {
        super.onCreate();
        instance = this;
        this.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new ActivityLifecycleListener());
        DaoManager.getInstance().setDebug();
        NetWorkManager.getInstance().init();
        this.initLogger();
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager)this.getSystemService("notification");
            if (notificationManager == null) {
                return;
            }
            NotificationChannel notificationChannel = new NotificationChannel("com.lianhezhuli.btnotification.notification", (CharSequence)"Notification", 3);
            notificationChannel.setDescription("");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(-65536);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{500L, 500L, 500L});
            notificationManager.createNotificationChannel(notificationChannel);
        }
        if (Build.VERSION.SDK_INT >= 31) {
            if (ActivityCompat.checkSelfPermission((Context)this.getApplicationContext(), (String)"android.permission.BLUETOOTH_CONNECT") == 0) {
                MainService.getInstance();
            } else {
                this.handler.postDelayed(this.startRun, 5000L);
            }
        } else {
            MainService.getInstance();
        }
        SpUtils.saveData((String)"user_id", (Object)"testUserId");
        SoundPlayUtil.init((Context)this);
        PushAiderHelper.getAiderHelper().start((Context)this);
        MobileAds.initialize((Context)this, (OnInitializationCompleteListener)_$.Lambda.MApplication.9hQKXxo7lRRbm0FcuuzLOWBFvOk.INSTANCE);
    }

    public void setAdvertConfigBean(AdvertConfigBean advertConfigBean) {
        this.advertConfigBean = advertConfigBean;
    }

    public void setShowAd(boolean bl) {
        this.isShowAd = bl;
    }
}
