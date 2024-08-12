/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator
 *  androidx.constraintlayout.motion.widget.SplineSet
 */
package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.SplineSet;

public class VelocityMatrix {
    private static String TAG = "VelocityMatrix";
    float mDRotate;
    float mDScaleX;
    float mDScaleY;
    float mDTranslateX;
    float mDTranslateY;
    float mRotate;

    public void applyTransform(float f, float f2, int n, int n2, float[] fArray) {
        float f3 = fArray[0];
        float f4 = fArray[1];
        f = (f - 0.5f) * 2.0f;
        float f5 = (f2 - 0.5f) * 2.0f;
        float f6 = this.mDTranslateX;
        f2 = this.mDTranslateY;
        float f7 = this.mDScaleX;
        float f8 = this.mDScaleY;
        float f9 = (float)Math.toRadians(this.mRotate);
        float f10 = (float)Math.toRadians(this.mDRotate);
        double d = (float)(-n) * f;
        double d2 = f9;
        double d3 = Math.sin(d2);
        Double.isNaN(d);
        double d4 = (float)n2 * f5;
        double d5 = Math.cos(d2);
        Double.isNaN(d4);
        f9 = (float)(d * d3 - d5 * d4);
        d = (float)n * f;
        d3 = Math.cos(d2);
        Double.isNaN(d);
        d2 = Math.sin(d2);
        Double.isNaN(d4);
        float f11 = (float)(d * d3 - d4 * d2);
        fArray[0] = f3 + f6 + f7 * f + f9 * f10;
        fArray[1] = f4 + f2 + f8 * f5 + f10 * f11;
    }

    public void clear() {
        this.mDRotate = 0.0f;
        this.mDTranslateY = 0.0f;
        this.mDTranslateX = 0.0f;
        this.mDScaleY = 0.0f;
        this.mDScaleX = 0.0f;
    }

    public void setRotationVelocity(KeyCycleOscillator keyCycleOscillator, float f) {
        if (keyCycleOscillator == null) return;
        this.mDRotate = keyCycleOscillator.getSlope(f);
    }

    public void setRotationVelocity(SplineSet splineSet, float f) {
        if (splineSet == null) return;
        this.mDRotate = splineSet.getSlope(f);
        this.mRotate = splineSet.get(f);
    }

    public void setScaleVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f) {
        if (keyCycleOscillator == null && keyCycleOscillator2 == null) {
            return;
        }
        if (keyCycleOscillator == null) {
            this.mDScaleX = keyCycleOscillator.getSlope(f);
        }
        if (keyCycleOscillator2 != null) return;
        this.mDScaleY = keyCycleOscillator2.getSlope(f);
    }

    public void setScaleVelocity(SplineSet splineSet, SplineSet splineSet2, float f) {
        if (splineSet != null) {
            this.mDScaleX = splineSet.getSlope(f);
        }
        if (splineSet2 == null) return;
        this.mDScaleY = splineSet2.getSlope(f);
    }

    public void setTranslationVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f) {
        if (keyCycleOscillator != null) {
            this.mDTranslateX = keyCycleOscillator.getSlope(f);
        }
        if (keyCycleOscillator2 == null) return;
        this.mDTranslateY = keyCycleOscillator2.getSlope(f);
    }

    public void setTranslationVelocity(SplineSet splineSet, SplineSet splineSet2, float f) {
        if (splineSet != null) {
            this.mDTranslateX = splineSet.getSlope(f);
        }
        if (splineSet2 == null) return;
        this.mDTranslateY = splineSet2.getSlope(f);
    }
}
