/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzakv
 *  com.google.android.gms.internal.ads.zzalu
 *  com.google.android.gms.internal.ads.zzalv
 *  com.google.android.gms.internal.ads.zzalw
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzov
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zztb
 *  com.google.android.gms.internal.ads.zztj
 *  com.google.android.gms.internal.ads.zztq
 *  com.google.android.gms.internal.ads.zzuc
 *  com.google.android.gms.internal.ads.zzun
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzakv;
import com.google.android.gms.internal.ads.zzalu;
import com.google.android.gms.internal.ads.zzalv;
import com.google.android.gms.internal.ads.zzalw;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zztb;
import com.google.android.gms.internal.ads.zztj;
import com.google.android.gms.internal.ads.zztq;
import com.google.android.gms.internal.ads.zzuc;
import com.google.android.gms.internal.ads.zzun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zztk
implements zztb {
    private final zzuc zza;
    private final zztq zzb;
    private final zztq zzc;
    private final zztq zzd;
    private long zze;
    private final boolean[] zzf;
    private String zzg;
    private zzox zzh;
    private zztj zzi;
    private boolean zzj;
    private long zzk;
    private boolean zzl;
    private final zzamf zzm;

    public zztk(zzuc zzuc2, boolean bl, boolean bl2) {
        this.zza = zzuc2;
        this.zzf = new boolean[3];
        this.zzb = new zztq(7, 128);
        this.zzc = new zztq(8, 128);
        this.zzd = new zztq(6, 128);
        this.zzk = -9223372036854775807L;
        this.zzm = new zzamf();
    }

    @RequiresNonNull(value={"sampleReader"})
    private final void zzf(byte[] byArray, int n, int n2) {
        if (!this.zzj) {
            this.zzb.zzd(byArray, n, n2);
            this.zzc.zzd(byArray, n, n2);
        }
        this.zzd.zzd(byArray, n, n2);
    }

    public final void zza() {
        this.zze = 0L;
        this.zzl = false;
        this.zzk = -9223372036854775807L;
        zzalw.zze((boolean[])this.zzf);
        this.zzb.zza();
        this.zzc.zza();
        this.zzd.zza();
        zztj zztj2 = this.zzi;
        if (zztj2 == null) return;
        zztj2.zzc();
    }

    public final void zzb(zznx zznx2, zzun zzun2) {
        zzox zzox2;
        zzun2.zza();
        this.zzg = zzun2.zzc();
        this.zzh = zzox2 = zznx2.zzB(zzun2.zzb(), 2);
        this.zzi = new zztj(zzox2, false, false);
        this.zza.zza(zznx2, zzun2);
    }

    public final void zzc(long l, int n) {
        if (l != -9223372036854775807L) {
            this.zzk = l;
        }
        int n2 = this.zzl;
        n = (n & 2) != 0 ? 1 : 0;
        this.zzl = n2 | n;
    }

    public final void zzd(zzamf object) {
        zzakt.zze((Object)this.zzh);
        int n = zzamq.zza;
        n = object.zzg();
        int n2 = object.zze();
        byte[] byArray = object.zzi();
        this.zze += (long)object.zzd();
        zzov.zzb((zzox)this.zzh, (zzamf)object, (int)object.zzd());
        while (true) {
            int n3;
            if ((n3 = zzalw.zzd((byte[])byArray, (int)n, (int)n2, (boolean[])this.zzf)) == n2) {
                this.zzf(byArray, n, n2);
                return;
            }
            int n4 = n3 + 3;
            int n5 = byArray[n4] & 0x1F;
            int n6 = n3 - n;
            if (n6 > 0) {
                this.zzf(byArray, n, n3);
            }
            n3 = n2 - n3;
            long l = this.zze - (long)n3;
            n = n6 < 0 ? -n6 : 0;
            long l2 = this.zzk;
            if (!this.zzj) {
                this.zzb.zze(n);
                this.zzc.zze(n);
                if (!this.zzj) {
                    if (this.zzb.zzb() && this.zzc.zzb()) {
                        object = new ArrayList();
                        zztq zztq2 = this.zzb;
                        object.add(Arrays.copyOf(zztq2.zza, zztq2.zzb));
                        zztq2 = this.zzc;
                        object.add(Arrays.copyOf(zztq2.zza, zztq2.zzb));
                        zztq2 = this.zzb;
                        zztq2 = zzalw.zzb((byte[])zztq2.zza, (int)3, (int)zztq2.zzb);
                        Object object2 = this.zzc;
                        zzalu zzalu2 = zzalw.zzc((byte[])object2.zza, (int)3, (int)object2.zzb);
                        object2 = zzakv.zza((int)zztq2.zza, (int)zztq2.zzb, (int)zztq2.zzc);
                        zzox zzox2 = this.zzh;
                        zzaft zzaft2 = new zzaft();
                        zzaft2.zzD(this.zzg);
                        zzaft2.zzN("video/avc");
                        zzaft2.zzK((String)object2);
                        zzaft2.zzS(zztq2.zze);
                        zzaft2.zzT(zztq2.zzf);
                        zzaft2.zzW(zztq2.zzg);
                        zzaft2.zzP((List)object);
                        zzox2.zzs(zzaft2.zzah());
                        this.zzj = true;
                        this.zzi.zza((zzalv)zztq2);
                        this.zzi.zzb(zzalu2);
                        this.zzb.zza();
                        this.zzc.zza();
                    }
                } else if (this.zzb.zzb()) {
                    object = this.zzb;
                    object = zzalw.zzb((byte[])((zztq)object).zza, (int)3, (int)((zztq)object).zzb);
                    this.zzi.zza((zzalv)object);
                    this.zzb.zza();
                } else if (this.zzc.zzb()) {
                    object = this.zzc;
                    object = zzalw.zzc((byte[])((zztq)object).zza, (int)3, (int)((zztq)object).zzb);
                    this.zzi.zzb((zzalu)object);
                    this.zzc.zza();
                }
            }
            if (this.zzd.zze(n)) {
                object = this.zzd;
                n = zzalw.zza((byte[])((zztq)object).zza, (int)((zztq)object).zzb);
                this.zzm.zzb(this.zzd.zza, n);
                this.zzm.zzh(4);
                this.zza.zzb(l2, this.zzm);
            }
            if (this.zzi.zze(l, n3, this.zzj, this.zzl)) {
                this.zzl = false;
            }
            l2 = this.zzk;
            if (!this.zzj) {
                this.zzb.zzc(n5);
                this.zzc.zzc(n5);
            }
            this.zzd.zzc(n5);
            this.zzi.zzd(l, n5, l2);
            n = n4;
        }
    }

    public final void zze() {
    }
}
