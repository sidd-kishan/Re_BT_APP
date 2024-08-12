/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.ReportFragment
 */
package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ReportFragment;

/*
 * Exception performing whole class analysis ignored.
 */
static class ReportFragment.LifecycleCallbacks
implements Application.ActivityLifecycleCallbacks {
    ReportFragment.LifecycleCallbacks() {
    }

    static void registerIn(Activity activity) {
        activity.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new ReportFragment.LifecycleCallbacks());
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityPostCreated(Activity activity, Bundle bundle) {
        ReportFragment.dispatch((Activity)activity, (Lifecycle.Event)Lifecycle.Event.ON_CREATE);
    }

    public void onActivityPostResumed(Activity activity) {
        ReportFragment.dispatch((Activity)activity, (Lifecycle.Event)Lifecycle.Event.ON_RESUME);
    }

    public void onActivityPostStarted(Activity activity) {
        ReportFragment.dispatch((Activity)activity, (Lifecycle.Event)Lifecycle.Event.ON_START);
    }

    public void onActivityPreDestroyed(Activity activity) {
        ReportFragment.dispatch((Activity)activity, (Lifecycle.Event)Lifecycle.Event.ON_DESTROY);
    }

    public void onActivityPrePaused(Activity activity) {
        ReportFragment.dispatch((Activity)activity, (Lifecycle.Event)Lifecycle.Event.ON_PAUSE);
    }

    public void onActivityPreStopped(Activity activity) {
        ReportFragment.dispatch((Activity)activity, (Lifecycle.Event)Lifecycle.Event.ON_STOP);
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
