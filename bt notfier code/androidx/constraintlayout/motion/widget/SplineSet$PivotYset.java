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

static class SplineSet.PivotYset
extends SplineSet {
    SplineSet.PivotYset() {
    }

    public void setProperty(View view, float f) {
        view.setPivotY(this.get(f));
    }
}
