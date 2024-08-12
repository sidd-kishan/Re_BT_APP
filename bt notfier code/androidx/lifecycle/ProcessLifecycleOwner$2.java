/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ProcessLifecycleOwner
 *  androidx.lifecycle.ReportFragment$ActivityInitializationListener
 */
package androidx.lifecycle;

import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.lifecycle.ReportFragment;

class ProcessLifecycleOwner.2
implements ReportFragment.ActivityInitializationListener {
    final ProcessLifecycleOwner this$0;

    ProcessLifecycleOwner.2(ProcessLifecycleOwner processLifecycleOwner) {
        this.this$0 = processLifecycleOwner;
    }

    public void onCreate() {
    }

    public void onResume() {
        this.this$0.activityResumed();
    }

    public void onStart() {
        this.this$0.activityStarted();
    }
}
