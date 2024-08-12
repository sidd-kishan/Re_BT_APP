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

static class SplineSet.RotationSet
extends SplineSet {
    SplineSet.RotationSet() {
    }

    public void setProperty(View view, float f) {
        view.setRotation(this.get(f));
    }
}
