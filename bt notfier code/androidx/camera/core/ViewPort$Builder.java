/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Rational
 *  androidx.camera.core.ViewPort
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import android.util.Rational;
import androidx.camera.core.ViewPort;
import androidx.core.util.Preconditions;

public static final class ViewPort.Builder {
    private static final int DEFAULT_LAYOUT_DIRECTION = 0;
    private static final int DEFAULT_SCALE_TYPE = 1;
    private final Rational mAspectRatio;
    private int mLayoutDirection = 0;
    private final int mRotation;
    private int mScaleType = 1;

    public ViewPort.Builder(Rational rational, int n) {
        this.mAspectRatio = rational;
        this.mRotation = n;
    }

    public ViewPort build() {
        Preconditions.checkNotNull((Object)this.mAspectRatio, (Object)"The crop aspect ratio must be set.");
        return new ViewPort(this.mScaleType, this.mAspectRatio, this.mRotation, this.mLayoutDirection);
    }

    public ViewPort.Builder setLayoutDirection(int n) {
        this.mLayoutDirection = n;
        return this;
    }

    public ViewPort.Builder setScaleType(int n) {
        this.mScaleType = n;
        return this;
    }
}
