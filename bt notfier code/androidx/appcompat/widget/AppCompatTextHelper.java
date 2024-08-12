/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.TypedArray
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 *  android.text.method.PasswordTransformationMethod
 *  android.view.View
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.widget.TextView
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.widget.AppCompatDrawableManager
 *  androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper
 *  androidx.appcompat.widget.DrawableUtils
 *  androidx.appcompat.widget.TintInfo
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.core.content.res.ResourcesCompat$FontCallback
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.inputmethod.EditorInfoCompat
 *  androidx.core.widget.AutoSizeableTextView
 *  androidx.core.widget.TextViewCompat
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintInfo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

class AppCompatTextHelper {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
    private boolean mAsyncFontPending;
    private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableEndTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableStartTint;
    private TintInfo mDrawableTint;
    private TintInfo mDrawableTopTint;
    private Typeface mFontTypeface;
    private int mFontWeight = -1;
    private int mStyle = 0;
    private final TextView mView;

    AppCompatTextHelper(TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(this.mView);
    }

    private void applyCompoundDrawableTint(Drawable drawable, TintInfo tintInfo) {
        if (drawable == null) return;
        if (tintInfo == null) return;
        AppCompatDrawableManager.tintDrawable((Drawable)drawable, (TintInfo)tintInfo, (int[])this.mView.getDrawableState());
    }

