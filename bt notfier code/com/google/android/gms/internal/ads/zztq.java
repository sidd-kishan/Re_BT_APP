/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzakt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzakt;
import java.util.Arrays;

final class zztq {
    public byte[] zza;
    public int zzb;
    private final int zzc;
    private boolean zzd;
    private boolean zze;

    public zztq(int n, int n2) {
        this.zzc = n;
        byte[] byArray = new byte[131];
        this.zza = byArray;
        byArray[2] = 1;
    }

    public final void zza() {
        this.zzd = false;
        this.zze = false;
    }

    public final boolean zzb() {
        return this.zze;
    }

    public final void zzc(int n) {
        boolean bl = this.zzd;
        boolean bl2 = true;
        zzakt.zzd((boolean)(bl ^ true));
        if (n != this.zzc) {
            bl2 = false;
        }
        this.zzd = bl2;
        if (!bl2) return;
        this.zzb = 3;
        this.zze = false;
    }

    public final void zzd(byte[] byArray, int n, int n2) {
        if (!this.zzd) {
            return;
        }
        byte[] byArray2 = this.zza;
        int n3 = byArray2.length;
        int n4 = this.zzb + (n2 -= n);
        if (n3 < n4) {
            this.zza = Arrays.copyOf(byArray2, n4 + n4);
        }
        System.arraycopy(byArray, n, this.zza, this.zzb, n2);
        this.zzb += n2;
    }

    public final boolean zze(int n) {
        if (!this.zzd) {
            return false;
        }
        this.zzb -= n;
        this.zzd = false;
        this.zze = true;
        return true;
    }
}
