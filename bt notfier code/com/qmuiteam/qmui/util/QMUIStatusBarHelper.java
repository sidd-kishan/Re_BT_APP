/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.Window
 *  android.view.WindowManager$LayoutParams
 *  androidx.core.view.ViewCompat
 *  com.qmuiteam.qmui.util.QMUIDeviceHelper
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.util.QMUINotchHelper
 */
package com.qmuiteam.qmui.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.util.QMUIDeviceHelper;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUINotchHelper;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;

public class QMUIStatusBarHelper {
    private static final int STATUSBAR_TYPE_ANDROID6 = 3;
    private static final int STATUSBAR_TYPE_DEFAULT = 0;
    private static final int STATUSBAR_TYPE_FLYME = 2;
    private static final int STATUSBAR_TYPE_MIUI = 1;
    private static final int STATUS_BAR_DEFAULT_HEIGHT_DP = 25;
    private static int mStatuBarType = 0;
    private static int sStatusbarHeight = -1;
    private static Integer sTransparentValue;
    public static float sVirtualDensity = -1.0f;
    public static float sVirtualDensityDpi = -1.0f;

    private static boolean Android6SetStatusBarLightMode(Window window, boolean bl) {
        View view = window.getDecorView();
        int n = bl ? 8192 : 256;
        view.setSystemUiVisibility(QMUIStatusBarHelper.changeStatusBarModeRetainFlag(window, n));
        if (!QMUIDeviceHelper.isMIUIV9()) return true;
        QMUIStatusBarHelper.MIUISetStatusBarLightMode(window, bl);
        return true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public static boolean FlymeSetStatusBarLightMode(Window window, boolean bl) {
        int n;
        Field field;
        WindowManager.LayoutParams layoutParams;
        boolean bl2 = true;
        if (window == null) return false;
        QMUIStatusBarHelper.Android6SetStatusBarLightMode(window, bl);
        try {
            layoutParams = window.getAttributes();
            Field field2 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            field = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            field2.setAccessible(true);
            field.setAccessible(true);
            n = field2.getInt(null);
            int n2 = field.getInt(layoutParams);
            n = bl ? n2 | n : ~n & n2;
        }
        catch (Exception exception) {
            return false;
        }
        {
            field.setInt(layoutParams, n);
            window.setAttributes(layoutParams);
            return bl2;
        }
    }

    public static boolean MIUISetStatusBarLightMode(Window window, boolean bl) {
        boolean bl2 = true;
        if (window != null) {
            GenericDeclaration genericDeclaration = window.getClass();
            try {
                Class<?> clazz = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int n = clazz.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(clazz);
                genericDeclaration = ((Class)genericDeclaration).getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                if (bl) {
                    ((Method)genericDeclaration).invoke(window, n, n);
                    bl = bl2;
                } else {
                    ((Method)genericDeclaration).invoke(window, 0, n);
                    bl = bl2;
                }
            }
            catch (Exception exception) {}
        }
        bl = false;
        return bl;
    }

    static /* synthetic */ void access$000(Window window, View view) {
        QMUIStatusBarHelper.realHandleDisplayCutoutMode(window, view);
    }

    private static int changeStatusBarModeRetainFlag(Window window, int n) {
        return QMUIStatusBarHelper.retainSystemUiFlag(window, QMUIStatusBarHelper.retainSystemUiFlag(window, QMUIStatusBarHelper.retainSystemUiFlag(window, QMUIStatusBarHelper.retainSystemUiFlag(window, QMUIStatusBarHelper.retainSystemUiFlag(window, QMUIStatusBarHelper.retainSystemUiFlag(window, n, 1024), 4), 2), 4096), 1024), 512);
    }

    public static Integer getStatusBarAPITransparentValue(Context object) {
        String[] stringArray = sTransparentValue;
        if (stringArray != null) {
            return stringArray;
        }
        stringArray = object.getPackageManager().getSystemSharedLibraryNames();
        int n = stringArray.length;
        object = null;
        for (int i = 0; i < n; ++i) {
            String string = stringArray[i];
            if ("touchwiz".equals(string)) {
                object = "SYSTEM_UI_FLAG_TRANSPARENT_BACKGROUND";
                continue;
            }
            if (!string.startsWith("com.sonyericsson.navigationbar")) continue;
            object = "SYSTEM_UI_FLAG_TRANSPARENT";
        }
        if (object == null) return sTransparentValue;
        try {
            object = View.class.getField((String)object);
            if (object == null) return sTransparentValue;
            if (((Field)object).getType() != Integer.TYPE) return sTransparentValue;
            sTransparentValue = ((Field)object).getInt(null);
        }
        catch (Exception exception) {}
        return sTransparentValue;
    }

    public static int getStatusbarHeight(Context context) {
        if (sStatusbarHeight != -1) return sStatusbarHeight;
        QMUIStatusBarHelper.initStatusBarHeight(context);
        return sStatusbarHeight;
    }

    private static void handleDisplayCutoutMode(Window window) {
        View view = window.getDecorView();
        if (view == null) return;
        if (ViewCompat.isAttachedToWindow((View)view)) {
            QMUIStatusBarHelper.realHandleDisplayCutoutMode(window, view);
        } else {
            view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private static void initStatusBarHeight(Context var0) {
        block13: {
            block14: {
                var7_1 = null;
                var5_3 = null;
                var8_5 = null;
                var9_6 = Class.forName("com.android.internal.R$dimen");
                var6_7 /* !! */  = var9_6.newInstance();
                var4_9 = var7_1;
                var3_11 = QMUIDeviceHelper.isMeizu();
                var4_9 = var8_5;
                if (!var3_11) ** GOTO lbl20
                try {
                    var4_9 = var9_6.getField("status_bar_height_large");
                    ** GOTO lbl20
                }
                catch (Throwable var5_4) {
                    var4_9 = var7_1;
                    try {
                        var5_4.printStackTrace();
                        var4_9 = var8_5;
lbl20:
                        // 3 sources

                        var5_3 = var4_9;
                        var7_1 = var6_7 /* !! */ ;
                        if (var4_9 == null) {
                            var5_3 = var9_6.getField("status_bar_height");
                            var7_1 = var6_7 /* !! */ ;
                        }
                        break block13;
                    }
                    catch (Throwable var7_2) {
                        var5_3 = (Field)var6_7 /* !! */ ;
                        var6_7 /* !! */  = var7_2;
                    }
                }
                break block14;
                catch (Throwable var6_8) {
                    var4_9 = null;
                }
            }
            var6_7 /* !! */ .printStackTrace();
            var7_1 = var5_3;
            var5_3 = var4_9;
        }
        if (var5_3 != null && var7_1 != null) {
            try {
                var2_12 = Integer.parseInt(var5_3.get(var7_1).toString());
                QMUIStatusBarHelper.sStatusbarHeight = var0.getResources().getDimensionPixelSize(var2_12);
            }
            catch (Throwable var4_10) {
                var4_10.printStackTrace();
            }
        }
        if (QMUIDeviceHelper.isTablet((Context)var0) && QMUIStatusBarHelper.sStatusbarHeight > QMUIDisplayHelper.dp2px((Context)var0, (int)25)) {
            QMUIStatusBarHelper.sStatusbarHeight = 0;
            return;
        }
        if (QMUIStatusBarHelper.sStatusbarHeight > 0) return;
        var1_13 = QMUIStatusBarHelper.sVirtualDensity;
        if (var1_13 == -1.0f) {
            QMUIStatusBarHelper.sStatusbarHeight = QMUIDisplayHelper.dp2px((Context)var0, (int)25);
            return;
        }
        QMUIStatusBarHelper.sStatusbarHeight = (int)(var1_13 * 25.0f + 0.5f);
    }

    public static boolean isFullScreen(Activity activity) {
        boolean bl = false;
        try {
            int n = activity.getWindow().getAttributes().flags;
            if ((n & 0x400) == 0) return bl;
            bl = true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return bl;
    }

    private static boolean isMIUICustomStatusBarLightModeImpl() {
        boolean bl = QMUIDeviceHelper.isMIUIV9();
        boolean bl2 = true;
        if (bl && Build.VERSION.SDK_INT < 23) {
            return true;
        }
        bl = bl2;
        if (QMUIDeviceHelper.isMIUIV5()) return bl;
        bl = bl2;
        if (QMUIDeviceHelper.isMIUIV6()) return bl;
        bl = bl2;
        if (QMUIDeviceHelper.isMIUIV7()) return bl;
        bl = QMUIDeviceHelper.isMIUIV8() ? bl2 : false;
        return bl;
    }

    private static void realHandleDisplayCutoutMode(Window window, View view) {
        if (view.getRootWindowInsets() == null) return;
        if (view.getRootWindowInsets().getDisplayCutout() == null) return;
        view = window.getAttributes();
        view.layoutInDisplayCutoutMode = 1;
        window.setAttributes((WindowManager.LayoutParams)view);
    }

    public static int retainSystemUiFlag(Window window, int n, int n2) {
        int n3 = n;
        if ((window.getDecorView().getSystemUiVisibility() & n2) != n2) return n3;
        n3 = n | n2;
        return n3;
    }

    public static boolean setStatusBarDarkMode(Activity activity) {
        if (activity == null) {
            return false;
        }
        int n = mStatuBarType;
        if (n == 0) {
            return true;
        }
        if (n == 1) {
            return QMUIStatusBarHelper.MIUISetStatusBarLightMode(activity.getWindow(), false);
        }
        if (n == 2) {
            return QMUIStatusBarHelper.FlymeSetStatusBarLightMode(activity.getWindow(), false);
        }
        if (n != 3) return true;
        return QMUIStatusBarHelper.Android6SetStatusBarLightMode(activity.getWindow(), false);
    }

    public static boolean setStatusBarLightMode(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (QMUIDeviceHelper.isZTKC2016()) {
            return false;
        }
        int n = mStatuBarType;
        if (n != 0) {
            return QMUIStatusBarHelper.setStatusBarLightMode(activity, n);
        }
        if (Build.VERSION.SDK_INT < 19) return false;
        if (QMUIStatusBarHelper.isMIUICustomStatusBarLightModeImpl() && QMUIStatusBarHelper.MIUISetStatusBarLightMode(activity.getWindow(), true)) {
            mStatuBarType = 1;
            return true;
        }
        if (QMUIStatusBarHelper.FlymeSetStatusBarLightMode(activity.getWindow(), true)) {
            mStatuBarType = 2;
            return true;
        }
        if (Build.VERSION.SDK_INT < 23) return false;
        QMUIStatusBarHelper.Android6SetStatusBarLightMode(activity.getWindow(), true);
        mStatuBarType = 3;
        return true;
    }

    private static boolean setStatusBarLightMode(Activity activity, int n) {
        if (n == 1) {
            return QMUIStatusBarHelper.MIUISetStatusBarLightMode(activity.getWindow(), true);
        }
        if (n == 2) {
            return QMUIStatusBarHelper.FlymeSetStatusBarLightMode(activity.getWindow(), true);
        }
        if (n != 3) return false;
        return QMUIStatusBarHelper.Android6SetStatusBarLightMode(activity.getWindow(), true);
    }

    public static void setVirtualDensity(float f) {
        sVirtualDensity = f;
    }

    public static void setVirtualDensityDpi(float f) {
        sVirtualDensityDpi = f;
    }

    public static boolean supportTransclentStatusBar6() {
        boolean bl = !QMUIDeviceHelper.isZUKZ1() && !QMUIDeviceHelper.isZTKC2016();
        return bl;
    }

    private static boolean supportTranslucent() {
        boolean bl = Build.VERSION.SDK_INT >= 19 && (!QMUIDeviceHelper.isEssentialPhone() || Build.VERSION.SDK_INT >= 26);
        return bl;
    }

    public static void translucent(Activity activity) {
        QMUIStatusBarHelper.translucent(activity.getWindow());
    }

    public static void translucent(Activity activity, int n) {
        QMUIStatusBarHelper.translucent(activity.getWindow(), n);
    }

    public static void translucent(Window window) {
        QMUIStatusBarHelper.translucent(window, 0x40000000);
    }

    public static void translucent(Window window, int n) {
        if (!QMUIStatusBarHelper.supportTranslucent()) {
            return;
        }
        if (QMUINotchHelper.isNotchOfficialSupport()) {
            QMUIStatusBarHelper.handleDisplayCutoutMode(window);
        }
        if (!(QMUIDeviceHelper.isMeizu() || QMUIDeviceHelper.isMIUI() && Build.VERSION.SDK_INT < 23)) {
            if (Build.VERSION.SDK_INT < 21) return;
            window.getDecorView().setSystemUiVisibility(1280);
            if (Build.VERSION.SDK_INT >= 23 && QMUIStatusBarHelper.supportTransclentStatusBar6()) {
                window.clearFlags(0x4000000);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
            } else {
                window.clearFlags(0x4000000);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(n);
            }
            return;
        }
        window.setFlags(0x4000000, 0x4000000);
    }
}
