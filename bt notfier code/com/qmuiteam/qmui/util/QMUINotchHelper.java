/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.View
 *  android.view.WindowManager
 *  com.qmuiteam.qmui.util.QMUIDeviceHelper
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.util.QMUIStatusBarHelper
 */
package com.qmuiteam.qmui.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import com.qmuiteam.qmui.util.QMUIDeviceHelper;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

public class QMUINotchHelper {
    private static final String MIUI_NOTCH = "ro.miui.notch";
    private static final int NOTCH_IN_SCREEN_VOIO = 32;
    private static final String TAG = "QMUINotchHelper";
    private static Boolean sHasNotch;
    private static Boolean sHuaweiIsNotchSetToShow;
    private static int[] sNotchSizeInHawei;
    private static Rect sRotation0SafeInset;
    private static Rect sRotation180SafeInset;
    private static Rect sRotation270SafeInset;
    private static Rect sRotation90SafeInset;

    private static boolean attachHasOfficialNotch(View view) {
        view = view.getRootWindowInsets();
        boolean bl = false;
        if (view == null) return false;
        if (view.getDisplayCutout() != null) {
            bl = true;
        }
        sHasNotch = bl;
        return true;
    }

    private static void clearAllRectInfo() {
        sRotation0SafeInset = null;
        sRotation90SafeInset = null;
        sRotation180SafeInset = null;
        sRotation270SafeInset = null;
    }

    private static void clearLandscapeRectInfo() {
        sRotation90SafeInset = null;
        sRotation270SafeInset = null;
    }

    private static void clearPortraitRectInfo() {
        sRotation0SafeInset = null;
        sRotation180SafeInset = null;
    }

    private static Rect get3rdSafeInsetRect(Context context) {
        int n;
        if (QMUIDeviceHelper.isHuawei()) {
            boolean bl = QMUIDisplayHelper.huaweiIsNotchSetToShowInSetting((Context)context);
            Boolean bl2 = sHuaweiIsNotchSetToShow;
            if (bl2 != null && bl2 != bl) {
                QMUINotchHelper.clearLandscapeRectInfo();
            }
            sHuaweiIsNotchSetToShow = bl;
        }
        if ((n = QMUINotchHelper.getScreenRotation(context)) == 1) {
            if (sRotation90SafeInset != null) return sRotation90SafeInset;
            sRotation90SafeInset = QMUINotchHelper.getRectInfoRotation90(context);
            return sRotation90SafeInset;
        }
        if (n == 2) {
            if (sRotation180SafeInset != null) return sRotation180SafeInset;
            sRotation180SafeInset = QMUINotchHelper.getRectInfoRotation180(context);
            return sRotation180SafeInset;
        }
        if (n == 3) {
            if (sRotation270SafeInset != null) return sRotation270SafeInset;
            sRotation270SafeInset = QMUINotchHelper.getRectInfoRotation270(context);
            return sRotation270SafeInset;
        }
        if (sRotation0SafeInset != null) return sRotation0SafeInset;
        sRotation0SafeInset = QMUINotchHelper.getRectInfoRotation0(context);
        return sRotation0SafeInset;
    }

    public static int getNotchHeightInVivo(Context context) {
        return QMUIDisplayHelper.dp2px((Context)context, (int)27);
    }

    public static int getNotchHeightInXiaomi(Context context) {
        int n = context.getResources().getIdentifier("notch_height", "dimen", "android");
        if (n <= 0) return QMUIDisplayHelper.getStatusBarHeight((Context)context);
        return context.getResources().getDimensionPixelSize(n);
    }

    public static int[] getNotchSizeInHuawei(Context object) {
        if (sNotchSizeInHawei != null) return sNotchSizeInHawei;
        sNotchSizeInHawei = new int[]{0, 0};
        try {
            object = object.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            sNotchSizeInHawei = (int[])((Class)object).getMethod("getNotchSize", new Class[0]).invoke(object, new Object[0]);
        }
        catch (Exception exception) {
            Log.e((String)TAG, (String)"getNotchSizeInHuawei Exception");
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Log.e((String)TAG, (String)"getNotchSizeInHuawei NoSuchMethodException");
        }
        catch (ClassNotFoundException classNotFoundException) {
            Log.e((String)TAG, (String)"getNotchSizeInHuawei ClassNotFoundException");
        }
        return sNotchSizeInHawei;
    }

    public static int getNotchWidthInVivo(Context context) {
        return QMUIDisplayHelper.dp2px((Context)context, (int)100);
    }

    public static int getNotchWidthInXiaomi(Context context) {
        int n = context.getResources().getIdentifier("notch_width", "dimen", "android");
        if (n <= 0) return -1;
        return context.getResources().getDimensionPixelSize(n);
    }

    private static void getOfficialSafeInsetRect(View view, Rect rect) {
        if (view == null) {
            return;
        }
        if ((view = view.getRootWindowInsets()) == null) {
            return;
        }
        if ((view = view.getDisplayCutout()) == null) return;
        rect.set(view.getSafeInsetLeft(), view.getSafeInsetTop(), view.getSafeInsetRight(), view.getSafeInsetBottom());
    }

