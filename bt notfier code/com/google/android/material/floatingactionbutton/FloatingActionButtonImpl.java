/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.animation.TypeEvaluator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.os.Build$VERSION
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  androidx.core.content.ContextCompat
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.R$animator
 *  com.google.android.material.R$color
 *  com.google.android.material.animation.AnimationUtils
 *  com.google.android.material.animation.AnimatorSetCompat
 *  com.google.android.material.animation.ImageMatrixProperty
 *  com.google.android.material.animation.MatrixEvaluator
 *  com.google.android.material.animation.MotionSpec
 *  com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$DisabledElevationAnimation
 *  com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$ElevateToHoveredFocusedTranslationZAnimation
 *  com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$ElevateToPressedTranslationZAnimation
 *  com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$InternalVisibilityChangedListener
 *  com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$ResetElevationAnimation
 *  com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$ShadowAnimatorImpl
 *  com.google.android.material.internal.CircularBorderDrawable
 *  com.google.android.material.internal.StateListAnimator
 *  com.google.android.material.internal.VisibilityAwareImageButton
 *  com.google.android.material.ripple.RippleUtils
 *  com.google.android.material.shadow.ShadowDrawableWrapper
 *  com.google.android.material.shadow.ShadowViewDelegate
 */
package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.internal.CircularBorderDrawable;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.android.material.shadow.ShadowViewDelegate;
import java.util.ArrayList;

class FloatingActionButtonImpl {
    static final int ANIM_STATE_HIDING = 1;
    static final int ANIM_STATE_NONE = 0;
    static final int ANIM_STATE_SHOWING = 2;
    static final long ELEVATION_ANIM_DELAY = 100L;
    static final long ELEVATION_ANIM_DURATION = 100L;
    static final TimeInterpolator ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    static final int[] EMPTY_STATE_SET;
    static final int[] ENABLED_STATE_SET;
    static final int[] FOCUSED_ENABLED_STATE_SET;
    private static final float HIDE_ICON_SCALE = 0.0f;
    private static final float HIDE_OPACITY = 0.0f;
    private static final float HIDE_SCALE = 0.0f;
    static final int[] HOVERED_ENABLED_STATE_SET;
    static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET;
    static final int[] PRESSED_ENABLED_STATE_SET;
    private static final float SHOW_ICON_SCALE = 1.0f;
    private static final float SHOW_OPACITY = 1.0f;
    private static final float SHOW_SCALE = 1.0f;
    int animState = 0;
    CircularBorderDrawable borderDrawable;
    Drawable contentBackground;
    Animator currentAnimator;
    private MotionSpec defaultHideMotionSpec;
    private MotionSpec defaultShowMotionSpec;
    float elevation;
    private ArrayList<Animator.AnimatorListener> hideListeners;
    MotionSpec hideMotionSpec;
    float hoveredFocusedTranslationZ;
    float imageMatrixScale = 1.0f;
    int maxImageSize;
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    float pressedTranslationZ;
    Drawable rippleDrawable;
    private float rotation;
    ShadowDrawableWrapper shadowDrawable;
    final ShadowViewDelegate shadowViewDelegate;
    Drawable shapeDrawable;
    private ArrayList<Animator.AnimatorListener> showListeners;
    MotionSpec showMotionSpec;
    private final StateListAnimator stateListAnimator;
    private final Matrix tmpMatrix;
    private final Rect tmpRect = new Rect();
    private final RectF tmpRectF1 = new RectF();
    private final RectF tmpRectF2 = new RectF();
    final VisibilityAwareImageButton view;

    static {
        PRESSED_ENABLED_STATE_SET = new int[]{16842919, 16842910};
        HOVERED_FOCUSED_ENABLED_STATE_SET = new int[]{16843623, 16842908, 16842910};
        FOCUSED_ENABLED_STATE_SET = new int[]{16842908, 16842910};
        HOVERED_ENABLED_STATE_SET = new int[]{16843623, 16842910};
        ENABLED_STATE_SET = new int[]{16842910};
        EMPTY_STATE_SET = new int[0];
    }

