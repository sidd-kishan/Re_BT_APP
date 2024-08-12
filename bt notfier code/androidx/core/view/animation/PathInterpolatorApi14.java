/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.view.animation.Interpolator
 */
package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

class PathInterpolatorApi14
implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    PathInterpolatorApi14(float f, float f2) {
        this(PathInterpolatorApi14.createQuad(f, f2));
    }

    PathInterpolatorApi14(float f, float f2, float f3, float f4) {
        this(PathInterpolatorApi14.createCubic(f, f2, f3, f4));
    }

    PathInterpolatorApi14(Path path) {
        path = new PathMeasure(path, false);
        float f = path.getLength();
        int n = (int)(f / 0.002f) + 1;
        this.mX = new float[n];
        this.mY = new float[n];
        float[] fArray = new float[2];
        int n2 = 0;
        while (n2 < n) {
            path.getPosTan((float)n2 * f / (float)(n - 1), fArray, null);
            this.mX[n2] = fArray[0];
            this.mY[n2] = fArray[1];
            ++n2;
        }
    }

    private static Path createCubic(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        return path;
    }

    private static Path createQuad(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        return path;
    }

    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int n = 0;
        int n2 = this.mX.length - 1;
        while (n2 - n > 1) {
            int n3 = (n + n2) / 2;
            if (f < this.mX[n3]) {
                n2 = n3;
                continue;
            }
            n = n3;
        }
        float[] fArray = this.mX;
        float f2 = fArray[n2] - fArray[n];
        if (f2 == 0.0f) {
            return this.mY[n];
        }
        f2 = (f - fArray[n]) / f2;
        fArray = this.mY;
        f = fArray[n];
        return f + f2 * (fArray[n2] - f);
    }
}
