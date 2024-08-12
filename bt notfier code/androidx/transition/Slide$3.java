/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.transition.Slide$CalculateSlideVertical
 */
package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Slide;

class Slide.3
extends Slide.CalculateSlideVertical {
    Slide.3() {
        super(null);
    }

    public float getGoneY(ViewGroup viewGroup, View view) {
        return view.getTranslationY() - (float)viewGroup.getHeight();
    }
}
