/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.util.Size
 */
package androidx.camera.view.transform;

import android.graphics.Matrix;
import android.util.Size;

public class OutputTransform {
    final Matrix mMatrix;
    final Size mViewPortSize;

    public OutputTransform(Matrix matrix, Size size) {
        this.mMatrix = matrix;
        this.mViewPortSize = size;
    }

    Matrix getMatrix() {
        return this.mMatrix;
    }

    Size getViewPortSize() {
        return this.mViewPortSize;
    }
}
