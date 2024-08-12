/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  androidx.appcompat.widget.AppCompatDrawableManager
 *  androidx.appcompat.widget.AppCompatImageHelper
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$DefaultBehavior
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.core.view.TintableBackgroundView
 *  androidx.core.view.ViewCompat
 *  androidx.core.widget.TintableImageSourceView
 *  com.google.android.material.R$attr
 *  com.google.android.material.R$dimen
 *  com.google.android.material.R$style
 *  com.google.android.material.R$styleable
 *  com.google.android.material.animation.MotionSpec
 *  com.google.android.material.expandable.ExpandableTransformationWidget
 *  com.google.android.material.expandable.ExpandableWidget
 *  com.google.android.material.expandable.ExpandableWidgetHelper
 *  com.google.android.material.floatingactionbutton.FloatingActionButton$Behavior
 *  com.google.android.material.floatingactionbutton.FloatingActionButton$OnVisibilityChangedListener
 *  com.google.android.material.floatingactionbutton.FloatingActionButton$ShadowDelegateImpl
 *  com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
 *  com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$InternalVisibilityChangedListener
 *  com.google.android.material.floatingactionbutton.FloatingActionButtonImplLollipop
 *  com.google.android.material.internal.ThemeEnforcement
 *  com.google.android.material.internal.ViewUtils
 *  com.google.android.material.internal.VisibilityAwareImageButton
 *  com.google.android.material.resources.MaterialResources
 *  com.google.android.material.shadow.ShadowViewDelegate
 *  com.google.android.material.stateful.ExtendableSavedState
 */
package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.expandable.ExpandableTransformationWidget;
import com.google.android.material.expandable.ExpandableWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImplLollipop;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.stateful.ExtendableSavedState;

