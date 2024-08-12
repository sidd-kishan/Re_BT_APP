/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 */
package androidx.customview.widget;

import android.view.animation.Interpolator;

static final class ViewDragHelper.1
implements Interpolator {
    ViewDragHelper.1() {
    }

    public float getInterpolation(float f) {
        return (f -= 1.0f) * f * f * f * f + 1.0f;
    }
}
