/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Path
 */
package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;

public static abstract class ShapePath.PathOperation {
    protected final Matrix matrix = new Matrix();

    public abstract void applyToPath(Matrix var1, Path var2);
}
