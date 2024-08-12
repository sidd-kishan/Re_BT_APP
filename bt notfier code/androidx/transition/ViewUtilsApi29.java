/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.view.View
 *  androidx.transition.ViewUtilsApi23
 */
package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import androidx.transition.ViewUtilsApi23;

class ViewUtilsApi29
extends ViewUtilsApi23 {
    ViewUtilsApi29() {
    }

    public float getTransitionAlpha(View view) {
        return view.getTransitionAlpha();
    }

    public void setAnimationMatrix(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    public void setLeftTopRightBottom(View view, int n, int n2, int n3, int n4) {
        view.setLeftTopRightBottom(n, n2, n3, n4);
    }

    public void setTransitionAlpha(View view, float f) {
        view.setTransitionAlpha(f);
    }

    public void setTransitionVisibility(View view, int n) {
        view.setTransitionVisibility(n);
    }

    public void transformMatrixToGlobal(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    public void transformMatrixToLocal(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
