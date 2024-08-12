/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Path
 *  com.google.android.material.shape.ShapePath$PathOperation
 */
package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import com.google.android.material.shape.ShapePath;

public static class ShapePath.PathQuadOperation
extends ShapePath.PathOperation {
    public float controlX;
    public float controlY;
    public float endX;
    public float endY;

    public void applyToPath(Matrix matrix, Path path) {
        Matrix matrix2 = this.matrix;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.quadTo(this.controlX, this.controlY, this.endX, this.endY);
        path.transform(matrix);
    }
}
