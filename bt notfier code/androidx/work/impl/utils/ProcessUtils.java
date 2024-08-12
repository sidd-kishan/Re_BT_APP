/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.app.Application
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Process
 *  android.text.TextUtils
 *  androidx.work.Configuration
 *  androidx.work.Logger
 */
package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Logger;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;

public class ProcessUtils {
    private static final String TAG = Logger.tagWithPrefix((String)"ProcessUtils");

    private ProcessUtils() {
    }

    public static String getProcessName(Context object) {
        Object object2;
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        try {
            GenericDeclaration genericDeclaration = Class.forName("android.app.ActivityThread", false, ProcessUtils.class.getClassLoader());
            if (Build.VERSION.SDK_INT >= 18) {
                object2 = ((Class)genericDeclaration).getDeclaredMethod("currentProcessName", new Class[0]);
                ((AccessibleObject)object2).setAccessible(true);
                object2 = ((Method)object2).invoke(null, new Object[0]);
            } else {
                object2 = ((Class)genericDeclaration).getDeclaredMethod("currentActivityThread", new Class[0]);
                ((AccessibleObject)object2).setAccessible(true);
                genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod("getProcessName", new Class[0]);
                ((AccessibleObject)((Object)genericDeclaration)).setAccessible(true);
                object2 = ((Method)genericDeclaration).invoke(((Method)object2).invoke(null, new Object[0]), new Object[0]);
            }
            if (object2 instanceof String) {
                object2 = (String)object2;
                return object2;
            }
        }
        catch (Throwable throwable) {
            Logger.get().debug(TAG, "Unable to check ActivityThread for processName", new Throwable[]{throwable});
        }
        int n = Process.myPid();
        if ((object = (ActivityManager)object.getSystemService("activity")) == null) return null;
        if ((object = object.getRunningAppProcesses()) == null) return null;
        if (object.isEmpty()) return null;
        object2 = object.iterator();
        do {
            if (!object2.hasNext()) return null;
            object = (ActivityManager.RunningAppProcessInfo)object2.next();
        } while (((ActivityManager.RunningAppProcessInfo)object).pid != n);
        return ((ActivityManager.RunningAppProcessInfo)object).processName;
    }

    public static boolean isDefaultProcess(Context context, Configuration configuration) {
        String string = ProcessUtils.getProcessName(context);
        if (TextUtils.isEmpty((CharSequence)configuration.getDefaultProcessName())) return TextUtils.equals((CharSequence)string, (CharSequence)context.getApplicationInfo().processName);
        return TextUtils.equals((CharSequence)string, (CharSequence)configuration.getDefaultProcessName());
    }
}
