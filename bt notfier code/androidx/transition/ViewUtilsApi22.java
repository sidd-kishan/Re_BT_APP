/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.transition.ViewUtilsApi21
 */
package androidx.transition;

import android.view.View;
import androidx.transition.ViewUtilsApi21;

class ViewUtilsApi22
extends ViewUtilsApi21 {
    private static boolean sTryHiddenSetLeftTopRightBottom = true;

    ViewUtilsApi22() {
    }

    public void setLeftTopRightBottom(View view, int n, int n2, int n3, int n4) {
        if (!sTryHiddenSetLeftTopRightBottom) return;
        try {
            view.setLeftTopRightBottom(n, n2, n3, n4);
        }
        catch (NoSuchMethodError noSuchMethodError) {
            sTryHiddenSetLeftTopRightBottom = false;
        }
    }
}
