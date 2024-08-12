/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.util.Rational
 *  androidx.camera.core.MeteringPointFactory
 *  androidx.camera.core.UseCase
 */
package androidx.camera.core;

import android.graphics.PointF;
import android.util.Rational;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.UseCase;

public class SurfaceOrientedMeteringPointFactory
extends MeteringPointFactory {
    private final float mHeight;
    private final float mWidth;

    public SurfaceOrientedMeteringPointFactory(float f, float f2) {
        this.mWidth = f;
        this.mHeight = f2;
    }

    public SurfaceOrientedMeteringPointFactory(float f, float f2, UseCase useCase) {
        super(SurfaceOrientedMeteringPointFactory.getUseCaseAspectRatio(useCase));
        this.mWidth = f;
        this.mHeight = f2;
    }

    private static Rational getUseCaseAspectRatio(UseCase useCase) {
        if (useCase == null) {
            return null;
        }
        Object object = useCase.getAttachedSurfaceResolution();
        if (object != null) {
            return new Rational(object.getWidth(), object.getHeight());
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("UseCase ");
        ((StringBuilder)object).append(useCase);
        ((StringBuilder)object).append(" is not bound.");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    protected PointF convertPoint(float f, float f2) {
        return new PointF(f / this.mWidth, f2 / this.mHeight);
    }
}
