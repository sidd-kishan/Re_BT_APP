/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.net.ConnectivityManager
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.provider.Settings$Global
 *  android.provider.Settings$Secure
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.KeyCharacterMap
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.WindowManager
 *  com.qmuiteam.qmui.util.QMUIDeviceHelper
 *  com.qmuiteam.qmui.util.QMUINotchHelper
 *  com.qmuiteam.qmui.util.QMUIStatusBarHelper
 */
package com.qmuiteam.qmui.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.qmuiteam.qmui.util.QMUIDeviceHelper;
import com.qmuiteam.qmui.util.QMUINotchHelper;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import java.lang.reflect.Method;
import java.util.Locale;

public class QMUIDisplayHelper {
    public static final float DENSITY = Resources.getSystem().getDisplayMetrics().density;
    private static final String HUAWAI_DISPLAY_NOTCH_STATUS = "display_notch_status";
    private static final String TAG = "QMUIDisplayHelper";
    private static final String VIVO_NAVIGATION_GESTURE = "navigation_gesture_on";
    private static final String XIAOMI_DISPLAY_NOTCH_STATUS = "force_black";
    private static final String XIAOMI_FULLSCREEN_GESTURE = "force_fsg_nav_bar";
    private static Boolean sHasCamera = null;

    public static void cancelFullScreen(Activity activity) {
        activity = activity.getWindow();
        activity.clearFlags(1024);
        activity.clearFlags(512);
    }

    private static boolean deviceHasNavigationBar() {
        boolean bl = false;
        try {
            boolean bl2;
            Method method = Class.forName("android.view.WindowManagerGlobal").getDeclaredMethod("getWindowManagerService", new Class[0]);
            method.setAccessible(true);
            Object object = method.invoke(null, new Object[0]);
            method = object.getClass().getDeclaredMethod("hasNavigationBar", new Class[0]);
            method.setAccessible(true);
            bl = bl2 = ((Boolean)method.invoke(object, new Object[0])).booleanValue();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return bl;
    }

    private static int[] doGetRealScreenSize(Context context) {
        int n;
        int n2;
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getMetrics(displayMetrics);
        int n3 = displayMetrics.widthPixels;
        int n4 = displayMetrics.heightPixels;
        try {
            n3 = n2 = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(context, new Object[0])).intValue();
            n4 = n = ((Integer)Display.class.getMethod("getRawHeight", new Class[0]).invoke(context, new Object[0])).intValue();
            n3 = n2;
        }
        catch (Exception exception) {
            // empty catch block
        }
        n = n4;
        n2 = n3;
        if (Build.VERSION.SDK_INT < 17) return new int[]{n2, n};
        n2 = n3;
        try {
            n2 = n3;
            displayMetrics = new Point();
            n2 = n3;
            context.getRealSize((Point)displayMetrics);
            n2 = n3;
            Display.class.getMethod("getRealSize", Point.class).invoke(context, displayMetrics);
            n2 = n3;
            n2 = n3 = displayMetrics.x;
            n = displayMetrics.y;
            n2 = n3;
        }
        catch (Exception exception) {
            n = n4;
        }
        return new int[]{n2, n};
    }

    public static int dp2px(Context context, int n) {
        double d = QMUIDisplayHelper.getDensity(context) * (float)n;
        Double.isNaN(d);
        return (int)(d + 0.5);
    }

    public static int dpToPx(int n) {
        return (int)((float)n * DENSITY + 0.5f);
    }

    public static int getActionBarHeight(Context context) {
        TypedValue typedValue = new TypedValue();
        int n = context.getTheme().resolveAttribute(16843499, typedValue, true) ? TypedValue.complexToDimensionPixelSize((int)typedValue.data, (DisplayMetrics)context.getResources().getDisplayMetrics()) : 0;
        return n;
    }

