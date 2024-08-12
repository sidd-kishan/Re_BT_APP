/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftg
 *  com.google.android.gms.internal.ads.zzfvw
 *  com.google.android.gms.internal.ads.zzgcq
 *  com.google.android.gms.internal.ads.zzgdm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftg;
import com.google.android.gms.internal.ads.zzfvw;
import com.google.android.gms.internal.ads.zzgcq;
import com.google.android.gms.internal.ads.zzgdm;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

abstract class zzgcs
implements zzftg {
    private final zzgcq zza;
    private final zzgcq zzb;

    public zzgcs(byte[] byArray) throws GeneralSecurityException {
        if (!zzfvw.zza((int)1)) throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        this.zza = this.zzb(byArray, 1);
        this.zzb = this.zzb(byArray, 0);
    }

    public final byte[] zza(byte[] byArray, byte[] byArray2) throws GeneralSecurityException {
        int n = byArray.length;
        if (n > Integer.MAX_VALUE - this.zza.zzc() - 16) throw new GeneralSecurityException("plaintext too long");
        ByteBuffer byteBuffer = ByteBuffer.allocate(this.zza.zzc() + n + 16);
        if (byteBuffer.remaining() < n + this.zza.zzc() + 16) throw new IllegalArgumentException("Given ByteBuffer output is too small");
        n = byteBuffer.position();
        this.zza.zzd(byteBuffer, byArray);
        byteBuffer.position(n);
        byArray = new byte[this.zza.zzc()];
        byteBuffer.get(byArray);
        byteBuffer.limit(byteBuffer.limit() - 16);
        ByteBuffer byteBuffer2 = this.zzb.zze(byArray, 0);
        byArray = new byte[32];
        byteBuffer2.get(byArray);
        int n2 = byteBuffer.remaining();
        n = n2 % 16;
        n = n == 0 ? n2 : n2 + 16 - n;
        byteBuffer2 = ByteBuffer.allocate(n + 16).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer2.put(byArray2);
        byteBuffer2.position(0);
        byteBuffer2.put(byteBuffer);
        byteBuffer2.position(n);
        byteBuffer2.putLong(0L);
        byteBuffer2.putLong(n2);
        byArray = zzgdm.zza((byte[])byArray, (byte[])byteBuffer2.array());
        byteBuffer.limit(byteBuffer.limit() + 16);
        byteBuffer.put(byArray);
        return byteBuffer.array();
    }

    abstract zzgcq zzb(byte[] var1, int var2) throws InvalidKeyException;
}
