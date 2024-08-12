/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftl
 *  com.google.android.gms.internal.ads.zzgct
 *  com.google.android.gms.internal.ads.zzgcy
 *  com.google.android.gms.internal.ads.zzgcz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftl;
import com.google.android.gms.internal.ads.zzgct;
import com.google.android.gms.internal.ads.zzgcy;
import com.google.android.gms.internal.ads.zzgcz;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

public final class zzgcv
implements zzftl {
    private static final byte[] zza = new byte[0];
    private final zzgcy zzb;
    private final String zzc;
    private final byte[] zzd;
    private final zzgct zze;
    private final int zzf;

    public zzgcv(ECPublicKey eCPublicKey, byte[] byArray, String string, int n, zzgct zzgct2) throws GeneralSecurityException {
        zzgcz.zza((ECPoint)eCPublicKey.getW(), (EllipticCurve)eCPublicKey.getParams().getCurve());
        this.zzb = new zzgcy(eCPublicKey);
        this.zzd = byArray;
        this.zzc = string;
        this.zzf = n;
        this.zze = zzgct2;
    }

    public final byte[] zza(byte[] byArray, byte[] object) throws GeneralSecurityException {
        object = this.zzb.zza(this.zzc, this.zzd, object, this.zze.zza(), this.zzf);
        byArray = this.zze.zzb(object.zzb()).zza(byArray, zza);
        object = object.zza();
        return ByteBuffer.allocate(((byte[])object).length + byArray.length).put((byte[])object).put(byArray).array();
    }
}
