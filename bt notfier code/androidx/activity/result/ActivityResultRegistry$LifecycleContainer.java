/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.LifecycleEventObserver
 *  androidx.lifecycle.LifecycleObserver
 */
package androidx.activity.result;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import java.util.ArrayList;
import java.util.Iterator;

private static class ActivityResultRegistry.LifecycleContainer {
    final Lifecycle mLifecycle;
    private final ArrayList<LifecycleEventObserver> mObservers;

    ActivityResultRegistry.LifecycleContainer(Lifecycle lifecycle) {
        this.mLifecycle = lifecycle;
        this.mObservers = new ArrayList();
    }

    void addObserver(LifecycleEventObserver lifecycleEventObserver) {
        this.mLifecycle.addObserver((LifecycleObserver)lifecycleEventObserver);
        this.mObservers.add(lifecycleEventObserver);
    }

    void clearObservers() {
        Iterator<LifecycleEventObserver> iterator = this.mObservers.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.mObservers.clear();
                return;
            }
            LifecycleEventObserver lifecycleEventObserver = iterator.next();
            this.mLifecycle.removeObserver((LifecycleObserver)lifecycleEventObserver);
        }
    }
}
