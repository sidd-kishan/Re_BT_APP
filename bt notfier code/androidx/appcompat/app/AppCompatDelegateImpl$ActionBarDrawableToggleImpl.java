/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.app.ActionBar
 *  androidx.appcompat.app.ActionBarDrawerToggle$Delegate
 *  androidx.appcompat.app.AppCompatDelegateImpl
 *  androidx.appcompat.widget.TintTypedArray
 */
package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.TintTypedArray;

private class AppCompatDelegateImpl.ActionBarDrawableToggleImpl
implements ActionBarDrawerToggle.Delegate {
    final AppCompatDelegateImpl this$0;

    AppCompatDelegateImpl.ActionBarDrawableToggleImpl(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public Context getActionBarThemedContext() {
        return this.this$0.getActionBarThemedContext();
    }

    public Drawable getThemeUpIndicator() {
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes((Context)this.getActionBarThemedContext(), null, (int[])new int[]{R.attr.homeAsUpIndicator});
        Drawable drawable = tintTypedArray.getDrawable(0);
        tintTypedArray.recycle();
        return drawable;
    }

    public boolean isNavigationVisible() {
        ActionBar actionBar = this.this$0.getSupportActionBar();
        boolean bl = actionBar != null && (actionBar.getDisplayOptions() & 4) != 0;
        return bl;
    }

    public void setActionBarDescription(int n) {
        ActionBar actionBar = this.this$0.getSupportActionBar();
        if (actionBar == null) return;
        actionBar.setHomeActionContentDescription(n);
    }

    public void setActionBarUpIndicator(Drawable drawable, int n) {
        ActionBar actionBar = this.this$0.getSupportActionBar();
        if (actionBar == null) return;
        actionBar.setHomeAsUpIndicator(drawable);
        actionBar.setHomeActionContentDescription(n);
    }
}
