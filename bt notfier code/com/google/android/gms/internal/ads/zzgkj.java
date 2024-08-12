/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgkh
 *  com.google.android.gms.internal.ads.zzxo
 *  com.google.android.gms.internal.ads.zzxp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkh;
import com.google.android.gms.internal.ads.zzxo;
import com.google.android.gms.internal.ads.zzxp;
import java.nio.ByteBuffer;

public abstract class zzgkj
extends zzgkh
implements zzxp {
    private int zza;

    protected zzgkj(String string) {
        super("mvhd");
    }

    public final int zzh() {
        if (this.zzc) return this.zza;
        this.zzg();
        return this.zza;
    }

    protected final long zzi(ByteBuffer byteBuffer) {
        this.zza = zzxo.zzc((byte)byteBuffer.get());
        zzxo.zzb((ByteBuffer)byteBuffer);
        byteBuffer.get();
        return 4L;
    }
}
