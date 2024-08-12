/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$FillType
 *  android.graphics.PathMeasure
 *  android.graphics.Shader
 *  androidx.collection.ArrayMap
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VFullPath
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VGroup
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VObject
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPath
 */
package androidx.vectordrawable.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Shader;
import androidx.collection.ArrayMap;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

/*
 * Exception performing whole class analysis ignored.
 */
private static class VectorDrawableCompat.VPathRenderer {
    private static final Matrix IDENTITY_MATRIX = new Matrix();
    float mBaseHeight = 0.0f;
    float mBaseWidth = 0.0f;
    private int mChangingConfigurations;
    Paint mFillPaint;
    private final Matrix mFinalPathMatrix = new Matrix();
    Boolean mIsStateful = null;
    private final Path mPath;
    private PathMeasure mPathMeasure;
    private final Path mRenderPath;
    int mRootAlpha = 255;
    final VectorDrawableCompat.VGroup mRootGroup;
    String mRootName = null;
    Paint mStrokePaint;
    final ArrayMap<String, Object> mVGTargetsMap;
    float mViewportHeight = 0.0f;
    float mViewportWidth = 0.0f;

    public VectorDrawableCompat.VPathRenderer() {
        this.mVGTargetsMap = new ArrayMap();
        this.mRootGroup = new VectorDrawableCompat.VGroup();
        this.mPath = new Path();
        this.mRenderPath = new Path();
    }

    public VectorDrawableCompat.VPathRenderer(VectorDrawableCompat.VPathRenderer vPathRenderer) {
        Object object;
        this.mVGTargetsMap = object = new ArrayMap();
        this.mRootGroup = new VectorDrawableCompat.VGroup(vPathRenderer.mRootGroup, object);
        this.mPath = new Path(vPathRenderer.mPath);
        this.mRenderPath = new Path(vPathRenderer.mRenderPath);
        this.mBaseWidth = vPathRenderer.mBaseWidth;
        this.mBaseHeight = vPathRenderer.mBaseHeight;
        this.mViewportWidth = vPathRenderer.mViewportWidth;
        this.mViewportHeight = vPathRenderer.mViewportHeight;
        this.mChangingConfigurations = vPathRenderer.mChangingConfigurations;
        this.mRootAlpha = vPathRenderer.mRootAlpha;
        this.mRootName = vPathRenderer.mRootName;
        object = vPathRenderer.mRootName;
        if (object != null) {
            this.mVGTargetsMap.put(object, (Object)this);
        }
        this.mIsStateful = vPathRenderer.mIsStateful;
    }

    private static float cross(float f, float f2, float f3, float f4) {
        return f * f4 - f2 * f3;
    }

    private void drawGroupTree(VectorDrawableCompat.VGroup vGroup, Matrix matrix, Canvas canvas, int n, int n2, ColorFilter colorFilter) {
        vGroup.mStackedMatrix.set(matrix);
        vGroup.mStackedMatrix.preConcat(vGroup.mLocalMatrix);
        canvas.save();
        int n3 = 0;
        while (true) {
            if (n3 >= vGroup.mChildren.size()) {
                canvas.restore();
                return;
            }
            matrix = (VectorDrawableCompat.VObject)vGroup.mChildren.get(n3);
            if (matrix instanceof VectorDrawableCompat.VGroup) {
                this.drawGroupTree((VectorDrawableCompat.VGroup)matrix, vGroup.mStackedMatrix, canvas, n, n2, colorFilter);
            } else if (matrix instanceof VectorDrawableCompat.VPath) {
                this.drawPath(vGroup, (VectorDrawableCompat.VPath)matrix, canvas, n, n2, colorFilter);
            }
            ++n3;
        }
    }

