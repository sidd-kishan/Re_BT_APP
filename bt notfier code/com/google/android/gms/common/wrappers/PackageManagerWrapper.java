/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AppOpsManager
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.drawable.Drawable
 *  android.os.Binder
 *  android.os.Process
 *  androidx.core.util.Pair
 *  com.google.android.gms.common.util.PlatformVersion
 *  com.google.android.gms.common.wrappers.InstantApps
 */
package com.google.android.gms.common.wrappers;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Process;
import androidx.core.util.Pair;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.InstantApps;

public class PackageManagerWrapper {
    protected final Context zza;

    public PackageManagerWrapper(Context context) {
        this.zza = context;
    }

    public int checkCallingOrSelfPermission(String string) {
        return this.zza.checkCallingOrSelfPermission(string);
    }

    public int checkPermission(String string, String string2) {
        return this.zza.getPackageManager().checkPermission(string, string2);
    }

    public ApplicationInfo getApplicationInfo(String string, int n) throws PackageManager.NameNotFoundException {
        return this.zza.getPackageManager().getApplicationInfo(string, n);
    }

    public CharSequence getApplicationLabel(String string) throws PackageManager.NameNotFoundException {
        return this.zza.getPackageManager().getApplicationLabel(this.zza.getPackageManager().getApplicationInfo(string, 0));
    }

    public Pair<CharSequence, Drawable> getApplicationLabelAndIcon(String string) throws PackageManager.NameNotFoundException {
        string = this.zza.getPackageManager().getApplicationInfo(string, 0);
        return Pair.create((Object)this.zza.getPackageManager().getApplicationLabel((ApplicationInfo)string), (Object)this.zza.getPackageManager().getApplicationIcon((ApplicationInfo)string));
    }

    public PackageInfo getPackageInfo(String string, int n) throws PackageManager.NameNotFoundException {
        return this.zza.getPackageManager().getPackageInfo(string, n);
    }

    public boolean isCallerInstantApp() {
        if (Binder.getCallingUid() == Process.myUid()) {
            return InstantApps.isInstantApp((Context)this.zza);
        }
        if (!PlatformVersion.isAtLeastO()) return false;
        String string = this.zza.getPackageManager().getNameForUid(Binder.getCallingUid());
        if (string == null) return false;
        return this.zza.getPackageManager().isInstantApp(string);
    }

    public final boolean zza(int n, String object) {
        if (PlatformVersion.isAtLeastKitKat()) {
            try {
                AppOpsManager appOpsManager = (AppOpsManager)this.zza.getSystemService("appops");
                if (appOpsManager != null) {
                    appOpsManager.checkPackage(n, (String)object);
                    return true;
                }
                object = new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
                throw object;
            }
            catch (SecurityException securityException) {
                return false;
            }
        }
        String[] stringArray = this.zza.getPackageManager().getPackagesForUid(n);
        if (object == null) return false;
        if (stringArray == null) return false;
        n = 0;
        while (n < stringArray.length) {
            if (((String)object).equals(stringArray[n])) {
                return true;
            }
            ++n;
        }
        return false;
    }
}
