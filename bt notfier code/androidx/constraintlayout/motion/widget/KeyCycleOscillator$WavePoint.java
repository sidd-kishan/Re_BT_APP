/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.motion.widget;

static class KeyCycleOscillator.WavePoint {
    float mOffset;
    float mPeriod;
    int mPosition;
    float mValue;

    public KeyCycleOscillator.WavePoint(int n, float f, float f2, float f3) {
        this.mPosition = n;
        this.mValue = f3;
        this.mOffset = f2;
        this.mPeriod = f;
    }
}
