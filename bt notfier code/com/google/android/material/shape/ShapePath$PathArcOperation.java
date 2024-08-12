/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Path
 *  android.graphics.RectF
 *  com.google.android.material.shape.ShapePath$PathOperation
 */
package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shape.ShapePath;

public static class ShapePath.PathArcOperation
extends ShapePath.PathOperation {
    private static final RectF rectF = new RectF();
    public float bottom;
    public float left;
    public float right;
    public float startAngle;
    public float sweepAngle;
    public float top;

    public ShapePath.PathArcOperation(float f, float f2, float f3, float f4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
    }

    public void applyToPath(Matrix matrix, Path path) {
        Matrix matrix2 = this.matrix;
        matrix.invert(matrix2);
        path.transform(matrix2);
        rectF.set(this.left, this.top, this.right, this.bottom);
        path.arcTo(rectF, this.startAngle, this.sweepAngle, false);
        path.transform(matrix);
    }
}
