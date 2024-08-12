/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.TransitionDrawable
 *  com.bumptech.glide.request.transition.Transition
 *  com.bumptech.glide.request.transition.Transition$ViewAdapter
 */
package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.transition.Transition;

public class DrawableCrossFadeTransition
implements Transition<Drawable> {
    private final int duration;
    private final boolean isCrossFadeEnabled;

    public DrawableCrossFadeTransition(int n, boolean bl) {
        this.duration = n;
        this.isCrossFadeEnabled = bl;
    }

    public boolean transition(Drawable drawable, Transition.ViewAdapter viewAdapter) {
        Drawable drawable2;
        Drawable drawable3 = drawable2 = viewAdapter.getCurrentDrawable();
        if (drawable2 == null) {
            drawable3 = new ColorDrawable(0);
        }
        drawable = new TransitionDrawable(new Drawable[]{drawable3, drawable});
        drawable.setCrossFadeEnabled(this.isCrossFadeEnabled);
        drawable.startTransition(this.duration);
        viewAdapter.setDrawable(drawable);
        return true;
    }
}
