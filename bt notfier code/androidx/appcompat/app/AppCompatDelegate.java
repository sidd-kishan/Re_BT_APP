/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.util.Log
 *  android.view.MenuInflater
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  androidx.appcompat.app.ActionBar
 *  androidx.appcompat.app.ActionBarDrawerToggle$Delegate
 *  androidx.appcompat.app.AppCompatCallback
 *  androidx.appcompat.app.AppCompatDelegateImpl
 *  androidx.appcompat.view.ActionMode
 *  androidx.appcompat.view.ActionMode$Callback
 *  androidx.appcompat.widget.Toolbar
 *  androidx.appcompat.widget.VectorEnabledTintResources
 *  androidx.collection.ArraySet
 */
package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.ArraySet;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class AppCompatDelegate {
    static final boolean DEBUG = false;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public static final int FEATURE_SUPPORT_ACTION_BAR = 108;
    public static final int FEATURE_SUPPORT_ACTION_BAR_OVERLAY = 109;
    @Deprecated
    public static final int MODE_NIGHT_AUTO = 0;
    public static final int MODE_NIGHT_AUTO_BATTERY = 3;
    @Deprecated
    public static final int MODE_NIGHT_AUTO_TIME = 0;
    public static final int MODE_NIGHT_FOLLOW_SYSTEM = -1;
    public static final int MODE_NIGHT_NO = 1;
    public static final int MODE_NIGHT_UNSPECIFIED = -100;
    public static final int MODE_NIGHT_YES = 2;
    static final String TAG = "AppCompatDelegate";
    private static final ArraySet<WeakReference<AppCompatDelegate>> sActivityDelegates = new ArraySet();
    private static final Object sActivityDelegatesLock = new Object();
    private static int sDefaultNightMode = -100;

    AppCompatDelegate() {
    }

    static void addActiveDelegate(AppCompatDelegate appCompatDelegate) {
        Object object = sActivityDelegatesLock;
        synchronized (object) {
            AppCompatDelegate.removeDelegateFromActives(appCompatDelegate);
            ArraySet<WeakReference<AppCompatDelegate>> arraySet = sActivityDelegates;
            WeakReference<AppCompatDelegate> weakReference = new WeakReference<AppCompatDelegate>(appCompatDelegate);
            arraySet.add(weakReference);
            return;
        }
    }

    private static void applyDayNightToActiveDelegates() {
        Object object = sActivityDelegatesLock;
        synchronized (object) {
            try {
                Iterator iterator = sActivityDelegates.iterator();
                while (iterator.hasNext()) {
                    AppCompatDelegate appCompatDelegate = (AppCompatDelegate)((WeakReference)iterator.next()).get();
                    if (appCompatDelegate == null) continue;
                    appCompatDelegate.applyDayNight();
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public static AppCompatDelegate create(Activity activity, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(activity, appCompatCallback);
    }

    public static AppCompatDelegate create(Dialog dialog, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(dialog, appCompatCallback);
    }

    public static AppCompatDelegate create(Context context, Activity activity, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(context, activity, appCompatCallback);
    }

    public static AppCompatDelegate create(Context context, Window window, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(context, window, appCompatCallback);
    }

    public static int getDefaultNightMode() {
        return sDefaultNightMode;
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return VectorEnabledTintResources.isCompatVectorFromResourcesEnabled();
    }

    static void removeActivityDelegate(AppCompatDelegate appCompatDelegate) {
        Object object = sActivityDelegatesLock;
        synchronized (object) {
            AppCompatDelegate.removeDelegateFromActives(appCompatDelegate);
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private static void removeDelegateFromActives(AppCompatDelegate appCompatDelegate) {
        Object object = sActivityDelegatesLock;
        synchronized (object) {
            Iterator iterator = sActivityDelegates.iterator();
            while (iterator.hasNext()) {
                AppCompatDelegate appCompatDelegate2 = (AppCompatDelegate)((WeakReference)iterator.next()).get();
                if (appCompatDelegate2 != appCompatDelegate && appCompatDelegate2 != null) continue;
                iterator.remove();
            }
            return;
        }
    }

    public static void setCompatVectorFromResourcesEnabled(boolean bl) {
        VectorEnabledTintResources.setCompatVectorFromResourcesEnabled((boolean)bl);
    }

    public static void setDefaultNightMode(int n) {
        if (n != -1 && n != 0 && n != 1 && n != 2 && n != 3) {
            Log.d((String)TAG, (String)"setDefaultNightMode() called with an unknown mode");
        } else {
            if (sDefaultNightMode == n) return;
            sDefaultNightMode = n;
            AppCompatDelegate.applyDayNightToActiveDelegates();
        }
    }

    public abstract void addContentView(View var1, ViewGroup.LayoutParams var2);

    public abstract boolean applyDayNight();

    @Deprecated
    public void attachBaseContext(Context context) {
    }

    public Context attachBaseContext2(Context context) {
        this.attachBaseContext(context);
        return context;
    }

    public abstract View createView(View var1, String var2, Context var3, AttributeSet var4);

    public abstract <T extends View> T findViewById(int var1);

    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();

    public int getLocalNightMode() {
        return -100;
    }

    public abstract MenuInflater getMenuInflater();

    public abstract ActionBar getSupportActionBar();

    public abstract boolean hasWindowFeature(int var1);

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract boolean isHandleNativeActionModesEnabled();

    public abstract void onConfigurationChanged(Configuration var1);

    public abstract void onCreate(Bundle var1);

    public abstract void onDestroy();

    public abstract void onPostCreate(Bundle var1);

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(Bundle var1);

    public abstract void onStart();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int var1);

    public abstract void setContentView(int var1);

    public abstract void setContentView(View var1);

    public abstract void setContentView(View var1, ViewGroup.LayoutParams var2);

    public abstract void setHandleNativeActionModesEnabled(boolean var1);

    public abstract void setLocalNightMode(int var1);

    public abstract void setSupportActionBar(Toolbar var1);

    public void setTheme(int n) {
    }

    public abstract void setTitle(CharSequence var1);

    public abstract ActionMode startSupportActionMode(ActionMode.Callback var1);
}
