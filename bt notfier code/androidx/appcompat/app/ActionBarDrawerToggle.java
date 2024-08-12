/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.res.Configuration
 *  android.graphics.drawable.Drawable
 *  android.util.Log
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.app.ActionBarDrawerToggle$Delegate
 *  androidx.appcompat.app.ActionBarDrawerToggle$DelegateProvider
 *  androidx.appcompat.app.ActionBarDrawerToggle$FrameworkActionBarDelegate
 *  androidx.appcompat.app.ActionBarDrawerToggle$ToolbarCompatDelegate
 *  androidx.appcompat.graphics.drawable.DrawerArrowDrawable
 *  androidx.appcompat.widget.Toolbar
 *  androidx.drawerlayout.widget.DrawerLayout
 *  androidx.drawerlayout.widget.DrawerLayout$DrawerListener
 */
package androidx.appcompat.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

public class ActionBarDrawerToggle
implements DrawerLayout.DrawerListener {
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    boolean mDrawerIndicatorEnabled = true;
    private final DrawerLayout mDrawerLayout;
    private boolean mDrawerSlideAnimationEnabled = true;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private DrawerArrowDrawable mSlider;
    View.OnClickListener mToolbarNavigationClickListener;
    private boolean mWarnedForDisplayHomeAsUp = false;

    ActionBarDrawerToggle(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, DrawerArrowDrawable drawerArrowDrawable, int n, int n2) {
        if (toolbar != null) {
            this.mActivityImpl = new ToolbarCompatDelegate(toolbar);
            toolbar.setNavigationOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            this.mActivityImpl = activity instanceof DelegateProvider ? ((DelegateProvider)activity).getDrawerToggleDelegate() : new FrameworkActionBarDelegate(activity);
        }
        this.mDrawerLayout = drawerLayout;
        this.mOpenDrawerContentDescRes = n;
        this.mCloseDrawerContentDescRes = n2;
        this.mSlider = drawerArrowDrawable == null ? new DrawerArrowDrawable(this.mActivityImpl.getActionBarThemedContext()) : drawerArrowDrawable;
        this.mHomeAsUpIndicator = this.getThemeUpIndicator();
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, int n, int n2) {
        this(activity, null, drawerLayout, null, n, n2);
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int n, int n2) {
        this(activity, toolbar, drawerLayout, null, n, n2);
    }

    private void setPosition(float f) {
        if (f == 1.0f) {
            this.mSlider.setVerticalMirror(true);
        } else if (f == 0.0f) {
            this.mSlider.setVerticalMirror(false);
        }
        this.mSlider.setProgress(f);
    }

    public DrawerArrowDrawable getDrawerArrowDrawable() {
        return this.mSlider;
    }

    Drawable getThemeUpIndicator() {
        return this.mActivityImpl.getThemeUpIndicator();
    }

    public View.OnClickListener getToolbarNavigationClickListener() {
        return this.mToolbarNavigationClickListener;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public boolean isDrawerSlideAnimationEnabled() {
        return this.mDrawerSlideAnimationEnabled;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.mHasCustomUpIndicator) {
            this.mHomeAsUpIndicator = this.getThemeUpIndicator();
        }
        this.syncState();
    }

    public void onDrawerClosed(View view) {
        this.setPosition(0.0f);
        if (!this.mDrawerIndicatorEnabled) return;
        this.setActionBarDescription(this.mOpenDrawerContentDescRes);
    }

    public void onDrawerOpened(View view) {
        this.setPosition(1.0f);
        if (!this.mDrawerIndicatorEnabled) return;
        this.setActionBarDescription(this.mCloseDrawerContentDescRes);
    }

    public void onDrawerSlide(View view, float f) {
        if (this.mDrawerSlideAnimationEnabled) {
            this.setPosition(Math.min(1.0f, Math.max(0.0f, f)));
        } else {
            this.setPosition(0.0f);
        }
    }

    public void onDrawerStateChanged(int n) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null) return false;
        if (menuItem.getItemId() != 16908332) return false;
        if (!this.mDrawerIndicatorEnabled) return false;
        this.toggle();
        return true;
    }

    void setActionBarDescription(int n) {
        this.mActivityImpl.setActionBarDescription(n);
    }

    void setActionBarUpIndicator(Drawable drawable, int n) {
        if (!this.mWarnedForDisplayHomeAsUp && !this.mActivityImpl.isNavigationVisible()) {
            Log.w((String)"ActionBarDrawerToggle", (String)"DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.mWarnedForDisplayHomeAsUp = true;
        }
        this.mActivityImpl.setActionBarUpIndicator(drawable, n);
    }

    public void setDrawerArrowDrawable(DrawerArrowDrawable drawerArrowDrawable) {
        this.mSlider = drawerArrowDrawable;
        this.syncState();
    }

    public void setDrawerIndicatorEnabled(boolean bl) {
        if (bl == this.mDrawerIndicatorEnabled) return;
        if (bl) {
            DrawerArrowDrawable drawerArrowDrawable = this.mSlider;
            int n = this.mDrawerLayout.isDrawerOpen(0x800003) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes;
            this.setActionBarUpIndicator((Drawable)drawerArrowDrawable, n);
        } else {
            this.setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        }
        this.mDrawerIndicatorEnabled = bl;
    }

    public void setDrawerSlideAnimationEnabled(boolean bl) {
        this.mDrawerSlideAnimationEnabled = bl;
        if (bl) return;
        this.setPosition(0.0f);
    }

    public void setHomeAsUpIndicator(int n) {
        Drawable drawable = n != 0 ? this.mDrawerLayout.getResources().getDrawable(n) : null;
        this.setHomeAsUpIndicator(drawable);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.mHomeAsUpIndicator = this.getThemeUpIndicator();
            this.mHasCustomUpIndicator = false;
        } else {
            this.mHomeAsUpIndicator = drawable;
            this.mHasCustomUpIndicator = true;
        }
        if (this.mDrawerIndicatorEnabled) return;
        this.setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
    }

    public void setToolbarNavigationClickListener(View.OnClickListener onClickListener) {
        this.mToolbarNavigationClickListener = onClickListener;
    }

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(0x800003)) {
            this.setPosition(1.0f);
        } else {
            this.setPosition(0.0f);
        }
        if (!this.mDrawerIndicatorEnabled) return;
        DrawerArrowDrawable drawerArrowDrawable = this.mSlider;
        int n = this.mDrawerLayout.isDrawerOpen(0x800003) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes;
        this.setActionBarUpIndicator((Drawable)drawerArrowDrawable, n);
    }

    void toggle() {
        int n = this.mDrawerLayout.getDrawerLockMode(0x800003);
        if (this.mDrawerLayout.isDrawerVisible(0x800003) && n != 2) {
            this.mDrawerLayout.closeDrawer(0x800003);
        } else {
            if (n == 1) return;
            this.mDrawerLayout.openDrawer(0x800003);
        }
    }
}
