/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Process
 *  android.os.WorkSource
 *  android.util.Log
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.util.PlatformVersion
 *  com.google.android.gms.common.util.Strings
 *  com.google.android.gms.common.wrappers.Wrappers
 */
package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class WorkSourceUtil {
    private static final int zza;
    private static final Method zzb;
    private static final Method zzc;
    private static final Method zzd;
    private static final Method zze;
    private static final Method zzf;
    private static final Method zzg;
    private static final Method zzh;

    static {
        Method method;
        Object var1;
        block18: {
            zza = Process.myUid();
            var1 = null;
            try {
                method = WorkSource.class.getMethod("add", Integer.TYPE);
            }
            catch (Exception exception) {
                method = null;
            }
            zzb = method;
            if (PlatformVersion.isAtLeastJellyBeanMR2()) {
                try {
                    method = WorkSource.class.getMethod("add", Integer.TYPE, String.class);
                }
                catch (Exception exception) {}
            }
            method = null;
            zzc = method;
            try {
                method = WorkSource.class.getMethod("size", new Class[0]);
            }
            catch (Exception exception) {
                method = null;
            }
            zzd = method;
            try {
                method = WorkSource.class.getMethod("get", Integer.TYPE);
            }
            catch (Exception exception) {
                method = null;
            }
            zze = method;
            if (PlatformVersion.isAtLeastJellyBeanMR2()) {
                try {
                    method = WorkSource.class.getMethod("getName", Integer.TYPE);
                }
                catch (Exception exception) {}
            }
            method = null;
            zzf = method;
            if (PlatformVersion.isAtLeastP()) {
                try {
                    method = WorkSource.class.getMethod("createWorkChain", new Class[0]);
                    break block18;
                }
                catch (Exception exception) {
                    Log.w((String)"WorkSourceUtil", (String)"Missing WorkChain API createWorkChain", (Throwable)exception);
                }
            }
            method = null;
        }
        zzg = method;
        method = var1;
        if (PlatformVersion.isAtLeastP()) {
            try {
                method = Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
            }
            catch (Exception exception) {
                Log.w((String)"WorkSourceUtil", (String)"Missing WorkChain class", (Throwable)exception);
                method = var1;
            }
        }
        zzh = method;
    }

    private WorkSourceUtil() {
    }

    public static WorkSource fromPackage(Context object, String string) {
        block3: {
            block2: {
                if (object == null) return null;
                if (object.getPackageManager() == null) return null;
                if (string == null) return null;
                try {
                    object = Wrappers.packageManager((Context)object).getApplicationInfo(string, 0);
                    if (object != null) break block2;
                    object = string.length() != 0 ? "Could not get applicationInfo from package: ".concat(string) : new String("Could not get applicationInfo from package: ");
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    String string2 = string.length() != 0 ? "Could not find package: ".concat(string) : new String("Could not find package: ");
                    Log.e((String)"WorkSourceUtil", (String)string2);
                    break block3;
                }
                Log.e((String)"WorkSourceUtil", (String)object);
                return null;
            }
            int n = object.uid;
            object = new WorkSource();
            WorkSourceUtil.zza((WorkSource)object, n, string);
            return object;
        }
        return null;
    }

    public static WorkSource fromPackageAndModuleExperimentalPi(Context object, String string, String string2) {
        block10: {
            int n;
            block9: {
                block8: {
                    if (object == null || object.getPackageManager() == null || string2 == null || string == null) break block10;
                    n = -1;
                    try {
                        object = Wrappers.packageManager((Context)object).getApplicationInfo(string, 0);
                        if (object != null) break block8;
                        object = string.length() != 0 ? "Could not get applicationInfo from package: ".concat(string) : new String("Could not get applicationInfo from package: ");
                    }
                    catch (PackageManager.NameNotFoundException nameNotFoundException) {
                        object = string.length() != 0 ? "Could not find package: ".concat(string) : new String("Could not find package: ");
                        Log.e((String)"WorkSourceUtil", (String)object);
                        break block9;
                    }
                    Log.e((String)"WorkSourceUtil", (String)object);
                    break block9;
                }
                n = object.uid;
            }
            if (n < 0) {
                return null;
            }
            object = new WorkSource();
            Object object2 = zzg;
            if (object2 != null && zzh != null) {
                try {
                    object2 = ((Method)object2).invoke(object, new Object[0]);
                    if (n != zza) {
                        zzh.invoke(object2, n, string);
                    }
                    zzh.invoke(object2, zza, string2);
                }
                catch (Exception exception) {
                    Log.w((String)"WorkSourceUtil", (String)"Unable to assign chained blame through WorkSource", (Throwable)exception);
                }
            } else {
                WorkSourceUtil.zza((WorkSource)object, n, string);
            }
            return object;
        }
        Log.w((String)"WorkSourceUtil", (String)"Unexpected null arguments");
        return null;
    }

    public static List<String> getNames(WorkSource workSource) {
        int n;
        Object object;
        ArrayList<String> arrayList;
        block8: {
            arrayList = new ArrayList<String>();
            if (workSource != null && (object = zzd) != null) {
                try {
                    object = ((Method)object).invoke(workSource, new Object[0]);
                    Preconditions.checkNotNull((Object)object);
                    n = (Integer)object;
                    break block8;
                }
                catch (Exception exception) {
                    Log.wtf((String)"WorkSourceUtil", (String)"Unable to assign blame through WorkSource", (Throwable)exception);
                }
            }
            n = 0;
        }
        if (n == 0) return arrayList;
        int n2 = 0;
        while (n2 < n) {
            Method method = zzf;
            Object var4_7 = null;
            object = var4_7;
            if (method != null) {
                try {
                    object = (String)method.invoke(workSource, n2);
                }
                catch (Exception exception) {
                    Log.wtf((String)"WorkSourceUtil", (String)"Unable to assign blame through WorkSource", (Throwable)exception);
                    object = var4_7;
                }
            }
            if (!Strings.isEmptyOrWhitespace((String)object)) {
                Preconditions.checkNotNull((Object)object);
                arrayList.add((String)object);
            }
            ++n2;
        }
        return arrayList;
    }

    public static boolean hasWorkSourcePermission(Context context) {
        if (context == null) {
            return false;
        }
        if (context.getPackageManager() == null) {
            return false;
        }
        if (Wrappers.packageManager((Context)context).checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) return false;
        return true;
    }

    public static void zza(WorkSource workSource, int n, String object) {
        Method method = zzc;
        if (method != null) {
            try {
                method.invoke(workSource, n, object);
                return;
            }
            catch (Exception exception) {
                Log.wtf((String)"WorkSourceUtil", (String)"Unable to assign blame through WorkSource", (Throwable)exception);
                return;
            }
        }
        object = zzb;
        if (object == null) return;
        try {
            ((Method)object).invoke(workSource, n);
            return;
        }
        catch (Exception exception) {
            Log.wtf((String)"WorkSourceUtil", (String)"Unable to assign blame through WorkSource", (Throwable)exception);
        }
    }
}
