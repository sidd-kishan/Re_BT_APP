/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Bitmap
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.view.View
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.widget.AppCompatBackgroundHelper
 *  androidx.appcompat.widget.AppCompatImageHelper
 *  androidx.appcompat.widget.ThemeUtils
 *  androidx.appcompat.widget.TintContextWrapper
 *  androidx.core.view.TintableBackgroundView
 *  androidx.core.widget.TintableImageSourceView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatBackgroundHelper;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.appcompat.widget.ThemeUtils;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableImageSourceView;

public class AppCompatImageButton
extends ImageButton
implements TintableBackgroundView,
TintableImageSourceView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatImageHelper mImageHelper;

    public AppCompatImageButton(Context context) {
        this(context, null);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int n) {
        super(TintContextWrapper.wrap((Context)context), attributeSet, n);
        ThemeUtils.checkAppCompatTheme((View)this, (Context)this.getContext());
        context = new AppCompatBackgroundHelper((View)this);
        this.mBackgroundTintHelper = context;
        context.loadFromAttributes(attributeSet, n);
        context = new AppCompatImageHelper((ImageView)this);
        this.mImageHelper = context;
        context.loadFromAttributes(attributeSet, n);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.applySupportBackgroundTint();
        }
        if ((appCompatBackgroundHelper = this.mImageHelper) == null) return;
        appCompatBackgroundHelper.applySupportImageTint();
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

    public ColorStateList getSupportImageTintList() {
        Object object = this.mImageHelper;
        object = object != null ? object.getSupportImageTintList() : null;
        return object;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        Object object = this.mImageHelper;
        object = object != null ? object.getSupportImageTintMode() : null;
        return object;
    }

    public boolean hasOverlappingRendering() {
        boolean bl = this.mImageHelper.hasOverlappingRendering() && super.hasOverlappingRendering();
        return bl;
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

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        bitmap = this.mImageHelper;
        if (bitmap == null) return;
        bitmap.applySupportImageTint();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        drawable = this.mImageHelper;
        if (drawable == null) return;
        drawable.applySupportImageTint();
    }

    public void setImageResource(int n) {
        this.mImageHelper.setImageResource(n);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        uri = this.mImageHelper;
        if (uri == null) return;
        uri.applySupportImageTint();
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

    public void setSupportImageTintList(ColorStateList colorStateList) {
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        if (appCompatImageHelper == null) return;
        appCompatImageHelper.setSupportImageTintList(colorStateList);
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        if (appCompatImageHelper == null) return;
        appCompatImageHelper.setSupportImageTintMode(mode);
    }
}
