/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.SplineSet
 */
package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.view.View;
import androidx.constraintlayout.motion.widget.SplineSet;

static class SplineSet.ElevationSet
extends SplineSet {
    SplineSet.ElevationSet() {
    }

    public void setProperty(View view, float f) {
        if (Build.VERSION.SDK_INT < 21) return;
        view.setElevation(this.get(f));
    }
}
