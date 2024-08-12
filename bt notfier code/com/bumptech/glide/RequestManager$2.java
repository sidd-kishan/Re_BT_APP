/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.RequestManager
 *  com.bumptech.glide.request.target.Target
 */
package com.bumptech.glide;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.target.Target;

class RequestManager.2
implements Runnable {
    final RequestManager this$0;
    final Target val$target;

    RequestManager.2(RequestManager requestManager, Target target) {
        this.this$0 = requestManager;
        this.val$target = target;
    }

    @Override
    public void run() {
        this.this$0.clear(this.val$target);
    }
}
