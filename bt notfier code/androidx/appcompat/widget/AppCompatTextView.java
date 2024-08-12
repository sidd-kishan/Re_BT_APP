/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.view.ActionMode$Callback
 *  android.view.View
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.view.textclassifier.TextClassifier
 *  android.widget.TextView
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.widget.AppCompatBackgroundHelper
 *  androidx.appcompat.widget.AppCompatHintHelper
 *  androidx.appcompat.widget.AppCompatTextClassifierHelper
 *  androidx.appcompat.widget.AppCompatTextHelper
 *  androidx.appcompat.widget.ThemeUtils
 *  androidx.appcompat.widget.TintContextWrapper
 *  androidx.core.graphics.TypefaceCompat
 *  androidx.core.text.PrecomputedTextCompat
 *  androidx.core.text.PrecomputedTextCompat$Params
 *  androidx.core.view.TintableBackgroundView
 *  androidx.core.widget.AutoSizeableTextView
 *  androidx.core.widget.TextViewCompat
 *  androidx.core.widget.TintableCompoundDrawablesView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatBackgroundHelper;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.appcompat.widget.AppCompatTextClassifierHelper;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.appcompat.widget.ThemeUtils;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView
extends TextView
implements TintableBackgroundView,
TintableCompoundDrawablesView,
AutoSizeableTextView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private boolean mIsSetTypefaceProcessing = false;
    private Future<PrecomputedTextCompat> mPrecomputedTextFuture;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int n) {
        super(TintContextWrapper.wrap((Context)context), attributeSet, n);
        ThemeUtils.checkAppCompatTheme((View)this, (Context)this.getContext());
        context = new AppCompatBackgroundHelper((View)this);
        this.mBackgroundTintHelper = context;
        context.loadFromAttributes(attributeSet, n);
        context = new AppCompatTextHelper((TextView)this);
        this.mTextHelper = context;
        context.loadFromAttributes(attributeSet, n);
        this.mTextHelper.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper((TextView)this);
    }

    /*
     * Enabled force condition propagation
     */
    private void consumeTextFutureAndSetBlocking() {
        Future<PrecomputedTextCompat> future = this.mPrecomputedTextFuture;
        if (future == null) return;
        try {
            this.mPrecomputedTextFuture = null;
            TextViewCompat.setPrecomputedText((TextView)this, (PrecomputedTextCompat)future.get());
            return;
        }
        catch (InterruptedException | ExecutionException exception) {
            return;
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.applySupportBackgroundTint();
        }
        if ((appCompatBackgroundHelper = this.mTextHelper) == null) return;
        appCompatBackgroundHelper.applyCompoundDrawablesTints();
    }

    public int getAutoSizeMaxTextSize() {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeMaxTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper == null) return -1;
        return appCompatTextHelper.getAutoSizeMaxTextSize();
    }

    public int getAutoSizeMinTextSize() {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeMinTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper == null) return -1;
        return appCompatTextHelper.getAutoSizeMinTextSize();
    }

    public int getAutoSizeStepGranularity() {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeStepGranularity();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper == null) return -1;
        return appCompatTextHelper.getAutoSizeStepGranularity();
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeTextAvailableSizes();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper == null) return new int[0];
        return appCompatTextHelper.getAutoSizeTextAvailableSizes();
    }

    public int getAutoSizeTextType() {
        boolean bl = PLATFORM_SUPPORTS_AUTOSIZE;
        int n = 0;
        if (bl) {
            if (super.getAutoSizeTextType() != 1) return n;
            n = 1;
            return n;
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper == null) return 0;
        return appCompatTextHelper.getAutoSizeTextType();
    }

    public int getFirstBaselineToTopHeight() {
        return TextViewCompat.getFirstBaselineToTopHeight((TextView)this);
    }

    public int getLastBaselineToBottomHeight() {
        return TextViewCompat.getLastBaselineToBottomHeight((TextView)this);
    }

    public ColorStateList getSupportBackgroundTintList() {
        Object object = this.mBackgroundTintHelper;
        object = object != null ? object.getSupportBackgroundTintList() : null;
        return object;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        Object object = this.mBackgroundTintHelper;
        object = object != null ? object.getSupportBackgroundTintMode() : null;
        return object;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.getCompoundDrawableTintList();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.getCompoundDrawableTintMode();
    }

    public CharSequence getText() {
        this.consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    public TextClassifier getTextClassifier() {
        if (Build.VERSION.SDK_INT >= 28) return super.getTextClassifier();
        AppCompatTextClassifierHelper appCompatTextClassifierHelper = this.mTextClassifierHelper;
        if (appCompatTextClassifierHelper != null) return appCompatTextClassifierHelper.getTextClassifier();
        return super.getTextClassifier();
    }

    public PrecomputedTextCompat.Params getTextMetricsParamsCompat() {
        return TextViewCompat.getTextMetricsParams((TextView)this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.populateSurroundingTextIfNeeded((TextView)this, inputConnection, editorInfo);
        return AppCompatHintHelper.onCreateInputConnection((InputConnection)inputConnection, (EditorInfo)editorInfo, (View)this);
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper == null) return;
        appCompatTextHelper.onLayout(bl, n, n2, n3, n4);
    }

    protected void onMeasure(int n, int n2) {
        this.consumeTextFutureAndSetBlocking();
        super.onMeasure(n, n2);
    }

    protected void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
        super.onTextChanged(charSequence, n, n2, n3);
        if (this.mTextHelper == null) return;
        if (PLATFORM_SUPPORTS_AUTOSIZE) return;
        if (!this.mTextHelper.isAutoSizeEnabled()) return;
        this.mTextHelper.autoSizeText();
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int n, int n2, int n3, int n4) throws IllegalArgumentException {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeUniformWithConfiguration(n, n2, n3, n4);
        } else {
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper == null) return;
            appCompatTextHelper.setAutoSizeTextTypeUniformWithConfiguration(n, n2, n3, n4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] nArray, int n) throws IllegalArgumentException {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(nArray, n);
        } else {
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper == null) return;
            appCompatTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(nArray, n);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int n) {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeWithDefaults(n);
        } else {
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper == null) return;
            appCompatTextHelper.setAutoSizeTextTypeWithDefaults(n);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper == null) return;
        appCompatBackgroundHelper.onSetBackgroundDrawable(drawable);
    }

    public void setBackgroundResource(int n) {
        super.setBackgroundResource(n);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper == null) return;
        appCompatBackgroundHelper.onSetBackgroundResource(n);
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        drawable = this.mTextHelper;
        if (drawable == null) return;
        drawable.onSetCompoundDrawables();
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        drawable = this.mTextHelper;
        if (drawable == null) return;
        drawable.onSetCompoundDrawables();
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int n, int n2, int n3, int n4) {
        Context context = this.getContext();
        Drawable drawable = null;
        Drawable drawable2 = n != 0 ? AppCompatResources.getDrawable((Context)context, (int)n) : null;
        Drawable drawable3 = n2 != 0 ? AppCompatResources.getDrawable((Context)context, (int)n2) : null;
        Drawable drawable4 = n3 != 0 ? AppCompatResources.getDrawable((Context)context, (int)n3) : null;
        if (n4 != 0) {
            drawable = AppCompatResources.getDrawable((Context)context, (int)n4);
        }
        this.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable);
        drawable2 = this.mTextHelper;
        if (drawable2 == null) return;
        drawable2.onSetCompoundDrawables();
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        drawable = this.mTextHelper;
        if (drawable == null) return;
        drawable.onSetCompoundDrawables();
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int n, int n2, int n3, int n4) {
        Context context = this.getContext();
        Drawable drawable = null;
        Drawable drawable2 = n != 0 ? AppCompatResources.getDrawable((Context)context, (int)n) : null;
        Drawable drawable3 = n2 != 0 ? AppCompatResources.getDrawable((Context)context, (int)n2) : null;
        Drawable drawable4 = n3 != 0 ? AppCompatResources.getDrawable((Context)context, (int)n3) : null;
        if (n4 != 0) {
            drawable = AppCompatResources.getDrawable((Context)context, (int)n4);
        }
        this.setCompoundDrawablesWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable);
        drawable2 = this.mTextHelper;
        if (drawable2 == null) return;
        drawable2.onSetCompoundDrawables();
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        drawable = this.mTextHelper;
        if (drawable == null) return;
        drawable.onSetCompoundDrawables();
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback((TextView)this, (ActionMode.Callback)callback));
    }

    public void setFirstBaselineToTopHeight(int n) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(n);
        } else {
            TextViewCompat.setFirstBaselineToTopHeight((TextView)this, (int)n);
        }
    }

    public void setLastBaselineToBottomHeight(int n) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(n);
        } else {
            TextViewCompat.setLastBaselineToBottomHeight((TextView)this, (int)n);
        }
    }

    public void setLineHeight(int n) {
        TextViewCompat.setLineHeight((TextView)this, (int)n);
    }

    public void setPrecomputedText(PrecomputedTextCompat precomputedTextCompat) {
        TextViewCompat.setPrecomputedText((TextView)this, (PrecomputedTextCompat)precomputedTextCompat);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper == null) return;
        appCompatBackgroundHelper.setSupportBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper == null) return;
        appCompatBackgroundHelper.setSupportBackgroundTintMode(mode);
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.setCompoundDrawableTintList(colorStateList);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.setCompoundDrawableTintMode(mode);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    public void setTextAppearance(Context context, int n) {
        super.setTextAppearance(context, n);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper == null) return;
        appCompatTextHelper.onSetTextAppearance(context, n);
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        AppCompatTextClassifierHelper appCompatTextClassifierHelper;
        if (Build.VERSION.SDK_INT < 28 && (appCompatTextClassifierHelper = this.mTextClassifierHelper) != null) {
            appCompatTextClassifierHelper.setTextClassifier(textClassifier);
            return;
        }
        super.setTextClassifier(textClassifier);
    }

    public void setTextFuture(Future<PrecomputedTextCompat> future) {
        this.mPrecomputedTextFuture = future;
        if (future == null) return;
        this.requestLayout();
    }

    public void setTextMetricsParamsCompat(PrecomputedTextCompat.Params params) {
        TextViewCompat.setTextMetricsParams((TextView)this, (PrecomputedTextCompat.Params)params);
    }

    public void setTextSize(int n, float f) {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setTextSize(n, f);
        } else {
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper == null) return;
            appCompatTextHelper.setTextSize(n, f);
        }
    }

    public void setTypeface(Typeface typeface, int n) {
        Typeface typeface2;
        if (this.mIsSetTypefaceProcessing) {
            return;
        }
        Typeface typeface3 = typeface2 = null;
        if (typeface != null) {
            typeface3 = typeface2;
            if (n > 0) {
                typeface3 = TypefaceCompat.create((Context)this.getContext(), (Typeface)typeface, (int)n);
            }
        }
        this.mIsSetTypefaceProcessing = true;
        if (typeface3 != null) {
            typeface = typeface3;
        }
        try {
            super.setTypeface(typeface, n);
            return;
        }
        finally {
            this.mIsSetTypefaceProcessing = false;
        }
    }
}
