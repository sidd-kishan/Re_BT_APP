/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Region$Op
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.os.Build$VERSION
 *  android.text.Layout
 *  android.text.Layout$Alignment
 *  android.text.StaticLayout
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.text.method.TransformationMethod
 *  android.util.Property
 *  android.view.ActionMode$Callback
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.widget.CompoundButton
 *  android.widget.TextView
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.R$string
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.text.AllCapsTransformationMethod
 *  androidx.appcompat.widget.AppCompatTextHelper
 *  androidx.appcompat.widget.DrawableUtils
 *  androidx.appcompat.widget.ThemeUtils
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.appcompat.widget.ViewUtils
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.core.view.ViewCompat
 *  androidx.core.widget.TextViewCompat
 */
package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.ThemeUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;

public class SwitchCompat
extends CompoundButton {
    private static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
    private static final int[] CHECKED_STATE_SET;
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int THUMB_ANIMATION_DURATION = 250;
    private static final Property<SwitchCompat, Float> THUMB_POS;
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE = 0;
    private boolean mHasThumbTint = false;
    private boolean mHasThumbTintMode = false;
    private boolean mHasTrackTint = false;
    private boolean mHasTrackTintMode = false;
    private int mMinFlingVelocity;
    private Layout mOffLayout;
    private Layout mOnLayout;
    ObjectAnimator mPositionAnimator;
    private boolean mShowText;
    private boolean mSplitTrack;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private TransformationMethod mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private ColorStateList mTextColors;
    private final AppCompatTextHelper mTextHelper;
    private CharSequence mTextOff;
    private CharSequence mTextOn;
    private final TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    float mThumbPosition;
    private int mThumbTextPadding;
    private ColorStateList mThumbTintList = null;
    private PorterDuff.Mode mThumbTintMode = null;
    private int mThumbWidth;
    private int mTouchMode;
    private int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private ColorStateList mTrackTintList = null;
    private PorterDuff.Mode mTrackTintMode = null;
    private VelocityTracker mVelocityTracker = VelocityTracker.obtain();

    static {
        THUMB_POS = new /* Unavailable Anonymous Inner Class!! */;
        CHECKED_STATE_SET = new int[]{0x10100A0};
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        int n2;
        Drawable drawable;
        this.mTempRect = new Rect();
        ThemeUtils.checkAppCompatTheme((View)this, (Context)this.getContext());
        this.mTextPaint = new TextPaint(1);
        Resources resources = this.getResources();
        this.mTextPaint.density = resources.getDisplayMetrics().density;
        resources = TintTypedArray.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.SwitchCompat, (int)n, (int)0);
        ViewCompat.saveAttributeDataForStyleable((View)this, (Context)context, (int[])R.styleable.SwitchCompat, (AttributeSet)attributeSet, (TypedArray)resources.getWrappedTypeArray(), (int)n, (int)0);
        this.mThumbDrawable = drawable = resources.getDrawable(R.styleable.SwitchCompat_android_thumb);
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback)this);
        }
        this.mTrackDrawable = drawable = resources.getDrawable(R.styleable.SwitchCompat_track);
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback)this);
        }
        this.mTextOn = resources.getText(R.styleable.SwitchCompat_android_textOn);
        this.mTextOff = resources.getText(R.styleable.SwitchCompat_android_textOff);
        this.mShowText = resources.getBoolean(R.styleable.SwitchCompat_showText, true);
        this.mThumbTextPadding = resources.getDimensionPixelSize(R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.mSwitchMinWidth = resources.getDimensionPixelSize(R.styleable.SwitchCompat_switchMinWidth, 0);
        this.mSwitchPadding = resources.getDimensionPixelSize(R.styleable.SwitchCompat_switchPadding, 0);
        this.mSplitTrack = resources.getBoolean(R.styleable.SwitchCompat_splitTrack, false);
        drawable = resources.getColorStateList(R.styleable.SwitchCompat_thumbTint);
        if (drawable != null) {
            this.mThumbTintList = drawable;
            this.mHasThumbTint = true;
        }
        if (this.mThumbTintMode != (drawable = DrawableUtils.parseTintMode((int)resources.getInt(R.styleable.SwitchCompat_thumbTintMode, -1), null))) {
            this.mThumbTintMode = drawable;
            this.mHasThumbTintMode = true;
        }
        if (this.mHasThumbTint || this.mHasThumbTintMode) {
            this.applyThumbTint();
        }
        if ((drawable = resources.getColorStateList(R.styleable.SwitchCompat_trackTint)) != null) {
            this.mTrackTintList = drawable;
            this.mHasTrackTint = true;
        }
        if (this.mTrackTintMode != (drawable = DrawableUtils.parseTintMode((int)resources.getInt(R.styleable.SwitchCompat_trackTintMode, -1), null))) {
            this.mTrackTintMode = drawable;
            this.mHasTrackTintMode = true;
        }
        if (this.mHasTrackTint || this.mHasTrackTintMode) {
            this.applyTrackTint();
        }
        if ((n2 = resources.getResourceId(R.styleable.SwitchCompat_switchTextAppearance, 0)) != 0) {
            this.setSwitchTextAppearance(context, n2);
        }
        drawable = new AppCompatTextHelper((TextView)this);
        this.mTextHelper = drawable;
        drawable.loadFromAttributes(attributeSet, n);
        resources.recycle();
        context = ViewConfiguration.get((Context)context);
        this.mTouchSlop = context.getScaledTouchSlop();
        this.mMinFlingVelocity = context.getScaledMinimumFlingVelocity();
        this.refreshDrawableState();
        this.setChecked(this.isChecked());
    }

    private void animateThumbToCheckedState(boolean bl) {
        ObjectAnimator objectAnimator;
        float f = bl ? 1.0f : 0.0f;
        this.mPositionAnimator = objectAnimator = ObjectAnimator.ofFloat((Object)((Object)this), THUMB_POS, (float[])new float[]{f});
        objectAnimator.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
            this.mPositionAnimator.setAutoCancel(true);
        }
        this.mPositionAnimator.start();
    }

    private void applyThumbTint() {
        Drawable drawable;
        if (this.mThumbDrawable == null) return;
        if (!this.mHasThumbTint) {
            if (!this.mHasThumbTintMode) return;
        }
        this.mThumbDrawable = drawable = DrawableCompat.wrap((Drawable)this.mThumbDrawable).mutate();
        if (this.mHasThumbTint) {
            DrawableCompat.setTintList((Drawable)drawable, (ColorStateList)this.mThumbTintList);
        }
        if (this.mHasThumbTintMode) {
            DrawableCompat.setTintMode((Drawable)this.mThumbDrawable, (PorterDuff.Mode)this.mThumbTintMode);
        }
        if (!this.mThumbDrawable.isStateful()) return;
        this.mThumbDrawable.setState(this.getDrawableState());
    }

    private void applyTrackTint() {
        Drawable drawable;
        if (this.mTrackDrawable == null) return;
        if (!this.mHasTrackTint) {
            if (!this.mHasTrackTintMode) return;
        }
        this.mTrackDrawable = drawable = DrawableCompat.wrap((Drawable)this.mTrackDrawable).mutate();
        if (this.mHasTrackTint) {
            DrawableCompat.setTintList((Drawable)drawable, (ColorStateList)this.mTrackTintList);
        }
        if (this.mHasTrackTintMode) {
            DrawableCompat.setTintMode((Drawable)this.mTrackDrawable, (PorterDuff.Mode)this.mTrackTintMode);
        }
        if (!this.mTrackDrawable.isStateful()) return;
        this.mTrackDrawable.setState(this.getDrawableState());
    }

    private void cancelPositionAnimator() {
        ObjectAnimator objectAnimator = this.mPositionAnimator;
        if (objectAnimator == null) return;
        objectAnimator.cancel();
    }

    private void cancelSuperTouch(MotionEvent motionEvent) {
        motionEvent = MotionEvent.obtain((MotionEvent)motionEvent);
        motionEvent.setAction(3);
        super.onTouchEvent(motionEvent);
        motionEvent.recycle();
    }

    private static float constrain(float f, float f2, float f3) {
        if (f < f2) return f2;
        f2 = f;
        if (!(f > f3)) return f2;
        f2 = f3;
        return f2;
    }

    private boolean getTargetCheckedState() {
        boolean bl = this.mThumbPosition > 0.5f;
        return bl;
    }

    private int getThumbOffset() {
        float f = ViewUtils.isLayoutRtl((View)this) ? 1.0f - this.mThumbPosition : this.mThumbPosition;
        return (int)(f * (float)this.getThumbScrollRange() + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.mTrackDrawable;
        if (drawable == null) return 0;
        Rect rect = this.mTempRect;
        drawable.getPadding(rect);
        drawable = this.mThumbDrawable;
        drawable = drawable != null ? DrawableUtils.getOpticalBounds((Drawable)drawable) : DrawableUtils.INSETS_NONE;
        return this.mSwitchWidth - this.mThumbWidth - rect.left - rect.right - drawable.left - drawable.right;
    }

    private boolean hitThumb(float f, float f2) {
        Drawable drawable = this.mThumbDrawable;
        boolean bl = false;
        if (drawable == null) {
            return false;
        }
        int n = this.getThumbOffset();
        this.mThumbDrawable.getPadding(this.mTempRect);
        int n2 = this.mSwitchTop;
        int n3 = this.mTouchSlop;
        int n4 = this.mSwitchLeft + n - n3;
        int n5 = this.mThumbWidth;
        int n6 = this.mTempRect.left;
        int n7 = this.mTempRect.right;
        n = this.mTouchSlop;
        int n8 = this.mSwitchBottom;
        boolean bl2 = bl;
        if (!(f > (float)n4)) return bl2;
        bl2 = bl;
        if (!(f < (float)(n5 + n4 + n6 + n7 + n))) return bl2;
        bl2 = bl;
        if (!(f2 > (float)(n2 - n3))) return bl2;
        bl2 = bl;
        if (!(f2 < (float)(n8 + n))) return bl2;
        bl2 = true;
        return bl2;
    }

    private Layout makeLayout(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.mSwitchTransformationMethod;
        CharSequence charSequence2 = charSequence;
        if (transformationMethod != null) {
            charSequence2 = transformationMethod.getTransformation(charSequence, (View)this);
        }
        charSequence = this.mTextPaint;
        int n = charSequence2 != null ? (int)Math.ceil(Layout.getDesiredWidth((CharSequence)charSequence2, (TextPaint)charSequence)) : 0;
        return new StaticLayout(charSequence2, (TextPaint)charSequence, n, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void setOffStateDescriptionOnRAndAbove() {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT < 30) return;
        CharSequence charSequence2 = charSequence = this.mTextOff;
        if (charSequence == null) {
            charSequence2 = this.getResources().getString(R.string.abc_capital_off);
        }
        ViewCompat.setStateDescription((View)this, (CharSequence)charSequence2);
    }

    private void setOnStateDescriptionOnRAndAbove() {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT < 30) return;
        CharSequence charSequence2 = charSequence = this.mTextOn;
        if (charSequence == null) {
            charSequence2 = this.getResources().getString(R.string.abc_capital_on);
        }
        ViewCompat.setStateDescription((View)this, (CharSequence)charSequence2);
    }

    private void setSwitchTypefaceByIndex(int n, int n2) {
        Object object = n != 1 ? (n != 2 ? (n != 3 ? null : Typeface.MONOSPACE) : Typeface.SERIF) : Typeface.SANS_SERIF;
        this.setSwitchTypeface((Typeface)object, n2);
    }

    private void stopDrag(MotionEvent motionEvent) {
        this.mTouchMode = 0;
        int n = motionEvent.getAction();
        boolean bl = true;
        n = n == 1 && this.isEnabled() ? 1 : 0;
        boolean bl2 = this.isChecked();
        if (n != 0) {
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float f = this.mVelocityTracker.getXVelocity();
            if (Math.abs(f) > (float)this.mMinFlingVelocity) {
                if (!(ViewUtils.isLayoutRtl((View)this) ? f < 0.0f : f > 0.0f)) {
                    bl = false;
                }
            } else {
                bl = this.getTargetCheckedState();
            }
        } else {
            bl = bl2;
        }
        if (bl != bl2) {
            this.playSoundEffect(0);
        }
        this.setChecked(bl);
        this.cancelSuperTouch(motionEvent);
    }

    public void draw(Canvas canvas) {
        int n;
        Drawable drawable;
        int n2;
        int n3;
        int n4;
        Rect rect;
        block4: {
            int n5;
            int n6;
            int n7;
            block7: {
                int n8;
                int n9;
                block6: {
                    block5: {
                        rect = this.mTempRect;
                        n9 = this.mSwitchLeft;
                        n4 = this.mSwitchTop;
                        n8 = this.mSwitchRight;
                        n3 = this.mSwitchBottom;
                        n2 = this.getThumbOffset() + n9;
                        drawable = this.mThumbDrawable;
                        drawable = drawable != null ? DrawableUtils.getOpticalBounds((Drawable)drawable) : DrawableUtils.INSETS_NONE;
                        Drawable drawable2 = this.mTrackDrawable;
                        n = n2;
                        if (drawable2 == null) break block4;
                        drawable2.getPadding(rect);
                        n7 = n2 + rect.left;
                        if (drawable == null) break block5;
                        n = n9;
                        if (drawable.left > rect.left) {
                            n = n9 + (drawable.left - rect.left);
                        }
                        n2 = drawable.top > rect.top ? drawable.top - rect.top + n4 : n4;
                        n6 = n8;
                        if (drawable.right > rect.right) {
                            n6 = n8 - (drawable.right - rect.right);
                        }
                        n9 = n;
                        n8 = n6;
                        n5 = n2;
                        if (drawable.bottom <= rect.bottom) break block6;
                        n5 = n3 - (drawable.bottom - rect.bottom);
                        break block7;
                    }
                    n5 = n4;
                }
                n = n3;
                n2 = n5;
                n5 = n;
                n6 = n8;
                n = n9;
            }
            this.mTrackDrawable.setBounds(n, n2, n6, n5);
            n = n7;
        }
        if ((drawable = this.mThumbDrawable) != null) {
            drawable.getPadding(rect);
            n2 = n - rect.left;
            n = n + this.mThumbWidth + rect.right;
            this.mThumbDrawable.setBounds(n2, n4, n, n3);
            drawable = this.getBackground();
            if (drawable != null) {
                DrawableCompat.setHotspotBounds((Drawable)drawable, (int)n2, (int)n4, (int)n, (int)n3);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f, float f2) {
        Drawable drawable;
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if ((drawable = this.mThumbDrawable) != null) {
            DrawableCompat.setHotspot((Drawable)drawable, (float)f, (float)f2);
        }
        if ((drawable = this.mTrackDrawable) == null) return;
        DrawableCompat.setHotspot((Drawable)drawable, (float)f, (float)f2);
    }

    protected void drawableStateChanged() {
        boolean bl;
        super.drawableStateChanged();
        int[] nArray = this.getDrawableState();
        Drawable drawable = this.mThumbDrawable;
        boolean bl2 = bl = false;
        if (drawable != null) {
            bl2 = bl;
            if (drawable.isStateful()) {
                bl2 = false | drawable.setState(nArray);
            }
        }
        drawable = this.mTrackDrawable;
        bl = bl2;
        if (drawable != null) {
            bl = bl2;
            if (drawable.isStateful()) {
                bl = bl2 | drawable.setState(nArray);
            }
        }
        if (!bl) return;
        this.invalidate();
    }

    public int getCompoundPaddingLeft() {
        int n;
        if (!ViewUtils.isLayoutRtl((View)this)) {
            return super.getCompoundPaddingLeft();
        }
        int n2 = n = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        if (TextUtils.isEmpty((CharSequence)this.getText())) return n2;
        n2 = n + this.mSwitchPadding;
        return n2;
    }

    public int getCompoundPaddingRight() {
        int n;
        if (ViewUtils.isLayoutRtl((View)this)) {
            return super.getCompoundPaddingRight();
        }
        int n2 = n = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if (TextUtils.isEmpty((CharSequence)this.getText())) return n2;
        n2 = n + this.mSwitchPadding;
        return n2;
    }

    public boolean getShowText() {
        return this.mShowText;
    }

    public boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public CharSequence getTextOff() {
        return this.mTextOff;
    }

    public CharSequence getTextOn() {
        return this.mTextOn;
    }

    public Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    public int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    public ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    public ColorStateList getTrackTintList() {
        return this.mTrackTintList;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.mTrackTintMode;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        if ((drawable = this.mTrackDrawable) != null) {
            drawable.jumpToCurrentState();
        }
        if ((drawable = this.mPositionAnimator) == null) return;
        if (!drawable.isStarted()) return;
        this.mPositionAnimator.end();
        this.mPositionAnimator = null;
    }

    protected int[] onCreateDrawableState(int n) {
        int[] nArray = super.onCreateDrawableState(n + 1);
        if (!this.isChecked()) return nArray;
        SwitchCompat.mergeDrawableStates((int[])nArray, (int[])CHECKED_STATE_SET);
        return nArray;
    }

    protected void onDraw(Canvas canvas) {
        int n;
        Object object;
        super.onDraw(canvas);
        Rect rect = this.mTempRect;
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int n2 = this.mSwitchTop;
        int n3 = this.mSwitchBottom;
        int n4 = rect.top;
        int n5 = rect.bottom;
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable != null) {
            if (this.mSplitTrack && drawable2 != null) {
                object = DrawableUtils.getOpticalBounds((Drawable)drawable2);
                drawable2.copyBounds(rect);
                rect.left += object.left;
                rect.right -= object.right;
                n = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(n);
            } else {
                drawable.draw(canvas);
            }
        }
        int n6 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        if ((rect = this.getTargetCheckedState() ? this.mOnLayout : this.mOffLayout) != null) {
            object = this.getDrawableState();
            drawable = this.mTextColors;
            if (drawable != null) {
                this.mTextPaint.setColor(drawable.getColorForState((int[])object, 0));
            }
            this.mTextPaint.drawableState = (int[])object;
            if (drawable2 != null) {
                drawable2 = drawable2.getBounds();
                n = drawable2.left + drawable2.right;
            } else {
                n = this.getWidth();
            }
            int n7 = rect.getWidth() / 2;
            n3 = (n2 + n4 + (n3 - n5)) / 2;
            n5 = rect.getHeight() / 2;
            canvas.translate((float)((n /= 2) - n7), (float)(n3 - n5));
            rect.draw(canvas);
        }
        canvas.restoreToCount(n6);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)ACCESSIBILITY_EVENT_CLASS_NAME);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)ACCESSIBILITY_EVENT_CLASS_NAME);
        if (Build.VERSION.SDK_INT >= 30) return;
        CharSequence charSequence = this.isChecked() ? this.mTextOn : this.mTextOff;
        if (TextUtils.isEmpty((CharSequence)charSequence)) return;
        CharSequence charSequence2 = accessibilityNodeInfo.getText();
        if (TextUtils.isEmpty((CharSequence)charSequence2)) {
            accessibilityNodeInfo.setText(charSequence);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(charSequence2);
            stringBuilder.append(' ');
            stringBuilder.append(charSequence);
            accessibilityNodeInfo.setText((CharSequence)stringBuilder);
        }
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        block9: {
            block8: {
                block6: {
                    block7: {
                        super.onLayout(bl, n, n2, n3, n4);
                        Drawable drawable = this.mThumbDrawable;
                        n = 0;
                        if (drawable != null) {
                            drawable = this.mTempRect;
                            Drawable drawable2 = this.mTrackDrawable;
                            if (drawable2 != null) {
                                drawable2.getPadding((Rect)drawable);
                            } else {
                                drawable.setEmpty();
                            }
                            drawable2 = DrawableUtils.getOpticalBounds((Drawable)this.mThumbDrawable);
                            n2 = Math.max(0, drawable2.left - drawable.left);
                            n = Math.max(0, drawable2.right - drawable.right);
                        } else {
                            n2 = 0;
                        }
                        if (ViewUtils.isLayoutRtl((View)this)) {
                            n3 = this.getPaddingLeft() + n2;
                            n2 = this.mSwitchWidth + n3 - n2 - n;
                        } else {
                            n3 = this.getWidth() - this.getPaddingRight() - n;
                            n = n3 - this.mSwitchWidth + n2 + n;
                            n2 = n3;
                            n3 = n;
                        }
                        n = this.getGravity() & 0x70;
                        if (n == 16) break block6;
                        if (n == 80) break block7;
                        n = this.getPaddingTop();
                        n4 = this.mSwitchHeight;
                        break block8;
                    }
                    n4 = this.getHeight() - this.getPaddingBottom();
                    n = n4 - this.mSwitchHeight;
                    break block9;
                }
                n = (this.getPaddingTop() + this.getHeight() - this.getPaddingBottom()) / 2;
                n4 = this.mSwitchHeight;
                n -= n4 / 2;
            }
            n4 += n;
        }
        this.mSwitchLeft = n3;
        this.mSwitchTop = n;
        this.mSwitchBottom = n4;
        this.mSwitchRight = n2;
    }

    public void onMeasure(int n, int n2) {
        int n3;
        int n4;
        if (this.mShowText) {
            if (this.mOnLayout == null) {
                this.mOnLayout = this.makeLayout(this.mTextOn);
            }
            if (this.mOffLayout == null) {
                this.mOffLayout = this.makeLayout(this.mTextOff);
            }
        }
        Rect rect = this.mTempRect;
        Drawable drawable = this.mThumbDrawable;
        int n5 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            n4 = this.mThumbDrawable.getIntrinsicWidth() - rect.left - rect.right;
            n3 = this.mThumbDrawable.getIntrinsicHeight();
        } else {
            n4 = 0;
            n3 = 0;
        }
        int n6 = this.mShowText ? Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()) + this.mThumbTextPadding * 2 : 0;
        this.mThumbWidth = Math.max(n6, n4);
        drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.getPadding(rect);
            n4 = this.mTrackDrawable.getIntrinsicHeight();
        } else {
            rect.setEmpty();
            n4 = n5;
        }
        int n7 = rect.left;
        int n8 = rect.right;
        rect = this.mThumbDrawable;
        n5 = n8;
        n6 = n7;
        if (rect != null) {
            rect = DrawableUtils.getOpticalBounds((Drawable)rect);
            n6 = Math.max(n7, rect.left);
            n5 = Math.max(n8, rect.right);
        }
        n6 = Math.max(this.mSwitchMinWidth, this.mThumbWidth * 2 + n6 + n5);
        n3 = Math.max(n4, n3);
        this.mSwitchWidth = n6;
        this.mSwitchHeight = n3;
        super.onMeasure(n, n2);
        if (this.getMeasuredHeight() >= n3) return;
        this.setMeasuredDimension(this.getMeasuredWidthAndState(), n3);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = this.isChecked() ? this.mTextOn : this.mTextOff;
        if (charSequence == null) return;
        accessibilityEvent.getText().add(charSequence);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        block7: {
            block4: {
                block5: {
                    int n;
                    block6: {
                        this.mVelocityTracker.addMovement(motionEvent);
                        n = motionEvent.getActionMasked();
                        if (n == 0) break block4;
                        if (n == 1) break block5;
                        if (n == 2) break block6;
                        if (n == 3) break block5;
                        break block7;
                    }
                    n = this.mTouchMode;
                    if (n != 1) {
                        if (n != 2) return super.onTouchEvent(motionEvent);
                        float f = motionEvent.getX();
                        n = this.getThumbScrollRange();
                        float f2 = f - this.mTouchX;
                        f2 = n != 0 ? (f2 /= (float)n) : (f2 > 0.0f ? 1.0f : -1.0f);
                        float f3 = f2;
                        if (ViewUtils.isLayoutRtl((View)this)) {
                            f3 = -f2;
                        }
                        if ((f2 = SwitchCompat.constrain(this.mThumbPosition + f3, 0.0f, 1.0f)) == this.mThumbPosition) return true;
                        this.mTouchX = f;
                        this.setThumbPosition(f2);
                        return true;
                    }
                    float f = motionEvent.getX();
                    float f4 = motionEvent.getY();
                    if (!(Math.abs(f - this.mTouchX) > (float)this.mTouchSlop)) {
                        if (!(Math.abs(f4 - this.mTouchY) > (float)this.mTouchSlop)) return super.onTouchEvent(motionEvent);
                    }
                    this.mTouchMode = 2;
                    this.getParent().requestDisallowInterceptTouchEvent(true);
                    this.mTouchX = f;
                    this.mTouchY = f4;
                    return true;
                }
                if (this.mTouchMode == 2) {
                    this.stopDrag(motionEvent);
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                this.mTouchMode = 0;
                this.mVelocityTracker.clear();
                break block7;
            }
            float f = motionEvent.getX();
            float f5 = motionEvent.getY();
            if (!this.isEnabled()) return super.onTouchEvent(motionEvent);
            if (!this.hitThumb(f, f5)) return super.onTouchEvent(motionEvent);
            this.mTouchMode = 1;
            this.mTouchX = f;
            this.mTouchY = f5;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setChecked(boolean bl) {
        super.setChecked(bl);
        bl = this.isChecked();
        if (bl) {
            this.setOnStateDescriptionOnRAndAbove();
        } else {
            this.setOffStateDescriptionOnRAndAbove();
        }
        if (this.getWindowToken() != null && ViewCompat.isLaidOut((View)this)) {
            this.animateThumbToCheckedState(bl);
        } else {
            this.cancelPositionAnimator();
            float f = bl ? 1.0f : 0.0f;
            this.setThumbPosition(f);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback((TextView)this, (ActionMode.Callback)callback));
    }

    public void setShowText(boolean bl) {
        if (this.mShowText == bl) return;
        this.mShowText = bl;
        this.requestLayout();
    }

    public void setSplitTrack(boolean bl) {
        this.mSplitTrack = bl;
        this.invalidate();
    }

    public void setSwitchMinWidth(int n) {
        this.mSwitchMinWidth = n;
        this.requestLayout();
    }

    public void setSwitchPadding(int n) {
        this.mSwitchPadding = n;
        this.requestLayout();
    }

    public void setSwitchTextAppearance(Context context, int n) {
        float f;
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes((Context)context, (int)n, (int[])R.styleable.TextAppearance);
        this.mTextColors = (context = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor)) != null ? context : this.getTextColors();
        n = tintTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
        if (n != 0 && (f = (float)n) != this.mTextPaint.getTextSize()) {
            this.mTextPaint.setTextSize(f);
            this.requestLayout();
        }
        this.setSwitchTypefaceByIndex(tintTypedArray.getInt(R.styleable.TextAppearance_android_typeface, -1), tintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, -1));
        this.mSwitchTransformationMethod = tintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false) ? new AllCapsTransformationMethod(this.getContext()) : null;
        tintTypedArray.recycle();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if (this.mTextPaint.getTypeface() == null || this.mTextPaint.getTypeface().equals((Object)typeface)) {
            if (this.mTextPaint.getTypeface() != null) return;
            if (typeface == null) return;
        }
        this.mTextPaint.setTypeface(typeface);
        this.requestLayout();
        this.invalidate();
    }

    public void setSwitchTypeface(Typeface typeface, int n) {
        float f = 0.0f;
        boolean bl = false;
        if (n > 0) {
            typeface = typeface == null ? Typeface.defaultFromStyle((int)n) : Typeface.create((Typeface)typeface, (int)n);
            this.setSwitchTypeface(typeface);
            int n2 = typeface != null ? typeface.getStyle() : 0;
            n = ~n2 & n;
            typeface = this.mTextPaint;
            if ((n & 1) != 0) {
                bl = true;
            }
            typeface.setFakeBoldText(bl);
            typeface = this.mTextPaint;
            if ((n & 2) != 0) {
                f = -0.25f;
            }
            typeface.setTextSkewX(f);
        } else {
            this.mTextPaint.setFakeBoldText(false);
            this.mTextPaint.setTextSkewX(0.0f);
            this.setSwitchTypeface(typeface);
        }
    }

    public void setTextOff(CharSequence charSequence) {
        this.mTextOff = charSequence;
        this.requestLayout();
        if (this.isChecked()) return;
        this.setOffStateDescriptionOnRAndAbove();
    }

    public void setTextOn(CharSequence charSequence) {
        this.mTextOn = charSequence;
        this.requestLayout();
        if (!this.isChecked()) return;
        this.setOnStateDescriptionOnRAndAbove();
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mThumbDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback)this);
        }
        this.requestLayout();
    }

    void setThumbPosition(float f) {
        this.mThumbPosition = f;
        this.invalidate();
    }

    public void setThumbResource(int n) {
        this.setThumbDrawable(AppCompatResources.getDrawable((Context)this.getContext(), (int)n));
    }

    public void setThumbTextPadding(int n) {
        this.mThumbTextPadding = n;
        this.requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.mThumbTintList = colorStateList;
        this.mHasThumbTint = true;
        this.applyThumbTint();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.mThumbTintMode = mode;
        this.mHasThumbTintMode = true;
        this.applyThumbTint();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mTrackDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback)this);
        }
        this.requestLayout();
    }

    public void setTrackResource(int n) {
        this.setTrackDrawable(AppCompatResources.getDrawable((Context)this.getContext(), (int)n));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.mTrackTintList = colorStateList;
        this.mHasTrackTint = true;
        this.applyTrackTint();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.mTrackTintMode = mode;
        this.mHasTrackTintMode = true;
        this.applyTrackTint();
    }

    public void toggle() {
        this.setChecked(this.isChecked() ^ true);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        boolean bl = super.verifyDrawable(drawable) || drawable == this.mThumbDrawable || drawable == this.mTrackDrawable;
        return bl;
    }
}
