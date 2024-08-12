/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  com.bumptech.glide.request.target.ViewTarget
 */
package com.bumptech.glide.request.target;

import android.view.View;
import com.bumptech.glide.request.target.ViewTarget;

class ViewTarget.1
implements View.OnAttachStateChangeListener {
    final ViewTarget this$0;

    ViewTarget.1(ViewTarget viewTarget) {
        this.this$0 = viewTarget;
    }

    public void onViewAttachedToWindow(View view) {
        this.this$0.resumeMyRequest();
    }

    public void onViewDetachedFromWindow(View view) {
        this.this$0.pauseMyRequest();
    }
}
