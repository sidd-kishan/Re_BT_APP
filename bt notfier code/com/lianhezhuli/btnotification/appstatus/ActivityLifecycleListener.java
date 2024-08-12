/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 *  com.lianhezhuli.btnotification.appstatus.AppStatusHelper
 */
package com.lianhezhuli.btnotification.appstatus;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.lianhezhuli.btnotification.appstatus.AppStatusHelper;

public class ActivityLifecycleListener
implements Application.ActivityLifecycleCallbacks {
    private int refCount = 0;
    private Activity topActivity;

    public Activity getTopActivity() {
        return this.topActivity;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        this.topActivity = activity;
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        int n;
        this.refCount = n = this.refCount + 1;
        if (n != 1) return;
        AppStatusHelper.getInstance().notify(true);
    }

    public void onActivityStopped(Activity activity) {
        int n;
        this.refCount = n = this.refCount - 1;
        if (n != 0) return;
        AppStatusHelper.getInstance().notify(false);
    }
}
