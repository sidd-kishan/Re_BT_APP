/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint$Cap
 *  android.graphics.Rect
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.Drawable
 *  android.view.animation.Interpolator
 *  android.view.animation.LinearInterpolator
 *  androidx.core.util.Preconditions
 *  androidx.interpolator.view.animation.FastOutSlowInInterpolator
 *  androidx.swiperefreshlayout.widget.CircularProgressDrawable$Ring
 */
package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.util.Preconditions;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

public class CircularProgressDrawable
extends Drawable
implements Animatable {
    private static final int ANIMATION_DURATION = 1332;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 7.5f;
    private static final float CENTER_RADIUS_LARGE = 11.0f;
    private static final int[] COLORS;
    private static final float COLOR_CHANGE_OFFSET = 0.75f;
    public static final int DEFAULT = 1;
    private static final float GROUP_FULL_ROTATION = 216.0f;
    public static final int LARGE = 0;
    private static final Interpolator LINEAR_INTERPOLATOR;
    private static final Interpolator MATERIAL_INTERPOLATOR;
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float MIN_PROGRESS_ARC = 0.01f;
    private static final float RING_ROTATION = 0.20999998f;
    private static final float SHRINK_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private Animator mAnimator;
    boolean mFinishing;
    private Resources mResources;
    private final Ring mRing;
    private float mRotation;
    float mRotationCount;

    static {
        LINEAR_INTERPOLATOR = new LinearInterpolator();
        MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
        COLORS = new int[]{-16777216};
    }

    public CircularProgressDrawable(Context context) {
        this.mResources = ((Context)Preconditions.checkNotNull((Object)context)).getResources();
        context = new Ring();
        this.mRing = context;
        context.setColors(COLORS);
        this.setStrokeWidth(2.5f);
        this.setupAnimators();
    }

    private void applyFinishTranslation(float f, Ring ring) {
        this.updateRingColor(f, ring);
        float f2 = (float)(Math.floor(ring.getStartingRotation() / 0.8f) + 1.0);
        ring.setStartTrim(ring.getStartingStartTrim() + (ring.getStartingEndTrim() - 0.01f - ring.getStartingStartTrim()) * f);
        ring.setEndTrim(ring.getStartingEndTrim());
        ring.setRotation(ring.getStartingRotation() + (f2 - ring.getStartingRotation()) * f);
    }

    private int evaluateColorChange(float f, int n, int n2) {
        int n3 = n >> 24 & 0xFF;
        int n4 = n >> 16 & 0xFF;
        int n5 = n >> 8 & 0xFF;
        return n3 + (int)((float)((n2 >> 24 & 0xFF) - n3) * f) << 24 | n4 + (int)((float)((n2 >> 16 & 0xFF) - n4) * f) << 16 | n5 + (int)((float)((n2 >> 8 & 0xFF) - n5) * f) << 8 | (n &= 0xFF) + (int)(f * (float)((n2 & 0xFF) - n));
    }

    private float getRotation() {
        return this.mRotation;
    }

    private void setRotation(float f) {
        this.mRotation = f;
    }

    private void setSizeParameters(float f, float f2, float f3, float f4) {
        Ring ring = this.mRing;
        float f5 = this.mResources.getDisplayMetrics().density;
        ring.setStrokeWidth(f2 * f5);
        ring.setCenterRadius(f * f5);
        ring.setColorIndex(0);
        ring.setArrowDimensions(f3 * f5, f4 * f5);
    }

    private void setupAnimators() {
        Ring ring = this.mRing;
        ValueAnimator valueAnimator = ValueAnimator.ofFloat((float[])new float[]{0.0f, 1.0f});
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.setRepeatMode(1);
        valueAnimator.setInterpolator((TimeInterpolator)LINEAR_INTERPOLATOR);
        valueAnimator.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mAnimator = valueAnimator;
    }

    void applyTransformation(float f, Ring ring, boolean bl) {
        if (this.mFinishing) {
            this.applyFinishTranslation(f, ring);
        } else {
            float f2;
            float f3;
            if (f == 1.0f) {
                if (!bl) return;
            }
            float f4 = ring.getStartingRotation();
            if (f < 0.5f) {
                f3 = f / 0.5f;
                f2 = ring.getStartingStartTrim();
                f3 = MATERIAL_INTERPOLATOR.getInterpolation(f3) * 0.79f + 0.01f + f2;
            } else {
                f2 = (f - 0.5f) / 0.5f;
                f3 = ring.getStartingStartTrim() + 0.79f;
                f2 = f3 - ((1.0f - MATERIAL_INTERPOLATOR.getInterpolation(f2)) * 0.79f + 0.01f);
            }
            float f5 = this.mRotationCount;
            ring.setStartTrim(f2);
            ring.setEndTrim(f3);
            ring.setRotation(f4 + 0.20999998f * f);
            this.setRotation((f + f5) * 216.0f);
        }
    }

    public void draw(Canvas canvas) {
        Rect rect = this.getBounds();
        canvas.save();
        canvas.rotate(this.mRotation, rect.exactCenterX(), rect.exactCenterY());
        this.mRing.draw(canvas, rect);
        canvas.restore();
    }

    public int getAlpha() {
        return this.mRing.getAlpha();
    }

    public boolean getArrowEnabled() {
        return this.mRing.getShowArrow();
    }

    public float getArrowHeight() {
        return this.mRing.getArrowHeight();
    }

    public float getArrowScale() {
        return this.mRing.getArrowScale();
    }

    public float getArrowWidth() {
        return this.mRing.getArrowWidth();
    }

    public int getBackgroundColor() {
        return this.mRing.getBackgroundColor();
    }

    public float getCenterRadius() {
        return this.mRing.getCenterRadius();
    }

    public int[] getColorSchemeColors() {
        return this.mRing.getColors();
    }

    public float getEndTrim() {
        return this.mRing.getEndTrim();
    }

    public int getOpacity() {
        return -3;
    }

    public float getProgressRotation() {
        return this.mRing.getRotation();
    }

    public float getStartTrim() {
        return this.mRing.getStartTrim();
    }

    public Paint.Cap getStrokeCap() {
        return this.mRing.getStrokeCap();
    }

    public float getStrokeWidth() {
        return this.mRing.getStrokeWidth();
    }

    public boolean isRunning() {
        return this.mAnimator.isRunning();
    }

    public void setAlpha(int n) {
        this.mRing.setAlpha(n);
        this.invalidateSelf();
    }

    public void setArrowDimensions(float f, float f2) {
        this.mRing.setArrowDimensions(f, f2);
        this.invalidateSelf();
    }

    public void setArrowEnabled(boolean bl) {
        this.mRing.setShowArrow(bl);
        this.invalidateSelf();
    }

    public void setArrowScale(float f) {
        this.mRing.setArrowScale(f);
        this.invalidateSelf();
    }

    public void setBackgroundColor(int n) {
        this.mRing.setBackgroundColor(n);
        this.invalidateSelf();
    }

    public void setCenterRadius(float f) {
        this.mRing.setCenterRadius(f);
        this.invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mRing.setColorFilter(colorFilter);
        this.invalidateSelf();
    }

    public void setColorSchemeColors(int ... nArray) {
        this.mRing.setColors(nArray);
        this.mRing.setColorIndex(0);
        this.invalidateSelf();
    }

    public void setProgressRotation(float f) {
        this.mRing.setRotation(f);
        this.invalidateSelf();
    }

    public void setStartEndTrim(float f, float f2) {
        this.mRing.setStartTrim(f);
        this.mRing.setEndTrim(f2);
        this.invalidateSelf();
    }

    public void setStrokeCap(Paint.Cap cap) {
        this.mRing.setStrokeCap(cap);
        this.invalidateSelf();
    }

    public void setStrokeWidth(float f) {
        this.mRing.setStrokeWidth(f);
        this.invalidateSelf();
    }

    public void setStyle(int n) {
        if (n == 0) {
            this.setSizeParameters(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            this.setSizeParameters(7.5f, 2.5f, 10.0f, 5.0f);
        }
        this.invalidateSelf();
    }

    public void start() {
        this.mAnimator.cancel();
        this.mRing.storeOriginals();
        if (this.mRing.getEndTrim() != this.mRing.getStartTrim()) {
            this.mFinishing = true;
            this.mAnimator.setDuration(666L);
            this.mAnimator.start();
        } else {
            this.mRing.setColorIndex(0);
            this.mRing.resetOriginals();
            this.mAnimator.setDuration(1332L);
            this.mAnimator.start();
        }
    }

    public void stop() {
        this.mAnimator.cancel();
        this.setRotation(0.0f);
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        this.invalidateSelf();
    }

    void updateRingColor(float f, Ring ring) {
        if (f > 0.75f) {
            ring.setColor(this.evaluateColorChange((f - 0.75f) / 0.25f, ring.getStartingColor(), ring.getNextColor()));
        } else {
            ring.setColor(ring.getStartingColor());
        }
    }
}
