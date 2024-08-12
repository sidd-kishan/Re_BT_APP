/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Build$VERSION
 *  android.view.Window
 *  android.view.WindowManager$LayoutParams
 *  com.luck.picture.lib.immersive.RomUtils
 */
package com.luck.picture.lib.immersive;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import com.luck.picture.lib.immersive.RomUtils;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;

public class LightStatusBarUtils {
    private static void initStatusBarStyle(Activity activity, boolean bl, boolean bl2) {
        if (Build.VERSION.SDK_INT < 16) return;
        if (bl && bl2) {
            activity.getWindow().getDecorView().setSystemUiVisibility(256);
        } else if (!bl && !bl2) {
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        } else {
            if (bl) return;
            if (!bl2) return;
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        }
    }

    /*
     * Unable to fully structure code
     */
    private static void setAndroidNativeLightStatusBar(Activity var0, boolean var1_2, boolean var2_3, boolean var3_4, boolean var4_5) {
        if (!var3_4) ** GOTO lbl24
        try {
            block15: {
                var0 = var0.getWindow();
                if (Build.VERSION.SDK_INT < 21) return;
                if (var1_2 && var2_3) {
                    if (var4_5 && Build.VERSION.SDK_INT >= 23) {
                        var0.getDecorView().setSystemUiVisibility(8448);
                    } else {
                        var0.getDecorView().setSystemUiVisibility(256);
                    }
                } else if (!var1_2 && !var2_3) {
                    if (var4_5 && Build.VERSION.SDK_INT >= 23) {
                        var0.getDecorView().setSystemUiVisibility(9472);
                    } else {
                        var0.getDecorView().setSystemUiVisibility(1280);
                    }
                } else {
                    if (var1_2 != false) return;
                    if (var2_3 == false) return;
                    if (var4_5 && Build.VERSION.SDK_INT >= 23) {
                        var0.getDecorView().setSystemUiVisibility(9472);
                    } else {
                        var0.getDecorView().setSystemUiVisibility(1280);
                    }
                }
                break block15;
lbl24:
                // 1 sources

                var0 = var0.getWindow().getDecorView();
                if (var4_5 && Build.VERSION.SDK_INT >= 23) {
                    var0.setSystemUiVisibility(8192);
                } else {
                    var0.setSystemUiVisibility(0);
                }
            }
lbl30:
            // 2 sources

            return;
        }
        catch (Exception var0_1) {
            ** continue;
        }
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    private static boolean setFlymeLightStatusBar(Activity activity, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        boolean bl5 = true;
        boolean bl6 = true;
        if (activity == null) {
            return false;
        }
        LightStatusBarUtils.initStatusBarStyle(activity, bl, bl2);
        WindowManager.LayoutParams layoutParams = activity.getWindow().getAttributes();
        Field field = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
        Field field2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
        field.setAccessible(true);
        field2.setAccessible(true);
        int n = field.getInt(null);
        int n2 = field2.getInt(layoutParams);
        n2 = bl4 ? n | n2 : ~n & n2;
        field2.setInt(layoutParams, n2);
        activity.getWindow().setAttributes(layoutParams);
        boolean bl7 = bl5;
        if (RomUtils.getFlymeVersion() < 7) return bl7;
        LightStatusBarUtils.setAndroidNativeLightStatusBar(activity, bl, bl2, bl3, bl4);
        return bl5;
        catch (Exception exception) {
            block6: {
                bl7 = false;
                break block6;
                catch (Exception exception2) {
                    bl7 = bl6;
                }
            }
            LightStatusBarUtils.setAndroidNativeLightStatusBar(activity, bl, bl2, bl3, bl4);
            return bl7;
        }
    }

    public static void setLightStatusBar(Activity activity, boolean bl) {
        LightStatusBarUtils.setLightStatusBar(activity, false, false, false, bl);
    }

    public static void setLightStatusBar(Activity activity, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        int n = RomUtils.getLightStatausBarAvailableRomType();
        if (n != 1) {
            if (n != 2) {
                if (n != 3) return;
                LightStatusBarUtils.setAndroidNativeLightStatusBar(activity, bl, bl2, bl3, bl4);
            } else {
                LightStatusBarUtils.setFlymeLightStatusBar(activity, bl, bl2, bl3, bl4);
            }
        } else if (RomUtils.getMIUIVersionCode() >= 7) {
            LightStatusBarUtils.setAndroidNativeLightStatusBar(activity, bl, bl2, bl3, bl4);
        } else {
            LightStatusBarUtils.setMIUILightStatusBar(activity, bl, bl2, bl3, bl4);
        }
    }

    public static void setLightStatusBarAboveAPI23(Activity activity, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (Build.VERSION.SDK_INT < 23) return;
        LightStatusBarUtils.setLightStatusBar(activity, bl, bl2, bl3, bl4);
    }

    private static boolean setMIUILightStatusBar(Activity activity, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        LightStatusBarUtils.initStatusBarStyle(activity, bl, bl2);
        GenericDeclaration genericDeclaration = activity.getWindow().getClass();
        try {
            Window window = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int n = window.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(window);
            genericDeclaration = ((Class)genericDeclaration).getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            window = activity.getWindow();
            int n2 = bl4 ? n : 0;
            ((Method)genericDeclaration).invoke(window, n2, n);
            return true;
        }
        catch (Exception exception) {
            LightStatusBarUtils.setAndroidNativeLightStatusBar(activity, bl, bl2, bl3, bl4);
            return false;
        }
    }
}
