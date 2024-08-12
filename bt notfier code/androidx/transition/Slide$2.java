/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.core.view.ViewCompat
 *  androidx.transition.Slide$CalculateSlideHorizontal
 */
package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.transition.Slide;

class Slide.2
extends Slide.CalculateSlideHorizontal {
    Slide.2() {
        super(null);
    }

    public float getGoneX(ViewGroup viewGroup, View view) {
        int n = ViewCompat.getLayoutDirection((View)viewGroup);
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        float f = bl ? view.getTranslationX() + (float)viewGroup.getWidth() : view.getTranslationX() - (float)viewGroup.getWidth();
        return f;
    }
}
