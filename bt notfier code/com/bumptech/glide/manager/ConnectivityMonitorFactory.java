/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.bumptech.glide.manager.ConnectivityMonitor
 *  com.bumptech.glide.manager.ConnectivityMonitor$ConnectivityListener
 */
package com.bumptech.glide.manager;

import android.content.Context;
import com.bumptech.glide.manager.ConnectivityMonitor;

public interface ConnectivityMonitorFactory {
    public ConnectivityMonitor build(Context var1, ConnectivityMonitor.ConnectivityListener var2);
}
