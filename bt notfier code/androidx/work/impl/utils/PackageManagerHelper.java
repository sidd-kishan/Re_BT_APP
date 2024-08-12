/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  androidx.work.Logger
 */
package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.work.Logger;

public class PackageManagerHelper {
    private static final String TAG = Logger.tagWithPrefix((String)"PackageManagerHelper");

    private PackageManagerHelper() {
    }

    public static boolean isComponentExplicitlyEnabled(Context context, Class<?> clazz) {
        return PackageManagerHelper.isComponentExplicitlyEnabled(context, clazz.getName());
    }

    public static boolean isComponentExplicitlyEnabled(Context context, String string) {
        int n = context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, string));
        boolean bl = true;
        if (n == 1) return bl;
        bl = false;
        return bl;
    }

    public static void setComponentEnabled(Context object, Class<?> object2, boolean bl) {
        String string = "enabled";
        try {
            PackageManager packageManager = object.getPackageManager();
            Object object3 = new ComponentName(object, ((Class)object2).getName());
            int n = bl ? 1 : 2;
            packageManager.setComponentEnabledSetting(object3, n, 1);
            packageManager = Logger.get();
            String string2 = TAG;
            object3 = ((Class)object2).getName();
            object = bl ? "enabled" : "disabled";
            packageManager.debug(string2, String.format("%s %s", object3, object), new Throwable[0]);
        }
        catch (Exception exception) {
            Logger logger = Logger.get();
            String string3 = TAG;
            object2 = ((Class)object2).getName();
            object = bl ? string : "disabled";
            logger.debug(string3, String.format("%s could not be %s", object2, object), new Throwable[]{exception});
        }
    }
}
