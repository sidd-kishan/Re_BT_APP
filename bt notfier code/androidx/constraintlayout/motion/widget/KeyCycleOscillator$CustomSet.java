/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator
 */
package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator;

static class KeyCycleOscillator.CustomSet
extends KeyCycleOscillator {
    float[] value = new float[1];

    KeyCycleOscillator.CustomSet() {
    }

    public void setProperty(View view, float f) {
        this.value[0] = this.get(f);
        this.mCustom.setInterpolatedValue(view, this.value);
    }
}
