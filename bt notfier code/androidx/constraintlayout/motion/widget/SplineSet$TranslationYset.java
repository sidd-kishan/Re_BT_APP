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

static class SplineSet.TranslationYset
extends SplineSet {
    SplineSet.TranslationYset() {
    }

    public void setProperty(View view, float f) {
        view.setTranslationY(this.get(f));
    }
}
