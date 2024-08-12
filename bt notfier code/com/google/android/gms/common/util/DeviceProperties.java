/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.res.Resources
 *  android.os.Build
 *  com.google.android.gms.common.GooglePlayServicesUtilLight
 *  com.google.android.gms.common.util.PlatformVersion
 */
package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.PlatformVersion;

public final class DeviceProperties {
    private static Boolean zza;
    private static Boolean zzb;
    private static Boolean zzc;
    private static Boolean zzd;
    private static Boolean zze;
    private static Boolean zzf;
    private static Boolean zzg;
    private static Boolean zzh;

    private DeviceProperties() {
    }

    public static boolean isAuto(Context context) {
        return DeviceProperties.isAuto(context.getPackageManager());
    }

    public static boolean isAuto(PackageManager packageManager) {
        boolean bl;
        if (zzg != null) return zzg;
        boolean bl2 = PlatformVersion.isAtLeastO();
        boolean bl3 = bl = false;
        if (bl2) {
            bl3 = bl;
            if (packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                bl3 = true;
            }
        }
        zzg = bl3;
        return zzg;
    }

    @Deprecated
    public static boolean isFeaturePhone(Context context) {
        return false;
    }

    public static boolean isLatchsky(Context context) {
        boolean bl;
        if (zze != null) return zze;
        context = context.getPackageManager();
        boolean bl2 = context.hasSystemFeature("com.google.android.feature.services_updater");
        boolean bl3 = bl = false;
        if (bl2) {
            bl3 = bl;
            if (context.hasSystemFeature("cn.google.services")) {
                bl3 = true;
            }
        }
        zze = bl3;
        return zze;
    }

    public static boolean isSidewinder(Context context) {
        return DeviceProperties.zza(context);
    }

    public static boolean isTablet(Resources resources) {
        boolean bl;
        block6: {
            block5: {
                boolean bl2 = false;
                if (resources == null) {
                    return false;
                }
                if (zza != null) return zza;
                if ((resources.getConfiguration().screenLayout & 0xF) > 3) break block5;
                if (zzb == null) {
                    resources = resources.getConfiguration();
                    bl = (resources.screenLayout & 0xF) <= 3 && resources.smallestScreenWidthDp >= 600;
                    zzb = bl;
                }
                bl = bl2;
                if (!zzb.booleanValue()) break block6;
            }
            bl = true;
        }
        zza = bl;
        return zza;
    }

    public static boolean isTv(Context context) {
        return DeviceProperties.isTv(context.getPackageManager());
    }

    public static boolean isTv(PackageManager packageManager) {
        boolean bl;
        if (zzh != null) return zzh;
        boolean bl2 = packageManager.hasSystemFeature("com.google.android.tv");
        boolean bl3 = bl = true;
        if (!bl2) {
            bl3 = bl;
            if (!packageManager.hasSystemFeature("android.hardware.type.television")) {
                bl3 = packageManager.hasSystemFeature("android.software.leanback") ? bl : false;
            }
        }
        zzh = bl3;
        return zzh;
    }

    public static boolean isUserBuild() {
        int n = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return "user".equals(Build.TYPE);
    }

    public static boolean isWearable(Context context) {
        return DeviceProperties.isWearable(context.getPackageManager());
    }

    public static boolean isWearable(PackageManager packageManager) {
        boolean bl;
        if (zzc != null) return zzc;
        boolean bl2 = PlatformVersion.isAtLeastKitKatWatch();
        boolean bl3 = bl = false;
        if (bl2) {
            bl3 = bl;
            if (packageManager.hasSystemFeature("android.hardware.type.watch")) {
                bl3 = true;
            }
        }
        zzc = bl3;
        return zzc;
    }

    public static boolean isWearableWithoutPlayStore(Context context) {
        boolean bl = DeviceProperties.isWearable(context);
        boolean bl2 = true;
        if (bl) {
            if (!PlatformVersion.isAtLeastN()) return bl2;
            if (DeviceProperties.zza(context)) {
                if (!PlatformVersion.isAtLeastO()) return true;
            }
        }
        bl2 = false;
        return bl2;
    }

    public static boolean zza(Context context) {
        boolean bl;
        if (zzd != null) return zzd;
        boolean bl2 = PlatformVersion.isAtLeastLollipop();
        boolean bl3 = bl = false;
        if (bl2) {
            bl3 = bl;
            if (context.getPackageManager().hasSystemFeature("cn.google")) {
                bl3 = true;
            }
        }
        zzd = bl3;
        return zzd;
    }

    public static boolean zzb(Context context) {
        boolean bl;
        if (zzf != null) return zzf;
        boolean bl2 = context.getPackageManager().hasSystemFeature("android.hardware.type.iot");
        boolean bl3 = bl = true;
        if (!bl2) {
            bl3 = context.getPackageManager().hasSystemFeature("android.hardware.type.embedded") ? bl : false;
        }
        zzf = bl3;
        return zzf;
    }
}
