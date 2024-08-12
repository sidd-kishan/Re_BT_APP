/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.material.shape.CornerTreatment
 *  com.google.android.material.shape.ShapePath
 */
package com.google.android.material.shape;

import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.ShapePath;

public class CutCornerTreatment
extends CornerTreatment {
    private final float size;

    public CutCornerTreatment(float f) {
        this.size = f;
    }

    public void getCornerPath(float f, float f2, ShapePath shapePath) {
        shapePath.reset(0.0f, this.size * f2);
        double d = f;
        double d2 = Math.sin(d);
        double d3 = this.size;
        Double.isNaN(d3);
        double d4 = f2;
        Double.isNaN(d4);
        f = (float)(d2 * d3 * d4);
        d3 = Math.cos(d);
        d = this.size;
        Double.isNaN(d);
        Double.isNaN(d4);
        shapePath.lineTo(f, (float)(d3 * d * d4));
    }
}
