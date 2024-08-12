/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.bumptech.glide.request.target.SizeReadyCallback
 *  com.bumptech.glide.request.target.ViewTarget
 *  com.bumptech.glide.request.transition.Transition
 */
package com.bumptech.glide.util;

import android.view.View;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;

private static final class ViewPreloadSizeProvider.SizeViewTarget
extends ViewTarget<View, Object> {
    ViewPreloadSizeProvider.SizeViewTarget(View view, SizeReadyCallback sizeReadyCallback) {
        super(view);
        this.getSize(sizeReadyCallback);
    }

    public void onResourceReady(Object object, Transition<? super Object> transition) {
    }
}
