/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.manager.LifecycleListener
 */
package com.bumptech.glide.manager;

import com.bumptech.glide.manager.LifecycleListener;

public interface Lifecycle {
    public void addListener(LifecycleListener var1);

    public void removeListener(LifecycleListener var1);
}
