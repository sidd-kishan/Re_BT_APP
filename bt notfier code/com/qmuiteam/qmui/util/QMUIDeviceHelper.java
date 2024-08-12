/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AppOpsManager
 *  android.content.Context
 *  android.os.Binder
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.text.TextUtils
 *  com.qmuiteam.qmui.QMUILog
 *  com.qmuiteam.qmui.util.QMUILangHelper
 */
package com.qmuiteam.qmui.util;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.qmuiteam.qmui.QMUILog;
import com.qmuiteam.qmui.util.QMUILangHelper;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.regex.Pattern;

public class QMUIDeviceHelper {
    private static final String BRAND;
    private static final String ESSENTIAL = "essential";
    private static final String FLYME = "flyme";
    private static final String KEY_FLYME_VERSION_NAME = "ro.build.display.id";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String[] MEIZUBOARD;
    private static final String TAG = "QMUIDeviceHelper";
    private static final String ZTEC2016 = "zte c2016";
    private static final String ZUKZ1 = "zuk z1";
    private static String sFlymeVersionName;
    private static boolean sIsTabletChecked;
    private static boolean sIsTabletValue;
    private static String sMiuiVersionName;

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    static {
        Object object;
        Properties properties;
        block13: {
            MEIZUBOARD = new String[]{"m9", "M9", "mx", "MX"};
            sIsTabletChecked = false;
            sIsTabletValue = false;
            BRAND = Build.BRAND.toLowerCase();
            properties = new Properties();
            if (Build.VERSION.SDK_INT < 26) {
                void var0_5;
                Object object2;
                block12: {
                    block10: {
                        object2 = null;
                        File file = new File(Environment.getRootDirectory(), "build.prop");
                        object2 = object = new FileInputStream(file);
                        try {
                            void var2_10;
                            block11: {
                                try {
                                    properties.load((InputStream)object);
                                    break block10;
                                }
                                catch (Exception exception) {
                                    break block11;
                                }
                                catch (Throwable throwable) {
                                    break block12;
                                }
                                catch (Exception exception) {
                                    object = null;
                                }
                            }
                            object2 = object;
                            QMUILog.printErrStackTrace((String)TAG, (Throwable)var2_10, (String)"read file error", (Object[])new Object[0]);
                        }
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                    QMUILangHelper.close((Closeable)object);
                    break block13;
                }
                QMUILangHelper.close(object2);
                throw var0_5;
            }
        }
        try {
            object = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            sMiuiVersionName = QMUIDeviceHelper.getLowerCaseName(properties, (Method)object, KEY_MIUI_VERSION_NAME);
            sFlymeVersionName = QMUIDeviceHelper.getLowerCaseName(properties, (Method)object, KEY_FLYME_VERSION_NAME);
            return;
        }
        catch (Exception exception) {
            QMUILog.printErrStackTrace((String)TAG, (Throwable)exception, (String)"read SystemProperties error", (Object[])new Object[0]);
        }
    }

    private static boolean _isTablet(Context context) {
        boolean bl = (context.getResources().getConfiguration().screenLayout & 0xF) >= 3;
        return bl;
    }

    private static boolean checkOp(Context context, int n) {
        int n2 = Build.VERSION.SDK_INT;
        boolean bl = false;
        if (n2 < 19) return false;
        AppOpsManager appOpsManager = (AppOpsManager)context.getSystemService("appops");
        try {
            n = (Integer)appOpsManager.getClass().getDeclaredMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, n, Binder.getCallingUid(), context.getPackageName());
            if (n != 0) return bl;
            bl = true;
            return bl;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    private static String getLowerCaseName(Properties object, Method object2, String string) {
        String string2 = ((Properties)object).getProperty(string);
        object = string2;
        if (string2 == null) {
            try {
                object = (String)((Method)object2).invoke(null, string);
            }
            catch (Exception exception) {
                object = string2;
            }
        }
        object2 = object;
        if (object == null) return object2;
        object2 = ((String)object).toLowerCase();
        return object2;
    }

    public static boolean isEssentialPhone() {
        return BRAND.contains(ESSENTIAL);
    }

    public static boolean isFloatWindowOpAllowed(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return QMUIDeviceHelper.checkOp(context, 24);
        }
        boolean bl = false;
        try {
            int n = context.getApplicationInfo().flags;
            if ((n & 0x8000000) != 0x8000000) return bl;
            bl = true;
            return bl;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public static boolean isFlyme() {
        boolean bl = !TextUtils.isEmpty((CharSequence)sFlymeVersionName) && sFlymeVersionName.contains(FLYME);
        return bl;
    }

    /*
     * Unable to fully structure code
     */
    public static boolean isFlymeVersionHigher5_2_4() {
        var3 = QMUIDeviceHelper.sFlymeVersionName;
        var2_1 = false;
        if (var3 == null || var3.equals("") || !(var3 = Pattern.compile("(\\d+\\.){2}\\d").matcher(QMUIDeviceHelper.sFlymeVersionName)).find() || (var3 = var3.group()) == null || var3.equals("") || (var3 = var3.split("\\.")).length != 3) ** GOTO lbl15
        if (Integer.valueOf(var3[0]) < 5) ** GOTO lbl-1000
        if (Integer.valueOf(var3[0]) > 5) ** GOTO lbl15
        if (Integer.valueOf(var3[1]) >= 2) {
            if (Integer.valueOf(var3[1]) <= 2) {
                ** if (Integer.valueOf((String)var3[2]).intValue() >= 4) goto lbl-1000
            } else {
                ** GOTO lbl10
            }
        }
        ** GOTO lbl-1000
lbl10:
        // 2 sources

        ** GOTO lbl15
lbl-1000:
        // 3 sources

        {
            var0_2 = false;
            ** GOTO lbl16
        }
lbl-1000:
        // 1 sources

        {
            Integer.valueOf(var3[2]).intValue();
lbl15:
            // 4 sources

            var0_2 = true;
        }
lbl16:
        // 2 sources

        var1_3 = var2_1;
        if (QMUIDeviceHelper.isMeizu() == false) return var1_3;
        var1_3 = var2_1;
        if (var0_2 == false) return var1_3;
        var1_3 = true;
        return var1_3;
    }

    public static boolean isHuawei() {
        boolean bl = BRAND.contains("huawei") || BRAND.contains("honor");
        return bl;
    }

    public static boolean isMIUI() {
        return TextUtils.isEmpty((CharSequence)sMiuiVersionName) ^ true;
    }

    public static boolean isMIUIV5() {
        return "v5".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV6() {
        return "v6".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV7() {
        return "v7".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV8() {
        return "v8".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV9() {
        return "v9".equals(sMiuiVersionName);
    }

    public static boolean isMeizu() {
        boolean bl = QMUIDeviceHelper.isPhone(MEIZUBOARD) || QMUIDeviceHelper.isFlyme();
        return bl;
    }

    public static boolean isOppo() {
        return BRAND.contains("oppo");
    }

    private static boolean isPhone(String[] stringArray) {
        String string = Build.BOARD;
        if (string == null) {
            return false;
        }
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            if (string.equals(stringArray[n2])) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public static boolean isTablet(Context context) {
        boolean bl;
        if (sIsTabletChecked) {
            return sIsTabletValue;
        }
        sIsTabletValue = bl = QMUIDeviceHelper._isTablet(context);
        sIsTabletChecked = true;
        return bl;
    }

    public static boolean isVivo() {
        boolean bl = BRAND.contains("vivo") || BRAND.contains("bbk");
        return bl;
    }

    public static boolean isXiaomi() {
        return Build.MANUFACTURER.toLowerCase().equals("xiaomi");
    }

    public static boolean isZTKC2016() {
        String string = Build.MODEL;
        boolean bl = string != null && string.toLowerCase().contains(ZTEC2016);
        return bl;
    }

    public static boolean isZUKZ1() {
        String string = Build.MODEL;
        boolean bl = string != null && string.toLowerCase().contains(ZUKZ1);
        return bl;
    }
}
