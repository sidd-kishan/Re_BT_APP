/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.manager.Lifecycle
 *  com.bumptech.glide.manager.LifecycleListener
 */
package com.bumptech.glide.manager;

import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;

class ApplicationLifecycle
implements Lifecycle {
    ApplicationLifecycle() {
    }

    public void addListener(LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }

    public void removeListener(LifecycleListener lifecycleListener) {
    }
}
