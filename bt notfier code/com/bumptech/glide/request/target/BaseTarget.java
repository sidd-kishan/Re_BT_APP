/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  com.bumptech.glide.request.Request
 *  com.bumptech.glide.request.target.Target
 */
package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.Target;

public abstract class BaseTarget<Z>
implements Target<Z> {
    private Request request;

    public Request getRequest() {
        return this.request;
    }

    public void onDestroy() {
    }

    public void onLoadCleared(Drawable drawable) {
    }

    public void onLoadFailed(Drawable drawable) {
    }

    public void onLoadStarted(Drawable drawable) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
