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

static class TimeCycleSplineSet.RotationSet
extends TimeCycleSplineSet {
    TimeCycleSplineSet.RotationSet() {
    }

    public boolean setProperty(View view, float f, long l, KeyCache keyCache) {
        view.setRotation(this.get(f, l, view, keyCache));
        return this.mContinue;
    }
}