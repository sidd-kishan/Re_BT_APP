/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 */
package androidx.recyclerview.widget;

import android.view.animation.Interpolator;

class ItemTouchHelper.Callback.1
implements Interpolator {
    ItemTouchHelper.Callback.1() {
    }

    public float getInterpolation(float f) {
        return f * f * f * f * f;
    }
}
