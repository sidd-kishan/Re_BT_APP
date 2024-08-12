/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 */
package com.yalantis.ucrop.callback;

import android.graphics.RectF;

public interface OverlayViewChangeListener {
    public void onCropRectUpdated(RectF var1);

    public void postTranslate(float var1, float var2);
}