    public static String getCurCountryLan(Context object) {
        object = object.getResources().getConfiguration();
        object = Build.VERSION.SDK_INT >= 24 ? object.getLocales().get(0) : ((Configuration)object).locale;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Locale)object).getLanguage());
        stringBuilder.append("-");
        stringBuilder.append(((Locale)object).getCountry());
        return stringBuilder.toString();
    }

    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static float getFontDensity(Context context) {
        return context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static int getNavMenuHeight(Context context) {
        if (!QMUIDisplayHelper.isNavMenuExist(context)) {
            return 0;
        }
        int n = QMUIDisplayHelper.getResourceNavHeight(context);
        if (n < 0) return QMUIDisplayHelper.getRealScreenSize(context)[1] - QMUIDisplayHelper.getScreenHeight(context);
        return n;
    }

    public static int[] getRealScreenSize(Context context) {
        return QMUIDisplayHelper.doGetRealScreenSize(context);
    }

    private static int getResourceNavHeight(Context context) {
        int n = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (n <= 0) return -1;
        return context.getResources().getDimensionPixelSize(n);
    }

    public static int getScreenHeight(Context context) {
        int n;
        int n2 = n = QMUIDisplayHelper.getDisplayMetrics((Context)context).heightPixels;
        if (!QMUIDeviceHelper.isXiaomi()) return n2;
        n2 = n;
        if (!QMUIDisplayHelper.xiaomiNavigationGestureEnabled(context)) return n2;
        n2 = n + QMUIDisplayHelper.getResourceNavHeight(context);
        return n2;
    }

    public static int getScreenWidth(Context context) {
        return QMUIDisplayHelper.getDisplayMetrics((Context)context).widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        if (QMUIDeviceHelper.isXiaomi()) {
            int n = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (n <= 0) return 0;
            return context.getResources().getDimensionPixelSize(n);
        }
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object obj = clazz.newInstance();
            int n = Integer.parseInt(clazz.getField("status_bar_height").get(obj).toString());
            if (n <= 0) return 0;
            n = context.getResources().getDimensionPixelSize(n);
            return n;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public static int getUsefulScreenHeight(Activity activity) {
        return QMUIDisplayHelper.getUsefulScreenHeight((Context)activity, QMUINotchHelper.hasNotch((Activity)activity));
    }

    private static int getUsefulScreenHeight(Context context, boolean bl) {
        int[] nArray = QMUIDisplayHelper.getRealScreenSize(context);
        boolean bl2 = true;
        int n = nArray[1];
        if (context.getResources().getConfiguration().orientation != 1) {
            bl2 = false;
        }
        int n2 = n;
        if (bl) return n2;
        n2 = n;
        if (!bl2) return n2;
        n2 = n;
        if (!QMUIDeviceHelper.isEssentialPhone()) return n2;
        n2 = n;
        if (Build.VERSION.SDK_INT >= 26) return n2;
        n2 = n - QMUIStatusBarHelper.getStatusbarHeight((Context)context) * 2;
        return n2;
    }

    public static int getUsefulScreenHeight(View view) {
        return QMUIDisplayHelper.getUsefulScreenHeight(view.getContext(), QMUINotchHelper.hasNotch((View)view));
    }

    public static int getUsefulScreenWidth(Activity activity) {
        return QMUIDisplayHelper.getUsefulScreenWidth((Context)activity, QMUINotchHelper.hasNotch((Activity)activity));
    }

    public static int getUsefulScreenWidth(Context context, boolean bl) {
        int[] nArray = QMUIDisplayHelper.getRealScreenSize(context);
        boolean bl2 = false;
        int n = nArray[0];
        if (context.getResources().getConfiguration().orientation == 2) {
            bl2 = true;
        }
        if (!bl) {
            int n2 = n;
            if (!bl2) return n2;
            n2 = n;
            if (!QMUIDeviceHelper.isEssentialPhone()) return n2;
            n2 = n;
            if (Build.VERSION.SDK_INT >= 26) return n2;
            n2 = n - QMUIStatusBarHelper.getStatusbarHeight((Context)context) * 2;
            return n2;
        }
        int n3 = n;
        if (!bl2) return n3;
        n3 = n;
        if (!QMUIDeviceHelper.isHuawei()) return n3;
        n3 = n;
        if (QMUIDisplayHelper.huaweiIsNotchSetToShowInSetting(context)) return n3;
        n3 = n - QMUINotchHelper.getNotchSizeInHuawei((Context)context)[1];
        return n3;
    }

    public static int getUsefulScreenWidth(View view) {
        return QMUIDisplayHelper.getUsefulScreenWidth(view.getContext(), QMUINotchHelper.hasNotch((View)view));
    }

    public static final boolean hasCamera(Context context) {
        if (sHasCamera != null) return sHasCamera;
        context = context.getPackageManager();
        boolean bl = context.hasSystemFeature("android.hardware.camera.front");
        boolean bl2 = context.hasSystemFeature("android.hardware.camera");
        bl2 = bl || bl2;
        sHasCamera = bl2;
        return sHasCamera;
    }

    public static boolean hasHardwareMenuKey(Context context) {
        boolean bl = Build.VERSION.SDK_INT < 11 ? true : (Build.VERSION.SDK_INT >= 14 ? ViewConfiguration.get((Context)context).hasPermanentMenuKey() : false);
        return bl;
    }

    public static boolean hasInternet(Context context) {
        boolean bl = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
        return bl;
    }

    public static boolean hasNavigationBar(Context context) {
        if (!QMUIDisplayHelper.deviceHasNavigationBar()) {
            return false;
        }
        if (!QMUIDeviceHelper.isVivo()) return true;
        return QMUIDisplayHelper.vivoNavigationGestureEnabled(context);
    }

    public static boolean hasStatusBar(Context context) {
        boolean bl;
        boolean bl2 = context instanceof Activity;
        boolean bl3 = bl = true;
        if (!bl2) return bl3;
        bl3 = (((Activity)context).getWindow().getAttributes().flags & 0x400) != 1024 ? bl : false;
        return bl3;
    }

    public static boolean huaweiIsNotchSetToShowInSetting(Context context) {
        context = context.getContentResolver();
        boolean bl = false;
        if (Settings.Secure.getInt((ContentResolver)context, (String)HUAWAI_DISPLAY_NOTCH_STATUS, (int)0) != 0) return bl;
        bl = true;
        return bl;
    }

    public static boolean isElevationSupported() {
        boolean bl = Build.VERSION.SDK_INT >= 21;
        return bl;
    }

    public static boolean isFullScreen(Activity activity) {
        boolean bl = (activity.getWindow().getAttributes().flags & 0x400) == 1024;
        return bl;
    }

    public static boolean isNavMenuExist(Context context) {
        boolean bl = ViewConfiguration.get((Context)context).hasPermanentMenuKey();
        boolean bl2 = KeyCharacterMap.deviceHasKey((int)4);
        if (bl) return false;
        if (bl2) return false;
        return true;
    }

    public static boolean isPackageExist(Context context, String string) {
        try {
            context = context.getPackageManager().getPackageInfo(string, 0);
            if (context == null) return false;
            return true;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
        }
        return false;
    }

    public static boolean isSdcardReady() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static boolean isZhCN(Context object) {
        object = object.getResources().getConfiguration();
        object = Build.VERSION.SDK_INT >= 24 ? object.getLocales().get(0) : object.locale;
        return object.getCountry().equalsIgnoreCase("CN");
    }

    public static int px2dp(Context context, int n) {
        double d = (float)n / QMUIDisplayHelper.getDensity(context);
        Double.isNaN(d);
        return (int)(d + 0.5);
    }

    public static int px2sp(Context context, int n) {
        double d = (float)n / QMUIDisplayHelper.getFontDensity(context);
        Double.isNaN(d);
        return (int)(d + 0.5);
    }

    public static int pxToDp(float f) {
        return (int)(f / DENSITY + 0.5f);
    }

    public static void setFullScreen(Activity activity) {
        activity = activity.getWindow();
        activity.addFlags(512);
        activity.addFlags(1024);
    }

    public static int sp2px(Context context, int n) {
        double d = QMUIDisplayHelper.getFontDensity(context) * (float)n;
        Double.isNaN(d);
        return (int)(d + 0.5);
    }

    public static boolean vivoNavigationGestureEnabled(Context context) {
        context = context.getContentResolver();
        boolean bl = false;
        if (Settings.Secure.getInt((ContentResolver)context, (String)VIVO_NAVIGATION_GESTURE, (int)0) == 0) return bl;
        bl = true;
        return bl;
    }

    public static boolean xiaomiIsNotchSetToShowInSetting(Context context) {
        context = context.getContentResolver();
        boolean bl = false;
        if (Settings.Global.getInt((ContentResolver)context, (String)XIAOMI_DISPLAY_NOTCH_STATUS, (int)0) != 0) return bl;
        bl = true;
        return bl;
    }

    public static boolean xiaomiNavigationGestureEnabled(Context context) {
        context = context.getContentResolver();
        boolean bl = false;
        if (Settings.Global.getInt((ContentResolver)context, (String)XIAOMI_FULLSCREEN_GESTURE, (int)0) == 0) return bl;
        bl = true;
        return bl;
    }
}
