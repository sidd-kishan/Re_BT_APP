/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 */
package com.qmuiteam.qmui;

import android.view.animation.Interpolator;

static final class QMUIInterpolatorStaticHolder.1
implements Interpolator {
    QMUIInterpolatorStaticHolder.1() {
    }

    public float getInterpolation(float f) {
        return (f -= 1.0f) * f * f * f * f + 1.0f;
    }
}
