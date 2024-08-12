/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.view.animation.LinearInterpolator
 *  androidx.interpolator.view.animation.FastOutLinearInInterpolator
 *  androidx.interpolator.view.animation.FastOutSlowInInterpolator
 *  androidx.interpolator.view.animation.LinearOutSlowInInterpolator
 */
package com.qmuiteam.qmui;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

public class QMUIInterpolatorStaticHolder {
    public static final Interpolator DECELERATE_INTERPOLATOR;
    public static final Interpolator FAST_OUT_LINEAR_IN_INTERPOLATOR;
    public static final Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR;
    public static final Interpolator LINEAR_INTERPOLATOR;
    public static final Interpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR;
    public static final Interpolator QUNITIC_INTERPOLATOR;

    static {
        LINEAR_INTERPOLATOR = new LinearInterpolator();
        FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
        FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
        LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();
        DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
        QUNITIC_INTERPOLATOR = new /* Unavailable Anonymous Inner Class!! */;
    }
}
