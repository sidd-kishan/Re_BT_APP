/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.transition.ViewUtilsBase
 */
package androidx.transition;

import android.view.View;
import androidx.transition.ViewUtilsBase;

class ViewUtilsApi19
extends ViewUtilsBase {
    private static boolean sTryHiddenTransitionAlpha = true;

    ViewUtilsApi19() {
    }

    public void clearNonTransitionAlpha(View view) {
    }

    public float getTransitionAlpha(View view) {
        if (!sTryHiddenTransitionAlpha) return view.getAlpha();
        try {
            float f = view.getTransitionAlpha();
            return f;
        }
        catch (NoSuchMethodError noSuchMethodError) {
            sTryHiddenTransitionAlpha = false;
        }
        return view.getAlpha();
    }

    public void saveNonTransitionAlpha(View view) {
    }

    public void setTransitionAlpha(View view, float f) {
        if (sTryHiddenTransitionAlpha) {
            try {
                view.setTransitionAlpha(f);
                return;
            }
            catch (NoSuchMethodError noSuchMethodError) {
                sTryHiddenTransitionAlpha = false;
            }
        }
        view.setAlpha(f);
    }
}
