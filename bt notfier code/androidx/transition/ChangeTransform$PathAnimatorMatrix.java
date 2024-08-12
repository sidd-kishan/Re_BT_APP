/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.PointF
 *  android.view.View
 *  androidx.transition.ViewUtils
 */
package androidx.transition;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.View;
import androidx.transition.ViewUtils;

private static class ChangeTransform.PathAnimatorMatrix {
    private final Matrix mMatrix = new Matrix();
    private float mTranslationX;
    private float mTranslationY;
    private final float[] mValues;
    private final View mView;

    ChangeTransform.PathAnimatorMatrix(View object, float[] fArray) {
        this.mView = object;
        object = (float[])fArray.clone();
        this.mValues = (float[])object;
        this.mTranslationX = (float)object[2];
        this.mTranslationY = (float)object[5];
        this.setAnimationMatrix();
    }

    private void setAnimationMatrix() {
        float[] fArray = this.mValues;
        fArray[2] = this.mTranslationX;
        fArray[5] = this.mTranslationY;
        this.mMatrix.setValues(fArray);
        ViewUtils.setAnimationMatrix((View)this.mView, (Matrix)this.mMatrix);
    }

    Matrix getMatrix() {
        return this.mMatrix;
    }

    void setTranslation(PointF pointF) {
        this.mTranslationX = pointF.x;
        this.mTranslationY = pointF.y;
        this.setAnimationMatrix();
    }

    void setValues(float[] fArray) {
        System.arraycopy(fArray, 0, this.mValues, 0, fArray.length);
        this.setAnimationMatrix();
    }
}
