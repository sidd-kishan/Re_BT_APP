/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  androidx.lifecycle.EmptyActivityLifecycleCallbacks
 *  androidx.lifecycle.ProcessLifecycleOwner
 *  androidx.lifecycle.ReportFragment
 */
package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.EmptyActivityLifecycleCallbacks;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.lifecycle.ReportFragment;

class ProcessLifecycleOwner.3
extends EmptyActivityLifecycleCallbacks {
    final ProcessLifecycleOwner this$0;

    ProcessLifecycleOwner.3(ProcessLifecycleOwner processLifecycleOwner) {
        this.this$0 = processLifecycleOwner;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 29) return;
        ReportFragment.get((Activity)activity).setProcessListener(this.this$0.mInitializationListener);
    }

    public void onActivityPaused(Activity activity) {
        this.this$0.activityPaused();
    }

    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        activity.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void onActivityStopped(Activity activity) {
        this.this$0.activityStopped();
    }
}