    private static TintInfo createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int n) {
        if ((appCompatDrawableManager = appCompatDrawableManager.getTintList(context, n)) == null) return null;
        context = new TintInfo();
        context.mHasTintList = true;
        context.mTintList = appCompatDrawableManager;
        return context;
    }

    private void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable textView, Drawable drawable3, Drawable textView2, Drawable textView3) {
        if (Build.VERSION.SDK_INT >= 17 && (textView2 != null || textView3 != null)) {
            textView = this.mView.getCompoundDrawablesRelative();
            drawable = this.mView;
            if (textView2 == null) {
                textView2 = textView[0];
            }
            if (drawable2 == null) {
                drawable2 = textView[1];
            }
            if (textView3 == null) {
                textView3 = textView[2];
            }
            if (drawable3 == null) {
                drawable3 = textView[3];
            }
            drawable.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable)textView2, drawable2, (Drawable)textView3, drawable3);
        } else {
            if (drawable == null && drawable2 == null && textView == null) {
                if (drawable3 == null) return;
            }
            if (Build.VERSION.SDK_INT >= 17 && ((textView2 = this.mView.getCompoundDrawablesRelative())[0] != null || textView2[2] != null)) {
                textView = this.mView;
                drawable = textView2[0];
                if (drawable2 == null) {
                    drawable2 = textView2[1];
                }
                textView3 = textView2[2];
                if (drawable3 == null) {
                    drawable3 = textView2[3];
                }
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, (Drawable)textView3, drawable3);
                return;
            }
            textView3 = this.mView.getCompoundDrawables();
            textView2 = this.mView;
            if (drawable == null) {
                drawable = textView3[0];
            }
            if (drawable2 == null) {
                drawable2 = textView3[1];
            }
            if (textView == null) {
                textView = textView3[2];
            }
            if (drawable3 == null) {
                drawable3 = textView3[3];
            }
            textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, (Drawable)textView, drawable3);
        }
    }

    private void setCompoundTints() {
        TintInfo tintInfo;
        this.mDrawableLeftTint = tintInfo = this.mDrawableTint;
        this.mDrawableTopTint = tintInfo;
        this.mDrawableRightTint = tintInfo;
        this.mDrawableBottomTint = tintInfo;
        this.mDrawableStartTint = tintInfo;
        this.mDrawableEndTint = tintInfo;
    }

    private void setTextSizeInternal(int n, float f) {
        this.mAutoSizeTextHelper.setTextSizeInternal(n, f);
    }

    private void updateTypefaceAndStyle(Context object, TintTypedArray tintTypedArray) {
        boolean bl;
        this.mStyle = tintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, this.mStyle);
        int n = Build.VERSION.SDK_INT;
        boolean bl2 = false;
        if (n >= 28) {
            this.mFontWeight = n = tintTypedArray.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
            if (n != -1) {
                this.mStyle = this.mStyle & 2 | 0;
            }
        }
        if (!tintTypedArray.hasValue(R.styleable.TextAppearance_android_fontFamily) && !tintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
            if (!tintTypedArray.hasValue(R.styleable.TextAppearance_android_typeface)) return;
            this.mAsyncFontPending = false;
            n = tintTypedArray.getInt(R.styleable.TextAppearance_android_typeface, 1);
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) return;
                    this.mFontTypeface = Typeface.MONOSPACE;
                } else {
                    this.mFontTypeface = Typeface.SERIF;
                }
            } else {
                this.mFontTypeface = Typeface.SANS_SERIF;
            }
            return;
        }
        this.mFontTypeface = null;
        n = tintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily) ? R.styleable.TextAppearance_fontFamily : R.styleable.TextAppearance_android_fontFamily;
        int n2 = this.mFontWeight;
        int n3 = this.mStyle;
        if (!object.isRestricted()) {
            object = new /* Unavailable Anonymous Inner Class!! */;
            try {
                object = tintTypedArray.getFont(n, this.mStyle, (ResourcesCompat.FontCallback)object);
                if (object != null) {
                    if (Build.VERSION.SDK_INT >= 28 && this.mFontWeight != -1) {
                        object = Typeface.create((Typeface)object, (int)0);
                        n3 = this.mFontWeight;
                        bl = (this.mStyle & 2) != 0;
                        this.mFontTypeface = Typeface.create((Typeface)object, (int)n3, (boolean)bl);
                    } else {
                        this.mFontTypeface = object;
                    }
                }
                bl = this.mFontTypeface == null;
                this.mAsyncFontPending = bl;
            }
            catch (Resources.NotFoundException | UnsupportedOperationException throwable) {
                // empty catch block
            }
        }
        if (this.mFontTypeface != null) return;
        object = tintTypedArray.getString(n);
        if (object == null) return;
        if (Build.VERSION.SDK_INT >= 28 && this.mFontWeight != -1) {
            object = Typeface.create((String)object, (int)0);
            n = this.mFontWeight;
            bl = bl2;
            if ((this.mStyle & 2) != 0) {
                bl = true;
            }
            this.mFontTypeface = Typeface.create((Typeface)object, (int)n, (boolean)bl);
        } else {
            this.mFontTypeface = Typeface.create((String)object, (int)this.mStyle);
        }
    }

    void applyCompoundDrawablesTints() {
        Drawable[] drawableArray;
        if (this.mDrawableLeftTint != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
            drawableArray = this.mView.getCompoundDrawables();
            this.applyCompoundDrawableTint(drawableArray[0], this.mDrawableLeftTint);
            this.applyCompoundDrawableTint(drawableArray[1], this.mDrawableTopTint);
            this.applyCompoundDrawableTint(drawableArray[2], this.mDrawableRightTint);
            this.applyCompoundDrawableTint(drawableArray[3], this.mDrawableBottomTint);
        }
        if (Build.VERSION.SDK_INT < 17) return;
        if (this.mDrawableStartTint == null) {
            if (this.mDrawableEndTint == null) return;
        }
        drawableArray = this.mView.getCompoundDrawablesRelative();
        this.applyCompoundDrawableTint(drawableArray[0], this.mDrawableStartTint);
        this.applyCompoundDrawableTint(drawableArray[2], this.mDrawableEndTint);
    }

    void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }

    int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    ColorStateList getCompoundDrawableTintList() {
        Object object = this.mDrawableTint;
        object = object != null ? object.mTintList : null;
        return object;
    }

    PorterDuff.Mode getCompoundDrawableTintMode() {
        Object object = this.mDrawableTint;
        object = object != null ? object.mTintMode : null;
        return object;
    }

    boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    void loadFromAttributes(AttributeSet attributeSet, int n) {
        String string;
        String string2;
        ColorStateList colorStateList;
        boolean bl;
        Object object;
        Context context = this.mView.getContext();
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        Object object2 = TintTypedArray.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.AppCompatTextHelper, (int)n, (int)0);
        Object object3 = this.mView;
        ViewCompat.saveAttributeDataForStyleable((View)object3, (Context)object3.getContext(), (int[])R.styleable.AppCompatTextHelper, (AttributeSet)attributeSet, (TypedArray)object2.getWrappedTypeArray(), (int)n, (int)0);
        int n2 = object2.getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (object2.hasValue(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.mDrawableLeftTint = AppCompatTextHelper.createTintInfo(context, appCompatDrawableManager, object2.getResourceId(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (object2.hasValue(R.styleable.AppCompatTextHelper_android_drawableTop)) {
            this.mDrawableTopTint = AppCompatTextHelper.createTintInfo(context, appCompatDrawableManager, object2.getResourceId(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (object2.hasValue(R.styleable.AppCompatTextHelper_android_drawableRight)) {
            this.mDrawableRightTint = AppCompatTextHelper.createTintInfo(context, appCompatDrawableManager, object2.getResourceId(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (object2.hasValue(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.mDrawableBottomTint = AppCompatTextHelper.createTintInfo(context, appCompatDrawableManager, object2.getResourceId(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (object2.hasValue(R.styleable.AppCompatTextHelper_android_drawableStart)) {
                this.mDrawableStartTint = AppCompatTextHelper.createTintInfo(context, appCompatDrawableManager, object2.getResourceId(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (object2.hasValue(R.styleable.AppCompatTextHelper_android_drawableEnd)) {
                this.mDrawableEndTint = AppCompatTextHelper.createTintInfo(context, appCompatDrawableManager, object2.getResourceId(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        object2.recycle();
        boolean bl2 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (n2 != -1) {
            object = TintTypedArray.obtainStyledAttributes((Context)context, (int)n2, (int[])R.styleable.TextAppearance);
            if (!bl2 && object.hasValue(R.styleable.TextAppearance_textAllCaps)) {
                bl = object.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
                n2 = 1;
            } else {
                bl = false;
                n2 = 0;
            }
            this.updateTypefaceAndStyle(context, (TintTypedArray)object);
            if (Build.VERSION.SDK_INT < 23) {
                colorStateList = object.hasValue(R.styleable.TextAppearance_android_textColor) ? object.getColorStateList(R.styleable.TextAppearance_android_textColor) : null;
                object3 = object.hasValue(R.styleable.TextAppearance_android_textColorHint) ? object.getColorStateList(R.styleable.TextAppearance_android_textColorHint) : null;
                object2 = object.hasValue(R.styleable.TextAppearance_android_textColorLink) ? object.getColorStateList(R.styleable.TextAppearance_android_textColorLink) : null;
            } else {
                object3 = null;
                object2 = null;
                colorStateList = null;
            }
            string2 = object.hasValue(R.styleable.TextAppearance_textLocale) ? object.getString(R.styleable.TextAppearance_textLocale) : null;
            string = Build.VERSION.SDK_INT >= 26 && object.hasValue(R.styleable.TextAppearance_fontVariationSettings) ? object.getString(R.styleable.TextAppearance_fontVariationSettings) : null;
            object.recycle();
            object = object2;
            object2 = colorStateList;
        } else {
            object3 = null;
            string = null;
            bl = false;
            n2 = 0;
            object = null;
            string2 = null;
            object2 = null;
        }
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.TextAppearance, (int)n, (int)0);
        if (!bl2 && tintTypedArray.hasValue(R.styleable.TextAppearance_textAllCaps)) {
            bl = tintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
            n2 = 1;
        }
        TextView textView = object3;
        TintTypedArray tintTypedArray2 = object;
        colorStateList = object2;
        if (Build.VERSION.SDK_INT < 23) {
            if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor)) {
                object2 = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
            }
            if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_textColorHint)) {
                object3 = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColorHint);
            }
            textView = object3;
            tintTypedArray2 = object;
            colorStateList = object2;
            if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_textColorLink)) {
                tintTypedArray2 = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColorLink);
                colorStateList = object2;
                textView = object3;
            }
        }
        if (tintTypedArray.hasValue(R.styleable.TextAppearance_textLocale)) {
            string2 = tintTypedArray.getString(R.styleable.TextAppearance_textLocale);
        }
        object3 = string;
        if (Build.VERSION.SDK_INT >= 26) {
            object3 = string;
            if (tintTypedArray.hasValue(R.styleable.TextAppearance_fontVariationSettings)) {
                object3 = tintTypedArray.getString(R.styleable.TextAppearance_fontVariationSettings);
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && tintTypedArray.hasValue(R.styleable.TextAppearance_android_textSize) && tintTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.mView.setTextSize(0, 0.0f);
        }
        this.updateTypefaceAndStyle(context, tintTypedArray);
        tintTypedArray.recycle();
        if (colorStateList != null) {
            this.mView.setTextColor(colorStateList);
        }
        if (textView != null) {
            this.mView.setHintTextColor((ColorStateList)textView);
        }
        if (tintTypedArray2 != null) {
            this.mView.setLinkTextColor((ColorStateList)tintTypedArray2);
        }
        if (!bl2 && n2 != 0) {
            this.setAllCaps(bl);
        }
        if ((object2 = this.mFontTypeface) != null) {
            if (this.mFontWeight == -1) {
                this.mView.setTypeface((Typeface)object2, this.mStyle);
            } else {
                this.mView.setTypeface((Typeface)object2);
            }
        }
        if (object3 != null) {
            this.mView.setFontVariationSettings((String)object3);
        }
        if (string2 != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.mView.setTextLocales(LocaleList.forLanguageTags((String)string2));
            } else if (Build.VERSION.SDK_INT >= 21) {
                object3 = string2.substring(0, string2.indexOf(44));
                this.mView.setTextLocale(Locale.forLanguageTag((String)object3));
            }
        }
        this.mAutoSizeTextHelper.loadFromAttributes(attributeSet, n);
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && this.mAutoSizeTextHelper.getAutoSizeTextType() != 0 && ((TextView)(object3 = (Object)this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes())).length > 0) {
            if ((float)this.mView.getAutoSizeStepGranularity() != -1.0f) {
                this.mView.setAutoSizeTextTypeUniformWithConfiguration(this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
            } else {
                this.mView.setAutoSizeTextTypeUniformWithPresetSizes((int[])object3, 0);
            }
        }
        attributeSet = (n = (colorStateList = TintTypedArray.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.AppCompatTextView)).getResourceId(R.styleable.AppCompatTextView_drawableLeftCompat, -1)) != -1 ? appCompatDrawableManager.getDrawable(context, n) : null;
        n = colorStateList.getResourceId(R.styleable.AppCompatTextView_drawableTopCompat, -1);
        object3 = n != -1 ? appCompatDrawableManager.getDrawable(context, n) : null;
        n = colorStateList.getResourceId(R.styleable.AppCompatTextView_drawableRightCompat, -1);
        object2 = n != -1 ? appCompatDrawableManager.getDrawable(context, n) : null;
        n = colorStateList.getResourceId(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
        string = n != -1 ? appCompatDrawableManager.getDrawable(context, n) : null;
        n = colorStateList.getResourceId(R.styleable.AppCompatTextView_drawableStartCompat, -1);
        string2 = n != -1 ? appCompatDrawableManager.getDrawable(context, n) : null;
        n = colorStateList.getResourceId(R.styleable.AppCompatTextView_drawableEndCompat, -1);
        object = n != -1 ? appCompatDrawableManager.getDrawable(context, n) : null;
        this.setCompoundDrawables((Drawable)attributeSet, (Drawable)object3, (Drawable)object2, (Drawable)string, (Drawable)string2, (Drawable)object);
        if (colorStateList.hasValue(R.styleable.AppCompatTextView_drawableTint)) {
            attributeSet = colorStateList.getColorStateList(R.styleable.AppCompatTextView_drawableTint);
            TextViewCompat.setCompoundDrawableTintList((TextView)this.mView, (ColorStateList)attributeSet);
        }
        if (colorStateList.hasValue(R.styleable.AppCompatTextView_drawableTintMode)) {
            attributeSet = DrawableUtils.parseTintMode((int)colorStateList.getInt(R.styleable.AppCompatTextView_drawableTintMode, -1), null);
            TextViewCompat.setCompoundDrawableTintMode((TextView)this.mView, (PorterDuff.Mode)attributeSet);
        }
        int n3 = colorStateList.getDimensionPixelSize(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        n2 = colorStateList.getDimensionPixelSize(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        n = colorStateList.getDimensionPixelSize(R.styleable.AppCompatTextView_lineHeight, -1);
        colorStateList.recycle();
        if (n3 != -1) {
            TextViewCompat.setFirstBaselineToTopHeight((TextView)this.mView, (int)n3);
        }
        if (n2 != -1) {
            TextViewCompat.setLastBaselineToBottomHeight((TextView)this.mView, (int)n2);
        }
        if (n == -1) return;
        TextViewCompat.setLineHeight((TextView)this.mView, (int)n);
    }

    void onAsyncTypefaceReceived(WeakReference<TextView> textView, Typeface typeface) {
        if (!this.mAsyncFontPending) return;
        this.mFontTypeface = typeface;
        if ((textView = (TextView)textView.get()) == null) return;
        if (ViewCompat.isAttachedToWindow((View)textView)) {
            textView.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            textView.setTypeface(typeface, this.mStyle);
        }
    }

    void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) return;
        this.autoSizeText();
    }

    void onSetCompoundDrawables() {
        this.applyCompoundDrawablesTints();
    }

    void onSetTextAppearance(Context object, int n) {
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes((Context)object, (int)n, (int[])R.styleable.TextAppearance);
        if (tintTypedArray.hasValue(R.styleable.TextAppearance_textAllCaps)) {
            this.setAllCaps(tintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23) {
            ColorStateList colorStateList;
            if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor) && (colorStateList = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor)) != null) {
                this.mView.setTextColor(colorStateList);
            }
            if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_textColorLink) && (colorStateList = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColorLink)) != null) {
                this.mView.setLinkTextColor(colorStateList);
            }
            if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_textColorHint) && (colorStateList = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColorHint)) != null) {
                this.mView.setHintTextColor(colorStateList);
            }
        }
        if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_textSize) && tintTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.mView.setTextSize(0, 0.0f);
        }
        this.updateTypefaceAndStyle((Context)object, tintTypedArray);
        if (Build.VERSION.SDK_INT >= 26 && tintTypedArray.hasValue(R.styleable.TextAppearance_fontVariationSettings) && (object = tintTypedArray.getString(R.styleable.TextAppearance_fontVariationSettings)) != null) {
            this.mView.setFontVariationSettings((String)object);
        }
        tintTypedArray.recycle();
        object = this.mFontTypeface;
        if (object == null) return;
        this.mView.setTypeface((Typeface)object, this.mStyle);
    }

    void populateSurroundingTextIfNeeded(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30) return;
        if (inputConnection == null) return;
        EditorInfoCompat.setInitialSurroundingText((EditorInfo)editorInfo, (CharSequence)textView.getText());
    }

    void setAllCaps(boolean bl) {
        this.mView.setAllCaps(bl);
    }

    void setAutoSizeTextTypeUniformWithConfiguration(int n, int n2, int n3, int n4) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(n, n2, n3, n4);
    }

    void setAutoSizeTextTypeUniformWithPresetSizes(int[] nArray, int n) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(nArray, n);
    }

    void setAutoSizeTextTypeWithDefaults(int n) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(n);
    }

    void setCompoundDrawableTintList(ColorStateList colorStateList) {
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        this.mDrawableTint.mTintList = colorStateList;
        TintInfo tintInfo = this.mDrawableTint;
        boolean bl = colorStateList != null;
        tintInfo.mHasTintList = bl;
        this.setCompoundTints();
    }

    void setCompoundDrawableTintMode(PorterDuff.Mode mode) {
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        this.mDrawableTint.mTintMode = mode;
        TintInfo tintInfo = this.mDrawableTint;
        boolean bl = mode != null;
        tintInfo.mHasTintMode = bl;
        this.setCompoundTints();
    }

    void setTextSize(int n, float f) {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) return;
        if (this.isAutoSizeEnabled()) return;
        this.setTextSizeInternal(n, f);
    }
}
