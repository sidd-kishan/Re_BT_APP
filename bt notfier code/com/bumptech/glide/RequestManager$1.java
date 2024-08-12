/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.RequestManager
 *  com.bumptech.glide.manager.LifecycleListener
 */
package com.bumptech.glide;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.LifecycleListener;

class RequestManager.1
implements Runnable {
    final RequestManager this$0;

    RequestManager.1(RequestManager requestManager) {
        this.this$0 = requestManager;
    }

    @Override
    public void run() {
        this.this$0.lifecycle.addListener((LifecycleListener)this.this$0);
    }
}
