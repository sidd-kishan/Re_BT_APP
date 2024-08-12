/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.view.ActionProvider
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.widget.ShareActionProvider
 *  androidx.core.app.ShareCompat$IntentBuilder
 */
package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.core.app.ShareCompat;

public final class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
    public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    private ShareCompat() {
    }

    @Deprecated
    public static void configureMenuItem(Menu object, int n, IntentBuilder intentBuilder) {
        if ((object = object.findItem(n)) != null) {
            ShareCompat.configureMenuItem((MenuItem)object, intentBuilder);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Could not find menu item with id ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" in the supplied menu");
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    @Deprecated
    public static void configureMenuItem(MenuItem menuItem, IntentBuilder intentBuilder) {
        ActionProvider actionProvider = menuItem.getActionProvider();
        actionProvider = !(actionProvider instanceof ShareActionProvider) ? new ShareActionProvider(intentBuilder.getContext()) : (ShareActionProvider)actionProvider;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HISTORY_FILENAME_PREFIX);
        stringBuilder.append(intentBuilder.getContext().getClass().getName());
        actionProvider.setShareHistoryFileName(stringBuilder.toString());
        actionProvider.setShareIntent(intentBuilder.getIntent());
        menuItem.setActionProvider(actionProvider);
        if (Build.VERSION.SDK_INT >= 16) return;
        if (menuItem.hasSubMenu()) return;
        menuItem.setIntent(intentBuilder.createChooserIntent());
    }

    public static ComponentName getCallingActivity(Activity activity) {
        Intent intent = activity.getIntent();
        ComponentName componentName = activity.getCallingActivity();
        activity = componentName;
        if (componentName != null) return activity;
        activity = ShareCompat.getCallingActivity(intent);
        return activity;
    }

    static ComponentName getCallingActivity(Intent intent) {
        ComponentName componentName;
        ComponentName componentName2 = componentName = (ComponentName)intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY);
        if (componentName != null) return componentName2;
        componentName2 = (ComponentName)intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY_INTEROP);
        return componentName2;
    }

    public static String getCallingPackage(Activity object) {
        Intent intent = object.getIntent();
        String string = object.getCallingPackage();
        object = string;
        if (string != null) return object;
        object = string;
        if (intent == null) return object;
        object = ShareCompat.getCallingPackage(intent);
        return object;
    }

    static String getCallingPackage(Intent intent) {
        String string;
        String string2 = string = intent.getStringExtra(EXTRA_CALLING_PACKAGE);
        if (string != null) return string2;
        string2 = intent.getStringExtra(EXTRA_CALLING_PACKAGE_INTEROP);
        return string2;
    }
}
