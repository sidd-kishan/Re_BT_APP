/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.ColorFilter
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.InsetDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.RippleDrawable
 */
package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;

class MaterialButtonBackgroundDrawable
extends RippleDrawable {
    MaterialButtonBackgroundDrawable(ColorStateList colorStateList, InsetDrawable insetDrawable, Drawable drawable) {
        super(colorStateList, (Drawable)insetDrawable, drawable);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.getDrawable(0) == null) return;
        ((GradientDrawable)((LayerDrawable)((InsetDrawable)this.getDrawable(0)).getDrawable()).getDrawable(0)).setColorFilter(colorFilter);
    }
}
