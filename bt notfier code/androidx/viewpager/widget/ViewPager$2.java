/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 */
package androidx.viewpager.widget;

import android.view.animation.Interpolator;

static final class ViewPager.2
implements Interpolator {
    ViewPager.2() {
    }

    public float getInterpolation(float f) {
        return (f -= 1.0f) * f * f * f * f + 1.0f;
    }
}
