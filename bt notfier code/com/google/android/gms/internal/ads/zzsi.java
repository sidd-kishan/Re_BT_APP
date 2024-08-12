/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzop
 *  com.google.android.gms.internal.ads.zzsk
 *  com.google.android.gms.internal.ads.zzsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzop;
import com.google.android.gms.internal.ads.zzsk;
import com.google.android.gms.internal.ads.zzsm;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class zzsi
extends zzsm {
    private static final byte[] zza = new byte[]{79, 112, 117, 115, 72, 101, 97, 100};
    private boolean zzb;

    zzsi() {
    }

    public static boolean zzd(zzamf zzamf2) {
        if (zzamf2.zzd() < 8) {
            return false;
        }
        byte[] byArray = new byte[8];
        zzamf2.zzm(byArray, 0, 8);
        return Arrays.equals(byArray, zza);
    }

    protected final void zza(boolean bl) {
        super.zza(bl);
        if (!bl) return;
        this.zzb = false;
    }

    protected final long zzb(zzamf object) {
        int n;
        object = object.zzi();
        int n2 = object[0] & 0xFF;
        int n3 = n2 & 3;
        int n4 = 2;
        if (n3 != 0) {
            n = n4;
            if (n3 != 1) {
                n = n4;
                if (n3 != 2) {
                    n = object[1] & 0x3F;
                }
            }
        } else {
            n = 1;
        }
        n4 = (n2 >>= 3) & 3;
        n4 = n2 >= 16 ? 2500 << n4 : (n2 >= 12 ? 10000 << (n4 & 1) : (n4 == 3 ? 60000 : 10000 << n4));
        return this.zzi((long)n * (long)n4);
    }

    @EnsuresNonNullIf(expression={"#3.format"}, result=false)
    protected final boolean zzc(zzamf object, long l, zzsk zzsk2) {
        boolean bl = this.zzb;
        boolean bl2 = true;
        if (!bl) {
            object = Arrays.copyOf(object.zzi(), object.zze());
            zzamf zzamf2 = object[9];
            object = zzop.zza((byte[])object);
            zzaft zzaft2 = new zzaft();
            zzaft2.zzN("audio/opus");
            zzaft2.zzaa(zzamf2 & 0xFF);
            zzaft2.zzab(48000);
            zzaft2.zzP((List)object);
            zzsk2.zza = zzaft2.zzah();
            this.zzb = true;
            return true;
        }
        if (zzsk2.zza == null) throw null;
        if (object.zzv() != 1332770163) {
            bl2 = false;
        }
        object.zzh(0);
        return bl2;
    }
}
