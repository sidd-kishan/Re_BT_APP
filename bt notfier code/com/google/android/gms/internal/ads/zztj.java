/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  com.google.android.gms.internal.ads.zzalu
 *  com.google.android.gms.internal.ads.zzalv
 *  com.google.android.gms.internal.ads.zzamg
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zzti
 */
package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzalu;
import com.google.android.gms.internal.ads.zzalv;
import com.google.android.gms.internal.ads.zzamg;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzti;

final class zztj {
    private final zzox zza;
    private final SparseArray<zzalv> zzb;
    private final SparseArray<zzalu> zzc;
    private final zzamg zzd;
    private final byte[] zze;
    private int zzf;
    private long zzg;
    private long zzh;
    private final zzti zzi;
    private final zzti zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private boolean zzn;

    public zztj(zzox object, boolean bl, boolean bl2) {
        this.zza = object;
        this.zzb = new SparseArray();
        this.zzc = new SparseArray();
        this.zzi = new zzti(null);
        this.zzj = new zzti(null);
        object = new byte[128];
        this.zze = (byte[])object;
        this.zzd = new zzamg((byte[])object, 0, 0);
        this.zzk = false;
    }

    public final void zza(zzalv zzalv2) {
        this.zzb.append(zzalv2.zzd, (Object)zzalv2);
    }

    public final void zzb(zzalu zzalu2) {
        this.zzc.append(zzalu2.zza, (Object)zzalu2);
    }

    public final void zzc() {
        this.zzk = false;
    }

    public final void zzd(long l, int n, long l2) {
        this.zzf = n;
        this.zzh = l2;
        this.zzg = l;
    }

    public final boolean zze(long l, int n, boolean bl, boolean bl2) {
        block7: {
            block6: {
                int n2 = this.zzf;
                int n3 = 0;
                if (n2 == 9) {
                    if (bl && this.zzk) {
                        long l2 = this.zzg;
                        int n4 = (int)(l - l2);
                        long l3 = this.zzm;
                        if (l3 != -9223372036854775807L) {
                            n2 = this.zzn ? 1 : 0;
                            l = this.zzl;
                            this.zza.zzv(l3, n2, (int)(l2 - l), n + n4, null);
                        }
                    }
                    this.zzl = this.zzg;
                    this.zzm = this.zzh;
                    this.zzn = false;
                    this.zzk = true;
                }
                bl = this.zzn;
                n2 = this.zzf;
                if (n2 == 5) break block6;
                n = n3;
                if (!bl2) break block7;
                n = n3;
                if (n2 != 1) break block7;
            }
            n = 1;
        }
        this.zzn = bl |= n;
        return bl;
    }
}
