/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdc
 *  com.google.android.gms.internal.ads.zzdd
 *  com.google.android.gms.internal.ads.zzeb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdc;
import com.google.android.gms.internal.ads.zzdd;
import com.google.android.gms.internal.ads.zzeb;
import java.nio.ByteBuffer;

final class zzec
extends zzeb {
    private int[] zzd;
    private int[] zze;

    zzec() {
    }

    public final void zzc(ByteBuffer byteBuffer) {
        Object object = this.zze;
        if (object == null) throw null;
        int[] nArray = object;
        int n = byteBuffer.position();
        int n2 = byteBuffer.limit();
        object = this.zzi((n2 - n) / this.zzb.zze * this.zzc.zze);
        while (true) {
            if (n >= n2) {
                byteBuffer.position(n2);
                object.flip();
                return;
            }
            for (int n3 : nArray) {
                object.putShort(byteBuffer.getShort(n3 + n3 + n));
            }
            n += this.zzb.zze;
        }
    }

    public final zzdc zzk(zzdc zzdc2) throws zzdd {
        int n;
        int[] nArray = this.zzd;
        if (nArray == null) {
            return zzdc.zza;
        }
        if (zzdc2.zzd != 2) {
            zzdc2 = new zzdd(zzdc2);
            throw zzdc2;
        }
        int n2 = zzdc2.zzc != nArray.length ? 1 : 0;
        for (int i = 0; i < (n = nArray.length); n2 |= n, ++i) {
            n = nArray[i];
            if (n >= zzdc2.zzc) throw new zzdd(zzdc2);
            n = n != i ? 1 : 0;
        }
        zzdc2 = n2 != 0 ? new zzdc(zzdc2.zzb, n, 2) : zzdc.zza;
        return zzdc2;
    }

    protected final void zzm() {
        this.zze = this.zzd;
    }

    protected final void zzn() {
        this.zze = null;
        this.zzd = null;
    }

    public final void zzo(int[] nArray) {
        this.zzd = nArray;
    }
}
