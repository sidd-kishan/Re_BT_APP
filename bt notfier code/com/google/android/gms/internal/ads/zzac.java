/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$CryptoInfo
 *  com.google.android.gms.internal.ads.zzab
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import com.google.android.gms.internal.ads.zzab;
import com.google.android.gms.internal.ads.zzamq;

public final class zzac {
    public byte[] zza;
    public byte[] zzb;
    public int[] zzc;
    public int[] zzd;
    private final MediaCodec.CryptoInfo zze = new MediaCodec.CryptoInfo();
    private final zzab zzf;

    public zzac() {
        int n = zzamq.zza;
        zzab zzab2 = null;
        if (n >= 24) {
            zzab2 = new zzab(this.zze, null);
        }
        this.zzf = zzab2;
    }

    public final void zza(int n, int[] object, int[] nArray, byte[] byArray, byte[] byArray2, int n2, int n3, int n4) {
        this.zzc = object;
        this.zzd = nArray;
        this.zzb = byArray;
        this.zza = byArray2;
        this.zze.numSubSamples = n;
        this.zze.numBytesOfClearData = object;
        this.zze.numBytesOfEncryptedData = nArray;
        this.zze.key = byArray;
        this.zze.iv = byArray2;
        this.zze.mode = n2;
        if (zzamq.zza < 24) return;
        object = this.zzf;
        if (object == null) throw null;
        zzab.zza((zzab)object, (int)n3, (int)n4);
    }

    public final MediaCodec.CryptoInfo zzb() {
        return this.zze;
    }

    public final void zzc(int n) {
        int[] nArray;
        if (n == 0) {
            return;
        }
        if (this.zzc == null) {
            nArray = new int[1];
            this.zzc = nArray;
            this.zze.numBytesOfClearData = nArray;
        }
        nArray = this.zzc;
        nArray[0] = nArray[0] + n;
    }
}