    private void drawPath(VectorDrawableCompat.VGroup vGroup, VectorDrawableCompat.VPath vPath, Canvas canvas, int n, int n2, ColorFilter colorFilter) {
        float f = (float)n / this.mViewportWidth;
        float f2 = (float)n2 / this.mViewportHeight;
        float f3 = Math.min(f, f2);
        vGroup = vGroup.mStackedMatrix;
        this.mFinalPathMatrix.set((Matrix)vGroup);
        this.mFinalPathMatrix.postScale(f, f2);
        f = this.getMatrixScale((Matrix)vGroup);
        if (f == 0.0f) {
            return;
        }
        vPath.toPath(this.mPath);
        Path path = this.mPath;
        this.mRenderPath.reset();
        if (vPath.isClipPath()) {
            colorFilter = this.mRenderPath;
            vGroup = vPath.mFillRule == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
            colorFilter.setFillType((Path.FillType)vGroup);
            this.mRenderPath.addPath(path, this.mFinalPathMatrix);
            canvas.clipPath(this.mRenderPath);
        } else {
            vPath = (VectorDrawableCompat.VFullPath)vPath;
            if (vPath.mTrimPathStart != 0.0f || vPath.mTrimPathEnd != 1.0f) {
                float f4 = vPath.mTrimPathStart;
                float f5 = vPath.mTrimPathOffset;
                float f6 = vPath.mTrimPathEnd;
                float f7 = vPath.mTrimPathOffset;
                if (this.mPathMeasure == null) {
                    this.mPathMeasure = new PathMeasure();
                }
                this.mPathMeasure.setPath(this.mPath, false);
                f2 = this.mPathMeasure.getLength();
                f4 = (f4 + f5) % 1.0f * f2;
                f7 = (f6 + f7) % 1.0f * f2;
                path.reset();
                if (f4 > f7) {
                    this.mPathMeasure.getSegment(f4, f2, path, true);
                    this.mPathMeasure.getSegment(0.0f, f7, path, true);
                } else {
                    this.mPathMeasure.getSegment(f4, f7, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.mRenderPath.addPath(path, this.mFinalPathMatrix);
            if (vPath.mFillColor.willDraw()) {
                vGroup = vPath.mFillColor;
                if (this.mFillPaint == null) {
                    path = new Paint(1);
                    this.mFillPaint = path;
                    path.setStyle(Paint.Style.FILL);
                }
                path = this.mFillPaint;
                if (vGroup.isGradient()) {
                    vGroup = vGroup.getShader();
                    vGroup.setLocalMatrix(this.mFinalPathMatrix);
                    path.setShader((Shader)vGroup);
                    path.setAlpha(Math.round(vPath.mFillAlpha * 255.0f));
                } else {
                    path.setShader(null);
                    path.setAlpha(255);
                    path.setColor(VectorDrawableCompat.applyAlpha((int)vGroup.getColor(), (float)vPath.mFillAlpha));
                }
                path.setColorFilter(colorFilter);
                Path path2 = this.mRenderPath;
                vGroup = vPath.mFillRule == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                path2.setFillType((Path.FillType)vGroup);
                canvas.drawPath(this.mRenderPath, (Paint)path);
            }
            if (!vPath.mStrokeColor.willDraw()) return;
            vGroup = vPath.mStrokeColor;
            if (this.mStrokePaint == null) {
                path = new Paint(1);
                this.mStrokePaint = path;
                path.setStyle(Paint.Style.STROKE);
            }
            path = this.mStrokePaint;
            if (vPath.mStrokeLineJoin != null) {
                path.setStrokeJoin(vPath.mStrokeLineJoin);
            }
            if (vPath.mStrokeLineCap != null) {
                path.setStrokeCap(vPath.mStrokeLineCap);
            }
            path.setStrokeMiter(vPath.mStrokeMiterlimit);
            if (vGroup.isGradient()) {
                vGroup = vGroup.getShader();
                vGroup.setLocalMatrix(this.mFinalPathMatrix);
                path.setShader((Shader)vGroup);
                path.setAlpha(Math.round(vPath.mStrokeAlpha * 255.0f));
            } else {
                path.setShader(null);
                path.setAlpha(255);
                path.setColor(VectorDrawableCompat.applyAlpha((int)vGroup.getColor(), (float)vPath.mStrokeAlpha));
            }
            path.setColorFilter(colorFilter);
            path.setStrokeWidth(vPath.mStrokeWidth * (f3 * f));
            canvas.drawPath(this.mRenderPath, (Paint)path);
        }
    }

    private float getMatrixScale(Matrix matrix) {
        float[] fArray;
        float[] fArray2 = fArray = new float[4];
        fArray[0] = 0.0f;
        fArray2[1] = 1.0f;
        fArray2[2] = 1.0f;
        fArray2[3] = 0.0f;
        matrix.mapVectors(fArray);
        float f = (float)Math.hypot(fArray[0], fArray[1]);
        float f2 = (float)Math.hypot(fArray[2], fArray[3]);
        float f3 = VectorDrawableCompat.VPathRenderer.cross(fArray[0], fArray[1], fArray[2], fArray[3]);
        f = Math.max(f, f2);
        f2 = 0.0f;
        if (!(f > 0.0f)) return f2;
        f2 = Math.abs(f3) / f;
        return f2;
    }

    public void draw(Canvas canvas, int n, int n2, ColorFilter colorFilter) {
        this.drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, canvas, n, n2, colorFilter);
    }

    public float getAlpha() {
        return (float)this.getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.mRootAlpha;
    }

    public boolean isStateful() {
        if (this.mIsStateful != null) return this.mIsStateful;
        this.mIsStateful = this.mRootGroup.isStateful();
        return this.mIsStateful;
    }

    public boolean onStateChanged(int[] nArray) {
        return this.mRootGroup.onStateChanged(nArray);
    }

    public void setAlpha(float f) {
        this.setRootAlpha((int)(f * 255.0f));
    }

    public void setRootAlpha(int n) {
        this.mRootAlpha = n;
    }
}
