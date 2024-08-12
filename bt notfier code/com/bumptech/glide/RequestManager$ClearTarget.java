/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.bumptech.glide.request.target.ViewTarget
 *  com.bumptech.glide.request.transition.Transition
 */
package com.bumptech.glide;

import android.view.View;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;

private static class RequestManager.ClearTarget
extends ViewTarget<View, Object> {
    RequestManager.ClearTarget(View view) {
        super(view);
    }

    public void onResourceReady(Object object, Transition<? super Object> transition) {
    }
}
