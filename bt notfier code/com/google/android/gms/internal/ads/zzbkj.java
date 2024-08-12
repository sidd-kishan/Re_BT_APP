/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.net.Uri
 *  androidx.browser.customtabs.CustomTabsClient
 *  androidx.browser.customtabs.CustomTabsServiceConnection
 *  androidx.browser.customtabs.CustomTabsSession
 *  com.google.android.gms.internal.ads.zzbkh
 *  com.google.android.gms.internal.ads.zzglo
 *  com.google.android.gms.internal.ads.zzglp
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.android.gms.internal.ads.zzbkh;
import com.google.android.gms.internal.ads.zzglo;
import com.google.android.gms.internal.ads.zzglp;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzbkj {
    private CustomTabsSession zza;
    private CustomTabsClient zzb;
    private CustomTabsServiceConnection zzc;
    private zzbkh zzd;

    public static boolean zza(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Object object = new Intent("android.intent.action.VIEW", Uri.parse((String)"http://www.example.com"));
        ResolveInfo resolveInfo = packageManager.resolveActivity((Intent)object, 0);
        if ((object = packageManager.queryIntentActivities((Intent)object, 65536)) == null) return false;
        if (resolveInfo == null) return false;
        int n = 0;
        while (n < object.size()) {
            packageManager = (ResolveInfo)object.get(n);
            if (resolveInfo.activityInfo.name.equals(packageManager.activityInfo.name)) {
                return resolveInfo.activityInfo.packageName.equals(zzglo.zza((Context)context));
            }
            ++n;
        }
        return false;
    }

    public final void zzb(Activity activity) {
        CustomTabsServiceConnection customTabsServiceConnection = this.zzc;
        if (customTabsServiceConnection == null) {
            return;
        }
        activity.unbindService((ServiceConnection)customTabsServiceConnection);
        this.zzb = null;
        this.zza = null;
        this.zzc = null;
    }

    public final CustomTabsSession zzc() {
        CustomTabsClient customTabsClient = this.zzb;
        if (customTabsClient == null) {
            this.zza = null;
        } else {
            if (this.zza != null) return this.zza;
            this.zza = customTabsClient.newSession(null);
        }
        return this.zza;
    }

    public final void zzd(zzbkh zzbkh2) {
        this.zzd = zzbkh2;
    }

    public final void zze(Activity activity) {
        if (this.zzb != null) {
            return;
        }
        String string = zzglo.zza((Context)activity);
        if (string == null) {
            return;
        }
        zzglp zzglp2 = new zzglp(this, null);
        this.zzc = zzglp2;
        CustomTabsClient.bindCustomTabsService((Context)activity, (String)string, (CustomTabsServiceConnection)zzglp2);
    }

    public final void zzf(CustomTabsClient customTabsClient) {
        this.zzb = customTabsClient;
        customTabsClient.warmup(0L);
        customTabsClient = this.zzd;
        if (customTabsClient == null) return;
        customTabsClient.zza();
    }

    public final void zzg() {
        this.zzb = null;
        this.zza = null;
    }
}
