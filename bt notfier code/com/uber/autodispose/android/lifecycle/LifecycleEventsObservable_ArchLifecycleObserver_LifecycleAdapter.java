/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.GeneratedAdapter
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.MethodCallsLogger
 *  com.uber.autodispose.android.lifecycle.LifecycleEventsObservable$ArchLifecycleObserver
 */
package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;
import com.uber.autodispose.android.lifecycle.LifecycleEventsObservable;

public class LifecycleEventsObservable_ArchLifecycleObserver_LifecycleAdapter
implements GeneratedAdapter {
    final LifecycleEventsObservable.ArchLifecycleObserver mReceiver;

    LifecycleEventsObservable_ArchLifecycleObserver_LifecycleAdapter(LifecycleEventsObservable.ArchLifecycleObserver archLifecycleObserver) {
        this.mReceiver = archLifecycleObserver;
    }

    public void callMethods(LifecycleOwner lifecycleOwner, Lifecycle.Event event, boolean bl, MethodCallsLogger methodCallsLogger) {
        boolean bl2 = methodCallsLogger != null;
        if (!bl) return;
        if (bl2) {
            if (!methodCallsLogger.approveCall("onStateChange", 4)) return;
        }
        this.mReceiver.onStateChange(lifecycleOwner, event);
    }
}
