/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.KeyCache
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet
 */
package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.motion.widget.KeyCache;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;

static class TimeCycleSplineSet.PathRotate
extends TimeCycleSplineSet {
    TimeCycleSplineSet.PathRotate() {
    }

    public boolean setPathRotate(View view, KeyCache keyCache, float f, long l, double d, double d2) {
        view.setRotation(this.get(f, l, view, keyCache) + (float)Math.toDegrees(Math.atan2(d2, d)));
        return this.mContinue;
    }

    public boolean setProperty(View view, float f, long l, KeyCache keyCache) {
        return this.mContinue;
    }
}
