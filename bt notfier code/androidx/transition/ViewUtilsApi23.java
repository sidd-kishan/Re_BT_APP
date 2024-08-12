/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  androidx.transition.ViewUtilsApi22
 */
package androidx.transition;

import android.os.Build;
import android.view.View;
import androidx.transition.ViewUtilsApi22;

class ViewUtilsApi23
extends ViewUtilsApi22 {
    private static boolean sTryHiddenSetTransitionVisibility = true;

    ViewUtilsApi23() {
    }

    public void setTransitionVisibility(View view, int n) {
        if (Build.VERSION.SDK_INT == 28) {
            super.setTransitionVisibility(view, n);
        } else {
            if (!sTryHiddenSetTransitionVisibility) return;
            try {
                view.setTransitionVisibility(n);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                sTryHiddenSetTransitionVisibility = false;
            }
        }
    }
}
