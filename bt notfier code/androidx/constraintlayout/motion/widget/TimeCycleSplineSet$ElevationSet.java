/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.KeyCache
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet
 */
package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.view.View;
import androidx.constraintlayout.motion.widget.KeyCache;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;

static class TimeCycleSplineSet.ElevationSet
extends TimeCycleSplineSet {
    TimeCycleSplineSet.ElevationSet() {
    }

    public boolean setProperty(View view, float f, long l, KeyCache keyCache) {
        if (Build.VERSION.SDK_INT < 21) return this.mContinue;
        view.setElevation(this.get(f, l, view, keyCache));
        return this.mContinue;
    }
}
