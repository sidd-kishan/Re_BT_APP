/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zzc
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzcgs
 *  com.google.android.gms.internal.ads.zzchj
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzc;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzchj;
import com.google.android.gms.internal.ads.zzfsm;

public final class zzd {
    public static void zza(Context context) {
        if (!zzcgs.zzk((Context)context)) {
            return;
        }
        if (zzcgs.zzi()) return;
        context = new zzc(context).zzc();
        zze.zzh((String)"Updating ad debug logging enablement.");
        zzchj.zza((zzfsm)context, (String)"AdDebugLogUpdater.updateEnablement");
    }
}
