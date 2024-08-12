/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 */
package androidx.transition;

import android.animation.TypeEvaluator;

class FloatArrayEvaluator
implements TypeEvaluator<float[]> {
    private float[] mArray;

    FloatArrayEvaluator(float[] fArray) {
        this.mArray = fArray;
    }

    public float[] evaluate(float f, float[] fArray, float[] fArray2) {
        float[] fArray3;
        float[] fArray4 = fArray3 = this.mArray;
        if (fArray3 == null) {
            fArray4 = new float[fArray.length];
        }
        int n = 0;
        while (n < fArray4.length) {
            float f2 = fArray[n];
            fArray4[n] = f2 + (fArray2[n] - f2) * f;
            ++n;
        }
        return fArray4;
    }
}