    FloatingActionButtonImpl(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate shadowViewDelegate) {
        this.tmpMatrix = new Matrix();
        this.view = visibilityAwareImageButton;
        this.shadowViewDelegate = shadowViewDelegate;
        visibilityAwareImageButton = new StateListAnimator();
        this.stateListAnimator = visibilityAwareImageButton;
        visibilityAwareImageButton.addState(PRESSED_ENABLED_STATE_SET, this.createElevationAnimator((ShadowAnimatorImpl)new ElevateToPressedTranslationZAnimation(this)));
        this.stateListAnimator.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, this.createElevationAnimator((ShadowAnimatorImpl)new ElevateToHoveredFocusedTranslationZAnimation(this)));
        this.stateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, this.createElevationAnimator((ShadowAnimatorImpl)new ElevateToHoveredFocusedTranslationZAnimation(this)));
        this.stateListAnimator.addState(HOVERED_ENABLED_STATE_SET, this.createElevationAnimator((ShadowAnimatorImpl)new ElevateToHoveredFocusedTranslationZAnimation(this)));
        this.stateListAnimator.addState(ENABLED_STATE_SET, this.createElevationAnimator((ShadowAnimatorImpl)new ResetElevationAnimation(this)));
        this.stateListAnimator.addState(EMPTY_STATE_SET, this.createElevationAnimator((ShadowAnimatorImpl)new DisabledElevationAnimation(this)));
        this.rotation = this.view.getRotation();
    }

    private void calculateImageMatrixFromScale(float f, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.view.getDrawable();
        if (drawable == null) return;
        if (this.maxImageSize == 0) return;
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        rectF.set(0.0f, 0.0f, (float)drawable.getIntrinsicWidth(), (float)drawable.getIntrinsicHeight());
        int n = this.maxImageSize;
        rectF2.set(0.0f, 0.0f, (float)n, (float)n);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        n = this.maxImageSize;
        matrix.postScale(f, f, (float)n / 2.0f, (float)n / 2.0f);
    }

    private AnimatorSet createAnimator(MotionSpec motionSpec, float f, float f2, float f3) {
        ArrayList<ObjectAnimator> arrayList = new ArrayList<ObjectAnimator>();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)this.view, (Property)View.ALPHA, (float[])new float[]{f});
        motionSpec.getTiming("opacity").apply((Animator)objectAnimator);
        arrayList.add(objectAnimator);
        objectAnimator = ObjectAnimator.ofFloat((Object)this.view, (Property)View.SCALE_X, (float[])new float[]{f2});
        motionSpec.getTiming("scale").apply((Animator)objectAnimator);
        arrayList.add(objectAnimator);
        objectAnimator = ObjectAnimator.ofFloat((Object)this.view, (Property)View.SCALE_Y, (float[])new float[]{f2});
        motionSpec.getTiming("scale").apply((Animator)objectAnimator);
        arrayList.add(objectAnimator);
        this.calculateImageMatrixFromScale(f3, this.tmpMatrix);
        objectAnimator = ObjectAnimator.ofObject((Object)this.view, (Property)new ImageMatrixProperty(), (TypeEvaluator)new MatrixEvaluator(), (Object[])new Matrix[]{new Matrix(this.tmpMatrix)});
        motionSpec.getTiming("iconScale").apply((Animator)objectAnimator);
        arrayList.add(objectAnimator);
        motionSpec = new AnimatorSet();
        AnimatorSetCompat.playTogether((AnimatorSet)motionSpec, arrayList);
        return motionSpec;
    }

    private ValueAnimator createElevationAnimator(ShadowAnimatorImpl shadowAnimatorImpl) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener((Animator.AnimatorListener)shadowAnimatorImpl);
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)shadowAnimatorImpl);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }

    private void ensurePreDrawListener() {
        if (this.preDrawListener != null) return;
        this.preDrawListener = new /* Unavailable Anonymous Inner Class!! */;
    }

    private MotionSpec getDefaultHideMotionSpec() {
        if (this.defaultHideMotionSpec != null) return this.defaultHideMotionSpec;
        this.defaultHideMotionSpec = MotionSpec.createFromResource((Context)this.view.getContext(), (int)R.animator.design_fab_hide_motion_spec);
        return this.defaultHideMotionSpec;
    }

    private MotionSpec getDefaultShowMotionSpec() {
        if (this.defaultShowMotionSpec != null) return this.defaultShowMotionSpec;
        this.defaultShowMotionSpec = MotionSpec.createFromResource((Context)this.view.getContext(), (int)R.animator.design_fab_show_motion_spec);
        return this.defaultShowMotionSpec;
    }

    private boolean shouldAnimateVisibilityChange() {
        boolean bl = ViewCompat.isLaidOut((View)this.view) && !this.view.isInEditMode();
        return bl;
    }

    private void updateFromViewRotation() {
        ShadowDrawableWrapper shadowDrawableWrapper;
        if (Build.VERSION.SDK_INT == 19) {
            if (this.rotation % 90.0f != 0.0f) {
                if (this.view.getLayerType() != 1) {
                    this.view.setLayerType(1, null);
                }
            } else if (this.view.getLayerType() != 0) {
                this.view.setLayerType(0, null);
            }
        }
        if ((shadowDrawableWrapper = this.shadowDrawable) != null) {
            shadowDrawableWrapper.setRotation(-this.rotation);
        }
        if ((shadowDrawableWrapper = this.borderDrawable) == null) return;
        shadowDrawableWrapper.setRotation(-this.rotation);
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        if (this.hideListeners == null) {
            this.hideListeners = new ArrayList();
        }
        this.hideListeners.add(animatorListener);
    }

    void addOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        if (this.showListeners == null) {
            this.showListeners = new ArrayList();
        }
        this.showListeners.add(animatorListener);
    }

    CircularBorderDrawable createBorderDrawable(int n, ColorStateList colorStateList) {
        Context context = this.view.getContext();
        CircularBorderDrawable circularBorderDrawable = this.newCircularDrawable();
        circularBorderDrawable.setGradientColors(ContextCompat.getColor((Context)context, (int)R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor((Context)context, (int)R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor((Context)context, (int)R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor((Context)context, (int)R.color.design_fab_stroke_end_outer_color));
        circularBorderDrawable.setBorderWidth((float)n);
        circularBorderDrawable.setBorderTint(colorStateList);
        return circularBorderDrawable;
    }

    GradientDrawable createShapeDrawable() {
        GradientDrawable gradientDrawable = this.newGradientDrawableForShape();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }

    final Drawable getContentBackground() {
        return this.contentBackground;
    }

    float getElevation() {
        return this.elevation;
    }

    final MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    float getHoveredFocusedTranslationZ() {
        return this.hoveredFocusedTranslationZ;
    }

    void getPadding(Rect rect) {
        this.shadowDrawable.getPadding(rect);
    }

    float getPressedTranslationZ() {
        return this.pressedTranslationZ;
    }

    final MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    void hide(InternalVisibilityChangedListener object, boolean bl) {
        if (this.isOrWillBeHidden()) {
            return;
        }
        Animator animator2 = this.currentAnimator;
        if (animator2 != null) {
            animator2.cancel();
        }
        if (this.shouldAnimateVisibilityChange()) {
            animator2 = this.hideMotionSpec;
            if (animator2 == null) {
                animator2 = this.getDefaultHideMotionSpec();
            }
            animator2 = this.createAnimator((MotionSpec)animator2, 0.0f, 0.0f, 0.0f);
            animator2.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
            object = this.hideListeners;
            if (object != null) {
                object = ((ArrayList)object).iterator();
                while (object.hasNext()) {
                    animator2.addListener((Animator.AnimatorListener)object.next());
                }
            }
            animator2.start();
        } else {
            animator2 = this.view;
            int n = bl ? 8 : 4;
            animator2.internalSetVisibility(n, bl);
            if (object == null) return;
            object.onHidden();
        }
    }

    boolean isOrWillBeHidden() {
        int n = this.view.getVisibility();
        boolean bl = false;
        boolean bl2 = false;
        if (n == 0) {
            if (this.animState != 1) return bl2;
            bl2 = true;
            return bl2;
        }
        bl2 = bl;
        if (this.animState == 2) return bl2;
        bl2 = true;
        return bl2;
    }

    boolean isOrWillBeShown() {
        int n = this.view.getVisibility();
        boolean bl = false;
        boolean bl2 = false;
        if (n != 0) {
            if (this.animState != 2) return bl2;
            bl2 = true;
            return bl2;
        }
        bl2 = bl;
        if (this.animState == 1) return bl2;
        bl2 = true;
        return bl2;
    }

    void jumpDrawableToCurrentState() {
        this.stateListAnimator.jumpToCurrentState();
    }

    CircularBorderDrawable newCircularDrawable() {
        return new CircularBorderDrawable();
    }

    GradientDrawable newGradientDrawableForShape() {
        return new GradientDrawable();
    }

    void onAttachedToWindow() {
        if (!this.requirePreDrawListener()) return;
        this.ensurePreDrawListener();
        this.view.getViewTreeObserver().addOnPreDrawListener(this.preDrawListener);
    }

    void onCompatShadowChanged() {
    }

    void onDetachedFromWindow() {
        if (this.preDrawListener == null) return;
        this.view.getViewTreeObserver().removeOnPreDrawListener(this.preDrawListener);
        this.preDrawListener = null;
    }

    void onDrawableStateChanged(int[] nArray) {
        this.stateListAnimator.setState(nArray);
    }

    void onElevationsChanged(float f, float f2, float f3) {
        ShadowDrawableWrapper shadowDrawableWrapper = this.shadowDrawable;
        if (shadowDrawableWrapper == null) return;
        shadowDrawableWrapper.setShadowSize(f, this.pressedTranslationZ + f);
        this.updatePadding();
    }

    void onPaddingUpdated(Rect rect) {
    }

    void onPreDraw() {
        float f = this.view.getRotation();
        if (this.rotation == f) return;
        this.rotation = f;
        this.updateFromViewRotation();
    }

    public void removeOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.hideListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    void removeOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.showListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    boolean requirePreDrawListener() {
        return true;
    }

    void setBackgroundDrawable(ColorStateList drawableArray, PorterDuff.Mode mode, ColorStateList colorStateList, int n) {
        Drawable drawable;
        this.shapeDrawable = drawable = DrawableCompat.wrap((Drawable)this.createShapeDrawable());
        DrawableCompat.setTintList((Drawable)drawable, (ColorStateList)drawableArray);
        if (mode != null) {
            DrawableCompat.setTintMode((Drawable)this.shapeDrawable, (PorterDuff.Mode)mode);
        }
        mode = DrawableCompat.wrap((Drawable)this.createShapeDrawable());
        this.rippleDrawable = mode;
        DrawableCompat.setTintList((Drawable)mode, (ColorStateList)RippleUtils.convertToRippleDrawableColor((ColorStateList)colorStateList));
        if (n > 0) {
            mode = this.createBorderDrawable(n, (ColorStateList)drawableArray);
            this.borderDrawable = mode;
            drawableArray = new Drawable[]{mode, this.shapeDrawable, this.rippleDrawable};
        } else {
            this.borderDrawable = null;
            drawableArray = new Drawable[]{this.shapeDrawable, this.rippleDrawable};
        }
        this.contentBackground = new LayerDrawable(drawableArray);
        drawableArray = this.view.getContext();
        mode = this.contentBackground;
        float f = this.shadowViewDelegate.getRadius();
        float f2 = this.elevation;
        drawableArray = new ShadowDrawableWrapper((Context)drawableArray, (Drawable)mode, f, f2, f2 + this.pressedTranslationZ);
        this.shadowDrawable = drawableArray;
        drawableArray.setAddPaddingForCorners(false);
        this.shadowViewDelegate.setBackgroundDrawable((Drawable)this.shadowDrawable);
    }

    void setBackgroundTintList(ColorStateList colorStateList) {
        Drawable drawable = this.shapeDrawable;
        if (drawable != null) {
            DrawableCompat.setTintList((Drawable)drawable, (ColorStateList)colorStateList);
        }
        if ((drawable = this.borderDrawable) == null) return;
        drawable.setBorderTint(colorStateList);
    }

    void setBackgroundTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.shapeDrawable;
        if (drawable == null) return;
        DrawableCompat.setTintMode((Drawable)drawable, (PorterDuff.Mode)mode);
    }

    final void setElevation(float f) {
        if (this.elevation == f) return;
        this.elevation = f;
        this.onElevationsChanged(f, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
    }

    final void setHideMotionSpec(MotionSpec motionSpec) {
        this.hideMotionSpec = motionSpec;
    }

    final void setHoveredFocusedTranslationZ(float f) {
        if (this.hoveredFocusedTranslationZ == f) return;
        this.hoveredFocusedTranslationZ = f;
        this.onElevationsChanged(this.elevation, f, this.pressedTranslationZ);
    }

    final void setImageMatrixScale(float f) {
        this.imageMatrixScale = f;
        Matrix matrix = this.tmpMatrix;
        this.calculateImageMatrixFromScale(f, matrix);
        this.view.setImageMatrix(matrix);
    }

    final void setMaxImageSize(int n) {
        if (this.maxImageSize == n) return;
        this.maxImageSize = n;
        this.updateImageMatrixScale();
    }

    final void setPressedTranslationZ(float f) {
        if (this.pressedTranslationZ == f) return;
        this.pressedTranslationZ = f;
        this.onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, f);
    }

    void setRippleColor(ColorStateList colorStateList) {
        Drawable drawable = this.rippleDrawable;
        if (drawable == null) return;
        DrawableCompat.setTintList((Drawable)drawable, (ColorStateList)RippleUtils.convertToRippleDrawableColor((ColorStateList)colorStateList));
    }

    final void setShowMotionSpec(MotionSpec motionSpec) {
        this.showMotionSpec = motionSpec;
    }

    void show(InternalVisibilityChangedListener object, boolean bl) {
        if (this.isOrWillBeShown()) {
            return;
        }
        Animator animator2 = this.currentAnimator;
        if (animator2 != null) {
            animator2.cancel();
        }
        if (this.shouldAnimateVisibilityChange()) {
            if (this.view.getVisibility() != 0) {
                this.view.setAlpha(0.0f);
                this.view.setScaleY(0.0f);
                this.view.setScaleX(0.0f);
                this.setImageMatrixScale(0.0f);
            }
            if ((animator2 = this.showMotionSpec) == null) {
                animator2 = this.getDefaultShowMotionSpec();
            }
            animator2 = this.createAnimator((MotionSpec)animator2, 1.0f, 1.0f, 1.0f);
            animator2.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
            object = this.showListeners;
            if (object != null) {
                object = ((ArrayList)object).iterator();
                while (object.hasNext()) {
                    animator2.addListener((Animator.AnimatorListener)object.next());
                }
            }
            animator2.start();
        } else {
            this.view.internalSetVisibility(0, bl);
            this.view.setAlpha(1.0f);
            this.view.setScaleY(1.0f);
            this.view.setScaleX(1.0f);
            this.setImageMatrixScale(1.0f);
            if (object == null) return;
            object.onShown();
        }
    }

    final void updateImageMatrixScale() {
        this.setImageMatrixScale(this.imageMatrixScale);
    }

    final void updatePadding() {
        Rect rect = this.tmpRect;
        this.getPadding(rect);
        this.onPaddingUpdated(rect);
        this.shadowViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
