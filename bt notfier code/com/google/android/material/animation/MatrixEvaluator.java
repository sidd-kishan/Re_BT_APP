/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 *  android.graphics.Matrix
 */
package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

public class MatrixEvaluator
implements TypeEvaluator<Matrix> {
    private final float[] tempEndValues;
    private final Matrix tempMatrix;
    private final float[] tempStartValues = new float[9];

    public MatrixEvaluator() {
        this.tempEndValues = new float[9];
        this.tempMatrix = new Matrix();
    }

    public Matrix evaluate(float f, Matrix object, Matrix object2) {
        object.getValues(this.tempStartValues);
        object2.getValues(this.tempEndValues);
        int n = 0;
        while (true) {
            if (n >= 9) {
                this.tempMatrix.setValues(this.tempEndValues);
                return this.tempMatrix;
            }
            object2 = this.tempEndValues;
            Matrix matrix = object2[n];
            object = this.tempStartValues;
            Matrix matrix2 = object[n];
            object2[n] = object[n] + (matrix - matrix2) * f;
            ++n;
        }
    }
}
