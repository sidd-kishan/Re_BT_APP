/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActionBar
 *  android.app.Activity
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 */
package androidx.legacy.app;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

private static class ActionBarDrawerToggle.SetIndicatorInfo {
    Method mSetHomeActionContentDescription;
    Method mSetHomeAsUpIndicator;
    ImageView mUpIndicatorView;

    ActionBarDrawerToggle.SetIndicatorInfo(Activity activity) {
        try {
            this.mSetHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
            this.mSetHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
            return;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            activity = activity.findViewById(16908332);
            if (activity == null) {
                return;
            }
            if ((activity = (ViewGroup)activity.getParent()).getChildCount() != 2) {
                return;
            }
            View view = activity.getChildAt(0);
            View view2 = activity.getChildAt(1);
            activity = view;
            if (view.getId() == 16908332) {
                activity = view2;
            }
            if (!(activity instanceof ImageView)) return;
            this.mUpIndicatorView = (ImageView)activity;
            return;
        }
    }
}
