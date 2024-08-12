/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  com.luck.picture.lib.tools.StringUtils
 *  com.luck.picture.lib.tools.ValueOf
 */
package com.luck.picture.lib.immersive;

import android.os.Build;
import android.text.TextUtils;
import com.luck.picture.lib.tools.StringUtils;
import com.luck.picture.lib.tools.ValueOf;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class RomUtils {
    private static Integer romType;

    public static int getFlymeVersion() {
        String string = Build.DISPLAY;
        if (TextUtils.isEmpty((CharSequence)string)) return 0;
        if (!string.contains("Flyme")) return 0;
        return StringUtils.stringToInt((String)string.replaceAll("Flyme", "").replaceAll("OS", "").replaceAll(" ", "").substring(0, 1));
    }

    public static int getLightStatausBarAvailableRomType() {
        Integer n = romType;
        if (n != null) {
            return n;
        }
        if (RomUtils.isMIUIV6OrAbove()) {
            romType = n = Integer.valueOf(1);
            return n;
        }
        if (RomUtils.isFlymeV4OrAbove()) {
            romType = n = Integer.valueOf(2);
            return n;
        }
        if (RomUtils.isAndroid5OrAbove()) {
            romType = n = Integer.valueOf(3);
            return n;
        }
        romType = n = Integer.valueOf(4);
        return n;
    }

    public static int getMIUIVersionCode() {
        String string = RomUtils.getSystemProperty("ro.miui.ui.version.code");
        if (TextUtils.isEmpty((CharSequence)string)) return 0;
        try {
            int n = ValueOf.toInt((Object)string);
            return n;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /*
     * WARNING - void declaration
     */
    public static String getSystemProperty(String object) {
        block13: {
            void var1_10;
            block12: {
                Object object2;
                Object var2_5 = null;
                try {
                    object2 = Runtime.getRuntime();
                    Object object3 = new StringBuilder();
                    ((StringBuilder)object3).append("getprop ");
                    ((StringBuilder)object3).append((String)object);
                    object2 = ((Runtime)object2).exec(((StringBuilder)object3).toString());
                    object3 = new InputStreamReader(((Process)object2).getInputStream());
                    object = new BufferedReader((Reader)object3, 1024);
                }
                catch (Throwable throwable) {
                    object = var2_5;
                    break block12;
                }
                catch (IOException iOException) {
                    object = null;
                    break block13;
                }
                try {
                    object2 = ((BufferedReader)object).readLine();
                    ((BufferedReader)object).close();
                }
                catch (Throwable throwable) {
                    break block12;
                }
                catch (IOException iOException) {
                    break block13;
                }
                try {
                    ((BufferedReader)object).close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                return object2;
            }
            if (object == null) throw var1_10;
            try {
                ((BufferedReader)object).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            throw var1_10;
        }
        if (object == null) return null;
        try {
            ((BufferedReader)object).close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return null;
    }

    private static boolean isAndroid5OrAbove() {
        if (Build.VERSION.SDK_INT < 21) return false;
        return true;
    }

    private static boolean isFlymeV4OrAbove() {
        boolean bl = RomUtils.getFlymeVersion() >= 4;
        return bl;
    }

    private static boolean isMIUIV6OrAbove() {
        String string = RomUtils.getSystemProperty("ro.miui.ui.version.code");
        if (TextUtils.isEmpty((CharSequence)string)) return false;
        try {
            int n = ValueOf.toInt((Object)string);
            if (n < 4) return false;
            return true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
