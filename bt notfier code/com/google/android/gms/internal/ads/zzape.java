/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$CryptoInfo
 *  com.google.android.gms.internal.ads.zzapd
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import com.google.android.gms.internal.ads.zzapd;
import com.google.android.gms.internal.ads.zzave;

public final class zzape {
    public byte[] zza;
    public byte[] zzb;
    public int zzc;
    public int[] zzd;
    public int[] zze;
    public int zzf;
    private final MediaCodec.CryptoInfo zzg;
    private final zzapd zzh;

    public zzape() {
        int n = zzave.zza;
        Object var3_2 = null;
        MediaCodec.CryptoInfo cryptoInfo = n >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.zzg = cryptoInfo;
        cryptoInfo = var3_2;
        if (zzave.zza >= 24) {
            cryptoInfo = new zzapd(this.zzg, null);
        }
        this.zzh = cryptoInfo;
    }

    public final void zza(int n, int[] nArray, int[] nArray2, byte[] byArray, byte[] byArray2, int n2) {
        this.zzf = n;
        this.zzd = nArray;
        this.zze = nArray2;
        this.zzb = byArray;
        this.zza = byArray2;
        this.zzc = 1;
        if (zzave.zza < 16) return;
        this.zzg.numSubSamples = this.zzf;
        this.zzg.numBytesOfClearData = this.zzd;
        this.zzg.numBytesOfEncryptedData = this.zze;
        this.zzg.key = this.zzb;
        this.zzg.iv = this.zza;
        this.zzg.mode = this.zzc;
        if (zzave.zza < 24) return;
        zzapd.zza((zzapd)this.zzh, (int)0, (int)0);
    }

    public final MediaCodec.CryptoInfo zzb() {
        return this.zzg;
    }
}
