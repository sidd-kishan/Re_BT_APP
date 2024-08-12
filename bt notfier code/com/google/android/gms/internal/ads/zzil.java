/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzagh
 *  com.google.android.gms.internal.ads.zzagj
 *  com.google.android.gms.internal.ads.zzagk
 *  com.google.android.gms.internal.ads.zzai
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzaj
 *  com.google.android.gms.internal.ads.zzay
 *  com.google.android.gms.internal.ads.zzfa
 *  com.google.android.gms.internal.ads.zzff
 *  com.google.android.gms.internal.ads.zzgi
 *  com.google.android.gms.internal.ads.zzhe
 *  com.google.android.gms.internal.ads.zzhf
 *  com.google.android.gms.internal.ads.zzho
 *  com.google.android.gms.internal.ads.zzhw
 *  com.google.android.gms.internal.ads.zzhx
 *  com.google.android.gms.internal.ads.zzic
 *  com.google.android.gms.internal.ads.zzig
 *  com.google.android.gms.internal.ads.zzih
 *  com.google.android.gms.internal.ads.zzik
 *  com.google.android.gms.internal.ads.zziy
 *  com.google.android.gms.internal.ads.zzko
 *  com.google.android.gms.internal.ads.zzku
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzagh;
import com.google.android.gms.internal.ads.zzagj;
import com.google.android.gms.internal.ads.zzagk;
import com.google.android.gms.internal.ads.zzai;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzay;
import com.google.android.gms.internal.ads.zzfa;
import com.google.android.gms.internal.ads.zzff;
import com.google.android.gms.internal.ads.zzgi;
import com.google.android.gms.internal.ads.zzhe;
import com.google.android.gms.internal.ads.zzhf;
import com.google.android.gms.internal.ads.zzho;
import com.google.android.gms.internal.ads.zzhw;
import com.google.android.gms.internal.ads.zzhx;
import com.google.android.gms.internal.ads.zzic;
import com.google.android.gms.internal.ads.zzig;
import com.google.android.gms.internal.ads.zzih;
import com.google.android.gms.internal.ads.zzik;
import com.google.android.gms.internal.ads.zziy;
import com.google.android.gms.internal.ads.zzko;
import com.google.android.gms.internal.ads.zzku;

public final class zzil
extends zzgi
implements zzic {
    private final zzagk zza;
    private final zzagj zzb;
    private final zzai zzc;
    private final zzhw zzd;
    private final zzff zze;
    private final int zzf;
    private boolean zzg;
    private long zzh;
    private boolean zzi;
    private boolean zzj;
    private zzay zzk;
    private final zzku zzl;

    /* synthetic */ zzil(zzagk zzagk2, zzai zzai2, zzhw zzhw2, zzff zzff2, zzku zzku2, int n, zzik zzik2, byte[] byArray) {
        zzik2 = zzagk2.zzc;
        if (zzik2 == null) throw null;
        this.zzb = zzik2;
        this.zza = zzagk2;
        this.zzc = zzai2;
        this.zzd = zzhw2;
        this.zze = zzff2;
        this.zzl = zzku2;
        this.zzf = n;
        this.zzg = true;
        this.zzh = -9223372036854775807L;
    }

    private final void zzv() {
        long l = this.zzh;
        boolean bl = this.zzi;
        boolean bl2 = this.zzj;
        zzagk zzagk2 = this.zza;
        zzagh zzagh2 = bl2 ? zzagk2.zzd : null;
        zzagh2 = new zziy(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, l, l, 0L, 0L, bl, false, false, null, zzagk2, zzagh2);
        if (this.zzg) {
            zzagh2 = new zzih(this, (zzaiq)zzagh2);
        }
        this.zze((zzaiq)zzagh2);
    }

    public final void zzA(zzhe zzhe2) {
        ((zzig)zzhe2).zzu();
    }

    public final zzhe zzC(zzhf zzhf2, zzko zzko2, long l) {
        zzaj zzaj2 = this.zzc.zza();
        zzay zzay2 = this.zzk;
        if (zzay2 != null) {
            zzaj2.zza(zzay2);
        }
        Uri uri = this.zzb.zza;
        zzay2 = this.zzd.zza();
        zzff zzff2 = this.zze;
        zzfa zzfa2 = this.zzh(zzhf2);
        zzku zzku2 = this.zzl;
        zzhf2 = this.zzf(zzhf2);
        String string = this.zzb.zzf;
        return new zzig(uri, zzaj2, (zzhx)zzay2, zzff2, zzfa2, zzku2, (zzho)zzhf2, (zzic)this, zzko2, null, this.zzf, null);
    }

    protected final void zza(zzay zzay2) {
        this.zzk = zzay2;
        this.zzv();
    }

    public final void zzb(long l, boolean bl, boolean bl2) {
        long l2 = l;
        if (l == -9223372036854775807L) {
            l2 = this.zzh;
        }
        if (!this.zzg && this.zzh == l2 && this.zzi == bl && this.zzj == bl2) {
            return;
        }
        this.zzh = l2;
        this.zzi = bl;
        this.zzj = bl2;
        this.zzg = false;
        this.zzv();
    }

    protected final void zzd() {
    }

    public final void zzu() {
    }

    public final zzagk zzz() {
        return this.zza;
    }
}
