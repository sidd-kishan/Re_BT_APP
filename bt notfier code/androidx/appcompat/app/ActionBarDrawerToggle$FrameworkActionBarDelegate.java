/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActionBar
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  androidx.appcompat.app.ActionBarDrawerToggle$Delegate
 *  androidx.appcompat.app.ActionBarDrawerToggleHoneycomb
 *  androidx.appcompat.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo
 */
package androidx.appcompat.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.ActionBarDrawerToggleHoneycomb;

private static class ActionBarDrawerToggle.FrameworkActionBarDelegate
implements ActionBarDrawerToggle.Delegate {
    private final Activity mActivity;
    private ActionBarDrawerToggleHoneycomb.SetIndicatorInfo mSetIndicatorInfo;

    ActionBarDrawerToggle.FrameworkActionBarDelegate(Activity activity) {
        this.mActivity = activity;
    }

    public Context getActionBarThemedContext() {
        ActionBar actionBar = this.mActivity.getActionBar();
        if (actionBar == null) return this.mActivity;
        return actionBar.getThemedContext();
    }

    public Drawable getThemeUpIndicator() {
        if (Build.VERSION.SDK_INT < 18) return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator((Activity)this.mActivity);
        TypedArray typedArray = this.getActionBarThemedContext().obtainStyledAttributes(null, new int[]{16843531}, 16843470, 0);
        Drawable drawable = typedArray.getDrawable(0);
        typedArray.recycle();
        return drawable;
    }

    public boolean isNavigationVisible() {
        ActionBar actionBar = this.mActivity.getActionBar();
        boolean bl = actionBar != null && (actionBar.getDisplayOptions() & 4) != 0;
        return bl;
    }

    public void setActionBarDescription(int n) {
        if (Build.VERSION.SDK_INT >= 18) {
            ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar == null) return;
            actionBar.setHomeActionContentDescription(n);
        } else {
            this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarDescription((ActionBarDrawerToggleHoneycomb.SetIndicatorInfo)this.mSetIndicatorInfo, (Activity)this.mActivity, (int)n);
        }
    }

    public void setActionBarUpIndicator(Drawable drawable, int n) {
        ActionBar actionBar = this.mActivity.getActionBar();
        if (actionBar == null) return;
        if (Build.VERSION.SDK_INT >= 18) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(n);
        } else {
            actionBar.setDisplayShowHomeEnabled(true);
            this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator((Activity)this.mActivity, (Drawable)drawable, (int)n);
            actionBar.setDisplayShowHomeEnabled(false);
        }
    }
}
