/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.manager.ConnectivityMonitor$ConnectivityListener
 *  com.bumptech.glide.manager.RequestTracker
 */
package com.bumptech.glide;

import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.RequestTracker;

private static class RequestManager.RequestManagerConnectivityListener
implements ConnectivityMonitor.ConnectivityListener {
    private final RequestTracker requestTracker;

    RequestManager.RequestManagerConnectivityListener(RequestTracker requestTracker) {
        this.requestTracker = requestTracker;
    }

    public void onConnectivityChanged(boolean bl) {
        if (!bl) return;
        this.requestTracker.restartRequests();
    }
}
