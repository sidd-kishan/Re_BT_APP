/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.drawable.Drawable
 */
package com.google.android.material.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

public class DrawableUtils {
    private DrawableUtils() {
    }

    public static PorterDuffColorFilter updateTintFilter(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null) return null;
        if (mode != null) return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
        return null;
    }
}
