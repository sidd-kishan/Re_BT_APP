/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.util.Rational
 *  androidx.camera.core.MeteringPoint
 */
package androidx.camera.core;

import android.graphics.PointF;
import android.util.Rational;
import androidx.camera.core.MeteringPoint;

public abstract class MeteringPointFactory {
    private Rational mSurfaceAspectRatio;

    public MeteringPointFactory() {
        this(null);
    }

    public MeteringPointFactory(Rational rational) {
        this.mSurfaceAspectRatio = rational;
    }

    public static float getDefaultPointSize() {
        return 0.15f;
    }

    protected abstract PointF convertPoint(float var1, float var2);

    public final MeteringPoint createPoint(float f, float f2) {
        return this.createPoint(f, f2, MeteringPointFactory.getDefaultPointSize());
    }

    public final MeteringPoint createPoint(float f, float f2, float f3) {
        PointF pointF = this.convertPoint(f, f2);
        return new MeteringPoint(pointF.x, pointF.y, f3, this.mSurfaceAspectRatio);
    }
}
