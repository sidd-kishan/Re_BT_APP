/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.manager.Lifecycle
 *  com.bumptech.glide.manager.LifecycleListener
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.manager;

import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

class ActivityFragmentLifecycle
implements Lifecycle {
    private boolean isDestroyed;
    private boolean isStarted;
    private final Set<LifecycleListener> lifecycleListeners = Collections.newSetFromMap(new WeakHashMap());

    ActivityFragmentLifecycle() {
    }

    public void addListener(LifecycleListener lifecycleListener) {
        this.lifecycleListeners.add(lifecycleListener);
        if (this.isDestroyed) {
            lifecycleListener.onDestroy();
        } else if (this.isStarted) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    void onDestroy() {
        this.isDestroyed = true;
        Iterator iterator = Util.getSnapshot(this.lifecycleListeners).iterator();
        while (iterator.hasNext()) {
            ((LifecycleListener)iterator.next()).onDestroy();
        }
    }

    void onStart() {
        this.isStarted = true;
        Iterator iterator = Util.getSnapshot(this.lifecycleListeners).iterator();
        while (iterator.hasNext()) {
            ((LifecycleListener)iterator.next()).onStart();
        }
    }

    void onStop() {
        this.isStarted = false;
        Iterator iterator = Util.getSnapshot(this.lifecycleListeners).iterator();
        while (iterator.hasNext()) {
            ((LifecycleListener)iterator.next()).onStop();
        }
    }

    public void removeListener(LifecycleListener lifecycleListener) {
        this.lifecycleListeners.remove(lifecycleListener);
    }
}