    private static Rect getRectInfoRotation0(Context context) {
        Rect rect = new Rect();
        if (QMUIDeviceHelper.isVivo()) {
            rect.top = QMUINotchHelper.getNotchHeightInVivo(context);
            rect.bottom = 0;
        } else if (QMUIDeviceHelper.isOppo()) {
            rect.top = QMUIStatusBarHelper.getStatusbarHeight((Context)context);
            rect.bottom = 0;
        } else if (QMUIDeviceHelper.isHuawei()) {
            rect.top = QMUINotchHelper.getNotchSizeInHuawei(context)[1];
            rect.bottom = 0;
        } else {
            if (!QMUIDeviceHelper.isXiaomi()) return rect;
            rect.top = QMUINotchHelper.getNotchHeightInXiaomi(context);
            rect.bottom = 0;
        }
        return rect;
    }

    private static Rect getRectInfoRotation180(Context object) {
        Rect rect = new Rect();
        if (QMUIDeviceHelper.isVivo()) {
            rect.top = 0;
            rect.bottom = QMUINotchHelper.getNotchHeightInVivo(object);
        } else if (QMUIDeviceHelper.isOppo()) {
            rect.top = 0;
            rect.bottom = QMUIStatusBarHelper.getStatusbarHeight((Context)object);
        } else if (QMUIDeviceHelper.isHuawei()) {
            object = QMUINotchHelper.getNotchSizeInHuawei(object);
            rect.top = 0;
            rect.bottom = (int)object[1];
        } else {
            if (!QMUIDeviceHelper.isXiaomi()) return rect;
            rect.top = 0;
            rect.bottom = QMUINotchHelper.getNotchHeightInXiaomi(object);
        }
        return rect;
    }

    private static Rect getRectInfoRotation270(Context context) {
        Rect rect = new Rect();
        if (QMUIDeviceHelper.isVivo()) {
            rect.right = QMUINotchHelper.getNotchHeightInVivo(context);
            rect.left = 0;
        } else if (QMUIDeviceHelper.isOppo()) {
            rect.right = QMUIStatusBarHelper.getStatusbarHeight((Context)context);
            rect.left = 0;
        } else if (QMUIDeviceHelper.isHuawei()) {
            rect.right = sHuaweiIsNotchSetToShow != false ? QMUINotchHelper.getNotchSizeInHuawei(context)[1] : 0;
            rect.left = 0;
        } else {
            if (!QMUIDeviceHelper.isXiaomi()) return rect;
            rect.right = QMUINotchHelper.getNotchHeightInXiaomi(context);
            rect.left = 0;
        }
        return rect;
    }

    private static Rect getRectInfoRotation90(Context context) {
        Rect rect = new Rect();
        if (QMUIDeviceHelper.isVivo()) {
            rect.left = QMUINotchHelper.getNotchHeightInVivo(context);
            rect.right = 0;
        } else if (QMUIDeviceHelper.isOppo()) {
            rect.left = QMUIStatusBarHelper.getStatusbarHeight((Context)context);
            rect.right = 0;
        } else if (QMUIDeviceHelper.isHuawei()) {
            rect.left = sHuaweiIsNotchSetToShow != false ? QMUINotchHelper.getNotchSizeInHuawei(context)[1] : 0;
            rect.right = 0;
        } else {
            if (!QMUIDeviceHelper.isXiaomi()) return rect;
            rect.left = QMUINotchHelper.getNotchHeightInXiaomi(context);
            rect.right = 0;
        }
        return rect;
    }

    public static int getSafeInsetBottom(Activity activity) {
        if (QMUINotchHelper.hasNotch(activity)) return QMUINotchHelper.getSafeInsetRect((Activity)activity).bottom;
        return 0;
    }

    public static int getSafeInsetBottom(View view) {
        if (QMUINotchHelper.hasNotch(view)) return QMUINotchHelper.getSafeInsetRect((View)view).bottom;
        return 0;
    }

    public static int getSafeInsetLeft(Activity activity) {
        if (QMUINotchHelper.hasNotch(activity)) return QMUINotchHelper.getSafeInsetRect((Activity)activity).left;
        return 0;
    }

    public static int getSafeInsetLeft(View view) {
        if (QMUINotchHelper.hasNotch(view)) return QMUINotchHelper.getSafeInsetRect((View)view).left;
        return 0;
    }

    private static Rect getSafeInsetRect(Activity activity) {
        if (!QMUINotchHelper.isNotchOfficialSupport()) return QMUINotchHelper.get3rdSafeInsetRect((Context)activity);
        Rect rect = new Rect();
        QMUINotchHelper.getOfficialSafeInsetRect(activity.getWindow().getDecorView(), rect);
        return rect;
    }

    private static Rect getSafeInsetRect(View view) {
        if (!QMUINotchHelper.isNotchOfficialSupport()) return QMUINotchHelper.get3rdSafeInsetRect(view.getContext());
        Rect rect = new Rect();
        QMUINotchHelper.getOfficialSafeInsetRect(view, rect);
        return rect;
    }

