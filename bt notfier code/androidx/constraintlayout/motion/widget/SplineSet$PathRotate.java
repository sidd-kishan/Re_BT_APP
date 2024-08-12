/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.SplineSet
 */
package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.motion.widget.SplineSet;

static class SplineSet.PathRotate
extends SplineSet {
    SplineSet.PathRotate() {
    }

    public void setPathRotate(View view, float f, double d, double d2) {
        view.setRotation(this.get(f) + (float)Math.toDegrees(Math.atan2(d2, d)));
    }

    public void setProperty(View view, float f) {
    }
}
