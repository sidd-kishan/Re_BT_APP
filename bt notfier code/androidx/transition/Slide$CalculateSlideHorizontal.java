/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.transition.Slide$CalculateSlide
 */
package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Slide;

private static abstract class Slide.CalculateSlideHorizontal
implements Slide.CalculateSlide {
    private Slide.CalculateSlideHorizontal() {
    }

    public float getGoneY(ViewGroup viewGroup, View view) {
        return view.getTranslationY();
    }
}
