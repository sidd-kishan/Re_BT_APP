/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 *  androidx.core.app.ActivityRecreator
 */
package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.core.app.ActivityRecreator;

/*
 * Exception performing whole class analysis ignored.
 */
private static final class ActivityRecreator.LifecycleCheckCallbacks
implements Application.ActivityLifecycleCallbacks {
    Object currentlyRecreatingToken;
    private Activity mActivity;
    private boolean mDestroyed = false;
    private final int mRecreatingHashCode;
    private boolean mStarted = false;
    private boolean mStopQueued = false;

    ActivityRecreator.LifecycleCheckCallbacks(Activity activity) {
        this.mActivity = activity;
        this.mRecreatingHashCode = activity.hashCode();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        if (this.mActivity != activity) return;
        this.mActivity = null;
        this.mDestroyed = true;
    }

    public void onActivityPaused(Activity activity) {
        if (!this.mDestroyed) return;
        if (this.mStopQueued) return;
        if (this.mStarted) return;
        if (!ActivityRecreator.queueOnStopIfNecessary((Object)this.currentlyRecreatingToken, (int)this.mRecreatingHashCode, (Activity)activity)) return;
        this.mStopQueued = true;
        this.currentlyRecreatingToken = null;
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (this.mActivity != activity) return;
        this.mStarted = true;
    }

    public void onActivityStopped(Activity activity) {
    }
}
