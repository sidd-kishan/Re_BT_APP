/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 *  android.graphics.Matrix
 */
package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

static class TransitionUtils.MatrixEvaluator
implements TypeEvaluator<Matrix> {
    final float[] mTempEndValues;
    final Matrix mTempMatrix;
    final float[] mTempStartValues = new float[9];

    TransitionUtils.MatrixEvaluator() {
        this.mTempEndValues = new float[9];
        this.mTempMatrix = new Matrix();
    }

    public Matrix evaluate(float f, Matrix object, Matrix object2) {
        object.getValues(this.mTempStartValues);
        object2.getValues(this.mTempEndValues);
        int n = 0;
        while (true) {
            if (n >= 9) {
                this.mTempMatrix.setValues(this.mTempEndValues);
                return this.mTempMatrix;
            }
            object = this.mTempEndValues;
            Matrix matrix = object[n];
            object2 = this.mTempStartValues;
            Matrix matrix2 = object2[n];
            object[n] = object2[n] + (matrix - matrix2) * f;
            ++n;
        }
    }
}
