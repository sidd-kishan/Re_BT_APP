/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.Region$Op
 *  android.graphics.drawable.Drawable
 *  androidx.core.graphics.drawable.TintAwareDrawable
 *  com.google.android.material.shape.CornerTreatment
 *  com.google.android.material.shape.EdgeTreatment
 *  com.google.android.material.shape.ShapePath
 *  com.google.android.material.shape.ShapePathModel
 */
package com.google.android.material.shape;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;
import com.google.android.material.shape.ShapePathModel;

public class MaterialShapeDrawable
extends Drawable
implements TintAwareDrawable {
    private int alpha;
    private final ShapePath[] cornerPaths;
    private final Matrix[] cornerTransforms;
    private final Matrix[] edgeTransforms;
    private float interpolation;
    private final Matrix matrix;
    private final Paint paint = new Paint();
    private Paint.Style paintStyle;
    private final Path path;
    private final PointF pointF;
    private float scale;
    private final float[] scratch;
    private final float[] scratch2;
    private final Region scratchRegion;
    private int shadowColor;
    private int shadowElevation;
    private boolean shadowEnabled;
    private int shadowRadius;
    private final ShapePath shapePath;
    private ShapePathModel shapedViewModel = null;
    private float strokeWidth;
    private PorterDuffColorFilter tintFilter;
    private ColorStateList tintList;
    private PorterDuff.Mode tintMode;
    private final Region transparentRegion;
    private boolean useTintColorForShadow;

    public MaterialShapeDrawable() {
        this(null);
    }

    public MaterialShapeDrawable(ShapePathModel shapePathModel) {
        this.cornerTransforms = new Matrix[4];
        this.edgeTransforms = new Matrix[4];
        this.cornerPaths = new ShapePath[4];
        this.matrix = new Matrix();
        this.path = new Path();
        this.pointF = new PointF();
        this.shapePath = new ShapePath();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        this.scratch = new float[2];
        this.scratch2 = new float[2];
        int n = 0;
        this.shadowEnabled = false;
        this.useTintColorForShadow = false;
        this.interpolation = 1.0f;
        this.shadowColor = -16777216;
        this.shadowElevation = 5;
        this.shadowRadius = 10;
        this.alpha = 255;
        this.scale = 1.0f;
        this.strokeWidth = 0.0f;
        this.paintStyle = Paint.Style.FILL_AND_STROKE;
        this.tintMode = PorterDuff.Mode.SRC_IN;
        this.tintList = null;
        this.shapedViewModel = shapePathModel;
        while (n < 4) {
            this.cornerTransforms[n] = new Matrix();
            this.edgeTransforms[n] = new Matrix();
            this.cornerPaths[n] = new ShapePath();
            ++n;
        }
    }

    private float angleOfCorner(int n, int n2, int n3) {
        this.getCoordinatesOfCorner((n - 1 + 4) % 4, n2, n3, this.pointF);
        float f = this.pointF.x;
        float f2 = this.pointF.y;
        this.getCoordinatesOfCorner((n + 1) % 4, n2, n3, this.pointF);
        float f3 = this.pointF.x;
        float f4 = this.pointF.y;
        this.getCoordinatesOfCorner(n, n2, n3, this.pointF);
        float f5 = this.pointF.x;
        float f6 = this.pointF.y;
        f3 = f5 = (float)Math.atan2(f2 - f6, f - f5) - (float)Math.atan2(f4 - f6, f3 - f5);
        if (!(f5 < 0.0f)) return f3;
        double d = f5;
        Double.isNaN(d);
        f3 = (float)(d + Math.PI * 2);
        return f3;
    }

    private float angleOfEdge(int n, int n2, int n3) {
        this.getCoordinatesOfCorner(n, n2, n3, this.pointF);
        float f = this.pointF.x;
        float f2 = this.pointF.y;
        this.getCoordinatesOfCorner((n + 1) % 4, n2, n3, this.pointF);
        float f3 = this.pointF.x;
        return (float)Math.atan2(this.pointF.y - f2, f3 - f);
    }

    private void appendCornerPath(int n, Path path) {
        this.scratch[0] = this.cornerPaths[n].startX;
        this.scratch[1] = this.cornerPaths[n].startY;
        this.cornerTransforms[n].mapPoints(this.scratch);
        if (n == 0) {
            float[] fArray = this.scratch;
            path.moveTo(fArray[0], fArray[1]);
        } else {
            float[] fArray = this.scratch;
            path.lineTo(fArray[0], fArray[1]);
        }
        this.cornerPaths[n].applyToPath(this.cornerTransforms[n], path);
    }

    private void appendEdgePath(int n, Path path) {
        int n2 = (n + 1) % 4;
        this.scratch[0] = this.cornerPaths[n].endX;
        this.scratch[1] = this.cornerPaths[n].endY;
        this.cornerTransforms[n].mapPoints(this.scratch);
        this.scratch2[0] = this.cornerPaths[n2].startX;
        this.scratch2[1] = this.cornerPaths[n2].startY;
        this.cornerTransforms[n2].mapPoints(this.scratch2);
        float[] fArray = this.scratch;
        float f = fArray[0];
        float[] fArray2 = this.scratch2;
        f = (float)Math.hypot(f - fArray2[0], fArray[1] - fArray2[1]);
        this.shapePath.reset(0.0f, 0.0f);
        this.getEdgeTreatmentForIndex(n).getEdgePath(f, this.interpolation, this.shapePath);
        this.shapePath.applyToPath(this.edgeTransforms[n], path);
    }

    private void getCoordinatesOfCorner(int n, int n2, int n3, PointF pointF) {
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    pointF.set(0.0f, 0.0f);
                } else {
                    pointF.set(0.0f, (float)n3);
                }
            } else {
                pointF.set((float)n2, (float)n3);
            }
        } else {
            pointF.set((float)n2, 0.0f);
        }
    }

    private CornerTreatment getCornerTreatmentForIndex(int n) {
        if (n == 1) return this.shapedViewModel.getTopRightCorner();
        if (n == 2) return this.shapedViewModel.getBottomRightCorner();
        if (n == 3) return this.shapedViewModel.getBottomLeftCorner();
        return this.shapedViewModel.getTopLeftCorner();
    }

    private EdgeTreatment getEdgeTreatmentForIndex(int n) {
        if (n == 1) return this.shapedViewModel.getRightEdge();
        if (n == 2) return this.shapedViewModel.getBottomEdge();
        if (n == 3) return this.shapedViewModel.getLeftEdge();
        return this.shapedViewModel.getTopEdge();
    }

    private void getPath(int n, int n2, Path path) {
        this.getPathForSize(n, n2, path);
        if (this.scale == 1.0f) {
            return;
        }
        this.matrix.reset();
        Matrix matrix = this.matrix;
        float f = this.scale;
        matrix.setScale(f, f, (float)(n / 2), (float)(n2 / 2));
        path.transform(this.matrix);
    }

    private static int modulateAlpha(int n, int n2) {
        return n * (n2 + (n2 >>> 7)) >>> 8;
    }

    private void setCornerPathAndTransform(int n, int n2, int n3) {
        this.getCoordinatesOfCorner(n, n2, n3, this.pointF);
        float f = this.angleOfCorner(n, n2, n3);
        this.getCornerTreatmentForIndex(n).getCornerPath(f, this.interpolation, this.cornerPaths[n]);
        f = this.angleOfEdge((n - 1 + 4) % 4, n2, n3);
        this.cornerTransforms[n].reset();
        this.cornerTransforms[n].setTranslate(this.pointF.x, this.pointF.y);
        this.cornerTransforms[n].preRotate((float)Math.toDegrees(f + 1.5707964f));
    }

    private void setEdgeTransform(int n, int n2, int n3) {
        this.scratch[0] = this.cornerPaths[n].endX;
        this.scratch[1] = this.cornerPaths[n].endY;
        this.cornerTransforms[n].mapPoints(this.scratch);
        float f = this.angleOfEdge(n, n2, n3);
        this.edgeTransforms[n].reset();
        Matrix matrix = this.edgeTransforms[n];
        float[] fArray = this.scratch;
        matrix.setTranslate(fArray[0], fArray[1]);
        this.edgeTransforms[n].preRotate((float)Math.toDegrees(f));
    }

    private void updateTintFilter() {
        ColorStateList colorStateList = this.tintList;
        if (colorStateList != null && this.tintMode != null) {
            int n = colorStateList.getColorForState(this.getState(), 0);
            this.tintFilter = new PorterDuffColorFilter(n, this.tintMode);
            if (!this.useTintColorForShadow) return;
            this.shadowColor = n;
            return;
        }
        this.tintFilter = null;
    }

    public void draw(Canvas canvas) {
        this.paint.setColorFilter((ColorFilter)this.tintFilter);
        int n = this.paint.getAlpha();
        this.paint.setAlpha(MaterialShapeDrawable.modulateAlpha(n, this.alpha));
        this.paint.setStrokeWidth(this.strokeWidth);
        this.paint.setStyle(this.paintStyle);
        int n2 = this.shadowElevation;
        if (n2 > 0 && this.shadowEnabled) {
            this.paint.setShadowLayer((float)this.shadowRadius, 0.0f, (float)n2, this.shadowColor);
        }
        if (this.shapedViewModel != null) {
            this.getPath(canvas.getWidth(), canvas.getHeight(), this.path);
            canvas.drawPath(this.path, this.paint);
        } else {
            canvas.drawRect(0.0f, 0.0f, (float)canvas.getWidth(), (float)canvas.getHeight(), this.paint);
        }
        this.paint.setAlpha(n);
    }

    public float getInterpolation() {
        return this.interpolation;
    }

    public int getOpacity() {
        return -3;
    }

    public Paint.Style getPaintStyle() {
        return this.paintStyle;
    }

    public void getPathForSize(int n, int n2, Path path) {
        int n3;
        path.rewind();
        if (this.shapedViewModel == null) {
            return;
        }
        int n4 = 0;
        int n5 = 0;
        while (true) {
            n3 = n4;
            if (n5 >= 4) break;
            this.setCornerPathAndTransform(n5, n, n2);
            this.setEdgeTransform(n5, n, n2);
            ++n5;
        }
        while (true) {
            if (n3 >= 4) {
                path.close();
                return;
            }
            this.appendCornerPath(n3, path);
            this.appendEdgePath(n3, path);
            ++n3;
        }
    }

    public float getScale() {
        return this.scale;
    }

    public int getShadowElevation() {
        return this.shadowElevation;
    }

    public int getShadowRadius() {
        return this.shadowRadius;
    }

    public ShapePathModel getShapedViewModel() {
        return this.shapedViewModel;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public ColorStateList getTintList() {
        return this.tintList;
    }

    public Region getTransparentRegion() {
        Rect rect = this.getBounds();
        this.transparentRegion.set(rect);
        this.getPath(rect.width(), rect.height(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, Region.Op.DIFFERENCE);
        return this.transparentRegion;
    }

    public boolean isPointInTransparentRegion(int n, int n2) {
        return this.getTransparentRegion().contains(n, n2);
    }

    public boolean isShadowEnabled() {
        return this.shadowEnabled;
    }

    public void setAlpha(int n) {
        this.alpha = n;
        this.invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        this.invalidateSelf();
    }

    public void setInterpolation(float f) {
        this.interpolation = f;
        this.invalidateSelf();
    }

    public void setPaintStyle(Paint.Style style) {
        this.paintStyle = style;
        this.invalidateSelf();
    }

    public void setScale(float f) {
        this.scale = f;
        this.invalidateSelf();
    }

    public void setShadowColor(int n) {
        this.shadowColor = n;
        this.useTintColorForShadow = false;
        this.invalidateSelf();
    }

    public void setShadowElevation(int n) {
        this.shadowElevation = n;
        this.invalidateSelf();
    }

    public void setShadowEnabled(boolean bl) {
        this.shadowEnabled = bl;
        this.invalidateSelf();
    }

    public void setShadowRadius(int n) {
        this.shadowRadius = n;
        this.invalidateSelf();
    }

    public void setShapedViewModel(ShapePathModel shapePathModel) {
        this.shapedViewModel = shapePathModel;
        this.invalidateSelf();
    }

    public void setStrokeWidth(float f) {
        this.strokeWidth = f;
        this.invalidateSelf();
    }

    public void setTint(int n) {
        this.setTintList(ColorStateList.valueOf((int)n));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.tintList = colorStateList;
        this.updateTintFilter();
        this.invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.tintMode = mode;
        this.updateTintFilter();
        this.invalidateSelf();
    }

    public void setUseTintColorForShadow(boolean bl) {
        this.useTintColorForShadow = bl;
        this.invalidateSelf();
    }
}
