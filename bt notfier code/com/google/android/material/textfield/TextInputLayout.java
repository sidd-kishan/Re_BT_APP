/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.graphics.drawable.DrawableContainer
 *  android.graphics.drawable.GradientDrawable
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.text.TextWatcher
 *  android.text.method.PasswordTransformationMethod
 *  android.text.method.TransformationMethod
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewStructure
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.widget.AppCompatDrawableManager
 *  androidx.appcompat.widget.AppCompatTextView
 *  androidx.appcompat.widget.DrawableUtils
 *  androidx.core.content.ContextCompat
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.ViewCompat
 *  androidx.core.widget.TextViewCompat
 *  com.google.android.material.R$attr
 *  com.google.android.material.R$color
 *  com.google.android.material.R$dimen
 *  com.google.android.material.R$id
 *  com.google.android.material.R$layout
 *  com.google.android.material.R$string
 *  com.google.android.material.R$style
 *  com.google.android.material.R$styleable
 *  com.google.android.material.animation.AnimationUtils
 *  com.google.android.material.internal.CheckableImageButton
 *  com.google.android.material.internal.CollapsingTextHelper
 *  com.google.android.material.internal.DescendantOffsetUtils
 *  com.google.android.material.internal.DrawableUtils
 *  com.google.android.material.internal.ThemeEnforcement
 *  com.google.android.material.internal.ViewUtils
 *  com.google.android.material.textfield.CutoutDrawable
 *  com.google.android.material.textfield.IndicatorViewController
 *  com.google.android.material.textfield.TextInputEditText
 *  com.google.android.material.textfield.TextInputLayout$AccessibilityDelegate
 *  com.google.android.material.textfield.TextInputLayout$SavedState
 */
