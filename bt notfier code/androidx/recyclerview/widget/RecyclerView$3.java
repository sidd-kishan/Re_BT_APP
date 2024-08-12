/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 */
package androidx.recyclerview.widget;

import android.view.animation.Interpolator;

class RecyclerView.3
implements Interpolator {
    RecyclerView.3() {
    }

    public float getInterpolation(float f) {
        return (f -= 1.0f) * f * f * f * f + 1.0f;
    }
}
