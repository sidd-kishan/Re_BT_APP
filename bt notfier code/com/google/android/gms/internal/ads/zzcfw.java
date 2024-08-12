/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzcfv
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzcfv;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzfsm;

public final class zzcfw {
    public final zzfsm<AdvertisingIdClient.Info> zza(Context context, int n) {
        zzchl zzchl2 = new zzchl();
        zzber.zza();
        if (!zzcgm.zzo((Context)context)) return zzchl2;
        zzchg.zza.execute((Runnable)new zzcfv(this, context, zzchl2));
        return zzchl2;
    }
}
