/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.view.View
 *  androidx.transition.ViewUtilsApi19
 */
package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import androidx.transition.ViewUtilsApi19;

class ViewUtilsApi21
extends ViewUtilsApi19 {
    private static boolean sTryHiddenSetAnimationMatrix = true;
    private static boolean sTryHiddenTransformMatrixToGlobal = true;
    private static boolean sTryHiddenTransformMatrixToLocal = true;

    ViewUtilsApi21() {
    }

    public void setAnimationMatrix(View view, Matrix matrix) {
        if (!sTryHiddenSetAnimationMatrix) return;
        try {
            view.setAnimationMatrix(matrix);
        }
        catch (NoSuchMethodError noSuchMethodError) {
            sTryHiddenSetAnimationMatrix = false;
        }
    }

    public void transformMatrixToGlobal(View view, Matrix matrix) {
        if (!sTryHiddenTransformMatrixToGlobal) return;
        try {
            view.transformMatrixToGlobal(matrix);
        }
        catch (NoSuchMethodError noSuchMethodError) {
            sTryHiddenTransformMatrixToGlobal = false;
        }
    }

    public void transformMatrixToLocal(View view, Matrix matrix) {
        if (!sTryHiddenTransformMatrixToLocal) return;
        try {
            view.transformMatrixToLocal(matrix);
        }
        catch (NoSuchMethodError noSuchMethodError) {
            sTryHiddenTransformMatrixToLocal = false;
        }
    }
}
