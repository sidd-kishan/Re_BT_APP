/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  androidx.lifecycle.EmptyActivityLifecycleCallbacks
 *  androidx.lifecycle.ReportFragment
 */
package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.EmptyActivityLifecycleCallbacks;
import androidx.lifecycle.ReportFragment;

static class LifecycleDispatcher.DispatcherActivityCallback
extends EmptyActivityLifecycleCallbacks {
    LifecycleDispatcher.DispatcherActivityCallback() {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        ReportFragment.injectIfNeededIn((Activity)activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