    public static int getSafeInsetRight(Activity activity) {
        if (QMUINotchHelper.hasNotch(activity)) return QMUINotchHelper.getSafeInsetRect((Activity)activity).right;
        return 0;
    }

    public static int getSafeInsetRight(View view) {
        if (QMUINotchHelper.hasNotch(view)) return QMUINotchHelper.getSafeInsetRect((View)view).right;
        return 0;
    }

    public static int getSafeInsetTop(Activity activity) {
        if (QMUINotchHelper.hasNotch(activity)) return QMUINotchHelper.getSafeInsetRect((Activity)activity).top;
        return 0;
    }

    public static int getSafeInsetTop(View view) {
        if (QMUINotchHelper.hasNotch(view)) return QMUINotchHelper.getSafeInsetRect((View)view).top;
        return 0;
    }

    private static int getScreenRotation(Context context) {
        if ((context = (WindowManager)context.getSystemService("window")) == null) {
            return 0;
        }
        if ((context = context.getDefaultDisplay()) != null) return context.getRotation();
        return 0;
    }

    public static boolean has3rdNotch(Context context) {
        if (QMUIDeviceHelper.isHuawei()) {
            return QMUINotchHelper.hasNotchInHuawei(context);
        }
        if (QMUIDeviceHelper.isVivo()) {
            return QMUINotchHelper.hasNotchInVivo(context);
        }
        if (QMUIDeviceHelper.isOppo()) {
            return QMUINotchHelper.hasNotchInOppo(context);
        }
        if (!QMUIDeviceHelper.isXiaomi()) return false;
        return QMUINotchHelper.hasNotchInXiaomi(context);
    }

    public static boolean hasNotch(Activity activity) {
        if (sHasNotch != null) return sHasNotch;
        if (!QMUINotchHelper.isNotchOfficialSupport()) {
            sHasNotch = QMUINotchHelper.has3rdNotch((Context)activity);
            return sHasNotch;
        }
        if ((activity = activity.getWindow()) == null) {
            return false;
        }
        if ((activity = activity.getDecorView()) == null) {
            return false;
        }
        if (QMUINotchHelper.attachHasOfficialNotch((View)activity)) return sHasNotch;
        return false;
    }

    public static boolean hasNotch(View view) {
        if (sHasNotch != null) return sHasNotch;
        if (QMUINotchHelper.isNotchOfficialSupport()) {
            if (QMUINotchHelper.attachHasOfficialNotch(view)) return sHasNotch;
            return false;
        }
        sHasNotch = QMUINotchHelper.has3rdNotch(view.getContext());
        return sHasNotch;
    }

    public static boolean hasNotchInHuawei(Context object) {
        boolean bl = false;
        try {
            boolean bl2;
            object = object.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            bl = bl2 = ((Boolean)((Class)object).getMethod("hasNotchInScreen", new Class[0]).invoke(object, new Object[0])).booleanValue();
        }
        catch (Exception exception) {
            Log.e((String)TAG, (String)"hasNotchInHuawei Exception");
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Log.e((String)TAG, (String)"hasNotchInHuawei NoSuchMethodException");
        }
        catch (ClassNotFoundException classNotFoundException) {
            Log.i((String)TAG, (String)"hasNotchInHuawei ClassNotFoundException");
        }
        return bl;
    }

    public static boolean hasNotchInOppo(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    public static boolean hasNotchInVivo(Context methodArray) {
        boolean bl = false;
        try {
            Class<?> clazz = methodArray.getClassLoader().loadClass("android.util.FtFeature");
            methodArray = clazz.getDeclaredMethods();
            boolean bl2 = bl;
            if (methodArray == null) return bl2;
            int n = 0;
            while (true) {
                bl2 = bl;
                if (n >= methodArray.length) return bl2;
                Method method = methodArray[n];
                if (method.getName().equalsIgnoreCase("isFeatureSupport")) {
                    return (Boolean)method.invoke(clazz, 32);
                }
                ++n;
            }
        }
        catch (Exception exception) {
            Log.e((String)TAG, (String)"hasNotchInVivo Exception");
            return bl;
        }
        catch (ClassNotFoundException classNotFoundException) {
            Log.i((String)TAG, (String)"hasNotchInVivo ClassNotFoundException");
            return bl;
        }
    }

    public static boolean hasNotchInXiaomi(Context object) {
        boolean bl = false;
        try {
            object = Class.forName("android.os.SystemProperties").getDeclaredMethod("getInt", String.class, Integer.TYPE);
            ((AccessibleObject)object).setAccessible(true);
            int n = (Integer)((Method)object).invoke(null, MIUI_NOTCH, 0);
            if (n != 1) return bl;
            bl = true;
            return bl;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public static boolean isNotchOfficialSupport() {
        boolean bl = Build.VERSION.SDK_INT >= 28;
        return bl;
    }

    public static boolean needFixLandscapeNotchAreaFitSystemWindow(View view) {
        boolean bl = QMUIDeviceHelper.isXiaomi() && QMUINotchHelper.hasNotch(view);
        return bl;
    }
}
