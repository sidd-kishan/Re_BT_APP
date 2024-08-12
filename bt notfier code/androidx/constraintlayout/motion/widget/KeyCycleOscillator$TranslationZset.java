/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator
 */
package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.view.View;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator;

static class KeyCycleOscillator.TranslationZset
extends KeyCycleOscillator {
    KeyCycleOscillator.TranslationZset() {
    }

    public void setProperty(View view, float f) {
        if (Build.VERSION.SDK_INT < 21) return;
        view.setTranslationZ(this.get(f));
    }
}
