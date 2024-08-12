/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzdtc
 *  com.google.android.gms.internal.ads.zzdvi
 *  com.google.android.gms.internal.ads.zzeeg
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 *  com.google.android.gms.internal.ads.zzfbe
 *  com.google.android.gms.internal.ads.zzffb
 *  com.google.android.gms.internal.ads.zzffc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzdtc;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzeeg;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import com.google.android.gms.internal.ads.zzfbe;
import com.google.android.gms.internal.ads.zzffb;
import com.google.android.gms.internal.ads.zzffc;
import javax.annotation.Nullable;

public final class zzehq {
    private final zzfbe zza;
    private final zzdtc zzb;
    private final zzdvi zzc;
    private final zzffc zzd;

    public zzehq(zzfbe zzfbe2, zzdtc zzdtc2, zzdvi zzdvi2, zzffc zzffc2) {
        this.zza = zzfbe2;
        this.zzb = zzdtc2;
        this.zzc = zzdvi2;
        this.zzd = zzffc2;
    }

    public final void zza(zzfac object, zzezz zzezz2, int n, @Nullable zzeeg zzeeg2, long l) {
        zzbjd zzbjd2 = zzbjl.zzgi;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            zzbjd2 = zzffb.zza((String)"adapter_status");
            zzbjd2.zzh(object);
            zzbjd2.zzi(zzezz2);
            zzbjd2.zzc("adapter_l", String.valueOf(l));
            zzbjd2.zzc("sc", Integer.toString(n));
            if (zzeeg2 != null) {
                zzbjd2.zzc("arec", Integer.toString(zzeeg2.zzb().zza));
                object = this.zza.zza(zzeeg2.getMessage());
                if (object != null) {
                    zzbjd2.zzc("areec", (String)object);
                }
            }
            if ((object = this.zzb.zzd(zzezz2.zzt)) != null) {
                zzbjd2.zzc("ancn", object.zza);
                zzezz2 = object.zzb;
                if (zzezz2 != null) {
                    zzbjd2.zzc("adapter_v", zzezz2.toString());
                }
                if ((object = object.zzc) != null) {
                    zzbjd2.zzc("adapter_sv", object.toString());
                }
            }
            this.zzd.zza((zzffb)zzbjd2);
            return;
        }
        zzbjd2 = this.zzc.zzd();
        zzbjd2.zzb(object);
        zzbjd2.zzc(zzezz2);
        zzbjd2.zzd("action", "adapter_status");
        zzbjd2.zzd("adapter_l", String.valueOf(l));
        zzbjd2.zzd("sc", Integer.toString(n));
        if (zzeeg2 != null) {
            zzbjd2.zzd("arec", Integer.toString(zzeeg2.zzb().zza));
            object = this.zza.zza(zzeeg2.getMessage());
            if (object != null) {
                zzbjd2.zzd("areec", (String)object);
            }
        }
        if ((object = this.zzb.zzd(zzezz2.zzt)) != null) {
            zzbjd2.zzd("ancn", object.zza);
            zzezz2 = object.zzb;
            if (zzezz2 != null) {
                zzbjd2.zzd("adapter_v", zzezz2.toString());
            }
            if ((object = object.zzc) != null) {
                zzbjd2.zzd("adapter_sv", object.toString());
            }
        }
        zzbjd2.zze();
    }
}
