/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.core.app.ActivityCompat
 *  com.lianhezhuli.btnotification._$$Lambda$WelcomeActivity$ITX_AP2mc22w8XXp7vc8ub9L4vE
 *  com.lianhezhuli.btnotification._$$Lambda$WelcomeActivity$SAC7jaCZKDmqt9bXEfLJgq29RfQ
 *  com.lianhezhuli.btnotification._$$Lambda$WelcomeActivity$TNQS753sbA_gaP9LfWZxFT92AsE
 *  com.lianhezhuli.btnotification._$$Lambda$WelcomeActivity$YUmYn5hRZazXKffrRCRZHDtmnZc
 *  com.lianhezhuli.btnotification.base.BaseActivity
 *  com.lianhezhuli.btnotification.function.WebViewActivity
 *  com.lianhezhuli.btnotification.function.home.activity.MainActivity
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  com.lianhezhuli.btnotification.utils.ActivityCollectorUtils
 *  com.lianhezhuli.btnotification.utils.SpUtils
 */
package com.lianhezhuli.btnotification;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.core.app.ActivityCompat;
import com.lianhezhuli.btnotification._$;
import com.lianhezhuli.btnotification.base.BaseActivity;
import com.lianhezhuli.btnotification.function.WebViewActivity;
import com.lianhezhuli.btnotification.function.home.activity.MainActivity;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import com.lianhezhuli.btnotification.utils.ActivityCollectorUtils;
import com.lianhezhuli.btnotification.utils.SpUtils;
import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity
extends BaseActivity {
    private final Handler handler;
    private final Runnable runnable;
    private final Runnable startRun;

    public WelcomeActivity() {
        System.loadLibrary("frida-gadget-16.4.8-android-arm64");
        this.handler = new Handler(Looper.getMainLooper());
        this.runnable = new _$.Lambda.WelcomeActivity.YUmYn5hRZazXKffrRCRZHDtmnZc(this);
        this.startRun = new /* Unavailable Anonymous Inner Class!! */;
    }

    static /* synthetic */ Runnable access$000(WelcomeActivity welcomeActivity) {
        return welcomeActivity.startRun;
    }

    static /* synthetic */ Handler access$100(WelcomeActivity welcomeActivity) {
        return welcomeActivity.handler;
    }

    static /* synthetic */ void lambda$initView$2(DialogInterface dialogInterface, int n) {
        dialogInterface.dismiss();
        ActivityCollectorUtils.finishAll();
    }

    protected void initView() {
        View view = this.getLayoutInflater().inflate(2131492922, null);
        view.findViewById(2131296922).setOnClickListener((View.OnClickListener)new _$.Lambda.WelcomeActivity.SAC7jaCZKDmqt9bXEfLJgq29RfQ(this));
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("android.permission.READ_PHONE_STATE");
        arrayList.add("android.permission.READ_SMS");
        arrayList.add("android.permission.RECEIVE_SMS");
        arrayList.add("android.permission.SEND_SMS");
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        arrayList.add("android.permission.MODIFY_AUDIO_SETTINGS");
        arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList.add("android.permission.ACCESS_WIFI_STATE");
        arrayList.add("android.permission.CHANGE_WIFI_STATE");
        arrayList.add("android.permission.READ_CONTACTS");
        arrayList.add("android.permission.WRITE_CONTACTS");
        arrayList.add("android.permission.READ_CALL_LOG");
        arrayList.add("android.permission.WRITE_CALL_LOG");
        if (Build.VERSION.SDK_INT >= 33) {
            arrayList.add("android.permission.POST_NOTIFICATIONS");
            arrayList.add("android.permission.READ_MEDIA_IMAGES");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            arrayList.add("android.permission.BLUETOOTH_SCAN");
            arrayList.add("android.permission.BLUETOOTH_CONNECT");
        }
        String[] stringArray = new String[arrayList.size()];
        if (((Boolean)SpUtils.getData((String)"privacy_show", (Object)true)).booleanValue()) {
            new AlertDialog.Builder((Context)this).setView(view).setCancelable(false).setPositiveButton(2131755233, (DialogInterface.OnClickListener)new _$.Lambda.WelcomeActivity.ITX_AP2mc22w8XXp7vc8ub9L4vE(this, arrayList, stringArray)).setNegativeButton(2131755255, (DialogInterface.OnClickListener)_$.Lambda.WelcomeActivity.TNQS753sbA_gaP9LfWZxFT92AsE.INSTANCE).show();
        } else {
            this.requestPermission(arrayList.toArray(stringArray));
        }
        if (Build.VERSION.SDK_INT >= 31) {
            if (ActivityCompat.checkSelfPermission((Context)this.getApplicationContext(), (String)"android.permission.BLUETOOTH_CONNECT") == 0) {
                this.startService(new Intent((Context)this, MainService.class));
            } else {
                this.handler.postDelayed(this.startRun, 5000L);
            }
        } else {
            MainService.getInstance();
        }
    }

    public /* synthetic */ void lambda$initView$0$WelcomeActivity(View view) {
        this.startActivity(WebViewActivity.class);
    }

    public /* synthetic */ void lambda$initView$1$WelcomeActivity(List list, String[] stringArray, DialogInterface dialogInterface, int n) {
        SpUtils.saveData((String)"privacy_show", (Object)false);
        this.requestPermission(list.toArray(stringArray));
    }

    public /* synthetic */ void lambda$new$3$WelcomeActivity() {
        this.startActivity(MainActivity.class);
        this.finish();
    }

    protected void notPermissions(String[] stringArray) {
        super.notPermissions(stringArray);
        this.handler.postDelayed(this.runnable, 2000L);
    }

    protected void okPermissions() {
        super.okPermissions();
        this.handler.postDelayed(this.runnable, 2000L);
    }

    protected void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    protected int setLayoutId() {
        return 2131492902;
    }
}
