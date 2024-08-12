/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.Log
 *  androidx.appcompat.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo
 */
package androidx.appcompat.app;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.app.ActionBarDrawerToggleHoneycomb;

class ActionBarDrawerToggleHoneycomb {
    private static final String TAG = "ActionBarDrawerToggleHC";
    private static final int[] THEME_ATTRS = new int[]{16843531};

    private ActionBarDrawerToggleHoneycomb() {
    }

    public static Drawable getThemeUpIndicator(Activity activity) {
        activity = activity.obtainStyledAttributes(THEME_ATTRS);
        Drawable drawable = activity.getDrawable(0);
        activity.recycle();
        return drawable;
    }

    public static SetIndicatorInfo setActionBarDescription(SetIndicatorInfo setIndicatorInfo, Activity activity, int n) {
        SetIndicatorInfo setIndicatorInfo2 = setIndicatorInfo;
        if (setIndicatorInfo == null) {
            setIndicatorInfo2 = new SetIndicatorInfo(activity);
        }
        if (setIndicatorInfo2.setHomeAsUpIndicator == null) return setIndicatorInfo2;
        try {
            setIndicatorInfo = activity.getActionBar();
            setIndicatorInfo2.setHomeActionContentDescription.invoke(setIndicatorInfo, n);
            if (Build.VERSION.SDK_INT > 19) return setIndicatorInfo2;
            setIndicatorInfo.setSubtitle(setIndicatorInfo.getSubtitle());
        }
        catch (Exception exception) {
            Log.w((String)TAG, (String)"Couldn't set content description via JB-MR2 API", (Throwable)exception);
        }
        return setIndicatorInfo2;
    }

    public static SetIndicatorInfo setActionBarUpIndicator(Activity activity, Drawable drawable, int n) {
        SetIndicatorInfo setIndicatorInfo = new SetIndicatorInfo(activity);
        if (setIndicatorInfo.setHomeAsUpIndicator != null) {
            try {
                activity = activity.getActionBar();
                setIndicatorInfo.setHomeAsUpIndicator.invoke(activity, drawable);
                setIndicatorInfo.setHomeActionContentDescription.invoke(activity, n);
            }
            catch (Exception exception) {
                Log.w((String)TAG, (String)"Couldn't set home-as-up indicator via JB-MR2 API", (Throwable)exception);
            }
        } else if (setIndicatorInfo.upIndicatorView != null) {
            setIndicatorInfo.upIndicatorView.setImageDrawable(drawable);
        } else {
            Log.w((String)TAG, (String)"Couldn't set home-as-up indicator");
        }
        return setIndicatorInfo;
    }
}
