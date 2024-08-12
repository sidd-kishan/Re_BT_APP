/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.MenuItem
 *  android.view.View
 *  androidx.core.content.ContextCompat
 *  androidx.drawerlayout.widget.DrawerLayout
 *  androidx.drawerlayout.widget.DrawerLayout$DrawerListener
 *  androidx.legacy.app.ActionBarDrawerToggle$Delegate
 *  androidx.legacy.app.ActionBarDrawerToggle$DelegateProvider
 *  androidx.legacy.app.ActionBarDrawerToggle$SetIndicatorInfo
 *  androidx.legacy.app.ActionBarDrawerToggle$SlideDrawable
 */
package androidx.legacy.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.legacy.app.ActionBarDrawerToggle;

@Deprecated
public class ActionBarDrawerToggle
implements DrawerLayout.DrawerListener {
    private static final int ID_HOME = 16908332;
    private static final String TAG = "ActionBarDrawerToggle";
    private static final int[] THEME_ATTRS = new int[]{16843531};
    private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334f;
    final Activity mActivity;
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled = true;
    private final DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private SetIndicatorInfo mSetIndicatorInfo;
    private SlideDrawable mSlider;

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, int n, int n2, int n3) {
        this(activity, drawerLayout, ActionBarDrawerToggle.assumeMaterial((Context)activity) ^ true, n, n2, n3);
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, boolean bl, int n, int n2, int n3) {
        this.mActivity = activity;
        this.mActivityImpl = activity instanceof DelegateProvider ? ((DelegateProvider)activity).getDrawerToggleDelegate() : null;
        this.mDrawerLayout = drawerLayout;
        this.mDrawerImageResource = n;
        this.mOpenDrawerContentDescRes = n2;
        this.mCloseDrawerContentDescRes = n3;
        this.mHomeAsUpIndicator = this.getThemeUpIndicator();
        this.mDrawerImage = ContextCompat.getDrawable((Context)activity, (int)n);
        activity = new SlideDrawable(this, this.mDrawerImage);
        this.mSlider = activity;
        float f = bl ? 0.33333334f : 0.0f;
        activity.setOffset(f);
    }

    private static boolean assumeMaterial(Context context) {
        boolean bl = context.getApplicationInfo().targetSdkVersion >= 21 && Build.VERSION.SDK_INT >= 21;
        return bl;
    }

    private Drawable getThemeUpIndicator() {
        Object object = this.mActivityImpl;
        if (object != null) {
            return object.getThemeUpIndicator();
        }
        if (Build.VERSION.SDK_INT < 18) {
            object = this.mActivity.obtainStyledAttributes(THEME_ATTRS);
            Drawable drawable = object.getDrawable(0);
            object.recycle();
            return drawable;
        }
        object = this.mActivity.getActionBar();
        object = object != null ? object.getThemedContext() : this.mActivity;
        object = object.obtainStyledAttributes(null, THEME_ATTRS, 16843470, 0);
        Drawable drawable = object.getDrawable(0);
        object.recycle();
        return drawable;
    }

    private void setActionBarDescription(int n) {
        Delegate delegate = this.mActivityImpl;
        if (delegate != null) {
            delegate.setActionBarDescription(n);
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            delegate = this.mActivity.getActionBar();
            if (delegate == null) return;
            delegate.setHomeActionContentDescription(n);
        } else {
            if (this.mSetIndicatorInfo == null) {
                this.mSetIndicatorInfo = new SetIndicatorInfo(this.mActivity);
            }
            if (this.mSetIndicatorInfo.mSetHomeAsUpIndicator == null) return;
            try {
                delegate = this.mActivity.getActionBar();
                this.mSetIndicatorInfo.mSetHomeActionContentDescription.invoke(delegate, n);
                delegate.setSubtitle(delegate.getSubtitle());
            }
            catch (Exception exception) {
                Log.w((String)TAG, (String)"Couldn't set content description via JB-MR2 API", (Throwable)exception);
            }
        }
    }

    private void setActionBarUpIndicator(Drawable drawable, int n) {
        Delegate delegate = this.mActivityImpl;
        if (delegate != null) {
            delegate.setActionBarUpIndicator(drawable, n);
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            delegate = this.mActivity.getActionBar();
            if (delegate == null) return;
            delegate.setHomeAsUpIndicator(drawable);
            delegate.setHomeActionContentDescription(n);
        } else {
            if (this.mSetIndicatorInfo == null) {
                this.mSetIndicatorInfo = new SetIndicatorInfo(this.mActivity);
            }
            if (this.mSetIndicatorInfo.mSetHomeAsUpIndicator != null) {
                try {
                    delegate = this.mActivity.getActionBar();
                    this.mSetIndicatorInfo.mSetHomeAsUpIndicator.invoke(delegate, drawable);
                    this.mSetIndicatorInfo.mSetHomeActionContentDescription.invoke(delegate, n);
                }
                catch (Exception exception) {
                    Log.w((String)TAG, (String)"Couldn't set home-as-up indicator via JB-MR2 API", (Throwable)exception);
                }
            } else if (this.mSetIndicatorInfo.mUpIndicatorView != null) {
                this.mSetIndicatorInfo.mUpIndicatorView.setImageDrawable(drawable);
            } else {
                Log.w((String)TAG, (String)"Couldn't set home-as-up indicator");
            }
        }
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.mHasCustomUpIndicator) {
            this.mHomeAsUpIndicator = this.getThemeUpIndicator();
        }
        this.mDrawerImage = ContextCompat.getDrawable((Context)this.mActivity, (int)this.mDrawerImageResource);
        this.syncState();
    }

    public void onDrawerClosed(View view) {
        this.mSlider.setPosition(0.0f);
        if (!this.mDrawerIndicatorEnabled) return;
        this.setActionBarDescription(this.mOpenDrawerContentDescRes);
    }

    public void onDrawerOpened(View view) {
        this.mSlider.setPosition(1.0f);
        if (!this.mDrawerIndicatorEnabled) return;
        this.setActionBarDescription(this.mCloseDrawerContentDescRes);
    }

    public void onDrawerSlide(View view, float f) {
        float f2 = this.mSlider.getPosition();
        f = f > 0.5f ? Math.max(f2, Math.max(0.0f, f - 0.5f) * 2.0f) : Math.min(f2, f * 2.0f);
        this.mSlider.setPosition(f);
    }

    public void onDrawerStateChanged(int n) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null) return false;
        if (menuItem.getItemId() != 16908332) return false;
        if (!this.mDrawerIndicatorEnabled) return false;
        if (this.mDrawerLayout.isDrawerVisible(0x800003)) {
            this.mDrawerLayout.closeDrawer(0x800003);
        } else {
            this.mDrawerLayout.openDrawer(0x800003);
        }
        return true;
    }

    public void setDrawerIndicatorEnabled(boolean bl) {
        if (bl == this.mDrawerIndicatorEnabled) return;
        if (bl) {
            SlideDrawable slideDrawable = this.mSlider;
            int n = this.mDrawerLayout.isDrawerOpen(0x800003) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes;
            this.setActionBarUpIndicator((Drawable)slideDrawable, n);
        } else {
            this.setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        }
        this.mDrawerIndicatorEnabled = bl;
    }

    public void setHomeAsUpIndicator(int n) {
        Drawable drawable = n != 0 ? ContextCompat.getDrawable((Context)this.mActivity, (int)n) : null;
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

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(0x800003)) {
            this.mSlider.setPosition(1.0f);
        } else {
            this.mSlider.setPosition(0.0f);
        }
        if (!this.mDrawerIndicatorEnabled) return;
        SlideDrawable slideDrawable = this.mSlider;
        int n = this.mDrawerLayout.isDrawerOpen(0x800003) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes;
        this.setActionBarUpIndicator((Drawable)slideDrawable, n);
    }
}
