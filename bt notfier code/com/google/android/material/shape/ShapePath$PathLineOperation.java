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

public static class ShapePath.PathLineOperation
extends ShapePath.PathOperation {
    private float x;
    private float y;

    static /* synthetic */ float access$002(ShapePath.PathLineOperation pathLineOperation, float f) {
        pathLineOperation.x = f;
        return f;
    }

    static /* synthetic */ float access$102(ShapePath.PathLineOperation pathLineOperation, float f) {
        pathLineOperation.y = f;
        return f;
    }

    public void applyToPath(Matrix matrix, Path path) {
        Matrix matrix2 = this.matrix;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.x, this.y);
        path.transform(matrix);
    }
}