package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.CutoutDrawable;
import com.google.android.material.textfield.IndicatorViewController;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class TextInputLayout
extends LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final String LOG_TAG = "TextInputLayout";
    private ValueAnimator animator;
    private GradientDrawable boxBackground;
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private final int boxBottomOffsetPx;
    private final int boxCollapsedPaddingTopPx;
    private float boxCornerRadiusBottomEnd;
    private float boxCornerRadiusBottomStart;
    private float boxCornerRadiusTopEnd;
    private float boxCornerRadiusTopStart;
    private final int boxLabelCutoutPaddingPx;
    private int boxStrokeColor;
    private final int boxStrokeWidthDefaultPx;
    private final int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;
    final CollapsingTextHelper collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private final int counterOverflowTextAppearance;
    private boolean counterOverflowed;
    private final int counterTextAppearance;
    private TextView counterView;
    private ColorStateList defaultHintTextColor;
    private final int defaultStrokeColor;
    private final int disabledColor;
    EditText editText;
    private Drawable editTextOriginalDrawable;
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private boolean hasPasswordToggleTintList;
    private boolean hasPasswordToggleTintMode;
    private boolean hasReconstructedEditTextBackground;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;
    private final int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final IndicatorViewController indicatorViewController = new IndicatorViewController(this);
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    private CharSequence passwordToggleContentDesc;
    private Drawable passwordToggleDrawable;
    private Drawable passwordToggleDummyDrawable;
    private boolean passwordToggleEnabled;
    private ColorStateList passwordToggleTintList;
    private PorterDuff.Mode passwordToggleTintMode;
    private CheckableImageButton passwordToggleView;
    private boolean passwordToggledVisible;
    private boolean restoringSavedState;
    private final Rect tmpRect = new Rect();
    private final RectF tmpRectF = new RectF();
    private Typeface typeface;

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    public TextInputLayout(Context object, AttributeSet attributeSet, int n) {
        super(object, attributeSet, n);
        FrameLayout frameLayout;
        this.collapsingTextHelper = new CollapsingTextHelper((View)this);
        this.setOrientation(1);
        this.setWillNotDraw(false);
        this.setAddStatesFromChildren(true);
        this.inputFrame = frameLayout = new FrameLayout(object);
        frameLayout.setAddStatesFromChildren(true);
        this.addView((View)this.inputFrame);
        this.collapsingTextHelper.setTextSizeInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        this.collapsingTextHelper.setPositionInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        this.collapsingTextHelper.setCollapsedTextGravity(0x800033);
        attributeSet = ThemeEnforcement.obtainTintedStyledAttributes((Context)object, (AttributeSet)attributeSet, (int[])R.styleable.TextInputLayout, (int)n, (int)R.style.Widget_Design_TextInputLayout, (int[])new int[0]);
        this.hintEnabled = attributeSet.getBoolean(R.styleable.TextInputLayout_hintEnabled, true);
        this.setHint(attributeSet.getText(R.styleable.TextInputLayout_android_hint));
        this.hintAnimationEnabled = attributeSet.getBoolean(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        this.boxBottomOffsetPx = object.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_bottom_offset);
        this.boxLabelCutoutPaddingPx = object.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = attributeSet.getDimensionPixelOffset(R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.boxCornerRadiusTopStart = attributeSet.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopStart, 0.0f);
        this.boxCornerRadiusTopEnd = attributeSet.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopEnd, 0.0f);
        this.boxCornerRadiusBottomEnd = attributeSet.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, 0.0f);
        this.boxCornerRadiusBottomStart = attributeSet.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomStart, 0.0f);
        this.boxBackgroundColor = attributeSet.getColor(R.styleable.TextInputLayout_boxBackgroundColor, 0);
        this.focusedStrokeColor = attributeSet.getColor(R.styleable.TextInputLayout_boxStrokeColor, 0);
        this.boxStrokeWidthDefaultPx = object.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default);
        this.boxStrokeWidthFocusedPx = object.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused);
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        this.setBoxBackgroundMode(attributeSet.getInt(R.styleable.TextInputLayout_boxBackgroundMode, 0));
        if (attributeSet.hasValue(R.styleable.TextInputLayout_android_textColorHint)) {
            frameLayout = attributeSet.getColorStateList(R.styleable.TextInputLayout_android_textColorHint);
            this.focusedTextColor = frameLayout;
            this.defaultHintTextColor = frameLayout;
        }
        this.defaultStrokeColor = ContextCompat.getColor((Context)object, (int)R.color.mtrl_textinput_default_box_stroke_color);
        this.disabledColor = ContextCompat.getColor((Context)object, (int)R.color.mtrl_textinput_disabled_color);
        this.hoveredStrokeColor = ContextCompat.getColor((Context)object, (int)R.color.mtrl_textinput_hovered_box_stroke_color);
        if (attributeSet.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
            this.setHintTextAppearance(attributeSet.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, 0));
        }
        n = attributeSet.getResourceId(R.styleable.TextInputLayout_errorTextAppearance, 0);
        boolean bl = attributeSet.getBoolean(R.styleable.TextInputLayout_errorEnabled, false);
        int n2 = attributeSet.getResourceId(R.styleable.TextInputLayout_helperTextTextAppearance, 0);
        boolean bl2 = attributeSet.getBoolean(R.styleable.TextInputLayout_helperTextEnabled, false);
        object = attributeSet.getText(R.styleable.TextInputLayout_helperText);
        boolean bl3 = attributeSet.getBoolean(R.styleable.TextInputLayout_counterEnabled, false);
        this.setCounterMaxLength(attributeSet.getInt(R.styleable.TextInputLayout_counterMaxLength, -1));
        this.counterTextAppearance = attributeSet.getResourceId(R.styleable.TextInputLayout_counterTextAppearance, 0);
        this.counterOverflowTextAppearance = attributeSet.getResourceId(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        this.passwordToggleEnabled = attributeSet.getBoolean(R.styleable.TextInputLayout_passwordToggleEnabled, false);
        this.passwordToggleDrawable = attributeSet.getDrawable(R.styleable.TextInputLayout_passwordToggleDrawable);
        this.passwordToggleContentDesc = attributeSet.getText(R.styleable.TextInputLayout_passwordToggleContentDescription);
        if (attributeSet.hasValue(R.styleable.TextInputLayout_passwordToggleTint)) {
            this.hasPasswordToggleTintList = true;
            this.passwordToggleTintList = attributeSet.getColorStateList(R.styleable.TextInputLayout_passwordToggleTint);
        }
        if (attributeSet.hasValue(R.styleable.TextInputLayout_passwordToggleTintMode)) {
            this.hasPasswordToggleTintMode = true;
            this.passwordToggleTintMode = ViewUtils.parseTintMode((int)attributeSet.getInt(R.styleable.TextInputLayout_passwordToggleTintMode, -1), null);
        }
        attributeSet.recycle();
        this.setHelperTextEnabled(bl2);
        this.setHelperText((CharSequence)object);
        this.setHelperTextTextAppearance(n2);
        this.setErrorEnabled(bl);
        this.setErrorTextAppearance(n);
        this.setCounterEnabled(bl3);
        this.applyPasswordToggleTint();
        ViewCompat.setImportantForAccessibility((View)this, (int)2);
    }

    static /* synthetic */ boolean access$000(TextInputLayout textInputLayout) {
        return textInputLayout.restoringSavedState;
    }

    private void applyBoxAttributes() {
        int n;
        int n2;
        EditText editText;
        if (this.boxBackground == null) {
            return;
        }
        this.setBoxAttributes();
        EditText editText2 = this.editText;
        if (editText2 != null && this.boxBackgroundMode == 2) {
            if (editText2.getBackground() != null) {
                this.editTextOriginalDrawable = this.editText.getBackground();
            }
            ViewCompat.setBackground((View)this.editText, null);
        }
        if ((editText = this.editText) != null && this.boxBackgroundMode == 1 && (editText2 = this.editTextOriginalDrawable) != null) {
            ViewCompat.setBackground((View)editText, (Drawable)editText2);
        }
        if ((n2 = this.boxStrokeWidthPx) > -1 && (n = this.boxStrokeColor) != 0) {
            this.boxBackground.setStroke(n2, n);
        }
        this.boxBackground.setCornerRadii(this.getCornerRadiiAsArray());
        this.boxBackground.setColor(this.boxBackgroundColor);
        this.invalidate();
    }

    private void applyCutoutPadding(RectF rectF) {
        rectF.left -= (float)this.boxLabelCutoutPaddingPx;
        rectF.top -= (float)this.boxLabelCutoutPaddingPx;
        rectF.right += (float)this.boxLabelCutoutPaddingPx;
        rectF.bottom += (float)this.boxLabelCutoutPaddingPx;
    }

    private void applyPasswordToggleTint() {
        Drawable drawable;
        Drawable drawable2;
        if (this.passwordToggleDrawable == null) return;
        if (!this.hasPasswordToggleTintList) {
            if (!this.hasPasswordToggleTintMode) return;
        }
        this.passwordToggleDrawable = drawable2 = DrawableCompat.wrap((Drawable)this.passwordToggleDrawable).mutate();
        if (this.hasPasswordToggleTintList) {
            DrawableCompat.setTintList((Drawable)drawable2, (ColorStateList)this.passwordToggleTintList);
        }
        if (this.hasPasswordToggleTintMode) {
            DrawableCompat.setTintMode((Drawable)this.passwordToggleDrawable, (PorterDuff.Mode)this.passwordToggleTintMode);
        }
        if ((drawable2 = this.passwordToggleView) == null) return;
        if ((drawable2 = drawable2.getDrawable()) == (drawable = this.passwordToggleDrawable)) return;
        this.passwordToggleView.setImageDrawable(drawable);
    }

    private void assignBoxBackgroundByMode() {
        int n = this.boxBackgroundMode;
        if (n == 0) {
            this.boxBackground = null;
        } else if (n == 2 && this.hintEnabled && !(this.boxBackground instanceof CutoutDrawable)) {
            this.boxBackground = new CutoutDrawable();
        } else {
            if (this.boxBackground instanceof GradientDrawable) return;
            this.boxBackground = new GradientDrawable();
        }
    }

    private int calculateBoxBackgroundTop() {
        EditText editText = this.editText;
        if (editText == null) {
            return 0;
        }
        int n = this.boxBackgroundMode;
        if (n == 1) return editText.getTop();
        if (n == 2) return editText.getTop() + this.calculateLabelMarginTop();
        return 0;
    }

    private int calculateCollapsedTextTopBounds() {
        int n = this.boxBackgroundMode;
        if (n == 1) return this.getBoxBackground().getBounds().top + this.boxCollapsedPaddingTopPx;
        if (n == 2) return this.getBoxBackground().getBounds().top - this.calculateLabelMarginTop();
        return this.getPaddingTop();
    }

    private int calculateLabelMarginTop() {
        float f;
        if (!this.hintEnabled) {
            return 0;
        }
        int n = this.boxBackgroundMode;
        if (n != 0 && n != 1) {
            if (n != 2) {
                return 0;
            }
            f = this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
        } else {
            f = this.collapsingTextHelper.getCollapsedTextHeight();
        }
        return (int)f;
    }

    private void closeCutout() {
        if (!this.cutoutEnabled()) return;
        ((CutoutDrawable)this.boxBackground).removeCutout();
    }

    private void collapseHint(boolean bl) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (bl && this.hintAnimationEnabled) {
            this.animateToExpansionFraction(1.0f);
        } else {
            this.collapsingTextHelper.setExpansionFraction(1.0f);
        }
        this.hintExpanded = false;
        if (!this.cutoutEnabled()) return;
        this.openCutout();
    }

    private boolean cutoutEnabled() {
        boolean bl = this.hintEnabled && !TextUtils.isEmpty((CharSequence)this.hint) && this.boxBackground instanceof CutoutDrawable;
        return bl;
    }

    private void ensureBackgroundDrawableStateWorkaround() {
        int n = Build.VERSION.SDK_INT;
        if (n != 21 && n != 22) {
            return;
        }
        Drawable drawable = this.editText.getBackground();
        if (drawable == null) {
            return;
        }
        if (this.hasReconstructedEditTextBackground) return;
        Drawable drawable2 = drawable.getConstantState().newDrawable();
        if (drawable instanceof DrawableContainer) {
            this.hasReconstructedEditTextBackground = com.google.android.material.internal.DrawableUtils.setContainerConstantState((DrawableContainer)((DrawableContainer)drawable), (Drawable.ConstantState)drawable2.getConstantState());
        }
        if (this.hasReconstructedEditTextBackground) return;
        ViewCompat.setBackground((View)this.editText, (Drawable)drawable2);
        this.hasReconstructedEditTextBackground = true;
        this.onApplyBoxBackgroundMode();
    }

    private void expandHint(boolean bl) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (bl && this.hintAnimationEnabled) {
            this.animateToExpansionFraction(0.0f);
        } else {
            this.collapsingTextHelper.setExpansionFraction(0.0f);
        }
        if (this.cutoutEnabled() && ((CutoutDrawable)this.boxBackground).hasCutout()) {
            this.closeCutout();
        }
        this.hintExpanded = true;
    }

    private Drawable getBoxBackground() {
        int n = this.boxBackgroundMode;
        if (n == 1) return this.boxBackground;
        if (n != 2) throw new IllegalStateException();
        return this.boxBackground;
    }

    private float[] getCornerRadiiAsArray() {
        if (!ViewUtils.isLayoutRtl((View)this)) {
            float f = this.boxCornerRadiusTopStart;
            float f2 = this.boxCornerRadiusTopEnd;
            float f3 = this.boxCornerRadiusBottomEnd;
            float f4 = this.boxCornerRadiusBottomStart;
            return new float[]{f, f, f2, f2, f3, f3, f4, f4};
        }
        float f = this.boxCornerRadiusTopEnd;
        float f5 = this.boxCornerRadiusTopStart;
        float f6 = this.boxCornerRadiusBottomStart;
        float f7 = this.boxCornerRadiusBottomEnd;
        return new float[]{f, f, f5, f5, f6, f6, f7, f7};
    }

    private boolean hasPasswordTransformation() {
        EditText editText = this.editText;
        boolean bl = editText != null && editText.getTransformationMethod() instanceof PasswordTransformationMethod;
        return bl;
    }

    private void onApplyBoxBackgroundMode() {
        this.assignBoxBackgroundByMode();
        if (this.boxBackgroundMode != 0) {
            this.updateInputLayoutMargins();
        }
        this.updateTextInputBoxBounds();
    }

    private void openCutout() {
        if (!this.cutoutEnabled()) {
            return;
        }
        RectF rectF = this.tmpRectF;
        this.collapsingTextHelper.getCollapsedTextActualBounds(rectF);
        this.applyCutoutPadding(rectF);
        ((CutoutDrawable)this.boxBackground).setCutout(rectF);
    }

    private static void recursiveSetEnabled(ViewGroup viewGroup, boolean bl) {
        int n = viewGroup.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            View view = viewGroup.getChildAt(n2);
            view.setEnabled(bl);
            if (view instanceof ViewGroup) {
                TextInputLayout.recursiveSetEnabled((ViewGroup)view, bl);
            }
            ++n2;
        }
    }

    private void setBoxAttributes() {
        int n = this.boxBackgroundMode;
        if (n != 1) {
            if (n != 2) return;
            if (this.focusedStrokeColor != 0) return;
            this.focusedStrokeColor = this.focusedTextColor.getColorForState(this.getDrawableState(), this.focusedTextColor.getDefaultColor());
        } else {
            this.boxStrokeWidthPx = 0;
        }
    }

    private void setEditText(EditText object) {
        if (this.editText != null) throw new IllegalArgumentException("We already have an EditText, can only have one");
        if (!(object instanceof TextInputEditText)) {
            Log.i((String)LOG_TAG, (String)"EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.editText = object;
        this.onApplyBoxBackgroundMode();
        this.setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
        if (!this.hasPasswordTransformation()) {
            this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
        }
        this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
        int n = this.editText.getGravity();
        this.collapsingTextHelper.setCollapsedTextGravity(n & 0xFFFFFF8F | 0x30);
        this.collapsingTextHelper.setExpandedTextGravity(n);
        this.editText.addTextChangedListener((TextWatcher)new /* Unavailable Anonymous Inner Class!! */);
        if (this.defaultHintTextColor == null) {
            this.defaultHintTextColor = this.editText.getHintTextColors();
        }
        if (this.hintEnabled) {
            if (TextUtils.isEmpty((CharSequence)this.hint)) {
                object = this.editText.getHint();
                this.originalHint = object;
                this.setHint((CharSequence)object);
                this.editText.setHint(null);
            }
            this.isProvidingHint = true;
        }
        if (this.counterView != null) {
            this.updateCounter(this.editText.getText().length());
        }
        this.indicatorViewController.adjustIndicatorPadding();
        this.updatePasswordToggleView();
        this.updateLabelState(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals((CharSequence)charSequence, (CharSequence)this.hint)) return;
        this.hint = charSequence;
        this.collapsingTextHelper.setText(charSequence);
        if (this.hintExpanded) return;
        this.openCutout();
    }

    private boolean shouldShowPasswordIcon() {
        boolean bl = this.passwordToggleEnabled && (this.hasPasswordTransformation() || this.passwordToggledVisible);
        return bl;
    }

    private void updateEditTextBackgroundBounds() {
        EditText editText = this.editText;
        if (editText == null) {
            return;
        }
        Drawable drawable = editText.getBackground();
        if (drawable == null) {
            return;
        }
        editText = drawable;
        if (DrawableUtils.canSafelyMutateDrawable((Drawable)drawable)) {
            editText = drawable.mutate();
        }
        drawable = new Rect();
        DescendantOffsetUtils.getDescendantRect((ViewGroup)this, (View)this.editText, (Rect)drawable);
        Rect rect = editText.getBounds();
        if (rect.left == rect.right) return;
        drawable = new Rect();
        editText.getPadding((Rect)drawable);
        int n = rect.left;
        int n2 = drawable.left;
        int n3 = rect.right;
        int n4 = drawable.right;
        editText.setBounds(n - n2, rect.top, n3 + n4 * 2, this.editText.getBottom());
    }

    private void updateInputLayoutMargins() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.inputFrame.getLayoutParams();
        int n = this.calculateLabelMarginTop();
        if (n == layoutParams.topMargin) return;
        layoutParams.topMargin = n;
        this.inputFrame.requestLayout();
    }

    private void updateLabelState(boolean bl, boolean bl2) {
        boolean bl3 = this.isEnabled();
        EditText editText = this.editText;
        boolean bl4 = true;
        boolean bl5 = editText != null && !TextUtils.isEmpty((CharSequence)editText.getText());
        editText = this.editText;
        if (editText == null || !editText.hasFocus()) {
            bl4 = false;
        }
        boolean bl6 = this.indicatorViewController.errorShouldBeShown();
        editText = this.defaultHintTextColor;
        if (editText != null) {
            this.collapsingTextHelper.setCollapsedTextColor((ColorStateList)editText);
            this.collapsingTextHelper.setExpandedTextColor(this.defaultHintTextColor);
        }
        if (!bl3) {
            this.collapsingTextHelper.setCollapsedTextColor(ColorStateList.valueOf((int)this.disabledColor));
            this.collapsingTextHelper.setExpandedTextColor(ColorStateList.valueOf((int)this.disabledColor));
        } else if (bl6) {
            this.collapsingTextHelper.setCollapsedTextColor(this.indicatorViewController.getErrorViewTextColors());
        } else if (this.counterOverflowed && (editText = this.counterView) != null) {
            this.collapsingTextHelper.setCollapsedTextColor(editText.getTextColors());
        } else if (bl4 && (editText = this.focusedTextColor) != null) {
            this.collapsingTextHelper.setCollapsedTextColor((ColorStateList)editText);
        }
        if (!(bl5 || this.isEnabled() && (bl4 || bl6))) {
            if (!bl2) {
                if (this.hintExpanded) return;
            }
            this.expandHint(bl);
        } else {
            if (!bl2) {
                if (!this.hintExpanded) return;
            }
            this.collapseHint(bl);
        }
    }

    private void updatePasswordToggleView() {
        if (this.editText == null) {
            return;
        }
        if (this.shouldShowPasswordIcon()) {
            Drawable[] drawableArray;
            if (this.passwordToggleView == null) {
                drawableArray = (CheckableImageButton)LayoutInflater.from((Context)this.getContext()).inflate(R.layout.design_text_input_password_icon, (ViewGroup)this.inputFrame, false);
                this.passwordToggleView = drawableArray;
                drawableArray.setImageDrawable(this.passwordToggleDrawable);
                this.passwordToggleView.setContentDescription(this.passwordToggleContentDesc);
                this.inputFrame.addView((View)this.passwordToggleView);
                this.passwordToggleView.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
            }
            if ((drawableArray = this.editText) != null && ViewCompat.getMinimumHeight((View)drawableArray) <= 0) {
                this.editText.setMinimumHeight(ViewCompat.getMinimumHeight((View)this.passwordToggleView));
            }
            this.passwordToggleView.setVisibility(0);
            this.passwordToggleView.setChecked(this.passwordToggledVisible);
            if (this.passwordToggleDummyDrawable == null) {
                this.passwordToggleDummyDrawable = new ColorDrawable();
            }
            this.passwordToggleDummyDrawable.setBounds(0, 0, this.passwordToggleView.getMeasuredWidth(), 1);
            drawableArray = TextViewCompat.getCompoundDrawablesRelative((TextView)this.editText);
            if (drawableArray[2] != this.passwordToggleDummyDrawable) {
                this.originalEditTextEndDrawable = drawableArray[2];
            }
            TextViewCompat.setCompoundDrawablesRelative((TextView)this.editText, (Drawable)drawableArray[0], (Drawable)drawableArray[1], (Drawable)this.passwordToggleDummyDrawable, (Drawable)drawableArray[3]);
            this.passwordToggleView.setPadding(this.editText.getPaddingLeft(), this.editText.getPaddingTop(), this.editText.getPaddingRight(), this.editText.getPaddingBottom());
        } else {
            Drawable[] drawableArray = this.passwordToggleView;
            if (drawableArray != null && drawableArray.getVisibility() == 0) {
                this.passwordToggleView.setVisibility(8);
            }
            if (this.passwordToggleDummyDrawable == null) return;
            drawableArray = TextViewCompat.getCompoundDrawablesRelative((TextView)this.editText);
            if (drawableArray[2] != this.passwordToggleDummyDrawable) return;
            TextViewCompat.setCompoundDrawablesRelative((TextView)this.editText, (Drawable)drawableArray[0], (Drawable)drawableArray[1], (Drawable)this.originalEditTextEndDrawable, (Drawable)drawableArray[3]);
            this.passwordToggleDummyDrawable = null;
        }
    }

    private void updateTextInputBoxBounds() {
        if (this.boxBackgroundMode == 0) return;
        if (this.boxBackground == null) return;
        if (this.editText == null) return;
        if (this.getRight() == 0) return;
        int n = this.editText.getLeft();
        int n2 = this.calculateBoxBackgroundTop();
        int n3 = this.editText.getRight();
        int n4 = this.editText.getBottom() + this.boxBottomOffsetPx;
        int n5 = n;
        int n6 = n2;
        int n7 = n3;
        int n8 = n4;
        if (this.boxBackgroundMode == 2) {
            n8 = this.boxStrokeWidthFocusedPx;
            n5 = n + n8 / 2;
            n6 = n2 - n8 / 2;
            n7 = n3 - n8 / 2;
            n8 = n4 + n8 / 2;
        }
        this.boxBackground.setBounds(n5, n6, n7, n8);
        this.applyBoxAttributes();
        this.updateEditTextBackgroundBounds();
    }

    public void addView(View view, int n, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = layoutParams2.gravity & 0xFFFFFF8F | 0x10;
            this.inputFrame.addView(view, (ViewGroup.LayoutParams)layoutParams2);
            this.inputFrame.setLayoutParams(layoutParams);
            this.updateInputLayoutMargins();
            this.setEditText((EditText)view);
        } else {
            super.addView(view, n, layoutParams);
        }
    }

    void animateToExpansionFraction(float f) {
        if (this.collapsingTextHelper.getExpansionFraction() == f) {
            return;
        }
        if (this.animator == null) {
            ValueAnimator valueAnimator;
            this.animator = valueAnimator = new ValueAnimator();
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.animator.setDuration(167L);
            this.animator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
        }
        this.animator.setFloatValues(new float[]{this.collapsingTextHelper.getExpansionFraction(), f});
        this.animator.start();
    }

    boolean cutoutIsOpen() {
        boolean bl = this.cutoutEnabled() && ((CutoutDrawable)this.boxBackground).hasCutout();
        return bl;
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int n) {
        Object object;
        if (this.originalHint != null && (object = this.editText) != null) {
            boolean bl = this.isProvidingHint;
            this.isProvidingHint = false;
            object = object.getHint();
            this.editText.setHint(this.originalHint);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, n);
                return;
            }
            finally {
                this.editText.setHint((CharSequence)object);
                this.isProvidingHint = bl;
            }
        }
        super.dispatchProvideAutofillStructure(viewStructure, n);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    public void draw(Canvas canvas) {
        GradientDrawable gradientDrawable = this.boxBackground;
        if (gradientDrawable != null) {
            gradientDrawable.draw(canvas);
        }
        super.draw(canvas);
        if (!this.hintEnabled) return;
        this.collapsingTextHelper.draw(canvas);
    }

    protected void drawableStateChanged() {
        if (this.inDrawableStateChanged) {
            return;
        }
        boolean bl = true;
        this.inDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] nArray = this.getDrawableState();
        if (!ViewCompat.isLaidOut((View)this) || !this.isEnabled()) {
            bl = false;
        }
        this.updateLabelState(bl);
        this.updateEditTextBackground();
        this.updateTextInputBoxBounds();
        this.updateTextInputBoxState();
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        boolean bl2 = collapsingTextHelper != null ? collapsingTextHelper.setState(nArray) | false : false;
        if (bl2) {
            this.invalidate();
        }
        this.inDrawableStateChanged = false;
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.boxCornerRadiusBottomEnd;
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.boxCornerRadiusBottomStart;
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.boxCornerRadiusTopEnd;
    }

    public float getBoxCornerRadiusTopStart() {
        return this.boxCornerRadiusTopStart;
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    CharSequence getCounterOverflowDescription() {
        if (!this.counterEnabled) return null;
        if (!this.counterOverflowed) return null;
        TextView textView = this.counterView;
        if (textView == null) return null;
        return textView.getContentDescription();
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    public EditText getEditText() {
        return this.editText;
    }

    public CharSequence getError() {
        CharSequence charSequence = this.indicatorViewController.isErrorEnabled() ? this.indicatorViewController.getErrorText() : null;
        return charSequence;
    }

    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    final int getErrorTextCurrentColor() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public CharSequence getHelperText() {
        CharSequence charSequence = this.indicatorViewController.isHelperTextEnabled() ? this.indicatorViewController.getHelperText() : null;
        return charSequence;
    }

    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.getHelperTextViewCurrentTextColor();
    }

    public CharSequence getHint() {
        CharSequence charSequence = this.hintEnabled ? this.hint : null;
        return charSequence;
    }

    final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.passwordToggleContentDesc;
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.passwordToggleDrawable;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.isErrorEnabled();
    }

    final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.helperTextIsDisplayed();
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.isHelperTextEnabled();
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    public boolean isPasswordVisibilityToggleEnabled() {
        return this.passwordToggleEnabled;
    }

    boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        if (this.boxBackground != null) {
            this.updateTextInputBoxBounds();
        }
        if (!this.hintEnabled) return;
        EditText editText = this.editText;
        if (editText == null) return;
        Rect rect = this.tmpRect;
        DescendantOffsetUtils.getDescendantRect((ViewGroup)this, (View)editText, (Rect)rect);
        n = rect.left + this.editText.getCompoundPaddingLeft();
        int n5 = rect.right - this.editText.getCompoundPaddingRight();
        n3 = this.calculateCollapsedTextTopBounds();
        this.collapsingTextHelper.setExpandedBounds(n, rect.top + this.editText.getCompoundPaddingTop(), n5, rect.bottom - this.editText.getCompoundPaddingBottom());
        this.collapsingTextHelper.setCollapsedBounds(n, n3, n5, n4 - n2 - this.getPaddingBottom());
        this.collapsingTextHelper.recalculate();
        if (!this.cutoutEnabled()) return;
        if (this.hintExpanded) return;
        this.openCutout();
    }

    protected void onMeasure(int n, int n2) {
        this.updatePasswordToggleView();
        super.onMeasure(n, n2);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        this.setError(parcelable.error);
        if (parcelable.isPasswordToggledVisible) {
            this.passwordVisibilityToggleRequested(true);
        }
        this.requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.errorShouldBeShown()) {
            savedState.error = this.getError();
        }
        savedState.isPasswordToggledVisible = this.passwordToggledVisible;
        return savedState;
    }

    public void passwordVisibilityToggleRequested(boolean bl) {
        if (!this.passwordToggleEnabled) return;
        int n = this.editText.getSelectionEnd();
        if (this.hasPasswordTransformation()) {
            this.editText.setTransformationMethod(null);
            this.passwordToggledVisible = true;
        } else {
            this.editText.setTransformationMethod((TransformationMethod)PasswordTransformationMethod.getInstance());
            this.passwordToggledVisible = false;
        }
        this.passwordToggleView.setChecked(this.passwordToggledVisible);
        if (bl) {
            this.passwordToggleView.jumpDrawablesToCurrentState();
        }
        this.editText.setSelection(n);
    }

    public void setBoxBackgroundColor(int n) {
        if (this.boxBackgroundColor == n) return;
        this.boxBackgroundColor = n;
        this.applyBoxAttributes();
    }

    public void setBoxBackgroundColorResource(int n) {
        this.setBoxBackgroundColor(ContextCompat.getColor((Context)this.getContext(), (int)n));
    }

    public void setBoxBackgroundMode(int n) {
        if (n == this.boxBackgroundMode) {
            return;
        }
        this.boxBackgroundMode = n;
        this.onApplyBoxBackgroundMode();
    }

    public void setBoxCornerRadii(float f, float f2, float f3, float f4) {
        if (this.boxCornerRadiusTopStart == f && this.boxCornerRadiusTopEnd == f2 && this.boxCornerRadiusBottomEnd == f4) {
            if (this.boxCornerRadiusBottomStart == f3) return;
        }
        this.boxCornerRadiusTopStart = f;
        this.boxCornerRadiusTopEnd = f2;
        this.boxCornerRadiusBottomEnd = f4;
        this.boxCornerRadiusBottomStart = f3;
        this.applyBoxAttributes();
    }

    public void setBoxCornerRadiiResources(int n, int n2, int n3, int n4) {
        this.setBoxCornerRadii(this.getContext().getResources().getDimension(n), this.getContext().getResources().getDimension(n2), this.getContext().getResources().getDimension(n3), this.getContext().getResources().getDimension(n4));
    }

    public void setBoxStrokeColor(int n) {
        if (this.focusedStrokeColor == n) return;
        this.focusedStrokeColor = n;
        this.updateTextInputBoxState();
    }

    public void setCounterEnabled(boolean bl) {
        if (this.counterEnabled == bl) return;
        if (bl) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.getContext());
            this.counterView = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_counter);
            appCompatTextView = this.typeface;
            if (appCompatTextView != null) {
                this.counterView.setTypeface((Typeface)appCompatTextView);
            }
            this.counterView.setMaxLines(1);
            this.setTextAppearanceCompatWithErrorFallback(this.counterView, this.counterTextAppearance);
            this.indicatorViewController.addIndicator(this.counterView, 2);
            appCompatTextView = this.editText;
            if (appCompatTextView == null) {
                this.updateCounter(0);
            } else {
                this.updateCounter(appCompatTextView.getText().length());
            }
        } else {
            this.indicatorViewController.removeIndicator(this.counterView, 2);
            this.counterView = null;
        }
        this.counterEnabled = bl;
    }

    public void setCounterMaxLength(int n) {
        if (this.counterMaxLength == n) return;
        this.counterMaxLength = n > 0 ? n : -1;
        if (!this.counterEnabled) return;
        EditText editText = this.editText;
        n = editText == null ? 0 : editText.getText().length();
        this.updateCounter(n);
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText == null) return;
        this.updateLabelState(false);
    }

    public void setEnabled(boolean bl) {
        TextInputLayout.recursiveSetEnabled((ViewGroup)this, bl);
        super.setEnabled(bl);
    }

    public void setError(CharSequence charSequence) {
        if (!this.indicatorViewController.isErrorEnabled()) {
            if (TextUtils.isEmpty((CharSequence)charSequence)) {
                return;
            }
            this.setErrorEnabled(true);
        }
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            this.indicatorViewController.showError(charSequence);
        } else {
            this.indicatorViewController.hideError();
        }
    }

    public void setErrorEnabled(boolean bl) {
        this.indicatorViewController.setErrorEnabled(bl);
    }

    public void setErrorTextAppearance(int n) {
        this.indicatorViewController.setErrorTextAppearance(n);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.indicatorViewController.setErrorViewTextColor(colorStateList);
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty((CharSequence)charSequence)) {
            if (!this.isHelperTextEnabled()) return;
            this.setHelperTextEnabled(false);
        } else {
            if (!this.isHelperTextEnabled()) {
                this.setHelperTextEnabled(true);
            }
            this.indicatorViewController.showHelper(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.indicatorViewController.setHelperTextViewTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean bl) {
        this.indicatorViewController.setHelperTextEnabled(bl);
    }

    public void setHelperTextTextAppearance(int n) {
        this.indicatorViewController.setHelperTextAppearance(n);
    }

    public void setHint(CharSequence charSequence) {
        if (!this.hintEnabled) return;
        this.setHintInternal(charSequence);
        this.sendAccessibilityEvent(2048);
    }

    public void setHintAnimationEnabled(boolean bl) {
        this.hintAnimationEnabled = bl;
    }

    public void setHintEnabled(boolean bl) {
        if (bl == this.hintEnabled) return;
        this.hintEnabled = bl;
        if (!bl) {
            this.isProvidingHint = false;
            if (!TextUtils.isEmpty((CharSequence)this.hint) && TextUtils.isEmpty((CharSequence)this.editText.getHint())) {
                this.editText.setHint(this.hint);
            }
            this.setHintInternal(null);
        } else {
            CharSequence charSequence = this.editText.getHint();
            if (!TextUtils.isEmpty((CharSequence)charSequence)) {
                if (TextUtils.isEmpty((CharSequence)this.hint)) {
                    this.setHint(charSequence);
                }
                this.editText.setHint(null);
            }
            this.isProvidingHint = true;
        }
        if (this.editText == null) return;
        this.updateInputLayoutMargins();
    }

    public void setHintTextAppearance(int n) {
        this.collapsingTextHelper.setCollapsedTextAppearance(n);
        this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
        if (this.editText == null) return;
        this.updateLabelState(false);
        this.updateInputLayoutMargins();
    }

    public void setPasswordVisibilityToggleContentDescription(int n) {
        CharSequence charSequence = n != 0 ? this.getResources().getText(n) : null;
        this.setPasswordVisibilityToggleContentDescription(charSequence);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.passwordToggleContentDesc = charSequence;
        CheckableImageButton checkableImageButton = this.passwordToggleView;
        if (checkableImageButton == null) return;
        checkableImageButton.setContentDescription(charSequence);
    }

    public void setPasswordVisibilityToggleDrawable(int n) {
        Drawable drawable = n != 0 ? AppCompatResources.getDrawable((Context)this.getContext(), (int)n) : null;
        this.setPasswordVisibilityToggleDrawable(drawable);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.passwordToggleDrawable = drawable;
        CheckableImageButton checkableImageButton = this.passwordToggleView;
        if (checkableImageButton == null) return;
        checkableImageButton.setImageDrawable(drawable);
    }

    public void setPasswordVisibilityToggleEnabled(boolean bl) {
        EditText editText;
        if (this.passwordToggleEnabled == bl) return;
        this.passwordToggleEnabled = bl;
        if (!bl && this.passwordToggledVisible && (editText = this.editText) != null) {
            editText.setTransformationMethod((TransformationMethod)PasswordTransformationMethod.getInstance());
        }
        this.passwordToggledVisible = false;
        this.updatePasswordToggleView();
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.passwordToggleTintList = colorStateList;
        this.hasPasswordToggleTintList = true;
        this.applyPasswordToggleTint();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.passwordToggleTintMode = mode;
        this.hasPasswordToggleTintMode = true;
        this.applyPasswordToggleTint();
    }

    void setTextAppearanceCompatWithErrorFallback(TextView textView, int n) {
        int n2 = 1;
        try {
            TextViewCompat.setTextAppearance((TextView)textView, (int)n);
            n = Build.VERSION.SDK_INT >= 23 && (n = textView.getTextColors().getDefaultColor()) == -65281 ? n2 : 0;
        }
        catch (Exception exception) {
            n = n2;
        }
        if (n == 0) return;
        TextViewCompat.setTextAppearance((TextView)textView, (int)R.style.TextAppearance_AppCompat_Caption);
        textView.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.design_error));
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate) {
        EditText editText = this.editText;
        if (editText == null) return;
        ViewCompat.setAccessibilityDelegate((View)editText, (AccessibilityDelegateCompat)accessibilityDelegate);
    }

    public void setTypeface(Typeface typeface) {
        if (typeface == this.typeface) return;
        this.typeface = typeface;
        this.collapsingTextHelper.setTypefaces(typeface);
        this.indicatorViewController.setTypefaces(typeface);
        TextView textView = this.counterView;
        if (textView == null) return;
        textView.setTypeface(typeface);
    }

    void updateCounter(int n) {
        boolean bl = this.counterOverflowed;
        if (this.counterMaxLength == -1) {
            this.counterView.setText((CharSequence)String.valueOf(n));
            this.counterView.setContentDescription(null);
            this.counterOverflowed = false;
        } else {
            if (ViewCompat.getAccessibilityLiveRegion((View)this.counterView) == 1) {
                ViewCompat.setAccessibilityLiveRegion((View)this.counterView, (int)0);
            }
            boolean bl2 = n > this.counterMaxLength;
            this.counterOverflowed = bl2;
            if (bl != bl2) {
                TextView textView = this.counterView;
                int n2 = bl2 ? this.counterOverflowTextAppearance : this.counterTextAppearance;
                this.setTextAppearanceCompatWithErrorFallback(textView, n2);
                if (this.counterOverflowed) {
                    ViewCompat.setAccessibilityLiveRegion((View)this.counterView, (int)1);
                }
            }
            this.counterView.setText((CharSequence)this.getContext().getString(R.string.character_counter_pattern, new Object[]{n, this.counterMaxLength}));
            this.counterView.setContentDescription((CharSequence)this.getContext().getString(R.string.character_counter_content_description, new Object[]{n, this.counterMaxLength}));
        }
        if (this.editText == null) return;
        if (bl == this.counterOverflowed) return;
        this.updateLabelState(false);
        this.updateTextInputBoxState();
        this.updateEditTextBackground();
    }

    void updateEditTextBackground() {
        EditText editText = this.editText;
        if (editText == null) {
            return;
        }
        Drawable drawable = editText.getBackground();
        if (drawable == null) {
            return;
        }
        this.ensureBackgroundDrawableStateWorkaround();
        editText = drawable;
        if (DrawableUtils.canSafelyMutateDrawable((Drawable)drawable)) {
            editText = drawable.mutate();
        }
        if (this.indicatorViewController.errorShouldBeShown()) {
            editText.setColorFilter((ColorFilter)AppCompatDrawableManager.getPorterDuffColorFilter((int)this.indicatorViewController.getErrorViewCurrentTextColor(), (PorterDuff.Mode)PorterDuff.Mode.SRC_IN));
        } else if (this.counterOverflowed && (drawable = this.counterView) != null) {
            editText.setColorFilter((ColorFilter)AppCompatDrawableManager.getPorterDuffColorFilter((int)drawable.getCurrentTextColor(), (PorterDuff.Mode)PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.clearColorFilter((Drawable)editText);
            this.editText.refreshDrawableState();
        }
    }

    void updateLabelState(boolean bl) {
        this.updateLabelState(bl, false);
    }

    void updateTextInputBoxState() {
        if (this.boxBackground == null) return;
        if (this.boxBackgroundMode == 0) return;
        EditText editText = this.editText;
        boolean bl = true;
        boolean bl2 = editText != null && editText.hasFocus();
        editText = this.editText;
        if (editText == null || !editText.isHovered()) {
            bl = false;
        }
        if (this.boxBackgroundMode != 2) return;
        this.boxStrokeColor = !this.isEnabled() ? this.disabledColor : (this.indicatorViewController.errorShouldBeShown() ? this.indicatorViewController.getErrorViewCurrentTextColor() : (this.counterOverflowed && (editText = this.counterView) != null ? editText.getCurrentTextColor() : (bl2 ? this.focusedStrokeColor : (bl ? this.hoveredStrokeColor : this.defaultStrokeColor))));
        this.boxStrokeWidthPx = (bl || bl2) && this.isEnabled() ? this.boxStrokeWidthFocusedPx : this.boxStrokeWidthDefaultPx;
        this.applyBoxAttributes();
    }
}
