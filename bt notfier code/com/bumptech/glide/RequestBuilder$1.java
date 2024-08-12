/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.RequestBuilder
 *  com.bumptech.glide.request.RequestFutureTarget
 *  com.bumptech.glide.request.RequestListener
 *  com.bumptech.glide.request.target.Target
 */
package com.bumptech.glide;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

class RequestBuilder.1
implements Runnable {
    final RequestBuilder this$0;
    final RequestFutureTarget val$target;

    RequestBuilder.1(RequestBuilder requestBuilder, RequestFutureTarget requestFutureTarget) {
        this.this$0 = requestBuilder;
        this.val$target = requestFutureTarget;
    }

    @Override
    public void run() {
        if (this.val$target.isCancelled()) return;
        RequestBuilder requestBuilder = this.this$0;
        RequestFutureTarget requestFutureTarget = this.val$target;
        requestBuilder.into((Target)requestFutureTarget, (RequestListener)requestFutureTarget);
    }
}
