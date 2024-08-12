/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznu
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzoa
 *  com.google.android.gms.internal.ads.zzoq
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zzpc
 *  com.google.android.gms.internal.ads.zzsc
 *  com.google.android.gms.internal.ads.zzsd
 *  com.google.android.gms.internal.ads.zzsg
 *  com.google.android.gms.internal.ads.zzsi
 *  com.google.android.gms.internal.ads.zzsm
 *  com.google.android.gms.internal.ads.zzso
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznu;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzoa;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzpc;
import com.google.android.gms.internal.ads.zzsc;
import com.google.android.gms.internal.ads.zzsd;
import com.google.android.gms.internal.ads.zzsg;
import com.google.android.gms.internal.ads.zzsi;
import com.google.android.gms.internal.ads.zzsm;
import com.google.android.gms.internal.ads.zzso;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

public final class zzse
implements zznu {
    public static final zzoa zza = zzsd.zza;
    private zznx zzb;
    private zzsm zzc;
    private boolean zzd;

    @EnsuresNonNullIf(expression={"streamReader"}, result=true)
    private final boolean zze(zznv zznv2) throws IOException {
        block6: {
            zzsg zzsg2;
            block5: {
                zzsg2 = new zzsg();
                if (!zzsg2.zzc(zznv2, true)) return false;
                if ((zzsg2.zza & 2) != 2) {
                    return false;
                }
                int n = Math.min(zzsg2.zze, 8);
                zzsg2 = new zzamf(n);
                byte[] byArray = zzsg2.zzi();
                ((zznp)zznv2).zzh(byArray, 0, n, false);
                zzsg2.zzh(0);
                if (zzsg2.zzd() >= 5 && zzsg2.zzn() == 127 && zzsg2.zzt() == 1179402563L) {
                    this.zzc = new zzsc();
                } else {
                    zzsg2.zzh(0);
                    try {
                        boolean bl = zzpc.zzc((int)1, (zzamf)zzsg2, (boolean)true);
                        if (!bl) break block5;
                    }
                    catch (zzaha zzaha2) {
                        // empty catch block
                        break block5;
                    }
                    this.zzc = new zzso();
                }
                break block6;
            }
            zzsg2.zzh(0);
            if (!zzsi.zzd((zzamf)zzsg2)) return false;
            this.zzc = new zzsi();
        }
        return true;
    }

    public final boolean zza(zznv zznv2) throws IOException {
        try {
            boolean bl = this.zze(zznv2);
            return bl;
        }
        catch (zzaha zzaha2) {
            return false;
        }
    }

    public final void zzb(zznx zznx2) {
        this.zzb = zznx2;
    }

    public final int zzc(zznv zznv2, zzoq zzoq2) throws IOException {
        zzakt.zze((Object)this.zzb);
        if (this.zzc == null) {
            if (!this.zze(zznv2)) throw zzaha.zzb((String)"Failed to determine bitstream type", null);
            zznv2.zzl();
        }
        if (this.zzd) return this.zzc.zzg(zznv2, zzoq2);
        zzox zzox2 = this.zzb.zzB(0, 1);
        this.zzb.zzC();
        this.zzc.zze(this.zzb, zzox2);
        this.zzd = true;
        return this.zzc.zzg(zznv2, zzoq2);
    }

    public final void zzd(long l, long l2) {
        zzsm zzsm2 = this.zzc;
        if (zzsm2 == null) return;
        zzsm2.zzf(l, l2);
    }
}