@CoordinatorLayout.DefaultBehavior(value=Behavior.class)
public class FloatingActionButton
extends VisibilityAwareImageButton
implements TintableBackgroundView,
TintableImageSourceView,
ExpandableTransformationWidget {
    private static final int AUTO_MINI_LARGEST_SCREEN_WIDTH = 470;
    private static final String EXPANDABLE_WIDGET_HELPER_KEY = "expandableWidgetHelper";
    private static final String LOG_TAG = "FloatingActionButton";
    public static final int NO_CUSTOM_SIZE = 0;
    public static final int SIZE_AUTO = -1;
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL = 0;
    private ColorStateList backgroundTint;
    private PorterDuff.Mode backgroundTintMode;
    private int borderWidth;
    boolean compatPadding;
    private int customSize;
    private final ExpandableWidgetHelper expandableWidgetHelper;
    private final AppCompatImageHelper imageHelper;
    private PorterDuff.Mode imageMode;
    private int imagePadding;
    private ColorStateList imageTint;
    private FloatingActionButtonImpl impl;
    private int maxImageSize;
    private ColorStateList rippleColor;
    final Rect shadowPadding = new Rect();
    private int size;
    private final Rect touchArea = new Rect();

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.floatingActionButtonStyle);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        TypedArray typedArray = ThemeEnforcement.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.FloatingActionButton, (int)n, (int)R.style.Widget_Design_FloatingActionButton, (int[])new int[0]);
        this.backgroundTint = MaterialResources.getColorStateList((Context)context, (TypedArray)typedArray, (int)R.styleable.FloatingActionButton_backgroundTint);
        this.backgroundTintMode = ViewUtils.parseTintMode((int)typedArray.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.rippleColor = MaterialResources.getColorStateList((Context)context, (TypedArray)typedArray, (int)R.styleable.FloatingActionButton_rippleColor);
        this.size = typedArray.getInt(R.styleable.FloatingActionButton_fabSize, -1);
        this.customSize = typedArray.getDimensionPixelSize(R.styleable.FloatingActionButton_fabCustomSize, 0);
        this.borderWidth = typedArray.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
        float f = typedArray.getDimension(R.styleable.FloatingActionButton_elevation, 0.0f);
        float f2 = typedArray.getDimension(R.styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float f3 = typedArray.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.compatPadding = typedArray.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
        this.maxImageSize = typedArray.getDimensionPixelSize(R.styleable.FloatingActionButton_maxImageSize, 0);
        MotionSpec motionSpec = MotionSpec.createFromAttribute((Context)context, (TypedArray)typedArray, (int)R.styleable.FloatingActionButton_showMotionSpec);
        context = MotionSpec.createFromAttribute((Context)context, (TypedArray)typedArray, (int)R.styleable.FloatingActionButton_hideMotionSpec);
        typedArray.recycle();
        typedArray = new AppCompatImageHelper((ImageView)this);
        this.imageHelper = typedArray;
        typedArray.loadFromAttributes(attributeSet, n);
        this.expandableWidgetHelper = new ExpandableWidgetHelper((ExpandableWidget)this);
        this.getImpl().setBackgroundDrawable(this.backgroundTint, this.backgroundTintMode, this.rippleColor, this.borderWidth);
        this.getImpl().setElevation(f);
        this.getImpl().setHoveredFocusedTranslationZ(f2);
        this.getImpl().setPressedTranslationZ(f3);
        this.getImpl().setMaxImageSize(this.maxImageSize);
        this.getImpl().setShowMotionSpec(motionSpec);
        this.getImpl().setHideMotionSpec((MotionSpec)context);
        this.setScaleType(ImageView.ScaleType.MATRIX);
    }

    static /* synthetic */ int access$000(FloatingActionButton floatingActionButton) {
        return floatingActionButton.imagePadding;
    }

    static /* synthetic */ void access$101(FloatingActionButton floatingActionButton, Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    private FloatingActionButtonImpl createImpl() {
        if (Build.VERSION.SDK_INT < 21) return new FloatingActionButtonImpl((VisibilityAwareImageButton)this, (ShadowViewDelegate)new ShadowDelegateImpl(this));
        return new FloatingActionButtonImplLollipop((VisibilityAwareImageButton)this, (ShadowViewDelegate)new ShadowDelegateImpl(this));
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.impl != null) return this.impl;
        this.impl = this.createImpl();
        return this.impl;
    }

    private int getSizeDimension(int n) {
        int n2 = this.customSize;
        if (n2 != 0) {
            return n2;
        }
        Resources resources = this.getResources();
        if (n != -1) {
            if (n == 1) return resources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
            return resources.getDimensionPixelSize(R.dimen.design_fab_size_normal);
        }
        n = Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? this.getSizeDimension(1) : this.getSizeDimension(0);
        return n;
    }

    private void offsetRectWithShadow(Rect rect) {
        rect.left += this.shadowPadding.left;
        rect.top += this.shadowPadding.top;
        rect.right -= this.shadowPadding.right;
        rect.bottom -= this.shadowPadding.bottom;
    }

    private void onApplySupportImageTint() {
        Drawable drawable = this.getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.imageTint;
        if (colorStateList == null) {
            DrawableCompat.clearColorFilter((Drawable)drawable);
            return;
        }
        int n = colorStateList.getColorForState(this.getDrawableState(), 0);
        PorterDuff.Mode mode = this.imageMode;
        colorStateList = mode;
        if (mode == null) {
            colorStateList = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter((ColorFilter)AppCompatDrawableManager.getPorterDuffColorFilter((int)n, (PorterDuff.Mode)colorStateList));
    }

    private static int resolveAdjustedSize(int n, int n2) {
        int n3 = View.MeasureSpec.getMode((int)n2);
        n2 = View.MeasureSpec.getSize((int)n2);
        if (n3 != Integer.MIN_VALUE) {
            if (n3 == 0) return n;
            if (n3 != 0x40000000) throw new IllegalArgumentException();
            n = n2;
        } else {
            n = Math.min(n, n2);
        }
        return n;
    }

    private FloatingActionButtonImpl.InternalVisibilityChangedListener wrapOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener) {
        if (onVisibilityChangedListener != null) return new /* Unavailable Anonymous Inner Class!! */;
        return null;
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        this.getImpl().addOnHideAnimationListener(animatorListener);
    }

    public void addOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        this.getImpl().addOnShowAnimationListener(animatorListener);
    }

    public void clearCustomSize() {
        this.setCustomSize(0);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.getImpl().onDrawableStateChanged(this.getDrawableState());
    }

    public ColorStateList getBackgroundTintList() {
        return this.backgroundTint;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    public float getCompatElevation() {
        return this.getImpl().getElevation();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return this.getImpl().getHoveredFocusedTranslationZ();
    }

    public float getCompatPressedTranslationZ() {
        return this.getImpl().getPressedTranslationZ();
    }

    public Drawable getContentBackground() {
        return this.getImpl().getContentBackground();
    }

    @Deprecated
    public boolean getContentRect(Rect rect) {
        if (!ViewCompat.isLaidOut((View)this)) return false;
        rect.set(0, 0, this.getWidth(), this.getHeight());
        this.offsetRectWithShadow(rect);
        return true;
    }

    public int getCustomSize() {
        return this.customSize;
    }

    public int getExpandedComponentIdHint() {
        return this.expandableWidgetHelper.getExpandedComponentIdHint();
    }

    public MotionSpec getHideMotionSpec() {
        return this.getImpl().getHideMotionSpec();
    }

    public void getMeasuredContentRect(Rect rect) {
        rect.set(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
        this.offsetRectWithShadow(rect);
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.rippleColor;
        int n = colorStateList != null ? colorStateList.getDefaultColor() : 0;
        return n;
    }

    public ColorStateList getRippleColorStateList() {
        return this.rippleColor;
    }

    public MotionSpec getShowMotionSpec() {
        return this.getImpl().getShowMotionSpec();
    }

    public int getSize() {
        return this.size;
    }

    int getSizeDimension() {
        return this.getSizeDimension(this.size);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.imageTint;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.imageMode;
    }

    public boolean getUseCompatPadding() {
        return this.compatPadding;
    }

    public void hide() {
        this.hide(null);
    }

    public void hide(OnVisibilityChangedListener onVisibilityChangedListener) {
        this.hide(onVisibilityChangedListener, true);
    }

    void hide(OnVisibilityChangedListener onVisibilityChangedListener, boolean bl) {
        this.getImpl().hide(this.wrapOnVisibilityChangedListener(onVisibilityChangedListener), bl);
    }

    public boolean isExpanded() {
        return this.expandableWidgetHelper.isExpanded();
    }

    public boolean isOrWillBeHidden() {
        return this.getImpl().isOrWillBeHidden();
    }

    public boolean isOrWillBeShown() {
        return this.getImpl().isOrWillBeShown();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.getImpl().jumpDrawableToCurrentState();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.getImpl().onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.getImpl().onDetachedFromWindow();
    }

    protected void onMeasure(int n, int n2) {
        int n3 = this.getSizeDimension();
        this.imagePadding = (n3 - this.maxImageSize) / 2;
        this.getImpl().updatePadding();
        n = Math.min(FloatingActionButton.resolveAdjustedSize(n3, n), FloatingActionButton.resolveAdjustedSize(n3, n2));
        this.setMeasuredDimension(this.shadowPadding.left + n + this.shadowPadding.right, n + this.shadowPadding.top + this.shadowPadding.bottom);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (ExtendableSavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        this.expandableWidgetHelper.onRestoreInstanceState((Bundle)parcelable.extendableStates.get((Object)EXPANDABLE_WIDGET_HELPER_KEY));
    }

    protected Parcelable onSaveInstanceState() {
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(super.onSaveInstanceState());
        extendableSavedState.extendableStates.put((Object)EXPANDABLE_WIDGET_HELPER_KEY, (Object)this.expandableWidgetHelper.onSaveInstanceState());
        return extendableSavedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) return super.onTouchEvent(motionEvent);
        if (!this.getContentRect(this.touchArea)) return super.onTouchEvent(motionEvent);
        if (this.touchArea.contains((int)motionEvent.getX(), (int)motionEvent.getY())) return super.onTouchEvent(motionEvent);
        return false;
    }

    public void removeOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        this.getImpl().removeOnHideAnimationListener(animatorListener);
    }

    public void removeOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        this.getImpl().removeOnShowAnimationListener(animatorListener);
    }

    public void setBackgroundColor(int n) {
        Log.i((String)LOG_TAG, (String)"Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i((String)LOG_TAG, (String)"Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int n) {
        Log.i((String)LOG_TAG, (String)"Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.backgroundTint == colorStateList) return;
        this.backgroundTint = colorStateList;
        this.getImpl().setBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.backgroundTintMode == mode) return;
        this.backgroundTintMode = mode;
        this.getImpl().setBackgroundTintMode(mode);
    }

    public void setCompatElevation(float f) {
        this.getImpl().setElevation(f);
    }

    public void setCompatElevationResource(int n) {
        this.setCompatElevation(this.getResources().getDimension(n));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        this.getImpl().setHoveredFocusedTranslationZ(f);
    }

    public void setCompatHoveredFocusedTranslationZResource(int n) {
        this.setCompatHoveredFocusedTranslationZ(this.getResources().getDimension(n));
    }

    public void setCompatPressedTranslationZ(float f) {
        this.getImpl().setPressedTranslationZ(f);
    }

    public void setCompatPressedTranslationZResource(int n) {
        this.setCompatPressedTranslationZ(this.getResources().getDimension(n));
    }

    public void setCustomSize(int n) {
        if (n < 0) throw new IllegalArgumentException("Custom size must be non-negative");
        this.customSize = n;
    }

    public boolean setExpanded(boolean bl) {
        return this.expandableWidgetHelper.setExpanded(bl);
    }

    public void setExpandedComponentIdHint(int n) {
        this.expandableWidgetHelper.setExpandedComponentIdHint(n);
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        this.getImpl().setHideMotionSpec(motionSpec);
    }

    public void setHideMotionSpecResource(int n) {
        this.setHideMotionSpec(MotionSpec.createFromResource((Context)this.getContext(), (int)n));
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.getImpl().updateImageMatrixScale();
    }

    public void setImageResource(int n) {
        this.imageHelper.setImageResource(n);
    }

    public void setRippleColor(int n) {
        this.setRippleColor(ColorStateList.valueOf((int)n));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.rippleColor == colorStateList) return;
        this.rippleColor = colorStateList;
        this.getImpl().setRippleColor(this.rippleColor);
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        this.getImpl().setShowMotionSpec(motionSpec);
    }

    public void setShowMotionSpecResource(int n) {
        this.setShowMotionSpec(MotionSpec.createFromResource((Context)this.getContext(), (int)n));
    }

    public void setSize(int n) {
        this.customSize = 0;
        if (n == this.size) return;
        this.size = n;
        this.requestLayout();
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        this.setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        this.setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.imageTint == colorStateList) return;
        this.imageTint = colorStateList;
        this.onApplySupportImageTint();
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.imageMode == mode) return;
        this.imageMode = mode;
        this.onApplySupportImageTint();
    }

    public void setUseCompatPadding(boolean bl) {
        if (this.compatPadding == bl) return;
        this.compatPadding = bl;
        this.getImpl().onCompatShadowChanged();
    }

    public void show() {
        this.show(null);
    }

    public void show(OnVisibilityChangedListener onVisibilityChangedListener) {
        this.show(onVisibilityChangedListener, true);
    }

    void show(OnVisibilityChangedListener onVisibilityChangedListener, boolean bl) {
        this.getImpl().show(this.wrapOnVisibilityChangedListener(onVisibilityChangedListener), bl);
    }
}
