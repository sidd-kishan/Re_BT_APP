/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  androidx.core.app.ActivityCompat
 *  androidx.core.content.ContextCompat
 *  androidx.fragment.app.FragmentActivity
 *  butterknife.ButterKnife
 *  butterknife.Unbinder
 *  com.lianhezhuli.btnotification.utils.ActivityCollectorUtils
 *  com.lianhezhuli.btnotification.utils.ToastUtils
 *  com.orhanobut.logger.Logger
 *  com.qmuiteam.qmui.util.QMUIStatusBarHelper
 */
package com.lianhezhuli.btnotification.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.lianhezhuli.btnotification.utils.ActivityCollectorUtils;
import com.lianhezhuli.btnotification.utils.ToastUtils;
import com.orhanobut.logger.Logger;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public abstract class BaseActivity
extends FragmentActivity {
    protected final String TAG = ((Object)((Object)this)).getClass().getSimpleName();
    private long mExitTime;
    private Unbinder mUnbinder;

    protected void initSetting() {
    }

    protected abstract void initView();

    protected boolean isExit(int n) {
        if (n != 4) return false;
        if (System.currentTimeMillis() - this.mExitTime > 2000L) {
            ToastUtils.showShort((Context)this, (int)2131755198);
            this.mExitTime = System.currentTimeMillis();
        } else {
            this.finish();
        }
        return true;
    }

    protected void notPermissions(String[] stringArray) {
    }

    protected void okPermissions() {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.initSetting();
        this.setContentView(this.setLayoutId());
        QMUIStatusBarHelper.translucent((Activity)this);
        ActivityCollectorUtils.addActivity((Activity)this, ((Object)((Object)this)).getClass());
        this.mUnbinder = ButterKnife.bind((Activity)this);
        this.onCreateMap(bundle);
        this.initView();
    }

    protected void onCreateMap(Bundle bundle) {
    }

    protected void onDestroy() {
        super.onDestroy();
        ActivityCollectorUtils.removeActivity((Activity)this);
        this.mUnbinder.unbind();
    }

    public void onRequestPermissionsResult(int n, String[] object, int[] nArray) {
        super.onRequestPermissionsResult(n, (String[])object, nArray);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("requestCode == ");
        stringBuilder.append(n);
        Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        if (n != 1) return;
        if (nArray.length > 0 && nArray[0] == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("permission_granted == ");
            ((StringBuilder)object).append(nArray[0]);
            Logger.e((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
            if (this.isFinishing()) return;
            this.okPermissions();
        } else {
            Logger.e((String)"permission_den == ddddd", (Object[])new Object[0]);
            this.notPermissions((String[])object);
        }
    }

    protected void requestPermission(String[] stringArray) {
        int n = stringArray.length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.okPermissions();
                return;
            }
            String string = stringArray[n2];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("permission == ");
            stringBuilder.append(string);
            Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
            if (ContextCompat.checkSelfPermission((Context)this, (String)string) != 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("requestPermission != PERMISSION_GRANTED == ");
                stringBuilder.append(string);
                Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
                ActivityCompat.requestPermissions((Activity)this, (String[])stringArray, (int)1);
                return;
            }
            ++n2;
        }
    }

    protected abstract int setLayoutId();

    protected void startActivity(Class clazz) {
        this.startActivity(new Intent((Context)this, clazz));
    }

    protected void startActivityForResult(Class clazz, int n) {
        this.startActivityForResult(new Intent((Context)this, clazz), n);
    }
}
