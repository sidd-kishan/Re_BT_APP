/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.text.TextUtils
 *  com.google.android.gms.common.GooglePlayServicesNotAvailableException
 *  com.google.android.gms.common.GooglePlayServicesRepairableException
 *  com.google.android.gms.common.GooglePlayServicesUtilLight
 *  com.google.android.gms.common.internal.zzs
 *  com.google.android.gms.common.util.DeviceProperties
 *  com.google.android.gms.common.wrappers.Wrappers
 */
package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;

public class GoogleApiAvailabilityLight {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    static final String TRACKING_SOURCE_DIALOG = "d";
    static final String TRACKING_SOURCE_NOTIFICATION = "n";
    private static final GoogleApiAvailabilityLight zza = new GoogleApiAvailabilityLight();

    GoogleApiAvailabilityLight() {
    }

    public static GoogleApiAvailabilityLight getInstance() {
        return zza;
    }

    public void cancelAvailabilityErrorNotifications(Context context) {
        GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications((Context)context);
    }

    public int getApkVersion(Context context) {
        return GooglePlayServicesUtilLight.getApkVersion((Context)context);
    }

    public int getClientVersion(Context context) {
        return GooglePlayServicesUtilLight.getClientVersion((Context)context);
    }

    @Deprecated
    public Intent getErrorResolutionIntent(int n) {
        return this.getErrorResolutionIntent(null, n, null);
    }

    public Intent getErrorResolutionIntent(Context context, int n, String string) {
        if (n != 1 && n != 2) {
            if (n == 3) return zzs.zza((String)GOOGLE_PLAY_SERVICES_PACKAGE);
            return null;
        }
        if (context != null) {
            if (DeviceProperties.isWearableWithoutPlayStore((Context)context)) return zzs.zzc();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty((CharSequence)string)) {
            stringBuilder.append(string);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context == null) return zzs.zzb((String)GOOGLE_PLAY_SERVICES_PACKAGE, (String)stringBuilder.toString());
        try {
            stringBuilder.append(Wrappers.packageManager((Context)context).getPackageInfo((String)context.getPackageName(), (int)0).versionCode);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {}
        return zzs.zzb((String)GOOGLE_PLAY_SERVICES_PACKAGE, (String)stringBuilder.toString());
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int n, int n2) {
        return this.getErrorResolutionPendingIntent(context, n, n2, null);
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int n, int n2, String string) {
        if ((string = this.getErrorResolutionIntent(context, n, string)) != null) return PendingIntent.getActivity((Context)context, (int)n2, (Intent)string, (int)0x8000000);
        return null;
    }

    public String getErrorString(int n) {
        return GooglePlayServicesUtilLight.getErrorString((int)n);
    }

    public int isGooglePlayServicesAvailable(Context context) {
        return this.isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public int isGooglePlayServicesAvailable(Context context, int n) {
        if (!GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating((Context)context, (int)(n = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable((Context)context, (int)n)))) return n;
        return 18;
    }

    public boolean isPlayServicesPossiblyUpdating(Context context, int n) {
        return GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating((Context)context, (int)n);
    }

    public boolean isPlayStorePossiblyUpdating(Context context, int n) {
        return GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating((Context)context, (int)n);
    }

    public boolean isUninstalledAppPossiblyUpdating(Context context, String string) {
        return GooglePlayServicesUtilLight.zza((Context)context, (String)string);
    }

    public boolean isUserResolvableError(int n) {
        return GooglePlayServicesUtilLight.isUserRecoverableError((int)n);
    }

    public void verifyGooglePlayServicesIsAvailable(Context context, int n) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        GooglePlayServicesUtilLight.ensurePlayServicesAvailable((Context)context, (int)n);
    }
}
