/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzoc
 *  com.google.android.gms.internal.ads.zzoe
 *  com.google.android.gms.internal.ads.zzog
 *  com.google.android.gms.internal.ads.zzoh
 *  com.google.android.gms.internal.ads.zzsb
 *  com.google.android.gms.internal.ads.zzsk
 *  com.google.android.gms.internal.ads.zzsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzoc;
import com.google.android.gms.internal.ads.zzoe;
import com.google.android.gms.internal.ads.zzog;
import com.google.android.gms.internal.ads.zzoh;
import com.google.android.gms.internal.ads.zzsb;
import com.google.android.gms.internal.ads.zzsk;
import com.google.android.gms.internal.ads.zzsm;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class zzsc
extends zzsm {
    private zzoh zza;
    private zzsb zzb;

    zzsc() {
    }

    private static boolean zzd(byte[] byArray) {
        if (byArray[0] != -1) return false;
        return true;
    }

    protected final void zza(boolean bl) {
        super.zza(bl);
        if (!bl) return;
        this.zza = null;
        this.zzb = null;
    }

    protected final long zzb(zzamf zzamf2) {
        int n;
        block3: {
            block2: {
                int n2;
                if (!zzsc.zzd(zzamf2.zzi())) return -1L;
                n = n2 = (zzamf2.zzi()[2] & 0xFF) >> 4;
                if (n2 == 6) break block2;
                n = n2;
                if (n2 != 7) break block3;
                n = 7;
            }
            zzamf2.zzk(4);
            zzamf2.zzH();
        }
        n = zzoc.zzc((zzamf)zzamf2, (int)n);
        zzamf2.zzh(0);
        return n;
    }

    @EnsuresNonNullIf(expression={"#3.format"}, result=false)
    protected final boolean zzc(zzamf zzamf2, long l, zzsk zzsk2) {
        byte[] byArray = zzamf2.zzi();
        zzoh zzoh2 = this.zza;
        if (zzoh2 == null) {
            this.zza = zzoh2 = new zzoh(byArray, 17);
            zzsk2.zza = zzoh2.zzc(Arrays.copyOfRange(byArray, 9, zzamf2.zze()), null);
            return true;
        }
        if ((byArray[0] & 0x7F) == 3) {
            zzamf2 = zzoe.zzb((zzamf)zzamf2);
            zzsk2 = zzoh2.zze((zzog)zzamf2);
            this.zza = zzsk2;
            this.zzb = new zzsb((zzoh)zzsk2, (zzog)zzamf2);
            return true;
        }
        if (!zzsc.zzd(byArray)) return true;
        zzamf2 = this.zzb;
        if (zzamf2 != null) {
            zzamf2.zza(l);
            zzsk2.zzb = this.zzb;
        }
        if (zzsk2.zza == null) throw null;
        return false;
    }
}
