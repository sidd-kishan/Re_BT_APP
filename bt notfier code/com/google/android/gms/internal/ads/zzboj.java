/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbnb
 *  com.google.android.gms.internal.ads.zzbnk
 *  com.google.android.gms.internal.ads.zzboi
 *  com.google.android.gms.internal.ads.zzbol
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbnb;
import com.google.android.gms.internal.ads.zzbnk;
import com.google.android.gms.internal.ads.zzboi;
import com.google.android.gms.internal.ads.zzbol;

final class zzboj
extends zzbnk {
    final zzbol zza;

    /* synthetic */ zzboj(zzbol zzbol2, zzboi zzboi2) {
        this.zza = zzbol2;
    }

    public final void zze(zzbnb zzbnb2, String string) {
        if (zzbol.zzb((zzbol)this.zza) == null) {
            return;
        }
        zzbol.zzb((zzbol)this.zza).onCustomClick(zzbol.zze((zzbol)this.zza, (zzbnb)zzbnb2), string);
    }
}
