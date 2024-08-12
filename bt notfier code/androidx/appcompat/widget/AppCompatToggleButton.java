/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.widget.TextView
 *  android.widget.ToggleButton
 *  androidx.appcompat.widget.AppCompatBackgroundHelper
 *  androidx.appcompat.widget.AppCompatTextHelper
 *  androidx.appcompat.widget.ThemeUtils
 *  androidx.core.view.TintableBackgroundView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.widget.AppCompatBackgroundHelper;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.appcompat.widget.ThemeUtils;
import androidx.core.view.TintableBackgroundView;

public class AppCompatToggleButton
extends ToggleButton
implements TintableBackgroundView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatToggleButton(Context context) {
        this(context, null);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        ThemeUtils.checkAppCompatTheme((View)this, (Context)this.getContext());
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
}
