/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.TextView
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.widget.AppCompatBackgroundHelper
 *  androidx.appcompat.widget.AppCompatCompoundButtonHelper
 *  androidx.appcompat.widget.AppCompatTextHelper
 *  androidx.appcompat.widget.ThemeUtils
 *  androidx.appcompat.widget.TintContextWrapper
 *  androidx.core.view.TintableBackgroundView
 *  androidx.core.widget.TintableCompoundButton
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatBackgroundHelper;
import androidx.appcompat.widget.AppCompatCompoundButtonHelper;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.appcompat.widget.ThemeUtils;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableCompoundButton;

public class AppCompatCheckBox
extends CheckBox
implements TintableCompoundButton,
TintableBackgroundView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatCompoundButtonHelper mCompoundButtonHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatCheckBox(Context context) {
        this(context, null);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int n) {
        super(TintContextWrapper.wrap((Context)context), attributeSet, n);
        ThemeUtils.checkAppCompatTheme((View)this, (Context)this.getContext());
        context = new AppCompatCompoundButtonHelper((CompoundButton)this);
        this.mCompoundButtonHelper = context;
        context.loadFromAttributes(attributeSet, n);
        context = new AppCompatBackgroundHelper((View)this);
        this.mBackgroundTintHelper = context;
        context.loadFromAttributes(attributeSet, n);
        context = new AppCompatTextHelper((TextView)this);
        this.mTextHelper = context;
        context.loadFromAttributes(attributeSet, n);
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

    public int getCompoundPaddingLeft() {
        int n = super.getCompoundPaddingLeft();
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCompoundButtonHelper;
        int n2 = n;
        if (appCompatCompoundButtonHelper == null) return n2;
        n2 = appCompatCompoundButtonHelper.getCompoundPaddingLeft(n);
        return n2;
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

    public ColorStateList getSupportButtonTintList() {
        Object object = this.mCompoundButtonHelper;
        object = object != null ? object.getSupportButtonTintList() : null;
        return object;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        Object object = this.mCompoundButtonHelper;
        object = object != null ? object.getSupportButtonTintMode() : null;
        return object;
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

    public void setButtonDrawable(int n) {
        this.setButtonDrawable(AppCompatResources.getDrawable((Context)this.getContext(), (int)n));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        drawable = this.mCompoundButtonHelper;
        if (drawable == null) return;
        drawable.onSetButtonDrawable();
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

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCompoundButtonHelper;
        if (appCompatCompoundButtonHelper == null) return;
        appCompatCompoundButtonHelper.setSupportButtonTintList(colorStateList);
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCompoundButtonHelper;
        if (appCompatCompoundButtonHelper == null) return;
        appCompatCompoundButtonHelper.setSupportButtonTintMode(mode);
    }
}
