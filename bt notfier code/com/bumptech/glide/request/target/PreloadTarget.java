/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  com.bumptech.glide.RequestManager
 *  com.bumptech.glide.request.target.SimpleTarget
 *  com.bumptech.glide.request.target.Target
 *  com.bumptech.glide.request.transition.Transition
 */
package com.bumptech.glide.request.target;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

public final class PreloadTarget<Z>
extends SimpleTarget<Z> {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper(), (Handler.Callback)new /* Unavailable Anonymous Inner Class!! */);
    private static final int MESSAGE_CLEAR = 1;
    private final RequestManager requestManager;

    private PreloadTarget(RequestManager requestManager, int n, int n2) {
        super(n, n2);
        this.requestManager = requestManager;
    }

    public static <Z> PreloadTarget<Z> obtain(RequestManager requestManager, int n, int n2) {
        return new PreloadTarget<Z>(requestManager, n, n2);
    }

    void clear() {
        this.requestManager.clear((Target)this);
    }

    public void onResourceReady(Z z, Transition<? super Z> transition) {
        HANDLER.obtainMessage(1, (Object)this).sendToTarget();
    }
}
