/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.RippleDrawable
 *  android.os.Build$VERSION
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.text.TextUtils$TruncateAt
 *  android.util.Log
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.PointerIcon
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewOutlineProvider
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.TextView$BufferType
 *  androidx.appcompat.widget.AppCompatCheckBox
 *  androidx.core.content.res.ResourcesCompat$FontCallback
 *  androidx.core.text.BidiFormatter
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.ViewCompat
 *  androidx.customview.widget.ExploreByTouchHelper
 *  com.google.android.material.R$attr
 *  com.google.android.material.R$style
 *  com.google.android.material.animation.MotionSpec
 *  com.google.android.material.chip.Chip$ChipTouchHelper
 *  com.google.android.material.chip.ChipDrawable
 *  com.google.android.material.chip.ChipDrawable$Delegate
 *  com.google.android.material.internal.ViewUtils
 *  com.google.android.material.resources.TextAppearance
 *  com.google.android.material.ripple.RippleUtils
 */
package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Chip
extends AppCompatCheckBox
implements ChipDrawable.Delegate {
    private static final int CLOSE_ICON_VIRTUAL_ID = 0;
    private static final Rect EMPTY_BOUNDS = new Rect();
    private static final String NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    private static final int[] SELECTED_STATE = new int[]{0x10100A1};
    private static final String TAG = "Chip";
    private ChipDrawable chipDrawable;
    private boolean closeIconFocused;
    private boolean closeIconHovered;
    private boolean closeIconPressed;
    private boolean deferredCheckedValue;
    private int focusedVirtualView = Integer.MIN_VALUE;
    private final ResourcesCompat.FontCallback fontCallback;
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListenerInternal;
    private View.OnClickListener onCloseIconClickListener;
    private final Rect rect = new Rect();
    private final RectF rectF = new RectF();
    private RippleDrawable ripple;
    private final ChipTouchHelper touchHelper;

    public Chip(Context context) {
        this(context, null);
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipStyle);
    }

    public Chip(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.fontCallback = new /* Unavailable Anonymous Inner Class!! */;
        this.validateAttributes(attributeSet);
        attributeSet = ChipDrawable.createFromAttributes((Context)context, (AttributeSet)attributeSet, (int)n, (int)R.style.Widget_MaterialComponents_Chip_Action);
        this.setChipDrawable((ChipDrawable)attributeSet);
        context = new ChipTouchHelper(this, this);
        this.touchHelper = context;
        ViewCompat.setAccessibilityDelegate((View)this, (AccessibilityDelegateCompat)context);
        this.initOutlineProvider();
        this.setChecked(this.deferredCheckedValue);
        attributeSet.setShouldDrawText(false);
        this.setText(attributeSet.getText());
        this.setEllipsize(attributeSet.getEllipsize());
        this.setIncludeFontPadding(false);
        if (this.getTextAppearance() != null) {
            this.updateTextPaintDrawState(this.getTextAppearance());
        }
        this.setSingleLine();
        this.setGravity(8388627);
        this.updatePaddingInternal();
    }

    static /* synthetic */ ChipDrawable access$000(Chip chip) {
        return chip.chipDrawable;
    }

    static /* synthetic */ boolean access$100(Chip chip) {
        return chip.hasCloseIcon();
    }

    static /* synthetic */ RectF access$200(Chip chip) {
        return chip.getCloseIconTouchBounds();
    }

    static /* synthetic */ Rect access$300(Chip chip) {
        return chip.getCloseIconTouchBoundsInt();
    }

    static /* synthetic */ Rect access$400() {
        return EMPTY_BOUNDS;
    }

    private void applyChipDrawable(ChipDrawable chipDrawable) {
        chipDrawable.setDelegate((ChipDrawable.Delegate)this);
    }

    private float calculateTextOffsetFromStart(ChipDrawable chipDrawable) {
        float f = this.getChipStartPadding() + chipDrawable.calculateChipIconWidth() + this.getTextStartPadding();
        if (ViewCompat.getLayoutDirection((View)this) != 0) return -f;
        return f;
    }

    private int[] createCloseIconDrawableState() {
        boolean bl = this.isEnabled();
        int n = 0;
        int n2 = bl ? 1 : 0;
        int n3 = n2;
        if (this.closeIconFocused) {
            n3 = n2 + 1;
        }
        n2 = n3;
        if (this.closeIconHovered) {
            n2 = n3 + 1;
        }
        n3 = n2;
        if (this.closeIconPressed) {
            n3 = n2 + 1;
        }
        n2 = n3;
        if (this.isChecked()) {
            n2 = n3 + 1;
        }
        int[] nArray = new int[n2];
        n2 = n;
        if (this.isEnabled()) {
            nArray[0] = 16842910;
            n2 = 1;
        }
        n3 = n2;
        if (this.closeIconFocused) {
            nArray[n2] = 16842908;
            n3 = n2 + 1;
        }
        n2 = n3;
        if (this.closeIconHovered) {
            nArray[n3] = 16843623;
            n2 = n3 + 1;
        }
        n3 = n2;
        if (this.closeIconPressed) {
            nArray[n2] = 16842919;
            n3 = n2 + 1;
        }
        if (!this.isChecked()) return nArray;
        nArray[n3] = 0x10100A1;
        return nArray;
    }

    private void ensureFocus() {
        if (this.focusedVirtualView != Integer.MIN_VALUE) return;
        this.setFocusedVirtualView(-1);
    }

    private RectF getCloseIconTouchBounds() {
        this.rectF.setEmpty();
        if (!this.hasCloseIcon()) return this.rectF;
        this.chipDrawable.getCloseIconTouchBounds(this.rectF);
        return this.rectF;
    }

    private Rect getCloseIconTouchBoundsInt() {
        RectF rectF = this.getCloseIconTouchBounds();
        this.rect.set((int)rectF.left, (int)rectF.top, (int)rectF.right, (int)rectF.bottom);
        return this.rect;
    }

    private TextAppearance getTextAppearance() {
        Object object = this.chipDrawable;
        object = object != null ? object.getTextAppearance() : null;
        return object;
    }

    private boolean handleAccessibilityExit(MotionEvent object) {
        if (object.getAction() != 10) return false;
        try {
            object = ExploreByTouchHelper.class.getDeclaredField("mHoveredVirtualViewId");
            ((AccessibleObject)object).setAccessible(true);
            if ((Integer)((Field)object).get(this.touchHelper) == Integer.MIN_VALUE) return false;
            object = ExploreByTouchHelper.class.getDeclaredMethod("updateHoveredVirtualView", Integer.TYPE);
            ((AccessibleObject)object).setAccessible(true);
            ((Method)object).invoke(this.touchHelper, Integer.MIN_VALUE);
            return true;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            Log.e((String)TAG, (String)"Unable to send Accessibility Exit event", (Throwable)noSuchFieldException);
        }
        catch (InvocationTargetException invocationTargetException) {
            Log.e((String)TAG, (String)"Unable to send Accessibility Exit event", (Throwable)invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.e((String)TAG, (String)"Unable to send Accessibility Exit event", (Throwable)illegalAccessException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Log.e((String)TAG, (String)"Unable to send Accessibility Exit event", (Throwable)noSuchMethodException);
        }
        return false;
    }

    private boolean hasCloseIcon() {
        ChipDrawable chipDrawable = this.chipDrawable;
        boolean bl = chipDrawable != null && chipDrawable.getCloseIcon() != null;
        return bl;
    }

    private void initOutlineProvider() {
        if (Build.VERSION.SDK_INT < 21) return;
        this.setOutlineProvider((ViewOutlineProvider)new /* Unavailable Anonymous Inner Class!! */);
    }

    /*
     * Enabled force condition propagation
     */
    private boolean moveFocus(boolean bl) {
        this.ensureFocus();
        boolean bl2 = true;
        if (bl) {
            if (this.focusedVirtualView != -1) return false;
            this.setFocusedVirtualView(0);
            return bl2;
        }
        if (this.focusedVirtualView != 0) return false;
        this.setFocusedVirtualView(-1);
        return bl2;
    }

    private void setCloseIconFocused(boolean bl) {
        if (this.closeIconFocused == bl) return;
        this.closeIconFocused = bl;
        this.refreshDrawableState();
    }

    private void setCloseIconHovered(boolean bl) {
        if (this.closeIconHovered == bl) return;
        this.closeIconHovered = bl;
        this.refreshDrawableState();
    }

    private void setCloseIconPressed(boolean bl) {
        if (this.closeIconPressed == bl) return;
        this.closeIconPressed = bl;
        this.refreshDrawableState();
    }

    private void setFocusedVirtualView(int n) {
        int n2 = this.focusedVirtualView;
        if (n2 == n) return;
        if (n2 == 0) {
            this.setCloseIconFocused(false);
        }
        this.focusedVirtualView = n;
        if (n != 0) return;
        this.setCloseIconFocused(true);
    }

    private void unapplyChipDrawable(ChipDrawable chipDrawable) {
        if (chipDrawable == null) return;
        chipDrawable.setDelegate(null);
    }

    private void updatePaddingInternal() {
        float f;
        float f2;
        block6: {
            block5: {
                if (TextUtils.isEmpty((CharSequence)this.getText())) return;
                ChipDrawable chipDrawable = this.chipDrawable;
                if (chipDrawable == null) return;
                f2 = chipDrawable.getChipStartPadding() + this.chipDrawable.getChipEndPadding() + this.chipDrawable.getTextStartPadding() + this.chipDrawable.getTextEndPadding();
                if (this.chipDrawable.isChipIconVisible() && this.chipDrawable.getChipIcon() != null) break block5;
                f = f2;
                if (this.chipDrawable.getCheckedIcon() == null) break block6;
                f = f2;
                if (!this.chipDrawable.isCheckedIconVisible()) break block6;
                f = f2;
                if (!this.isChecked()) break block6;
            }
            f = f2 + (this.chipDrawable.getIconStartPadding() + this.chipDrawable.getIconEndPadding() + this.chipDrawable.getChipIconSize());
        }
        f2 = f;
        if (this.chipDrawable.isCloseIconVisible()) {
            f2 = f;
            if (this.chipDrawable.getCloseIcon() != null) {
                f2 = f + (this.chipDrawable.getCloseIconStartPadding() + this.chipDrawable.getCloseIconEndPadding() + this.chipDrawable.getCloseIconSize());
            }
        }
        if ((float)ViewCompat.getPaddingEnd((View)this) == f2) return;
        ViewCompat.setPaddingRelative((View)this, (int)ViewCompat.getPaddingStart((View)this), (int)this.getPaddingTop(), (int)((int)f2), (int)this.getPaddingBottom());
    }

    private void updateTextPaintDrawState(TextAppearance textAppearance) {
        TextPaint textPaint = this.getPaint();
        textPaint.drawableState = this.chipDrawable.getState();
        textAppearance.updateDrawState(this.getContext(), textPaint, this.fontCallback);
    }

    private void validateAttributes(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, "background") != null) throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
        if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, "drawableLeft") != null) throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, "drawableStart") != null) throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, "drawableEnd") != null) throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, "drawableRight") != null) throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        if (!attributeSet.getAttributeBooleanValue(NAMESPACE_ANDROID, "singleLine", true)) throw new UnsupportedOperationException("Chip does not support multi-line text");
        if (attributeSet.getAttributeIntValue(NAMESPACE_ANDROID, "lines", 1) != 1) throw new UnsupportedOperationException("Chip does not support multi-line text");
        if (attributeSet.getAttributeIntValue(NAMESPACE_ANDROID, "minLines", 1) != 1) throw new UnsupportedOperationException("Chip does not support multi-line text");
        if (attributeSet.getAttributeIntValue(NAMESPACE_ANDROID, "maxLines", 1) != 1) throw new UnsupportedOperationException("Chip does not support multi-line text");
        if (attributeSet.getAttributeIntValue(NAMESPACE_ANDROID, "gravity", 8388627) == 8388627) return;
        Log.w((String)TAG, (String)"Chip text must be vertically center and start aligned");
    }

    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        boolean bl = this.handleAccessibilityExit(motionEvent) || this.touchHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
        return bl;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean bl = this.touchHelper.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        return bl;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        ChipDrawable chipDrawable = this.chipDrawable;
        boolean bl = chipDrawable != null && chipDrawable.isCloseIconStateful() ? this.chipDrawable.setCloseIconState(this.createCloseIconDrawableState()) : false;
        if (!bl) return;
        this.invalidate();
    }

    public Drawable getCheckedIcon() {
        Object object = this.chipDrawable;
        object = object != null ? object.getCheckedIcon() : null;
        return object;
    }

    public ColorStateList getChipBackgroundColor() {
        Object object = this.chipDrawable;
        object = object != null ? object.getChipBackgroundColor() : null;
        return object;
    }

    public float getChipCornerRadius() {
        ChipDrawable chipDrawable = this.chipDrawable;
        float f = chipDrawable != null ? chipDrawable.getChipCornerRadius() : 0.0f;
        return f;
    }

    public Drawable getChipDrawable() {
        return this.chipDrawable;
    }

    public float getChipEndPadding() {
        ChipDrawable chipDrawable = this.chipDrawable;
        float f = chipDrawable != null ? chipDrawable.getChipEndPadding() : 0.0f;
        return f;
    }

    public Drawable getChipIcon() {
        Object object = this.chipDrawable;
        object = object != null ? object.getChipIcon() : null;
        return object;
    }

    public float getChipIconSize() {
        ChipDrawable chipDrawable = this.chipDrawable;
        float f = chipDrawable != null ? chipDrawable.getChipIconSize() : 0.0f;
        return f;
    }

    public ColorStateList getChipIconTint() {
        Object object = this.chipDrawable;
        object = object != null ? object.getChipIconTint() : null;
        return object;
    }

    public float getChipMinHeight() {
        ChipDrawable chipDrawable = this.chipDrawable;
        float f = chipDrawable != null ? chipDrawable.getChipMinHeight() : 0.0f;
        return f;
    }

    public float getChipStartPadding() {
        ChipDrawable chipDrawable = this.chipDrawable;
        float f = chipDrawable != null ? chipDrawable.getChipStartPadding() : 0.0f;
        return f;
    }

    public ColorStateList getChipStrokeColor() {
        Object object = this.chipDrawable;
        object = object != null ? object.getChipStrokeColor() : null;
        return object;
    }

    public float getChipStrokeWidth() {
        ChipDrawable chipDrawable = this.chipDrawable;
        float f = chipDrawable != null ? chipDrawable.getChipStrokeWidth() : 0.0f;
        return f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return this.getText();
    }

    public Drawable getCloseIcon() {
        Object object = this.chipDrawable;
        object = object != null ? object.getCloseIcon() : null;
        return object;
    }

    public CharSequence getCloseIconContentDescription() {
        Object object = this.chipDrawable;
        object = object != null ? object.getCloseIconContentDescription() : null;
        return object;
    }

    public float getCloseIconEndPadding() {
        ChipDrawable chipDrawable = this.chipDrawable;
        float f = chipDrawable != null ? chipDrawable.getCloseIconEndPadding() : 0.0f;
        return f;
    }

    public float getCloseIconSize() {
        ChipDrawable chipDrawable = this.chipDrawable;
        float f = chipDrawable != null ? chipDrawable.getCloseIconSize() : 0.0f;
        return f;
    }

    public float getCloseIconStartPadding() {
        ChipDrawable chipDrawable = this.chipDrawable;
        float f = chipDrawable != null ? chipDrawable.getCloseIconStartPadding() : 0.0f;
        return f;
    }

    public ColorStateList getCloseIconTint() {
        Object object = this.chipDrawable;
        object = object != null ? object.getCloseIconTint() : null;
        return object;
    }

    public TextUtils.TruncateAt getEllipsize() {
        Object object = this.chipDrawable;
        object = object != null ? object.getEllipsize() : null;
        return object;
    }

    public void getFocusedRect(Rect rect) {
        if (this.focusedVirtualView == 0) {
            rect.set(this.getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public MotionSpec getHideMotionSpec() {
        Object object = this.chipDrawable;
        object = object != null ? object.getHideMotionSpec() : null;
        return object;
    }

    public float getIconEndPadding() {
        ChipDrawable chipDrawable = this.chipDrawable;
        float f = chipDrawable != null ? chipDrawable.getIconEndPadding() : 0.0f;
        return f;
    }

    public float getIconStartPadding() {
        ChipDrawable chipDrawable = this.chipDrawable;
        float f = chipDrawable != null ? chipDrawable.getIconStartPadding() : 0.0f;
        return f;
    }

    public ColorStateList getRippleColor() {
        Object object = this.chipDrawable;
        object = object != null ? object.getRippleColor() : null;
        return object;
    }

    public MotionSpec getShowMotionSpec() {
        Object object = this.chipDrawable;
        object = object != null ? object.getShowMotionSpec() : null;
        return object;
    }

    public CharSequence getText() {
        Object object = this.chipDrawable;
        object = object != null ? object.getText() : "";
        return object;
    }

    public float getTextEndPadding() {
        ChipDrawable chipDrawable = this.chipDrawable;
        float f = chipDrawable != null ? chipDrawable.getTextEndPadding() : 0.0f;
        return f;
    }

    public float getTextStartPadding() {
        ChipDrawable chipDrawable = this.chipDrawable;
        float f = chipDrawable != null ? chipDrawable.getTextStartPadding() : 0.0f;
        return f;
    }

    public boolean isCheckable() {
        ChipDrawable chipDrawable = this.chipDrawable;
        boolean bl = chipDrawable != null && chipDrawable.isCheckable();
        return bl;
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        return this.isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        ChipDrawable chipDrawable = this.chipDrawable;
        boolean bl = chipDrawable != null && chipDrawable.isCheckedIconVisible();
        return bl;
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        return this.isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        ChipDrawable chipDrawable = this.chipDrawable;
        boolean bl = chipDrawable != null && chipDrawable.isChipIconVisible();
        return bl;
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        return this.isCloseIconVisible();
    }

    public boolean isCloseIconVisible() {
        ChipDrawable chipDrawable = this.chipDrawable;
        boolean bl = chipDrawable != null && chipDrawable.isCloseIconVisible();
        return bl;
    }

    public void onChipDrawableSizeChange() {
        this.updatePaddingInternal();
        this.requestLayout();
        if (Build.VERSION.SDK_INT < 21) return;
        this.invalidateOutline();
    }

    protected int[] onCreateDrawableState(int n) {
        int[] nArray = super.onCreateDrawableState(n + 1);
        if (!this.isChecked()) return nArray;
        Chip.mergeDrawableStates((int[])nArray, (int[])SELECTED_STATE);
        return nArray;
    }

    protected void onDraw(Canvas canvas) {
        ChipDrawable chipDrawable;
        if (!TextUtils.isEmpty((CharSequence)this.getText()) && (chipDrawable = this.chipDrawable) != null && !chipDrawable.shouldDrawText()) {
            int n = canvas.save();
            canvas.translate(this.calculateTextOffsetFromStart(this.chipDrawable), 0.0f);
            super.onDraw(canvas);
            canvas.restoreToCount(n);
            return;
        }
        super.onDraw(canvas);
    }

    protected void onFocusChanged(boolean bl, int n, Rect rect) {
        if (bl) {
            this.setFocusedVirtualView(-1);
        } else {
            this.setFocusedVirtualView(Integer.MIN_VALUE);
        }
        this.invalidate();
        super.onFocusChanged(bl, n, rect);
        this.touchHelper.onFocusChanged(bl, n, rect);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int n = motionEvent.getActionMasked();
        if (n != 7) {
            if (n != 10) return super.onHoverEvent(motionEvent);
            this.setCloseIconHovered(false);
        } else {
            this.setCloseIconHovered(this.getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        }
        return super.onHoverEvent(motionEvent);
    }

    /*
     * Unable to fully structure code
     */
    public boolean onKeyDown(int var1_1, KeyEvent var2_2) {
        block11: {
            block10: {
                var3_3 = var2_2.getKeyCode();
                var5_4 = false;
                if (var3_3 == 61) break block10;
                if (var3_3 == 66) ** GOTO lbl-1000
                switch (var3_3) {
                    default: {
                        var4_5 = var5_4;
                        break;
                    }
                    case 22: {
                        var4_5 = var5_4;
                        if (!var2_2.hasNoModifiers()) break;
                        var4_5 = this.moveFocus(ViewUtils.isLayoutRtl((View)this) ^ true);
                        break;
                    }
                    case 21: {
                        var4_5 = var5_4;
                        if (!var2_2.hasNoModifiers()) break;
                        var4_5 = this.moveFocus(ViewUtils.isLayoutRtl((View)this));
                        break;
                    }
                    case 23: lbl-1000:
                    // 2 sources

                    {
                        if ((var3_3 = this.focusedVirtualView) == -1) {
                            this.performClick();
                            return true;
                        }
                        if (var3_3 == 0) {
                            this.performCloseIconClick();
                            return true;
                        }
                        var4_5 = var5_4;
                        break;
                    }
                }
                break block11;
            }
            var3_3 = var2_2.hasNoModifiers() != false ? 2 : (var2_2.hasModifiers(1) != false ? 1 : 0);
            var4_5 = var5_4;
            if (var3_3 != 0) {
                var8_6 = this.getParent();
                var6_7 = this;
                while ((var7_8 = var6_7.focusSearch(var3_3)) != null && var7_8 != this) {
                    var6_7 = var7_8;
                    if (var7_8.getParent() == var8_6) continue;
                }
                var4_5 = var5_4;
                if (var7_8 != null) {
                    var7_8.requestFocus();
                    return true;
                }
            }
        }
        if (var4_5 == false) return super.onKeyDown(var1_1, var2_2);
        this.invalidate();
        return true;
    }

    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int n) {
        if (!this.getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY())) return null;
        if (!this.isEnabled()) return null;
        return PointerIcon.getSystemIcon((Context)this.getContext(), (int)1002);
    }

    /*
     * Unable to fully structure code
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        block9: {
            block6: {
                block7: {
                    block8: {
                        var2_2 = var1_1.getActionMasked();
                        var4_3 = this.getCloseIconTouchBounds().contains(var1_1.getX(), var1_1.getY());
                        var3_4 = false;
                        if (var2_2 == 0) break block6;
                        if (var2_2 == 1) break block7;
                        if (var2_2 == 2) break block8;
                        if (var2_2 == 3) ** GOTO lbl-1000
                        ** GOTO lbl-1000
                    }
                    if (!this.closeIconPressed) ** GOTO lbl-1000
                    if (!var4_3) {
                        this.setCloseIconPressed(false);
                    }
                    ** GOTO lbl26
                }
                if (this.closeIconPressed) {
                    this.performCloseIconClick();
                    var2_2 = 1;
                } else lbl-1000:
                // 2 sources

                {
                    var2_2 = 0;
                }
                this.setCloseIconPressed(false);
                break block9;
            }
            if (var4_3) {
                this.setCloseIconPressed(true);
lbl26:
                // 2 sources

                var2_2 = 1;
            } else lbl-1000:
            // 3 sources

            {
                var2_2 = 0;
            }
        }
        if (var2_2 == 0) {
            if (super.onTouchEvent(var1_1) == false) return var3_4;
        }
        var3_4 = true;
        return var3_4;
    }

    public boolean performCloseIconClick() {
        boolean bl;
        this.playSoundEffect(0);
        View.OnClickListener onClickListener = this.onCloseIconClickListener;
        if (onClickListener != null) {
            onClickListener.onClick((View)this);
            bl = true;
        } else {
            bl = false;
        }
        this.touchHelper.sendEventForVirtualView(0, 1);
        return bl;
    }

    public void setBackground(Drawable drawable) {
        if (drawable != this.chipDrawable) {
            if (drawable != this.ripple) throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
        }
        super.setBackground(drawable);
    }

    public void setBackgroundColor(int n) {
        throw new UnsupportedOperationException("Do not set the background color; Chip manages its own background drawable.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != this.chipDrawable) {
            if (drawable != this.ripple) throw new UnsupportedOperationException("Do not set the background drawable; Chip manages its own background drawable.");
        }
        super.setBackgroundDrawable(drawable);
    }

    public void setBackgroundResource(int n) {
        throw new UnsupportedOperationException("Do not set the background resource; Chip manages its own background drawable.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        throw new UnsupportedOperationException("Do not set the background tint list; Chip manages its own background drawable.");
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        throw new UnsupportedOperationException("Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean bl) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setCheckable(bl);
    }

    public void setCheckableResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setCheckableResource(n);
    }

    public void setChecked(boolean bl) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) {
            this.deferredCheckedValue = bl;
        } else {
            if (!chipDrawable.isCheckable()) return;
            boolean bl2 = this.isChecked();
            super.setChecked(bl);
            if (bl2 == bl) return;
            chipDrawable = this.onCheckedChangeListenerInternal;
            if (chipDrawable == null) return;
            chipDrawable.onCheckedChanged((CompoundButton)this, bl);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setCheckedIcon(drawable);
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean bl) {
        this.setCheckedIconVisible(bl);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int n) {
        this.setCheckedIconVisible(n);
    }

    public void setCheckedIconResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setCheckedIconResource(n);
    }

    public void setCheckedIconVisible(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setCheckedIconVisible(n);
    }

    public void setCheckedIconVisible(boolean bl) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setCheckedIconVisible(bl);
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipBackgroundColor(colorStateList);
    }

    public void setChipBackgroundColorResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipBackgroundColorResource(n);
    }

    public void setChipCornerRadius(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipCornerRadius(f);
    }

    public void setChipCornerRadiusResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipCornerRadiusResource(n);
    }

    public void setChipDrawable(ChipDrawable chipDrawable) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 == chipDrawable) return;
        this.unapplyChipDrawable(chipDrawable2);
        this.chipDrawable = chipDrawable;
        this.applyChipDrawable(chipDrawable);
        if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
            this.ripple = new RippleDrawable(RippleUtils.convertToRippleDrawableColor((ColorStateList)this.chipDrawable.getRippleColor()), (Drawable)this.chipDrawable, null);
            this.chipDrawable.setUseCompatRipple(false);
            ViewCompat.setBackground((View)this, (Drawable)this.ripple);
        } else {
            this.chipDrawable.setUseCompatRipple(true);
            ViewCompat.setBackground((View)this, (Drawable)this.chipDrawable);
        }
    }

    public void setChipEndPadding(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipEndPadding(f);
    }

    public void setChipEndPaddingResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipEndPaddingResource(n);
    }

    public void setChipIcon(Drawable drawable) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipIcon(drawable);
    }

    @Deprecated
    public void setChipIconEnabled(boolean bl) {
        this.setChipIconVisible(bl);
    }

    @Deprecated
    public void setChipIconEnabledResource(int n) {
        this.setChipIconVisible(n);
    }

    public void setChipIconResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipIconResource(n);
    }

    public void setChipIconSize(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipIconSize(f);
    }

    public void setChipIconSizeResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipIconSizeResource(n);
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipIconTint(colorStateList);
    }

    public void setChipIconTintResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipIconTintResource(n);
    }

    public void setChipIconVisible(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipIconVisible(n);
    }

    public void setChipIconVisible(boolean bl) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipIconVisible(bl);
    }

    public void setChipMinHeight(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipMinHeight(f);
    }

    public void setChipMinHeightResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipMinHeightResource(n);
    }

    public void setChipStartPadding(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipStartPadding(f);
    }

    public void setChipStartPaddingResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipStartPaddingResource(n);
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipStrokeColor(colorStateList);
    }

    public void setChipStrokeColorResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipStrokeColorResource(n);
    }

    public void setChipStrokeWidth(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipStrokeWidth(f);
    }

    public void setChipStrokeWidthResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setChipStrokeWidthResource(n);
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        this.setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int n) {
        this.setText(this.getResources().getString(n));
    }

    public void setCloseIcon(Drawable drawable) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setCloseIcon(drawable);
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setCloseIconContentDescription(charSequence);
    }

    @Deprecated
    public void setCloseIconEnabled(boolean bl) {
        this.setCloseIconVisible(bl);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int n) {
        this.setCloseIconVisible(n);
    }

    public void setCloseIconEndPadding(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setCloseIconEndPadding(f);
    }

    public void setCloseIconEndPaddingResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setCloseIconEndPaddingResource(n);
    }

    public void setCloseIconResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setCloseIconResource(n);
    }

    public void setCloseIconSize(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setCloseIconSize(f);
    }

    public void setCloseIconSizeResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setCloseIconSizeResource(n);
    }

    public void setCloseIconStartPadding(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setCloseIconStartPadding(f);
    }

    public void setCloseIconStartPaddingResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setCloseIconStartPaddingResource(n);
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setCloseIconTint(colorStateList);
    }

    public void setCloseIconTintResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setCloseIconTintResource(n);
    }

    public void setCloseIconVisible(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setCloseIconVisible(n);
    }

    public void setCloseIconVisible(boolean bl) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setCloseIconVisible(bl);
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        if (drawable3 != null) throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        if (drawable3 != null) throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int n, int n2, int n3, int n4) {
        if (n != 0) throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        if (n3 != 0) throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(n, n2, n3, n4);
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        if (drawable3 != null) throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int n, int n2, int n3, int n4) {
        if (n != 0) throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        if (n3 != 0) throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        super.setCompoundDrawablesWithIntrinsicBounds(n, n2, n3, n4);
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        if (drawable3 != null) throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.chipDrawable == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        super.setEllipsize(truncateAt);
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setEllipsize(truncateAt);
    }

    public void setGravity(int n) {
        if (n != 8388627) {
            Log.w((String)TAG, (String)"Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(n);
        }
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setHideMotionSpec(motionSpec);
    }

    public void setHideMotionSpecResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setHideMotionSpecResource(n);
    }

    public void setIconEndPadding(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setIconEndPadding(f);
    }

    public void setIconEndPaddingResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setIconEndPaddingResource(n);
    }

    public void setIconStartPadding(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setIconStartPadding(f);
    }

    public void setIconStartPaddingResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setIconStartPaddingResource(n);
    }

    public void setLines(int n) {
        if (n > 1) throw new UnsupportedOperationException("Chip does not support multi-line text");
        super.setLines(n);
    }

    public void setMaxLines(int n) {
        if (n > 1) throw new UnsupportedOperationException("Chip does not support multi-line text");
        super.setMaxLines(n);
    }

    public void setMaxWidth(int n) {
        super.setMaxWidth(n);
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setMaxWidth(n);
    }

    public void setMinLines(int n) {
        if (n > 1) throw new UnsupportedOperationException("Chip does not support multi-line text");
        super.setMinLines(n);
    }

    void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListenerInternal = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.onCloseIconClickListener = onClickListener;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setRippleColor(colorStateList);
    }

    public void setRippleColorResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setRippleColorResource(n);
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setShowMotionSpec(motionSpec);
    }

    public void setShowMotionSpecResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setShowMotionSpecResource(n);
    }

    public void setSingleLine(boolean bl) {
        if (!bl) throw new UnsupportedOperationException("Chip does not support multi-line text");
        super.setSingleLine(bl);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.chipDrawable == null) {
            return;
        }
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = "";
        }
        charSequence = BidiFormatter.getInstance().unicodeWrap(charSequence2);
        if (this.chipDrawable.shouldDrawText()) {
            charSequence = null;
        }
        super.setText(charSequence, bufferType);
        charSequence = this.chipDrawable;
        if (charSequence == null) return;
        charSequence.setText(charSequence2);
    }

    public void setTextAppearance(int n) {
        super.setTextAppearance(n);
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setTextAppearanceResource(n);
        }
        if (this.getTextAppearance() == null) return;
        this.getTextAppearance().updateMeasureState(this.getContext(), this.getPaint(), this.fontCallback);
        this.updateTextPaintDrawState(this.getTextAppearance());
    }

    public void setTextAppearance(Context context, int n) {
        super.setTextAppearance(context, n);
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setTextAppearanceResource(n);
        }
        if (this.getTextAppearance() == null) return;
        this.getTextAppearance().updateMeasureState(context, this.getPaint(), this.fontCallback);
        this.updateTextPaintDrawState(this.getTextAppearance());
    }

    public void setTextAppearance(TextAppearance textAppearance) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setTextAppearance(textAppearance);
        }
        if (this.getTextAppearance() == null) return;
        this.getTextAppearance().updateMeasureState(this.getContext(), this.getPaint(), this.fontCallback);
        this.updateTextPaintDrawState(textAppearance);
    }

    public void setTextAppearanceResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setTextAppearanceResource(n);
        }
        this.setTextAppearance(this.getContext(), n);
    }

    public void setTextEndPadding(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setTextEndPadding(f);
    }

    public void setTextEndPaddingResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setTextEndPaddingResource(n);
    }

    public void setTextStartPadding(float f) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setTextStartPadding(f);
    }

    public void setTextStartPaddingResource(int n) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) return;
        chipDrawable.setTextStartPaddingResource(n);
    }
}
