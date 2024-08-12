/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.View
 */
package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import android.view.View;

public static interface Transition.ViewAdapter {
    public Drawable getCurrentDrawable();

    public View getView();

    public void setDrawable(Drawable var1);
}
