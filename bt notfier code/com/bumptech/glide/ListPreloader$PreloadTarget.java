/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.request.target.BaseTarget
 *  com.bumptech.glide.request.target.SizeReadyCallback
 *  com.bumptech.glide.request.transition.Transition
 */
package com.bumptech.glide;

import com.bumptech.glide.request.target.BaseTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;

private static final class ListPreloader.PreloadTarget
extends BaseTarget<Object> {
    int photoHeight;
    int photoWidth;

    ListPreloader.PreloadTarget() {
    }

    public void getSize(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.photoWidth, this.photoHeight);
    }

    public void onResourceReady(Object object, Transition<? super Object> transition) {
    }

    public void removeCallback(SizeReadyCallback sizeReadyCallback) {
    }
}
