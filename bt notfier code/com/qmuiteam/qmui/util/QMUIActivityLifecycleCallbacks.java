/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 */
package com.qmuiteam.qmui.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public abstract class QMUIActivityLifecycleCallbacks
implements Application.ActivityLifecycleCallbacks {
    private final Activity mTargetActivity;

    public QMUIActivityLifecycleCallbacks(Activity activity) {
        this.mTargetActivity = activity;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        Activity activity2 = this.mTargetActivity;
        if (activity != activity2) return;
        activity2.getApplication().unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
        this.onTargetActivityDestroyed();
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    protected abstract void onTargetActivityDestroyed();
}
