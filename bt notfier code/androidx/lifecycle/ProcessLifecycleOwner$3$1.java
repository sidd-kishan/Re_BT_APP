/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  androidx.lifecycle.EmptyActivityLifecycleCallbacks
 *  androidx.lifecycle.ProcessLifecycleOwner$3
 */
package androidx.lifecycle;

import android.app.Activity;
import androidx.lifecycle.EmptyActivityLifecycleCallbacks;
import androidx.lifecycle.ProcessLifecycleOwner;

class ProcessLifecycleOwner.1
extends EmptyActivityLifecycleCallbacks {
    final ProcessLifecycleOwner.3 this$1;

    ProcessLifecycleOwner.1(ProcessLifecycleOwner.3 var1_1) {
        this.this$1 = var1_1;
    }

    public void onActivityPostResumed(Activity activity) {
        this.this$1.this$0.activityResumed();
    }

    public void onActivityPostStarted(Activity activity) {
        this.this$1.this$0.activityStarted();
    }
}
