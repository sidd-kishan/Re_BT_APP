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

static class KeyCycleOscillator.TranslationXset
extends KeyCycleOscillator {
    KeyCycleOscillator.TranslationXset() {
    }

    public void setProperty(View view, float f) {
        view.setTranslationX(this.get(f));
    }
}