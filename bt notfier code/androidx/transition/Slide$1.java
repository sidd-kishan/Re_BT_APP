/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.transition.Slide$CalculateSlideHorizontal
 */
package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Slide;

class Slide.1
extends Slide.CalculateSlideHorizontal {
    Slide.1() {
        super(null);
    }

    public float getGoneX(ViewGroup viewGroup, View view) {
        return view.getTranslationX() - (float)viewGroup.getWidth();
    }
}
