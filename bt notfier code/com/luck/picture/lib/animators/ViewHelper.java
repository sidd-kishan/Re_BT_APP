/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.ViewCompat
 */
package com.luck.picture.lib.animators;

import android.view.View;
import androidx.core.view.ViewCompat;

public final class ViewHelper {
    public static void clear(View view) {
        view.setAlpha(1.0f);
        view.setScaleY(1.0f);
        view.setScaleX(1.0f);
        view.setTranslationY(0.0f);
        view.setTranslationX(0.0f);
        view.setRotation(0.0f);
        view.setRotationY(0.0f);
        view.setRotationX(0.0f);
        view.setPivotY((float)(view.getMeasuredHeight() / 2));
        view.setPivotX((float)(view.getMeasuredWidth() / 2));
        ViewCompat.animate((View)view).setInterpolator(null).setStartDelay(0L);
    }
}
