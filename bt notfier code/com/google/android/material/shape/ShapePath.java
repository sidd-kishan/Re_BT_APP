/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Path
 *  com.google.android.material.shape.ShapePath$PathArcOperation
 *  com.google.android.material.shape.ShapePath$PathLineOperation
 *  com.google.android.material.shape.ShapePath$PathOperation
 *  com.google.android.material.shape.ShapePath$PathQuadOperation
 */
package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import com.google.android.material.shape.ShapePath;
import java.util.ArrayList;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public class ShapePath {
    public float endX;
    public float endY;
    private final List<PathOperation> operations = new ArrayList<PathOperation>();
    public float startX;
    public float startY;

    public ShapePath() {
        this.reset(0.0f, 0.0f);
    }

    public ShapePath(float f, float f2) {
        this.reset(f, f2);
    }

    public void addArc(float f, float f2, float f3, float f4, float f5, float f6) {
        PathArcOperation pathArcOperation = new PathArcOperation(f, f2, f3, f4);
        pathArcOperation.startAngle = f5;
        pathArcOperation.sweepAngle = f6;
        this.operations.add((PathOperation)pathArcOperation);
        float f7 = (f3 - f) / 2.0f;
        double d = f5 + f6;
        this.endX = (f + f3) * 0.5f + f7 * (float)Math.cos(Math.toRadians(d));
        this.endY = (f2 + f4) * 0.5f + (f4 - f2) / 2.0f * (float)Math.sin(Math.toRadians(d));
    }

    public void applyToPath(Matrix matrix, Path path) {
        int n = this.operations.size();
        int n2 = 0;
        while (n2 < n) {
            this.operations.get(n2).applyToPath(matrix, path);
            ++n2;
        }
    }

    public void lineTo(float f, float f2) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        PathLineOperation.access$002((PathLineOperation)pathLineOperation, (float)f);
        PathLineOperation.access$102((PathLineOperation)pathLineOperation, (float)f2);
        this.operations.add((PathOperation)pathLineOperation);
        this.endX = f;
        this.endY = f2;
    }

    public void quadToPoint(float f, float f2, float f3, float f4) {
        PathQuadOperation pathQuadOperation = new PathQuadOperation();
        pathQuadOperation.controlX = f;
        pathQuadOperation.controlY = f2;
        pathQuadOperation.endX = f3;
        pathQuadOperation.endY = f4;
        this.operations.add((PathOperation)pathQuadOperation);
        this.endX = f3;
        this.endY = f4;
    }

    public void reset(float f, float f2) {
        this.startX = f;
        this.startY = f2;
        this.endX = f;
        this.endY = f2;
        this.operations.clear();
    }
}
