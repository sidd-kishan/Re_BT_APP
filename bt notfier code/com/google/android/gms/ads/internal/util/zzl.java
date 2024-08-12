/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.net.Uri
 *  androidx.browser.customtabs.CustomTabsIntent
 *  androidx.browser.customtabs.CustomTabsIntent$Builder
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.internal.ads.zzbkh
 *  com.google.android.gms.internal.ads.zzbkj
 *  com.google.android.gms.internal.ads.zzglo
 */
package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.internal.ads.zzbkh;
import com.google.android.gms.internal.ads.zzbkj;
import com.google.android.gms.internal.ads.zzglo;

final class zzl
implements zzbkh {
    final zzbkj zza;
    final Context zzb;
    final Uri zzc;

    zzl(zzs zzs2, zzbkj zzbkj2, Context context, Uri uri) {
        this.zza = zzbkj2;
        this.zzb = context;
        this.zzc = uri;
    }

    public final void zza() {
        CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder(this.zza.zzc()).build();
        customTabsIntent.intent.setPackage(zzglo.zza((Context)this.zzb));
        customTabsIntent.launchUrl(this.zzb, this.zzc);
        this.zza.zzb((Activity)this.zzb);
    }
}
