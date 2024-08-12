/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzah
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznu
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzoa
 *  com.google.android.gms.internal.ads.zzoq
 *  com.google.android.gms.internal.ads.zzos
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzov
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zzpd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzah;
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznu;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzoa;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzos;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzpd;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzpe
implements zznu {
    public static final zzoa zza = zzpd.zza;
    private static final int[] zzb = new int[]{13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] zzc = new int[]{18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
    private static final byte[] zzd = zzamq.zzs((String)"#!AMR\n");
    private static final byte[] zze = zzamq.zzs((String)"#!AMR-WB\n");
    private static final int zzf = zzc[8];
    private final byte[] zzg = new byte[1];
    private boolean zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;
    private int zzm = -1;
    private int zzn;
    private long zzo;
    private zznx zzp;
    private zzox zzq;
    private zzot zzr;
    private boolean zzs;

    public zzpe() {
        this(0);
    }

    public zzpe(int n) {
    }

    private final boolean zze(zznv zznv2) throws IOException {
        if (zzpe.zzf(zznv2, zzd)) {
            this.zzh = false;
            int n = zzd.length;
            ((zznp)zznv2).zzd(n, false);
            return true;
        }
        if (!zzpe.zzf(zznv2, zze)) return false;
        this.zzh = true;
        int n = zze.length;
        ((zznp)zznv2).zzd(n, false);
        return true;
    }

    private static boolean zzf(zznv zznv2, byte[] byArray) throws IOException {
        zznv2.zzl();
        int n = byArray.length;
        byte[] byArray2 = new byte[n];
        ((zznp)zznv2).zzh(byArray2, 0, n, false);
        return Arrays.equals(byArray2, byArray);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @RequiresNonNull(value={"trackOutput"})
    private final int zzg(zznv object) throws IOException {
        int n;
        int n2;
        block11: {
            n = n2 = this.zzk;
            if (n2 == 0) {
                try {
                    object.zzl();
                    Object object2 = this.zzg;
                    ((zznp)object).zzh((byte[])object2, 0, 1, false);
                    n2 = this.zzg[0];
                    if ((n2 & 0x83) <= 0) {
                        n = n2 >> 3 & 0xF;
                        boolean bl = this.zzh;
                        if (bl && (n < 10 || n > 13) || !bl && (n < 12 || n > 14)) {
                            n2 = bl ? zzc[n] : zzb[n];
                            this.zzj = n2;
                            this.zzk = n2;
                            int n3 = n = this.zzm;
                            if (n == -1) {
                                this.zzm = n2;
                                n3 = n2;
                            }
                            n = n2;
                            if (n3 == n2) {
                                ++this.zzn;
                                n = n2;
                            }
                            break block11;
                        }
                        object = "WB";
                        if (!bl) {
                            object = "NB";
                        }
                        n2 = ((String)object).length();
                        object2 = new StringBuilder;
                        ((StringBuilder)object2)(n2 + 35);
                        ((StringBuilder)object2).append("Illegal AMR ");
                        ((StringBuilder)object2).append((String)object);
                        ((StringBuilder)object2).append(" frame type ");
                        ((StringBuilder)object2).append(n);
                        throw zzaha.zzb((String)((StringBuilder)object2).toString(), null);
                    }
                    object = new StringBuilder(42);
                    ((StringBuilder)object).append("Invalid padding bits for frame header ");
                    ((StringBuilder)object).append(n2);
                    throw zzaha.zzb((String)((StringBuilder)object).toString(), null);
                }
                catch (EOFException eOFException) {
                    return -1;
                }
            }
        }
        if ((n2 = zzov.zza((zzox)this.zzq, (zzah)object, (int)n, (boolean)true)) == -1) {
            return -1;
        }
        this.zzk = n2 = this.zzk - n2;
        if (n2 > 0) {
            return 0;
        }
        this.zzq.zzv(this.zzi, 1, this.zzj, 0, null);
        this.zzi += 20000L;
        return 0;
    }

    public final boolean zza(zznv zznv2) throws IOException {
        return this.zze(zznv2);
    }

    public final void zzb(zznx zznx2) {
        this.zzp = zznx2;
        this.zzq = zznx2.zzB(0, 1);
        zznx2.zzC();
    }

    public final int zzc(zznv zznv2, zzoq object) throws IOException {
        zzakt.zze((Object)this.zzq);
        int n = zzamq.zza;
        if (zznv2.zzn() == 0L) {
            if (!this.zze(zznv2)) throw zzaha.zzb((String)"Could not find AMR header.", null);
        }
        if (!this.zzs) {
            this.zzs = true;
            boolean bl = this.zzh;
            object = true != bl ? "audio/3gpp" : "audio/amr-wb";
            n = true != bl ? 8000 : 16000;
            zzox zzox2 = this.zzq;
            zzaft zzaft2 = new zzaft();
            zzaft2.zzN((String)object);
            zzaft2.zzO(zzf);
            zzaft2.zzaa(1);
            zzaft2.zzab(n);
            zzox2.zzs(zzaft2.zzah());
        }
        n = this.zzg(zznv2);
        if (this.zzl) {
            return n;
        }
        zznv2 = new zzos(-9223372036854775807L, 0L);
        this.zzr = zznv2;
        this.zzp.zzD((zzot)zznv2);
        this.zzl = true;
        return n;
    }

    public final void zzd(long l, long l2) {
        this.zzi = 0L;
        this.zzj = 0;
        this.zzk = 0;
        this.zzo = 0L;
    }
}
