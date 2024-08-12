/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzdhv
 *  com.google.android.gms.internal.ads.zzffb
 *  com.google.android.gms.internal.ads.zzffc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzdhv;
import com.google.android.gms.internal.ads.zzffb;
import com.google.android.gms.internal.ads.zzffc;

public final class zzecc
implements zzdhv {
    private boolean zza = false;
    private boolean zzb = false;
    private final String zzc;
    private final zzffc zzd;
    private final zzg zze;

    public zzecc(String string, zzffc zzffc2) {
        this.zzc = string;
        this.zzd = zzffc2;
        this.zze = zzt.zzg().zzp();
    }

    private final zzffb zzf(String string) {
        String string2 = this.zze.zzC() ? "" : this.zzc;
        string = zzffb.zza((String)string);
        string.zzc("tms", Long.toString(zzt.zzj().elapsedRealtime(), 10));
        string.zzc("tid", string2);
        return string;
    }

    public final void zza(String string) {
        zzffc zzffc2 = this.zzd;
        zzffb zzffb2 = this.zzf("adapter_init_started");
        zzffb2.zzc("ancn", string);
        zzffc2.zza(zzffb2);
    }

    public final void zzb(String string) {
        zzffc zzffc2 = this.zzd;
        zzffb zzffb2 = this.zzf("adapter_init_finished");
        zzffb2.zzc("ancn", string);
        zzffc2.zza(zzffb2);
    }

    public final void zzc(String string, String string2) {
        zzffc zzffc2 = this.zzd;
        zzffb zzffb2 = this.zzf("adapter_init_finished");
        zzffb2.zzc("ancn", string);
        zzffb2.zzc("rqe", string2);
        zzffc2.zza(zzffb2);
    }

    public final void zzd() {
        synchronized (this) {
            if (this.zza) return;
            this.zzd.zza(this.zzf("init_started"));
            this.zza = true;
            return;
        }
    }

    public final void zze() {
        synchronized (this) {
            if (this.zzb) return;
            this.zzd.zza(this.zzf("init_finished"));
            this.zzb = true;
            return;
        }
    }
}
